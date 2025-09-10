package jp.co.sss.crud.io;

import java.util.List;

import jp.co.sss.crud.DTO.Employee;
import jp.co.sss.crud.util.ConstantMsg;

public class ConsoleWriter {
	/**
	 * メニュー表示用のメソッド
	 */
	public static void showMenu() {
		System.out.println(ConstantMsg.TITLE);
		System.out.println(ConstantMsg.FIND_ALL);
		System.out.println(ConstantMsg.SEARCH_EMP_NAME);
		System.out.println(ConstantMsg.SEARCH_DEPT_ID);
		System.out.println(ConstantMsg.INSERT);
		System.out.println(ConstantMsg.UPDATE);
		System.out.println(ConstantMsg.DELETE);
		System.out.println(ConstantMsg.END);
		System.out.print(ConstantMsg.SELECT_MENU_NO);
	}

	/**
	 * 検索結果のコンソール表示
	 * @param employees
	 */
	public static void showSearchreSult(List<Employee> employees) {
		System.out.println(ConstantMsg.SEARCH_RESULT);
		for (Employee employee : employees) {
			System.out.println(employee);
		}
	}
}
