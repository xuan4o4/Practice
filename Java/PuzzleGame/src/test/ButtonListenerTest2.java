package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class ButtonListenerTest2 extends JFrame implements ActionListener {

  JButton jbt1 = new JButton("ボタン1");
  JButton jbt2 = new JButton("ボタン2");

  public ButtonListenerTest2(){

    this.setSize(603,680);

    this.setTitle("ボタンデモ");

    this.setAlwaysOnTop(true);

    this.setLocationRelativeTo(null);

    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    this.setLayout(null);

    jbt1.setBounds(0, 0, 200, 100);
    jbt1.addActionListener(this);


    jbt2.setBounds(0, 200, 200, 100);
    jbt2.addActionListener(this);

    this.getContentPane().add(jbt1);
    this.getContentPane().add(jbt2);

    //ウィンドウを表示する
    this.setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {

    Object source = e.getSource();
    if (source == jbt1){
      jbt1.setSize(200,200);
    } else if (source == jbt2) {
      Random r = new Random();
      jbt2.setLocation(r.nextInt(500), r.nextInt(500));
    }
  }


}
