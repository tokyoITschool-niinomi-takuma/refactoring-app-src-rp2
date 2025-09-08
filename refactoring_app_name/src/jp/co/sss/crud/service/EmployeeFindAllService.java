package jp.co.sss.crud.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.co.sss.crud.DTO.Employee;
import jp.co.sss.crud.db.DBManager;
import jp.co.sss.crud.util.ConstantMsg;
import jp.co.sss.crud.util.ConstantSQL;

public class EmployeeFindAllService {
	public static List<Employee> findAll() throws ClassNotFoundException, SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		// DBに接続
		connection = DBManager.getDBConnection();

		// ステートメントを作成
		preparedStatement = connection.prepareStatement(ConstantSQL.SQL_ALL_SELECT);

		// SQL文を実行
		resultSet = preparedStatement.executeQuery();

		//resultSetの結果Setがない場合はfalse
		if (!resultSet.isBeforeFirst()) {
			System.out.println(ConstantMsg.NO_APPLICABLE_PERSON);
			return null;
		}
		//employeeを格納するリストを生成
		List<Employee> employees = new ArrayList<Employee>();
		while (resultSet.next()) {
			//Employeeのオブジェクトを生成
			Employee employee = new Employee();
			employee.setEmpId(resultSet.getInt("emp_id"));
			employee.setEmpName(resultSet.getString("emp_name"));
			employee.setGender(resultSet.getInt("gender"));
			employee.setBirthday(resultSet.getString("birthday"));
			employees.add(employee);
		}
		// ResultSetをクローズ
		DBManager.resultSetClose(resultSet);
		// Statementをクローズ
		DBManager.preparedStatementClose(preparedStatement);
		// DBとの接続を切断
		DBManager.DBCloseConnection(connection);

		return employees;

	}
}
