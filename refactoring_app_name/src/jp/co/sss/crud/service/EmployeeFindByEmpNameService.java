package jp.co.sss.crud.service;

import java.util.List;

import jp.co.sss.crud.DTO.Employee;
import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;

public class EmployeeFindByEmpNameService {

	/**
	 * 社員名検索サービスクラス
	 */
	public void execute(String searchName) throws SystemErrorException, IllegalInputException {
		EmployeeDAO employeeDAO = new EmployeeDAO();
		List<Employee> employees = employeeDAO.findByEmployeeName(searchName);
		ConsoleWriter.showSearchreSult(employees);
	}
}