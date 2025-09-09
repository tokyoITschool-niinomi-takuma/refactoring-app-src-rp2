package jp.co.sss.crud.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.co.sss.crud.DTO.Employee;
import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.util.ConstantMsg;

public class EmployeeFindAllService {
	public static List<Employee> findAll() throws ClassNotFoundException, SQLException {
		ResultSet resultSet = EmployeeDAO.findAll();
		if (!resultSet.isBeforeFirst()) {
			System.out.println(ConstantMsg.NO_APPLICABLE_PERSON);
			return new ArrayList<Employee>();
		}
		//employeeを格納するリストを生成
		List<Employee> employees = new ArrayList<Employee>();
		while (resultSet.next()) {
			//Employeeのオブジェクトを生成
			Employee employee = new Employee();
			employee.setEmpId(resultSet.getInt("emp_id"));
			employee.setEmpName(resultSet.getString("emp_name"));
			employee.setGender(resultSet.getInt("gender"));
			employee.setBirthday(resultSet.getString("birthday"));
			employee.setDeptName(resultSet.getString("dept_name"));
			employees.add(employee);
		}
		return employees;
	}

}
