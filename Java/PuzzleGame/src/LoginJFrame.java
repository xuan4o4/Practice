import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class LoginJFrame extends JFrame implements MouseListener {

  private JButton login;
  private JButton register;
  private JTextField username;
  private JPasswordField password;
  private JTextField code;
  private String codeStr;


  static ArrayList<User> list = new ArrayList<>();
  static {
    list.add(new User("tomato1", "123"));
    list.add(new User("tomato2", "123"));
  }

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
    this.getContentPane().removeAll();

    //ユーザー
    JLabel usernameText = new JLabel(new ImageIcon("image\\login\\用户名.png"));
    usernameText.setBounds(116,135,47,17);
    this.getContentPane().add(usernameText);

    username = new JTextField();
    username.setBounds(195,134,200,30);
    this.getContentPane().add(username);

    //パスワード
    JLabel passwordText = new JLabel(new ImageIcon("image\\login\\密码.png"));
    passwordText.setBounds(130,195,32,16);
    this.getContentPane().add(passwordText);

    password = new JPasswordField();
    password.setBounds(195,195,200,30);
    this.getContentPane().add(password);

    //認証コード
    JLabel codeText = new JLabel(new ImageIcon("image\\login\\验证码.png"));
    codeText.setBounds(133,256,50,30);
    this.getContentPane().add(codeText);

    code = new JTextField();
    code.setBounds(195,256,100,30);
    this.getContentPane().add(code);

    codeStr = MyTool.getCode();
    JLabel rightCode = new JLabel();
    rightCode.setText(codeStr);
    rightCode.setBounds(300,256,50,30);
    this.getContentPane().add(rightCode);

    //ボタン
    login = new JButton();
    login.setBounds(123,310,128,47);
    login.setIcon(new ImageIcon("image\\login\\登录按钮.png"));
    login.setBorderPainted(false);            //去除边框
    login.setContentAreaFilled(false);        //去除背景
    login.addMouseListener(this);
    this.getContentPane().add(login);

    register = new JButton();
    register.setBounds(256,310,128,47);
    register.setIcon(new ImageIcon("image\\login\\注册按钮.png"));
    register.setBorderPainted(false);            //去除边框
    register.setContentAreaFilled(false);        //去除背景
    register.addMouseListener(this);
    this.getContentPane().add(register);

    //背景画像追加
    JLabel background = new JLabel(new ImageIcon("image\\login\\background.png"));
    background.setBounds(0, 0, 470, 390);
    this.getContentPane().add(background);

    this.getContentPane().repaint();
  }

  public void showJDialog(String content) {
    JDialog jDialog = new JDialog();
    jDialog.setSize(260, 150);
    jDialog.setAlwaysOnTop(true);             // 置顶
    jDialog.setLocationRelativeTo(null);      // 居中
    jDialog.setModal(true);                   // 模态弹窗
    jDialog.setLayout(null);                  // 自定义布局

    // 提示文字
    JLabel warning = new JLabel(content, JLabel.CENTER);
    warning.setBounds(30, 20, 200, 30);
    jDialog.add(warning);

    // 确定按钮
    JButton okButton = new JButton("確定");
    okButton.setBounds(90, 70, 80, 30);
    okButton.addActionListener(e -> jDialog.dispose()); // 点击关闭弹窗
    jDialog.add(okButton);

    jDialog.setVisible(true);  // 显示弹窗
  }

  @Override
  public void mouseClicked(MouseEvent e) {

  }

  @Override
  public void mousePressed(MouseEvent e) {
    //System.out.println("クリック");
    Object source = e.getSource();
    if(source == login){
      login.setIcon(new ImageIcon("image\\login\\登录按下.png"));
    } else if (source == register) {
      register.setIcon(new ImageIcon("image\\login\\注册按下.png"));
    }
  }

  @Override
  public void mouseReleased(MouseEvent e) {
    Object source = e.getSource();
    if (source == login){
      login.setIcon(new ImageIcon("image\\login\\登录按钮.png"));

      String inputUsername = username.getText();
      String inputPassword = new String(password.getPassword());
      String inputCode = code.getText();

      // 先验证验证码是否正确
      if (!inputCode.equalsIgnoreCase(codeStr)) {
        showJDialog("認証コードが違います！");
        return;
      }

      // 再验证用户名和密码
      boolean match = false;

      for (User user : list) {
        if (user.getUsername().equals(inputUsername) &&
            user.getPassword().equals(inputPassword)) {
          match = true;
          break;
        }
      }

      if (match) {
        showJDialog("ログイン成功！");
        new GameJFrame();

      } else {
        showJDialog("ユーザー名またはパスワードが間違っています。");
      }

    } else if (source == register) {
      register.setIcon(new ImageIcon("image\\login\\注册按钮.png"));


    }
  }

  @Override
  public void mouseEntered(MouseEvent e) {

  }

  @Override
  public void mouseExited(MouseEvent e) {

  }
}
