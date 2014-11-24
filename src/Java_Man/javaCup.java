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

    public javaCup(int xCoor, int yCoor, int tilesize){//constructor for javaCups
        this.xCoor = xCoor;
        this.yCoor = yCoor;
        width = tilesize;
        height = tilesize;
    }
        //get and set methods for javaCup position
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


    public void draw(Graphics g) {//draws our javaCup, (a red square at the moment)
        g.setColor(Color.WHITE);
        g.fillRect(xCoor * width, yCoor * height, width, height);//the base square
        g.fillRect((xCoor * width + 2), yCoor * height+height, width-4, 2);//bottom of the cup
        g.fillRect((xCoor * width + 2), yCoor * height-1, width-4, 2);//top of cup
        Color brown=new Color(156, 93, 82);//new Brown color the fill
        g.setColor(brown);;//changes fill color
            //Dimensions of the interior (fill) rectangles
        g.fillRect(xCoor * width + 2, yCoor * height +2, width-4, height-10);
        g.fillRect((xCoor * width + 2)+2, yCoor * height+7, width-8, height-13);
        g.fillRect((xCoor * width + 2)+2, yCoor * height+1, width-8, height-13);
            //draws the cup handle
        g.setColor(Color.WHITE);
        g.fillRect((xCoor * width)+(width-1), (yCoor * height)+(height/4), width/2, height/2);
        g.setColor(Color.pink);
        g.fillRect((xCoor * width)+(width-1)+width/6, (yCoor * height+height/6)+(height/4), width/4, height/4);
            //Unused
        //g.drawImage(xCoor * width, yCoor * height, width, height,)
    }

   }



