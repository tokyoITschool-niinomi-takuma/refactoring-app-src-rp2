package jp.co.sss.crud.service;

import java.util.List;

import jp.co.sss.crud.DTO.Employee;
import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.io.EmployeeNameReader;
import jp.co.sss.crud.util.ConstantMsg;

public class EmployeeFindByEmpNameService implements IEmployeeService {

	/**
	 * 社員名検索サービスクラス
	 */
	public void execute() throws SystemErrorException, IllegalInputException {
		System.out.println(ConstantMsg.EMP_NAME);
		EmployeeDAO employeeDAO = new EmployeeDAO();
		String searchName = (String) new EmployeeNameReader().input();
		List<Employee> employees = employeeDAO.findByEmployeeName(searchName);
		ConsoleWriter.showSearchreSult(employees);
		System.out.println();//改行
	}
}