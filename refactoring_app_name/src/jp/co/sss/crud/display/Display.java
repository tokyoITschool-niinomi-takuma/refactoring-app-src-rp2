package jp.co.sss.crud.display;

import java.util.List;

import jp.co.sss.crud.DTO.Employee;
import jp.co.sss.crud.util.ConstantMsg;

public class Display {
	/**
	 * 検索結果表示用メソッド
	 * @param employees
	 */
	public static void find(List<Employee> employees) {
		System.out.println(ConstantMsg.SEARCH_RESULT);
		for (Employee employee : employees) {
			System.out.print(employee.getEmpId() + "\t");
			System.out.print(employee.getEmpName() + "\t");
			if (employee.getGender() == 0) {
				System.out.println(ConstantMsg.NO_ANSWER);
			} else if (employee.getGender() == 1) {
				System.out.print(ConstantMsg.GENDER_MALE + "\t");
			} else if (employee.getGender() == 2) {
				System.out.print(ConstantMsg.GENDER_FEMALE + "\t");
			} else if (employee.getGender() == 9) {
				System.out.print(ConstantMsg.OTHERS + "\t");
			}
			System.out.print(employee.getBirthday() + "\t");
			System.out.print(employee.getDeptName() + "\t");
			System.out.println();
		}
	}
}
