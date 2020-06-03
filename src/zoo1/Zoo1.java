/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zoo1;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author joelewis
 */
public class Zoo1 {
    private static JFrame myWindow;
    private static ArrayList<ImageDisplay> myAnimals = new ArrayList<>();

    
    public static void main(String[] args) {
        myWindow = new JFrame();
        myWindow.setVisible(true);
        myWindow.setSize(400, 400);
        myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //FileUtils.readZooFromFile();
        UserInterface.showMenu();
    }
    
    protected static void saveZoo(){
        FileUtils.saveZooToFile(myAnimals);
    }
    
    protected static void addImage(String imagePath){
        BufferedImage image = FileUtils.loadImage(imagePath);
        ImageDisplay myImage;
        myImage = new ImageDisplay(image, 100, 100, 100,100);
        myWindow.add(myImage);
        myAnimals.add(myImage);
        System.out.println("Image added: "+ imagePath);
        myWindow.repaint();
    }
    
    protected static void addImage(String imagePath, int x, int y, int width, int height){
        BufferedImage image = FileUtils.loadImage(imagePath);
        ImageDisplay myImage;
        myImage = new ImageDisplay(image, x, y, width,height);
        myWindow.add(myImage);
        myAnimals.add(myImage);
        System.out.println("Image added: "+ imagePath);
        myWindow.repaint();
    }

    public static JFrame getMyWindow() {
        return myWindow;
    }

    public static ArrayList<ImageDisplay> getMyAnimals() {
        return myAnimals;
    }
    
    
    
}
