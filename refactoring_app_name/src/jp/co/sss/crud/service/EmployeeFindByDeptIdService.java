package jp.co.sss.crud.service;

import java.util.List;

import jp.co.sss.crud.DTO.Employee;
import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;

public class EmployeeFindByDeptIdService {

	/**
	 * 部署ID検索サービスクラス
	 * @param deptId
	 * @throws SystemErrorException
	 * @throws IllegalInputException
	 */
	public void execute(int deptId) throws SystemErrorException, IllegalInputException {
		EmployeeDAO employeeDAO = new EmployeeDAO();
		List<Employee> employees = employeeDAO.findByDeptId(deptId);
		ConsoleWriter.showSearchreSult(employees);

	}

}
