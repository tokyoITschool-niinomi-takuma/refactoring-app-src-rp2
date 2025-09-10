package jp.co.sss.crud.io;

public class EmployeeDeptIdReader implements IConsoleReader {

	@Override
	public String getErrorMsg() {
		return "数字を入力してください";
	}

	@Override
	public boolean isValid(String inputString) {
		return inputString != null && !inputString.isEmpty();
	}

	@Override
	public boolean isParseInt() {
		return true;
	}

}
