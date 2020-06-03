/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Garden;

import java.util.ArrayList;
import static Garden.UserInterface.getIntInput;

/**
 *
 * @author Wenjia Wang
 */
public class Flower extends FlowerBed {

    private final String myType;
    private static final int flowerSize = 25;

    public Flower(String imagePath, int myX, int myY, int myWidth, int myHeight, int myNo, String myType) {
        super(imagePath, myX, myY, myWidth, myHeight, myNo);
        this.myType = myType;
        this.setOpaque(false);
        System.out.println("flower constructed:" + myType);
    }

    public String getType() {
        return myType;
    }

    public static int flowerSize() {
        return flowerSize;
    }

    public String toString() {
        return "ImageDisplay," + " myX=" + myX + ", myY=" + myY + ", myWidth=" + myWidth + ", myHeight=" + myHeight + ", myPath=" + path + ",myNo=" + myNo + ",myType=" + myType + ",myFlowerSize=" + flowerSize;
    }

}
