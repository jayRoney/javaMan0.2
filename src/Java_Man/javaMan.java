package Java_Man;

import java.awt.*;

/**
 * Created by joshuamaroney on 11/19/14.
 */
public class javaMan {

    private int xCoor, yCoor, width, height;

    public javaMan(int xCoor, int yCoor, int tilesize){//constructor for javaMan
        this.xCoor = xCoor;
        this.yCoor = yCoor;
        width = tilesize;
        height = tilesize;
    }
        //get and set methdos
    public int getxCoor() {
        return xCoor;
    }

    public void setxCoor(int xCoor) {
        this.xCoor = xCoor;
    }

    public int getyCoor() {
        return yCoor;
    }

    public void setyCoor(int yCoor) {
        this.yCoor = yCoor;
    }

    public void tick(){



    }

    public void draw(Graphics g){//javaMan is black
        g.setColor(Color.BLACK);
        g.fillRect(xCoor * width, yCoor * height, width, height);
        g.setColor(Color.ORANGE);//changes background color
        g.fillRect(xCoor * width + 2, yCoor * height + 2, width-4, height-4);
    }
}
