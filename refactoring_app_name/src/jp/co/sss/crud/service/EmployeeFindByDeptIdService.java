package jp.co.sss.crud.service;

import java.util.List;

import jp.co.sss.crud.DTO.Employee;
import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.io.EmployeeDeptIdReader;
import jp.co.sss.crud.util.ConstantMsg;

public class EmployeeFindByDeptIdService implements IEmployeeService {
	/**
	 * 部署ID検索サービスクラス
	 * @param deptId
	 * @throws SystemErrorException
	 * @throws IllegalInputException
	 */
	@Override
	public void execute() throws SystemErrorException, IllegalInputException {
		System.out.println(ConstantMsg.INPUT_SELECT_DEPT_ID);
		EmployeeDAO employeeDAO = new EmployeeDAO();
		int deptId = (int) new EmployeeDeptIdReader().input();
		List<Employee> employees = employeeDAO.findByDeptId(deptId);
		ConsoleWriter.showSearchreSult(employees);

	}

}
