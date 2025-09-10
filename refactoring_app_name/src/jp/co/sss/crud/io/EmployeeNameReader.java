package jp.co.sss.crud.io;

public class EmployeeNameReader implements IConsoleReader {

	@Override
	public String getErrorMsg() {
		return "4文字以上8文字以内の半角数字を入力してください";
	}

	@Override
	public boolean isValid(String inputString) {
		return inputString != null && !inputString.isEmpty();
	}

	@Override
	public boolean isParseInt() {
		return false;
	}
}
