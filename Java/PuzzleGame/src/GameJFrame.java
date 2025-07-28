import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;

public class GameJFrame extends JFrame implements KeyListener, ActionListener {
  Random random = new Random();
  String path = "image\\animal\\animal3\\";
  int[][] data = new int[4][4];
  int x;
  int y;
  int step = 0;
  int[][] win = {
      {1,2,3,4},
      {5,6,7,8},
      {9,10,11,12},
      {13,14,15,0},
  };

  JMenu changeImage = new JMenu("画像変更");
  JMenuItem girl = new JMenuItem("美人");
  JMenuItem animal = new JMenuItem("動物");
  JMenuItem sport = new JMenuItem("スポーツ");
  JMenuItem rePlayItem = new JMenuItem("再プレイ");
  JMenuItem reLoginItem = new JMenuItem("再ログイン");
  JMenuItem closeItem = new JMenuItem("終了");

  public GameJFrame(){
    //ヴィンドウ初期化
    initJFrame();

    //メニュー初期化
    initJMenuBar();

    //画像位置初期化(Random)
    initData();

    //画像初期化
    initImage();

    //ウィンドウを表示する
    this.setVisible(true);
  }

  /**
   * パズルの初期データをランダムに生成するメソッド。
   * 0〜15 の数字をランダムにシャッフルし、4x4 の配列に配置する。
   */
  private void initData() {
    int[] tempArr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};

    Random random = new Random();
    for (int i = 0; i < tempArr.length; i++) {
      int index = random.nextInt(tempArr.length);
      int temp;
      temp = tempArr[i];
      tempArr[i] = tempArr[index];
      tempArr[index] = temp;
    }

    for (int i = 0; i < tempArr.length; i++) {
      if(tempArr[i] == 0){
        x = i / 4;
        y = i % 4;
      }
      data[i / 4][i % 4] = tempArr[i];
    }
  }

  /**
   * パズル画像を画面に表示するメソッド。
   * 各パネルに対応する画像を配置し、背景画像も追加する。
   */
  private void initImage() {

    //コンテンツパネル上のすべてのコンポーネントを削除する（画面をリセットするため）
    this.getContentPane().removeAll();

    JLabel stepCount = new JLabel("步数：" + step);
    stepCount.setBounds(50, 30, 100, 20);
    this.getContentPane().add(stepCount);

    if (victory()){
      JLabel jLabel = new JLabel(new ImageIcon("image\\win.png"));
      jLabel.setBounds(203,283,197,73);
      this.getContentPane().add(jLabel);
    }

    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        int number = data[i][j];
        //JLabel のオブジェクトを作成する
        JLabel jLabel = new JLabel(new ImageIcon(path + number + ".jpg"));

        // ラベルに凹型の立体的な枠線を設定する
        jLabel.setBorder(new BevelBorder(BevelBorder.LOWERED));

        //位置とサイズを設定する
        jLabel.setBounds(105 * j + 83, 105 * i + 134, 105, 105);

        //画面に追加する
        this.getContentPane().add(jLabel);

        // 画面を更新する
        this.getContentPane().repaint();
      }
    }

    //背景画像追加
    JLabel background = new JLabel(new ImageIcon("image\\background.png"));
    background.setBounds(40, 40, 508, 560);
    this.getContentPane().add(background);
  }

  /**
   * ゲームウィンドウの初期設定を行うメソッド。
   * ウィンドウサイズ、タイトル、表示位置、終了動作などを設定する。
   */
  private void initJFrame() {
    //ウィンドウのサイズを設定する
    this.setSize(603, 680);

    //ウィンドウのタイトルを設定する
    this.setTitle("パズルゲーム");

    //常に最前面に表示するように設定する
    this.setAlwaysOnTop(true);

    //画面中央にウィンドウを表示する
    this.setLocationRelativeTo(null);

    //ウィンドウを閉じたときにプログラムを終了するように設定する
    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    // このウィンドウにキーリスナーを登録する
    this.addKeyListener(this);

    //中央揃えを無効にする
    this.setLayout(null);
  }

  /**
   * ゲーム画面のメニューバーを初期化するメソッド。
   * 「機能」メニューに「再プレイ」「再ログイン」「終了」のメニュー項目を追加し、メニューバーに設定する。
   */
  private void initJMenuBar() {
    JMenuBar jMenuBar = new JMenuBar();

    JMenu functhionJMenu = new JMenu("機能");

    functhionJMenu.add(changeImage);
    functhionJMenu.add(rePlayItem);
    functhionJMenu.add(reLoginItem);
    functhionJMenu.add(closeItem);

    jMenuBar.add(functhionJMenu);

    rePlayItem.addActionListener(this);
    reLoginItem.addActionListener(this);
    closeItem.addActionListener(this);

    changeImage.add(girl);
    changeImage.add(animal);
    changeImage.add(sport);

    girl.addActionListener(this);
    animal.addActionListener(this);
    sport.addActionListener(this);

    this.setJMenuBar(jMenuBar);
  }

  @Override
  public void keyTyped(KeyEvent e) {

  }

  @Override
  public void keyPressed(KeyEvent e) {
    int keyCode = e.getKeyCode();
    if (keyCode == 65){
      this.getContentPane().removeAll();

      JLabel jLabel = new JLabel(new ImageIcon(path + "all.jpg"));
      jLabel.setBounds(83,134,420,420);
      this.getContentPane().add(jLabel);

      JLabel background = new JLabel(new ImageIcon("image\\background.png"));
      background.setBounds(40, 40, 508, 560);
      this.getContentPane().add(background);

      this.getContentPane().repaint();
    }
  }

  @Override
  public void keyReleased(KeyEvent e) {
    if (victory()){
      return;
    }
    int keyCode = e.getKeyCode();
    //System.out.println(keyCode);

    if (keyCode == 37){

      if (y == 0){
        System.out.println("左に移動できません");
        return;
      }else {
        System.out.println("左に移動する");
      }
      data[x][y] = data[x][y - 1];
      data[x][y - 1] = 0;
      y--;
      step++;
      initImage();

    } else if (keyCode == 38) {

        if (x == 0){
          System.out.println("上に移動できません");
          return;
        }else {
          System.out.println("上に移動する");
        }
        data[x][y] = data[x - 1][y];
        data[x - 1][y] = 0;
        x--;
        step++;
        initImage();

    } else if (keyCode == 39) {

      if (y == 3){
        System.out.println("右に移動できません");
        return;
      }else {
        System.out.println("右に移動する");
      }
      data[x][y] = data[x][y + 1];
      data[x][y + 1] = 0;
      y++;
      step++;
      initImage();

    } else if (keyCode == 40) {

      if (x == 3){
        System.out.println("下に移動できません");
        return;
      }else {
        System.out.println("下に移動する");
      }
      data[x][y] = data[x + 1][y];
      data[x + 1][y] = 0;
      x++;
      step++;
      initImage();
    } else if (keyCode == 65) {
      initImage();
    } else if (keyCode == 70){
      data = new int[][]{
          {1,2,3,4},
          {5,6,7,8},
          {9,10,11,12},
          {13,14,15,0},
      };

      initImage();
    }
  }

  public boolean victory(){

    for (int i = 0; i < data.length; i++) {
      for (int j = 0; j < data[i].length; j++) {
        if (data[i][j] != win[i][j]){
          return false;
        }
      }
    }
    return true;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    Object obj = e.getSource();
    if (obj == rePlayItem){
      System.out.println("再プレイ");
      step = 0;
      initData();
      initImage();

    } else if (obj == reLoginItem) {
      System.out.println("再ログイン");

    } else if (obj == closeItem) {
      System.out.println("終了");
      System.exit(0);

    } else if (obj == girl) {
      System.out.println("美人の画像に変更する");
      path = "image\\girl\\girl" + (random.nextInt(13) + 1) + "\\";
      initData();
      initImage();

    } else if (obj == animal) {
      System.out.println("動物の画像に変更する");
      path = "image\\animal\\animal" + (random.nextInt(8) + 1) + "\\";
      initData();
      initImage();

    } else if (obj == sport) {
      System.out.println("スポーツの画像に変更する");
      path = "image\\sport\\sport" + (random.nextInt(10) + 1) + "\\";
      initData();
      initImage();

    }

  }
}
