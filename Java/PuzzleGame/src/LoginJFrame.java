import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class LoginJFrame extends JFrame {

  public LoginJFrame(){
    //ヴィンドウ初期化
    initJFrame();

    //画像初期化
    initView();

    //ウィンドウを表示する
    this.setVisible(true);
  }

  private void initJFrame(){
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

    //中央揃えを無効にする
    this.setLayout(null);
  }

  private void initView(){

    //ユーザー
    JLabel usernameText = new JLabel(new ImageIcon("image\\login\\用户名.png"));
    usernameText.setBounds(116,135,47,17);
    this.getContentPane().add(usernameText);

    JTextField username = new JTextField();
    username.setBounds(195,134,200,30);
    this.getContentPane().add(username);

    //パスワード
    JLabel passwordText = new JLabel(new ImageIcon("image\\login\\密码.png"));
    passwordText.setBounds(130,195,32,16);
    this.getContentPane().add(passwordText);

    JPasswordField password = new JPasswordField();
    password.setBounds(195,195,200,30);
    this.getContentPane().add(password);

    //認証コード
    JLabel codeText = new JLabel(new ImageIcon("image\\login\\验证码.png"));
    codeText.setBounds(133,256,50,30);
    this.getContentPane().add(codeText);

    JTextField code = new JTextField();
    code.setBounds(195,256,100,30);
    this.getContentPane().add(code);

    //从这里开始
    //需要写验证码生成静态方法


    //背景画像追加
    JLabel background = new JLabel(new ImageIcon("image\\login\\background.png"));
    background.setBounds(0, 0, 470, 390);
    this.getContentPane().add(background);

  }

}
