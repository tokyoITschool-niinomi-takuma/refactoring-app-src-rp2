package jp.co.sss.crud.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.text.ParseException;

import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.io.EmployeeNameReader;
import jp.co.sss.crud.service.EmployeeFindAllService;
import jp.co.sss.crud.service.EmployeeFindByEmpNameService;
import jp.co.sss.crud.util.ConstantMsg;
import jp.co.sss.crud.util.ConstantValue;

/**
 * 社員情報管理システム開始クラス 社員情報管理システムはこのクラスから始まる。<br/>
 * メニュー画面を表示する。
 * 
 * 初回のコミット用コメント
 * developブランチを利用した確認コメント
 *
 * @author System Shared
 *
 */
public class MainSystem {
	/**
	 * 社員管理システムを起動
	 *
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws ParseException 
	 * @throws SystemErrorException 
	 * @throws IllegalInputException 
	 */
	public static void main(String[] args)
			throws IOException, ClassNotFoundException, SQLException, ParseException, SystemErrorException,
			IllegalInputException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int menuNo = 0;

		do {
			// メニューの表示
			ConsoleWriter.showMenu();

			// メニュー番号の入力
			String menuNoStr = br.readLine();
			menuNo = Integer.parseInt(menuNoStr);

			// 機能の呼出
			switch (menuNo) {
			case ConstantValue.MENU_FIND_ALL:
				// 全件表示機能の呼出
				EmployeeFindAllService employeeFindAllService = new EmployeeFindAllService();
				employeeFindAllService.execute();
				break;

			case ConstantValue.MENU_SEARCH_EMP_NAME:
				// 社員名検索
				EmployeeFindByEmpNameService employeeFindByEmpNameService = new EmployeeFindByEmpNameService();
				EmployeeNameReader employeeNameReader = new EmployeeNameReader();
				System.out.println(ConstantMsg.EMP_NAME);
				String searchName = (String) employeeNameReader.input();
				employeeFindByEmpNameService.execute(searchName);
				break;

			//			case ConstantValue.MENU_SEARCH_DEPT_ID:
			//				// 検索する部署IDを入力
			//				System.out.print(ConstantMsg.INPUT_SELECT_DEPT_ID);
			//				String selectDeptId = br.readLine();
			//				// 検索機能の呼出
			//				List<Employee> findByDeptId = EmployeeDAO.findByDeptId(selectDeptId);
			//				Display.find(findByDeptId);
			//				break;
			//
			//			case ConstantValue.MENU_INSERT:
			//				// 登録する値を入力
			//				System.out.print(ConstantMsg.EMP_NAME);
			//				String emp_name = br.readLine();
			//				System.out.print(ConstantMsg.SELECT_GENDER);
			//				String gender = br.readLine();
			//				System.out.print(ConstantMsg.INPUT_DATE_OF_BIRTDAY);
			//				String birthday = br.readLine();
			//				System.out.print(ConstantMsg.SELECT_DEPT_ID);
			//				String deptId = br.readLine();
			//				// 登録機能の呼出
			//				EmployeeDAO.insert(emp_name, gender, birthday, deptId);
			//				break;

			//			case ConstantValue.MENU_UPDATE:
			//				// 更新する社員IDを入力
			//				System.out.print(ConstantMsg.UPDATE_SELECT_EMP_ID);
			//
			//				// 更新する値を入力する
			//				String updateEmpId = br.readLine();
			//				Integer.parseInt(updateEmpId);
			//
			//				// 更新機能の呼出
			//				EmployeeDAO.update(updateEmpId);
			//				System.out.println(ConstantMsg.COMPLETE_UPDATE);
			//
			//				break;
			//
			//			case ConstantValue.MENU_DELETE:
			//				// 削除する社員IDを入力
			//				System.out.print(ConstantMsg.DELETE_EMP_ID);
			//
			//				// 削除機能の呼出
			//				EmployeeDAO.delete();
			//				break;
			//
			}
			// DBとの接続を切断
		} while (menuNo != ConstantValue.MENU_END);
		System.out.println(ConstantMsg.END_SYSTEM);

	}
}
