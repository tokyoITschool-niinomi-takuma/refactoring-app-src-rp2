package jp.co.sss.crud.io;

public class EmployeeBirthdayReader implements IConsoleReader {

	@Override
	public String getErrorMsg() {
		return "正しい形式(西暦年/月/日)で日付を入力してください";
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
