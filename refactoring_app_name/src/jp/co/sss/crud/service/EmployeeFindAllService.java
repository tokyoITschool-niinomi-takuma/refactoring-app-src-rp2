package jp.co.sss.crud.service;

import java.util.List;

import jp.co.sss.crud.DTO.Employee;
import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;

public class EmployeeFindAllService implements IEmployeeService {

	/**
	 * 更新用のサービスクラス
	 */
	public void execute() throws SystemErrorException {
		EmployeeDAO employeeDAO = new EmployeeDAO();
		List<Employee> employees = employeeDAO.findAll();
		ConsoleWriter.showSearchreSult(employees);
		System.out.println();//改行
	}
}
