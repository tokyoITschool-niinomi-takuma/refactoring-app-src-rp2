package jp.co.sss.crud.io;

public class MenuNoReader implements IConsoleReader {

	@Override
	public String getErrorMsg() {
		return "1以上7以下の整数を入力してください";
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
