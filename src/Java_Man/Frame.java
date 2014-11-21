package Java_Man; /**
 * Created by joshuamaroney on 11/19/14.
 */

import javax.swing.JFrame;
import java.awt.GridLayout;

public class Frame extends JFrame {

    public Frame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("JavaMan");
        setResizable(true);

        init();


    }

    public void init(){
        setLayout(new GridLayout(1, 1, 0, 0));

        Screen s = new Screen();
        add(s);//adds Screen to frame

        pack();//sets size of frame to whatever size of screen is

        setLocationRelativeTo(null);
        setVisible(true);//make frame visible

    }

    public static void main(String[] ars){

        new Frame();

    }
}
