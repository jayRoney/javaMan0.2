package Java_Man;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * Created by joshuamaroney on 11/19/14.
 */
public class javaCup {

    private int xCoor, yCoor, width, height;

    public javaCup(int xCoor, int yCoor, int tilesize){
        this.xCoor = xCoor;
        this.yCoor = yCoor;
        width = tilesize;
        height = tilesize;
    }

    public int getyCoor() {
        return yCoor;
    }

    public void setyCoor(int yCoor) {
        this.yCoor = yCoor;
    }

    public int getxCoor() {
        return xCoor;
    }

    public void setxCoor(int xCoor) {
        this.xCoor = xCoor;
    }

    public void tick(){

    }


    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(xCoor * width, yCoor * height, width, height);
        //g.drawImage(xCoor * width, yCoor * height, width, height,)
    }

   }



