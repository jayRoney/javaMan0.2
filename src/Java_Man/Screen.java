package Java_Man; /**
 * Created by joshuamaroney on 11/19/14.
 */

import com.sun.java.swing.plaf.windows.WindowsTableHeaderUI;


import javax.swing.JPanel;
import java.awt.*;

public class Screen extends JPanel implements Runnable{

    public static final int WIDTH = 800, HEIGHT = 800;
    private Thread thread;
    private boolean running = false;

    public Screen(){
        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        start();
    }

    public void tick(){


    }

    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        for (int i = 0; i < WIDTH / 10; i++){
        g.drawLine(i * 10, 0, i * 10, HEIGHT);


    }
            for (int i = 0; i < HEIGHT / 10; i++) {
                g.drawLine(0,i * 10, WIDTH,i*10);
            }
    }

    public void start(){
        running = true;
        thread = new Thread(this, "Game Loop");
        thread.start();


    }

    public void stop(){


    }

    public void run(){
        while(running){
            tick();
            repaint();
        }

    }
}
