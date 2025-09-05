package jp.co.sss.crud.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.text.ParseException;

import jp.co.sss.crud.db.DBController;
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
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException, ParseException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int menuNo = 0;

		do {
			// メニューの表示
			System.out.println(ConstantMsg.TITLE);
			System.out.println(ConstantMsg.FIND_ALL);
			System.out.println(ConstantMsg.SEARCH_EMP_NAME);
			System.out.println(ConstantMsg.SEARCH_DEPT_ID);
			System.out.println(ConstantMsg.INSERT);
			System.out.println(ConstantMsg.UPDATE);
			System.out.println(ConstantMsg.DELETE);
			System.out.println(ConstantMsg.END);
			System.out.print(ConstantMsg.SELECT_MENU_NO);

			// メニュー番号の入力
			String menuNoStr = br.readLine();
			menuNo = Integer.parseInt(menuNoStr);

			// 機能の呼出
			switch (menuNo) {
			case ConstantValue.MENU_FIND_ALL:
				// 全件表示機能の呼出
				DBController.findAll();
				break;

			case ConstantValue.MENU_SEARCH_EMP_NAME:
				// 社員名検索
				System.out.print(ConstantMsg.EMP_NAME);

				// 検索機能の呼出
				DBController.findByEmpName();
				break;

			case ConstantValue.MENU_SEARCH_DEPT_ID:
				// 検索する部署IDを入力
				System.out.print(ConstantMsg.INPUT_SELECT_DEPT_ID);
				String deptIdA = br.readLine();

				// 検索機能の呼出
				DBController.findByDeptId(deptIdA);
				break;

			case ConstantValue.MENU_INSERT:
				// 登録する値を入力
				System.out.print(ConstantMsg.EMP_NAME);
				String emp_name = br.readLine();
				System.out.print(ConstantMsg.SELECT_GENDER);
				String Seibetsu = br.readLine();
				System.out.print(ConstantMsg.INPUT_DATE_OF_BIRTDAY);
				String birthday = br.readLine();
				System.out.print(ConstantMsg.SELECT_DEPT_ID);
				String deptIdB = br.readLine();

				// 登録機能の呼出
				DBController.insert(emp_name, Seibetsu, birthday, deptIdB);
				break;

			case ConstantValue.MENU_UPDATE:
				// 更新する社員IDを入力
				System.out.print(ConstantMsg.UPDATE_SELECT_EMP_ID);

				// 更新する値を入力する
				String empId_1 = br.readLine();
				Integer.parseInt(empId_1);

				// 更新機能の呼出
				DBController.update(empId_1);
				System.out.println(ConstantMsg.COMPLETE_UPDATE);

				break;

			case ConstantValue.MENU_DELETE:
				// 削除する社員IDを入力
				System.out.print(ConstantMsg.DELETE_EMP_ID);

				// 削除機能の呼出
				DBController.delete();
				break;

			}
		} while (menuNo != ConstantValue.MENU_END);
		System.out.println(ConstantMsg.END_SYSTEM);
	}
}
