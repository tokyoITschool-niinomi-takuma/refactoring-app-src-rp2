package jp.co.sss.crud.util;

public class ConstantMsg {
	/**タイトル表示用定数*/
	public static final String TITLE = "=== 社員管理システム ===";
	/**全件表示メニュー番号*/
	public static final String FIND_ALL = "1.全件表示";
	/**社員名検索メニュー番号*/
	public static final String SEARCH_EMP_NAME = "2.社員名検索";
	/**部署ID検索メニュー番号*/
	public static final String SEARCH_DEPT_ID = "3.部署ID検索";
	/**新規登録メニュー番号*/
	public static final String INSERT = "4.新規登録";
	/**更新メニュー番号*/
	public static final String UPDATE = "5.更新";
	/**削除メニュー番号*/
	public static final String DELETE = "6.削除";
	/**終了メニュー番号*/
	public static final String END = "7.終了";
	/**メニュー番号選択用定数*/
	public static final String SELECT_MENU_NO = "メニュー番号を入力してください：";

	/**社員名と表示する定数*/
	public static final String EMP_NAME = "社員名";
	/**性別の選択用定数*/
	public static final String SELECT_GENDER = "性別(0:その他, 1:男性, 2:女性, 9:回答なし):";
	/**生年月日の入力用定数*/
	public static final String INPUT_DATE_OF_BIRTDAY = "生年月日(西暦年/月/日):";
	/**部署IDの選択用定数*/
	public static final String SELECT_DEPT_ID = "部署ID(1:営業部、2:経理部、3:総務部):";
	/**検索する部署IDの入力用定数*/
	public static final String INPUT_SELECT_DEPT_ID = "部署ID(1:営業部、2:経理部、3:総務部)を入力してください:";
	/**更新する社員IDの入力用定数*/
	public static final String UPDATE_SELECT_EMP_ID = "更新する社員の社員IDを入力してください：";
	/**更新完了表示*/
	public static final String COMPLETE_UPDATE = "社員情報を更新しました";
	/**社員情報の登録完了*/
	public static final String INSERT_EMPLOYEE_INFORMATION = "社員情報を登録しました";
	/**社員情報の削除完了*/
	public static final String DELETE_EMPLOYEE_INFOMATION = "社員情報を削除しました";
	/**削除する社員IDの入力用定数 */
	public static final String DELETE_EMP_ID = "削除する社員の社員IDを入力してください：";
	/**システム終了表示用定数*/
	public static final String END_SYSTEM = "システムを終了します";
	/**性別：男性*/
	public static final String GENDER_MALE = "男性";
	/**性別：女性*/
	public static final String GENDER_FEMALE = "女性";
	/**その他*/
	public static final String OTHERS = "その他";
	/**回答なし*/
	public static final String NO_ANSWER = "回答なし";
	/**該当者はいませんでした*/
	public static final String NO_APPLICABLE_PERSON = "該当者はいませんでした";
	/**営業部*/
	public static final String DEPT_ID_1 = "営業部";
	/**経理部*/
	public static final String DEPT_ID_2 = "経理部";
	/**総務部*/
	public static final String DEPT_ID_3 = "総務部";
	/**検索結果の種類表示定数*/
	public static final String SEARCH_RESULT = "社員ID\t社員名\t性別\t生年月日\t部署名";
}
