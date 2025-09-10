package jp.co.sss.crud.io;

import java.util.List;

import jp.co.sss.crud.DTO.Employee;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
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

	/**
	 * 
	 * @return 新規登録完了
	 * @throws SystemErrorException
	 * @throws IllegalInputException
	 */
	public static Employee insert()
			throws SystemErrorException, IllegalInputException {
		Employee employee = new Employee();
		EmployeeNameReader NameReader = new EmployeeNameReader();
		EmployeeGenderReader GenderReader = new EmployeeGenderReader();
		EmployeeBirthdayReader birthdayReader = new EmployeeBirthdayReader();
		EmployeeDeptIdReader deptIdReader = new EmployeeDeptIdReader();
		//各登録項目の表示と入力
		System.out.print(ConstantMsg.EMP_NAME);
		employee.setEmpName((String) NameReader.input());
		System.out.print(ConstantMsg.SELECT_GENDER);
		employee.setGender((int) GenderReader.input());
		System.out.print(ConstantMsg.INPUT_DATE_OF_BIRTDAY);
		employee.setBirthday((String) birthdayReader.input());
		System.out.print(ConstantMsg.SELECT_DEPT_ID);
		employee.setDeptId((int) deptIdReader.input());
		// 登録完了メッセージを出力
		System.out.println(ConstantMsg.INSERT_EMPLOYEE_INFORMATION);
		return employee;
	}
}
