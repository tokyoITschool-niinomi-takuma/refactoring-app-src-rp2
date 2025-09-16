package jp.co.sss.crud.service;

import jp.co.sss.crud.DTO.Employee;
import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;

public class EmployeeUpdateService implements IEmployeeService {

	/**
	 * 更新サービスクラス
	 * @throws SystemErrorException
	 * @throws IllegalInputException
	 */
	public void execute() throws SystemErrorException, IllegalInputException {
		EmployeeDAO employeeDAO = new EmployeeDAO();
		Employee employee = ConsoleWriter.update();
		employeeDAO.update(employee);
	}

}
