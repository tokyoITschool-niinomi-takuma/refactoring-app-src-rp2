package jp.co.sss.crud.db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import jp.co.sss.crud.DTO.Employee;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.util.ConstantMsg;
import jp.co.sss.crud.util.ConstantSQL;

public class EmployeeDAO implements IEmployeeDAO {

	/**
	 * 全ての社員情報を検索
	 * @return 全件検索結果
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException           DB処理でエラーが発生した場合に送出
	 */
	public List<Employee> findAll() throws SystemErrorException {
		//employeeを格納するリストを生成
		List<Employee> employees = new ArrayList<Employee>();
		try (
				// try-with-resources で自動クローズされる
				Connection connection = DBManager.getDBConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(ConstantSQL.SQL_ALL_SELECT);
				ResultSet resultSet = preparedStatement.executeQuery();) {
			//resultSetの結果Setがない場合はfalse
			if (!resultSet.isBeforeFirst()) {
				System.out.println(ConstantMsg.NO_APPLICABLE_PERSON);
				// 空リストを返す
				return employees;
			}
			while (resultSet.next()) {
				//Employeeのオブジェクトを生成
				Employee employee = new Employee();
				employee.setEmpId(resultSet.getInt("emp_id"));
				employee.setEmpName(resultSet.getString("emp_name"));
				employee.setGender(resultSet.getInt("gender"));
				employee.setBirthday(resultSet.getString("birthday"));
				employee.setDeptName(resultSet.getString("dept_name"));
				employees.add(employee);
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			throw new SystemErrorException();
		}
		return employees;
	}

	/**
	 * 社員名に該当する社員情報を検索
	 * @return 社員名あいまい検索結果
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException           DB処理でエラーが発生した場合に送出
	 */
	public List<Employee> findByEmployeeName(String searchName) throws SystemErrorException {
		//employeeを格納するリストを生成
		List<Employee> employees = new ArrayList<Employee>();

		if (searchName == null || searchName.isEmpty()) {
			searchName = "";
		}
		String sql = ConstantSQL.SQL_SELECT_BASIC + ConstantSQL.SQL_SELECT_BY_EMP_NAME;

		try (
				Connection connection = DBManager.getDBConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
			preparedStatement.setString(1, "%" + searchName + "%");

			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				if (!resultSet.isBeforeFirst()) {
					System.out.println(ConstantMsg.NO_APPLICABLE_PERSON);
					// 空リストを返す
					return employees;
				}

				while (resultSet.next()) {
					Employee employee = new Employee();
					employee.setEmpId(resultSet.getInt("emp_id"));
					employee.setEmpName(resultSet.getString("emp_name"));
					employee.setGender(resultSet.getInt("gender"));
					employee.setBirthday(resultSet.getString("birthday"));
					employee.setDeptName(resultSet.getString("dept_name"));
					employees.add(employee);
				}
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			throw new SystemErrorException();
		}
		return employees;
	}

	/** 
	* 部署IDに該当する社員情報を検索
	* @return 部署ID検索結果
	* @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	* @throws SQLException           DB処理でエラーが発生した場合に送出
	* @throws IOException            入力処理でエラーが発生した場合に送出
	*/
	public List<Employee> findByDeptId(int deptId) throws SystemErrorException {
		//employeeを格納するリストを生成
		List<Employee> employees = new ArrayList<Employee>();
		// SQL文を準備
		String sql = ConstantSQL.SQL_SELECT_BASIC + ConstantSQL.SQL_SELECT_BY_DEPT_ID;
		try (
				// DBに接続
				Connection connection = DBManager.getDBConnection();
				// ステートメントの作成
				PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
			// 検索条件となる値をバインド
			preparedStatement.setInt(1, deptId);
			// SQL文を実行
			try (ResultSet resultSet = preparedStatement.executeQuery()) {

				if (!resultSet.isBeforeFirst()) {
					System.out.println(ConstantMsg.NO_APPLICABLE_PERSON);
					return employees;
				}
				while (resultSet.next()) {
					//Employeeのオブジェクトを生成
					Employee employee = new Employee();
					employee.setEmpId(resultSet.getInt("emp_id"));
					employee.setEmpName(resultSet.getString("emp_name"));
					employee.setGender(resultSet.getInt("gender"));
					employee.setBirthday(resultSet.getString("birthday"));
					employee.setDeptName(resultSet.getString("dept_name"));
					employees.add(employee);
				}
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			throw new SystemErrorException();
		}
		return employees;
	}

	/**
	 * 社員情報を1件登録
	 * 
	 * @param empName 社員名
	 * @param gender 性別
	 * @param birthday 生年月日
	 * @param deptId 部署ID
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException            DB処理でエラーが発生した場合に送出
	 * @throws IOException             入力処理でエラーが発生した場合に送出
	 * @throws ParseException 
	 */
	public void insert(String empName, int gender, String birthday, int deptId) throws SystemErrorException {
		try (
				// DBに接続
				Connection connection = DBManager.getDBConnection();
				// ステートメントを作成
				PreparedStatement preparedStatement = connection.prepareStatement(ConstantSQL.SQL_INSERT)) {
			// 入力値をバインド
			preparedStatement.setString(1, empName);
			preparedStatement.setInt(2, gender);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			preparedStatement.setObject(3, sdf.parse(birthday), Types.DATE);
			preparedStatement.setInt(4, deptId);
			// SQL文を実行
			preparedStatement.executeUpdate();
			// 登録完了メッセージを出力
			System.out.println(ConstantMsg.INSERT_EMPLOYEE_INFORMATION);
		} catch (SQLException | ClassNotFoundException | ParseException e) {
			e.printStackTrace();
			throw new SystemErrorException();
		}
	}
}

//	/**
//	* 社員情報を1件更新
//	* 
//	* @param empId 社員ID
//	* @throws ClassNotFoundException ドライバクラスが不在の場合に送出
//	* @throws SQLException            DB処理でエラーが発生した場合に送出
//	* @throws IOException             入力処理でエラーが発生した場合に送出
//	* @throws ParseException 
//	*/
//	@Override
//	public Integer update(Employee employee) throws SystemErrorException {
//		Connection connection = null;
//		PreparedStatement preparedStatement = null;
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//		try {
//			// データベースに接続
//			connection = DBManager.getDBConnection();
//
//			// ステートメントの作成
//			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_UPDATE);
//
//			System.out.print(ConstantMsg.EMP_NAME);
//			String emp_name = br.readLine();
//			// 性別を入力
//			System.out.print(ConstantMsg.SELECT_GENDER);
//			String gender = br.readLine();
//			// 誕生日を入力
//			System.out.print(ConstantMsg.INPUT_DATE_OF_BIRTDAY);
//			String birthday = br.readLine();
//
//			// 部署IDを入力
//			System.out.print(ConstantMsg.SELECT_DEPT_ID);
//			String deptId = br.readLine();
//
//			// 入力値をバインド
//			preparedStatement.setString(1, emp_name);
//			preparedStatement.setInt(2, Integer.parseInt(gender));
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
//			preparedStatement.setObject(3, sdf.parse(birthday), Types.DATE);
//			preparedStatement.setInt(4, Integer.parseInt(deptId));
//			preparedStatement.setInt(5, Integer.parseInt(empId));
//
//			// SQL文の実行(失敗時は戻り値0)
//			preparedStatement.executeUpdate();
//
//		} finally {
//			// クローズ処理
//			DBManager.preparedStatementClose(preparedStatement);
//			// DBとの接続を切断
//			DBManager.DBCloseConnection(connection);
//		}
//	}
//
//	@Override
//	public Integer delete(Integer empId) throws SystemErrorException {
//		Connection connection = null;
//		PreparedStatement preparedStatement = null;
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//		try {
//			// データベースに接続
//			connection = DBManager.getDBConnection();
//			String empId = br.readLine();
//
//			// ステートメントの作成
//			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_DELETE);
//
//			// 社員IDをバインド
//			preparedStatement.setInt(1, Integer.parseInt(empId));
//
//			// SQL文の実行(失敗時は戻り値0)
//			preparedStatement.executeUpdate();
//
//			System.out.println(ConstantMsg.DELETE_EMPLOYEE_INFOMATION);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//
//		}
//
//		finally {
//			// Statementをクローズ
//			try {
//				DBManager.preparedStatementClose(preparedStatement);
//				DBManager.DBCloseConnection(connection);
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//			// DBとの接続を切断
//		}
//		return null;
//	}
