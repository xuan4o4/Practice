import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class RegisterJFrame extends JFrame {

  public RegisterJFrame(){

    //ウィンドウのサイズを設定する
    this.setSize(488, 500);

    //ウィンドウのタイトルを設定する
    this.setTitle("新規登録");

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
