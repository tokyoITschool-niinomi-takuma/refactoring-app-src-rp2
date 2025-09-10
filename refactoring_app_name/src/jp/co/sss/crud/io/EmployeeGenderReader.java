package jp.co.sss.crud.io;

public class EmployeeGenderReader implements IConsoleReader {

	@Override
	public String getErrorMsg() {
		return "0以上2以下、または9の整数を入力してください";
	}

	@Override
	public boolean isValid(String inputString) {
		return inputString != null && !inputString.isEmpty() &&
				inputString == "^|[0129０１２９]{1}$";
	}

	@Override
	public boolean isParseInt() {
		return true;
	}

}
