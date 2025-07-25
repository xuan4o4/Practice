import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.*;
import javax.swing.border.BevelBorder;

public class GameJFrame extends JFrame implements KeyListener {

  int[][] data = new int[4][4];
  int x = 0;
  int y = 0;
  String path = "image\\animal\\animal1\\";
  int[][] win = {
      {1, 2, 3, 4},
      {5, 6, 7, 8},
      {9, 10, 11, 12},
      {13, 14, 15, 0}
  };

  JLabel[][] labels = new JLabel[4][4];

  public GameJFrame() {
    initJFrame();
    initJMenuBar();
    initData();
    initImageFirstTime();
    updateImages();
    this.setVisible(true);
  }

  private void initData() {
    int[] tempArr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};

    Random random = new Random();
    for (int i = 0; i < tempArr.length; i++) {
      int index = random.nextInt(tempArr.length);
      int temp = tempArr[i];
      tempArr[i] = tempArr[index];
      tempArr[index] = temp;
    }

    for (int i = 0; i < tempArr.length; i++) {
      data[i / 4][i % 4] = tempArr[i];
      if (tempArr[i] == 0) {
        x = i / 4;
        y = i % 4;
      }
    }
  }

  private void initImageFirstTime() {
    this.getContentPane().setLayout(null);

    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        labels[i][j] = new JLabel();
        labels[i][j].setBounds(105 * j + 83, 105 * i + 134, 105, 105);
        labels[i][j].setBorder(new BevelBorder(BevelBorder.LOWERED));
        this.getContentPane().add(labels[i][j]);
      }
    }

    // 背景图（最后添加）
    JLabel background = new JLabel(new ImageIcon("image\\background.png"));
    background.setBounds(40, 40, 508, 560);
    this.getContentPane().add(background);
  }

  private void updateImages() {
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        int number = data[i][j];
        if (number != 0) {
          labels[i][j].setIcon(new ImageIcon(path + number + ".jpg"));
        } else {
          labels[i][j].setIcon(null);
        }
      }
    }

    this.getContentPane().repaint();

    if (victory()) {
      JOptionPane.showMessageDialog(this, "🎉 勝利！");
    }
  }

  private void initJFrame() {
    this.setSize(603, 680);
    this.setTitle("パズルゲーム");
    this.setAlwaysOnTop(true);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    this.setLayout(null);
    this.addKeyListener(this);

  }

  private void initJMenuBar() {
    JMenuBar jMenuBar = new JMenuBar();
    JMenu functhionJMenu = new JMenu("機能");

    JMenuItem rePlayItem = new JMenuItem("再プレイ");
    JMenuItem reLoginItem = new JMenuItem("再ログイン");
    JMenuItem closeItem = new JMenuItem("終了");

    rePlayItem.addActionListener(e -> {
      initData();
      updateImages();
    });
    closeItem.addActionListener(e -> System.exit(0));

    functhionJMenu.add(rePlayItem);
    functhionJMenu.add(reLoginItem);
    functhionJMenu.add(closeItem);
    jMenuBar.add(functhionJMenu);

    this.setJMenuBar(jMenuBar);
  }

  @Override
  public void keyTyped(KeyEvent e) {}

  @Override
  public void keyPressed(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_A) {
      JLabel all = new JLabel(new ImageIcon(path + "all.jpg"));
      all.setBounds(83, 134, 420, 420);
      this.getContentPane().add(all);
      this.getContentPane().repaint();
    }
  }

  @Override
  public void keyReleased(KeyEvent e) {
    if (victory()) return;

    int code = e.getKeyCode();
    if (code == KeyEvent.VK_LEFT && y > 0) {
      data[x][y] = data[x][y - 1];
      data[x][y - 1] = 0;
      y--;
    } else if (code == KeyEvent.VK_RIGHT && y < 3) {
      data[x][y] = data[x][y + 1];
      data[x][y + 1] = 0;
      y++;
    } else if (code == KeyEvent.VK_UP && x > 0) {
      data[x][y] = data[x - 1][y];
      data[x - 1][y] = 0;
      x--;
    } else if (code == KeyEvent.VK_DOWN && x < 3) {
      data[x][y] = data[x + 1][y];
      data[x + 1][y] = 0;
      x++;
    } else if (code == KeyEvent.VK_A) {
      updateImages();
    } else if (code == KeyEvent.VK_W) {
      data = new int[][]{
          {1, 2, 3, 4},
          {5, 6, 7, 8},
          {9, 10, 11, 12},
          {13, 14, 15, 0}
      };
      x = 3;
      y = 3;
    }

    updateImages();
  }

  public boolean victory() {
    for (int i = 0; i < 4; i++)
      for (int j = 0; j < 4; j++)
        if (data[i][j] != win[i][j]) return false;
    return true;
  }
}
