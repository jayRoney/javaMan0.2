package Java_Man; /**
 * Created by joshuamaroney on 11/19/14.
 */

import com.sun.java.swing.plaf.windows.WindowsTableHeaderUI;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.Color;

public class Screen extends JPanel implements Runnable{

    public static final int WIDTH = 800, HEIGHT = 800;
    private Thread thread;
    private boolean running = false;

    private javaMan b;
    private ArrayList<javaMan> player;

    private int xCoor = 10, yCoor = 10;
    private int size = 5;

    private boolean right = true, left = false, up = false, down = false;

    private int ticks = 0;

    private Key key;

    public Screen(){
        setFocusable(true);
        key = new Key();
        addKeyListener(key);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        player = new ArrayList<javaMan>();

        start();
    }

    public void tick(){
        if(player.size()==0){
            b = new javaMan(xCoor, yCoor, 10);
            player.add(b);

        }

        ticks++;

        if(ticks>250000){
            if(right) xCoor++;
            if(left) xCoor--;
            if(up) yCoor--;
            if(down) yCoor++;

            ticks = 0;

            b = new javaMan(xCoor, yCoor, 10);
            player.add(b);

            if(player.size()> size){
                player.remove(0);
            }
        }

    }

    public void paint(Graphics g) {
        g.clearRect(0,0,WIDTH,HEIGHT);
        g.setColor(Color.BLUE);
        for (int i = 0; i < WIDTH / 10; i++){
        g.drawLine(i * 10, 0, i * 10, HEIGHT);


    }
            for (int i = 0; i < HEIGHT / 10; i++) {
                g.drawLine(0,i * 10, WIDTH,i*10);
            }
        for(int i = 0; i<player.size(); i++){
            player.get(i).draw(g);
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

    private class Key implements KeyListener {


        public void keyPressed(KeyEvent e){
            int key = e.getKeyCode();

            if(key == KeyEvent.VK_RIGHT&&!left){
                up = false;
                down = false;
                right = true;
            }
            if(key == KeyEvent.VK_LEFT&&!right){
                up = false;
                down = false;
                left = true;
            }
            if(key == KeyEvent.VK_UP&&!down){
                left = false;
                right = false;
                up = true;
            }
            if(key == KeyEvent.VK_DOWN&&!up){
                left = false;
                right = false;
                down = true;
            }
        }
        @Override
        public void keyReleased(KeyEvent arg0){

        }
        @Override
        public void keyTyped(KeyEvent arg0){

        }
    }
}
