package test;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class KyeListenerTest extends JFrame implements KeyListener {

  public KyeListenerTest() {
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

    this.addKeyListener(this);

    //ウィンドウを表示する
    this.setVisible(true);
  }

  @Override
  public void keyTyped(KeyEvent e) {

  }

  @Override
  public void keyPressed(KeyEvent e) {
    System.out.println("按下不松");
  }

  @Override
  public void keyReleased(KeyEvent e) {
    System.out.println("松开按键");
    int keyCode = e.getKeyCode();
    if(keyCode == 65){
      System.out.println("按下的是A键");
    } else if (keyCode == 66) {
      System.out.println("按下的是B键");
    }
  }
}
