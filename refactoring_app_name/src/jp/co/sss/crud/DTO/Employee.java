package jp.co.sss.crud.DTO;

import jp.co.sss.crud.util.ConstantMsg;

public class Employee {

	private int empId;
	private String empName;
	private int gender;
	private String birthday;
	private String deptName;
	private int deptId;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	@Override
	public String toString() {
		String gender_ja = " ";
		if (this.gender == 1) {
			gender_ja = ConstantMsg.GENDER_MALE;
		} else if (this.gender == 2) {
			gender_ja = ConstantMsg.GENDER_FEMALE;
		}
		return empId + "\t" + empName + "\t" + gender_ja + "\t" + birthday + "\t" + deptName;
	}
}
