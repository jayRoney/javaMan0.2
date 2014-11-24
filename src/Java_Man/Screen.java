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

    public static final int WIDTH = 900, HEIGHT = 700;//constant variables for screen size
    private Thread thread;
    private boolean running = false;

    private javaMan b;//creates new instance of javaMan called b
    private ArrayList<javaMan> player;//creates new Arraylist called player for javaMan

    private javaCup cup;//creates new instance javaCup called cup
    private ArrayList<javaCup>cups;//creates new arraylist for javacups called cups

    private Random r;//random number generator

    private int xCoor = 10, yCoor = 10;
    private int size = 0;

    private boolean right = true, left = false, up = false, down = false;//booleans for directional pad

    private int ticks = 0;
    private double tickSpeed=900000;

    private Key key;//creates new instance of key

    public Screen(){//sets up screen
        setFocusable(true);
        key = new Key();
        addKeyListener(key);//listens out for keypresses from left, right, up, and down
        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        r = new Random();//new random number generator



        player = new ArrayList<javaMan>();//new arraylist for javaman called players
        cups = new ArrayList<javaCup>();//new arraylist for javacups called cups
        start();
    }

    public void tick(){
        if(player.size()==0){
            b = new javaMan(xCoor, yCoor, 15);
            player.add(b);

        }
        if (cups.size() == 0){
           int xCoor = r.nextInt(53);//creates random x and y coords
           int yCoor = r.nextInt(44);

            cup = new javaCup(xCoor,yCoor, 15);//creates new cup
            cups.add(cup);

        }
        double x = .75;
        for(int i = 0; i<cups.size();i++){
            if(xCoor == cups.get(i).getxCoor() && yCoor == cups.get(i).getyCoor()){
                cups.remove(i);
                tickSpeed=tickSpeed/1.5;//makes javaMan move faster after getting javaCup

                i--;
            }
        }
        for (int i = 0; i < player.size();i++){
            if (xCoor == player.get(i).getxCoor() && yCoor == player.get(i).getyCoor());
                if(i != player.size() - 1){
                stop();
        }

        }


        if(xCoor < 1 || xCoor > 58 || yCoor < 1 || yCoor > 45) {//sets boundaries, stops game if javaman runs into boundary
            stop();
        }

        ticks++;

        if(ticks>tickSpeed){
            if(right) xCoor++;
            if(left) xCoor--;
            if(up) yCoor--;
            if(down) yCoor++;

            ticks = 0;

            b = new javaMan(xCoor, yCoor, 10);//creates new javaman at defined x and y coords, at size 10

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


        for (int i = 0; i < player.size(); i++) {//draws javaman to screen
            player.get(i).draw(g);
        }
        for (int i = 0; i < cups.size(); i++) {//draws cup to screen
               cups.get(i).draw(g);
            }
        }


    public void start(){//starts thread and sets run to true to start game
        running = true;
        thread = new Thread(this, "Game Loop");
        thread.start();


    }

    public void stop(){//stops thread and game
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    public void run(){//starts ticks and repaints screen
        while(running){
            tick();
            repaint();
        }

    }

    private class Key implements KeyListener {//listens out for key presses from directional pad


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
        public void keyReleased(KeyEvent arg0){//unused method that is required with keypressed()

        }
        @Override
        public void keyTyped(KeyEvent arg0){//unused method that is required with keypressed()

        }
    }




}
