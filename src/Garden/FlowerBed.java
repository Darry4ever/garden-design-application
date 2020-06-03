/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Garden;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Wenjia Wang
 */
public class FlowerBed extends JPanel {

    final int myX;
    final int myY;
    final int myWidth;
    final int myHeight;
    final String path;
    final int myNo;
    private final BufferedImage myImage;
    private String myType;
    private ArrayList<String> fPath = new ArrayList<>();
    private final int myMax = 10;

    public FlowerBed(String imagePath,
            int myX,
            int myY,
            int myWidth,
            int myHeight,
            int myNo) {
        this.myX = myX;
        this.myY = myY;
        this.myWidth = myWidth;
        this.myHeight = myHeight;
        this.path = imagePath;
        this.myNo = myNo;
        myImage = FileUtils.loadImage(imagePath);
        this.fPath = fPath;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(myImage, 0, 0, myWidth, myHeight, this);
    }

    @Override
    public int getX() {
        return myX;
    }

    @Override
    public int getY() {
        return myY;
    }

    @Override
    public int getWidth() {
        return myWidth;
    }

    @Override
    public int getHeight() {
        return myHeight;
    }

    public BufferedImage getImage() {
        return myImage;
    }

    public String constructor() {
        return "ImageDisplay," + " myX=" + myX + ", myY=" + myY + ", myWidth=" + myWidth + ", myHeight=" + myHeight + ", myPath=" + path + ",myNo=" + myNo;
    }

    public String getPath() {
        return path;
    }

    public int getNo() {
        return myNo;
    }

    public void addfpath(String f) {
        fPath.add(f);
    }

}
