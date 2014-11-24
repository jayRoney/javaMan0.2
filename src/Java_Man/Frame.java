package Java_Man; /**
 * Created by joshuamaroney on 11/19/14.
 */

import javax.swing.JFrame;
import java.awt.GridLayout;

public class Frame extends JFrame {

    public Frame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//sets default close operation to close window
        setTitle("JavaMan");//sets title of frame
        setResizable(false);//window can not be resized

        init();//calls init to set layout of grid and creates a new instance of screen


    }

    public void init(){
        setLayout(new GridLayout(1, 1, 0, 0));

        Screen s = new Screen();
        add(s);//adds Screen to frame

        pack();//sets size of frame to whatever size of screen is, so it "packs" the screen in the window

        setLocationRelativeTo(null);
        setVisible(true);//make frame visible

    }

    public static void main(String[] ars){

        new Frame();//creates a new frame with screen and pretty much begins the game

    }
}
