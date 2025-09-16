package jp.co.sss.crud.main;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.io.MenuNoReader;
import jp.co.sss.crud.service.IEmployeeService;
import jp.co.sss.crud.util.ConstantMsg;
import jp.co.sss.crud.util.ConstantValue;

/**
 * 社員情報管理システム開始クラス 社員情報管理システムはこのクラスから始まる。<br/>
 * メニュー画面を表示する。
 * 
 * 初回のコミット用コメント
 * developブランチを利用した確認コメント
 *
 * @author System Shared
 *
 */
public class MainSystem {
	/**
	 * 社員管理システムを起動
	 * @param args
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws ParseException
	 * @throws SystemErrorException
	 * @throws IllegalInputException
	 */
	public static void main(String[] args)
			throws IOException, ClassNotFoundException, SQLException, ParseException, SystemErrorException,
			IllegalInputException {

		MenuNoReader menuNoReader = new MenuNoReader();
		int menuNo = 0;

		do {
			// メニューの表示
			ConsoleWriter.showMenu();

			// メニュー番号の入力
			menuNo = (int) menuNoReader.input();
			if (menuNo == ConstantValue.MENU_END) {
				break;
			}
			// 機能の呼出
			//入力されたmenuNoをIEmployeeServiceに渡して、getInstanceByMenuNo()を呼び出す
			//IEmployeeServiceインターフェイスでは渡されたmenuNoを基にswitch文で選択されたクラスを代入して呼び出す
			//するとIEmployeeServiceインターフェイスは呼び出された各クラスと同じ動きをするようになる
			//インスタンス化するためには実装したメソッドの引数は統一しないといけない
			IEmployeeService iEmployeeService = IEmployeeService.getInstanceByMenuNo(menuNo);
			iEmployeeService.execute();
			// DBとの接続を切断
		} while (menuNo != ConstantValue.MENU_END);
		//システム終了メッセージ
		System.out.println(ConstantMsg.END_SYSTEM);
	}
}
