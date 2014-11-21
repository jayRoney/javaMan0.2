package Java_Man;

import java.awt.*;

/**
 * Created by joshuamaroney on 11/19/14.
 */
public class javaMan {

    private int xCoor, yCoor, width, height;

    public javaMan(int xCoor, int yCoor, int tilesize){
        this.xCoor = xCoor;
        this.yCoor = yCoor;
        width = tilesize;
        height = tilesize;

    }

    public void tick(){


    }

    public void draw(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(xCoor * width, yCoor * height, width, height);
        g.setColor(Color.GREEN);
        g.fillRect(xCoor * width + 2, yCoor * height + 2, width-4, height-4);
    }
}
