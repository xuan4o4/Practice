package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class ButtonListenerTest1 extends JFrame {

  public void buttonTest1(){
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

    JButton jbt = new JButton("ボタンです");

    jbt.setBounds(0, 0, 200, 100);

    jbt.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.out.println("ダメです！！");
      }
    });

    this.getContentPane().add(jbt);

    //ウィンドウを表示する
    this.setVisible(true);
  }
}
