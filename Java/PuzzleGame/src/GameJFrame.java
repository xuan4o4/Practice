import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.WindowConstants;

public class GameJFrame extends JFrame {
  int[][] data = new int[4][4];

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
      data[i / 4][i % 4] = tempArr[i];
    }
  }

  private void initImage() {

    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        int number = data[i][j];
        //画像の ImageIcon オブジェクトを作成する
        //JLabel のオブジェクトを作成する
        JLabel jLabel = new JLabel(new ImageIcon(
            "C:\\Users\\user\\Desktop\\Practice\\Java\\PuzzleGame\\image\\animal\\animal1\\"
                + number + ".jpg"));

        //位置とサイズを設定する
        jLabel.setBounds(105 * j, 105 * i, 105, 105);

        //画面に追加する
        this.getContentPane().add(jLabel);
        number++;
      }
    }


  }


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

    //中央揃えを無効にする
    this.setLayout(null);
  }


  private void initJMenuBar() {
    JMenuBar jMenuBar = new JMenuBar();

    JMenu functhionJMenu = new JMenu("機能");

    JMenuItem rePlayItem = new JMenuItem("再プレイ");
    JMenuItem reLoginItem = new JMenuItem("再ログイン");
    JMenuItem closeItem = new JMenuItem("終了");

    functhionJMenu.add(rePlayItem);
    functhionJMenu.add(reLoginItem);
    functhionJMenu.add(closeItem);

    jMenuBar.add(functhionJMenu);

    this.setJMenuBar(jMenuBar);
  }
}
