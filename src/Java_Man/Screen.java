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

    public static final int WIDTH = 900, HEIGHT = 700;//creates constant variables for screen height
    private Thread thread;//new thread
    private boolean running = false;

    private javaMan b;//creates instance of new javaMan character
    private ArrayList<javaMan> player;//array to hold javaMan

    private javaCup cup;//creates new instance of javaCup
    private ArrayList<javaCup>cups;//creates new array for javaCups

    private Random r;//random number generator

    private int xCoor = 10, yCoor = 10;
    private int size = 0;

    private boolean right = true, left = false, up = false, down = false;//directional booleans

    private int ticks = 0;

    private Key key;

    public Screen(){
        setFocusable(true);
        key = new Key();//new instance of key
        addKeyListener(key);//listens out for key presses, left, right, up, or down.
        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        r = new Random();

        player = new ArrayList<javaMan>();//creates new arrayList to hold javaMan
        cups = new ArrayList<javaCup>();//creates new arrayList to hold javaCups
        start();//starts game
    }

    public void tick(){
        if(player.size()==0){
            b = new javaMan(xCoor, yCoor, 15);
            player.add(b);

        }
           if (cups.size() == 0){
           int xCoor = r.nextInt(79);
           int yCoor = r.nextInt(79);

            cup = new javaCup(xCoor,yCoor, 15);//adds new cup to screen
            cups.add(cup);//adds new cup to array

        }
        for(int i = 0; i<cups.size();i++){
            if(xCoor == cups.get(i).getxCoor() && yCoor == cups.get(i).getyCoor()){
                cups.remove(i);
                i--;
            }
        }
        for (int i = 0; i < player.size();i++){
            if (xCoor == player.get(i).getxCoor() && yCoor == player.get(i).getyCoor());
                if(i != player.size() - 1) {
                    stop();
                }

        }


        if(xCoor < 0 || xCoor > 54 || yCoor < 0 || yCoor > 54 ) {//boundaries for screen
            stop();
        }

        ticks++;

        if(ticks>250000){
            if(right) xCoor++;
            if(left) xCoor--;
            if(up) yCoor--;
            if(down) yCoor++;

            ticks = 0;

            b = new javaMan(xCoor, yCoor, 10);//creates new instance of javaMan


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

        for (int i = 0; i < player.size(); i++) {//draws javaMan to screen
            player.get(i).draw(g);
        }
        for (int i = 0; i < cups.size(); i++) {//draws cups to screen
               cups.get(i).draw(g);
            }
        }


    public void start(){//starts game
        running = true;//sets running to true to run game
        thread = new Thread(this, "Game Loop");//new thread to handle multiple tasks
        thread.start();//starts thread


    }

    public void stop(){
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    public void run(){
        while(running){
            tick();
            repaint();//updates screen
        }

    }

    private class Key implements KeyListener {//key class that tracks key presses


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
