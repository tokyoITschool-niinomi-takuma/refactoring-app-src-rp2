package jp.co.sss.crud.io;

public class EmployeeNameReader implements IConsoleReader {

	@Override
	public String getErrorMsg() {
		return "1文字以上30文字以下の文字列を入力してください";
	}

	@Override
	public boolean isValid(String inputString) {
		return inputString != null && !inputString.isEmpty() &&
				inputString.length() >= 1 && 30 >= inputString.length();
	}

	@Override
	public boolean isParseInt() {
		return false;
	}
}
