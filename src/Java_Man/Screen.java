package Java_Man; /**
 * Created by joshuamaroney on 11/19/14.
 */

import com.sun.java.swing.plaf.windows.WindowsTableHeaderUI;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.util.Random;
import java.awt.Dimension;

public class Screen extends JPanel implements Runnable{

    public static final int WIDTH = 900, HEIGHT = 700;
    private Thread thread;
    private boolean running = false;

    private javaMan b;
    private ArrayList<javaMan> player;

    private javaCup cup;
    private ArrayList<javaCup>cups;

    private Random r;

    private int xCoor = 10, yCoor = 10;
    private int size = 0;

    private boolean right = true, left = false, up = false, down = false;

    private int ticks = 0;

    private Key key;

    public Screen(){
        setFocusable(true);
        key = new Key();
        addKeyListener(key);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        r = new Random();

        player = new ArrayList<javaMan>();
        cups = new ArrayList<javaCup>();
        start();
    }

    public void tick(){
        if(player.size()==0){
            b = new javaMan(xCoor, yCoor, 15);
            player.add(b);

        }
           if (cups.size() == 0){
           int xCoor = r.nextInt(79);
           int yCoor = r.nextInt(79);

            cup = new javaCup(xCoor,yCoor, 15);
            cups.add(cup);

        }
        for(int i = 0; i<cups.size();i++){
            if(xCoor == cups.get(i).getxCoor() && yCoor == cups.get(i).getyCoor()){
                //size++;
                cups.remove(i);
                i--;
            }
        }


        ticks++;

        if(ticks>250000){
            if(right) xCoor++;
            if(left) xCoor--;
            if(up) yCoor--;
            if(down) yCoor++;

            ticks = 0;

            b = new javaMan(xCoor, yCoor, 10);
            //player.add(b);

            if(player.size()> size){
                player.remove(0);
            }
        }

    }

    public void paint(Graphics g) {
        g.clearRect(0, 0, WIDTH, HEIGHT);
        g.setColor(Color.PINK);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        g.setColor(Color.BLACK);

//        for (int i = 0; i < WIDTH / 10; i++) {
//            g.drawLine(i * 10, 0, i * 10, HEIGHT);
//        }
//        for (int i = 0; i < HEIGHT / 10; i++) {
//            g.drawLine(0, i * 10, WIDTH, i * 10);
//        }
        for (int i = 0; i < player.size(); i++) {
            player.get(i).draw(g);
        }
        for (int i = 0; i < cups.size(); i++) {
               cups.get(i).draw(g);
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
