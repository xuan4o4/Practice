package test;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class MouseListenerTest extends JFrame implements MouseListener {

  public MouseListenerTest() {
    //ウィンドウのサイズを設定する
    this.setSize(603, 680);

    //ウィンドウのタイトルを設定する
    this.setTitle("イベントデモ");

    //常に最前面に表示するように設定する
    this.setAlwaysOnTop(true);

    //画面中央にウィンドウを表示する
    this.setLocationRelativeTo(null);

    //ウィンドウを閉じたときにプログラムを終了するように設定する
    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    //中央揃えを無効にする
    this.setLayout(null);

    JButton jbt = new JButton("MouseTest");

    jbt.setBounds(0, 0, 200, 100);

    jbt.addMouseListener(this);

    this.getContentPane().add(jbt);

    //ウィンドウを表示する
    this.setVisible(true);


  }

  @Override
  public void mouseClicked(MouseEvent e) {
    System.out.println("单击");
  }

  @Override
  public void mousePressed(MouseEvent e) {
    System.out.println("按下");
  }

  @Override
  public void mouseReleased(MouseEvent e) {
    System.out.println("松开");
  }

  @Override
  public void mouseEntered(MouseEvent e) {
    System.out.println("划入");
  }

  @Override
  public void mouseExited(MouseEvent e) {
    System.out.println("划出");
  }
}
