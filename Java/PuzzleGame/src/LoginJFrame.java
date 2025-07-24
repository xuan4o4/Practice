import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class LoginJFrame extends JFrame {

  public LoginJFrame(){
    //ウィンドウのサイズを設定する
    this.setSize(488, 430);

    //ウィンドウのタイトルを設定する
    this.setTitle("ログイン");

    //常に最前面に表示するように設定する
    this.setAlwaysOnTop(true);

    //画面中央にウィンドウを表示する
    this.setLocationRelativeTo(null);

    //ウィンドウを閉じたときにプログラムを終了するように設定する
    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    //ウィンドウを表示する
    this.setVisible(true);
  }

}
