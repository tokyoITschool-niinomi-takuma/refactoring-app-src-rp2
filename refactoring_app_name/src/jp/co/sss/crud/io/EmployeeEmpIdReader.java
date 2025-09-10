package jp.co.sss.crud.io;

public class EmployeeEmpIdReader implements IConsoleReader {

	@Override
	public String getErrorMsg() {
		return "1以上9999以下の整数を入力してください";
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
