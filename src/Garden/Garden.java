/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Garden;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import javax.swing.JFrame;
import static Garden.UserInterface.getFlowerInput;
import static Garden.UserInterface.getIntInput;
import java.awt.Color;

/**
 *
 * @author Wenjia Wang
 */
public class Garden {

    private static JFrame myWindow;
    private static ArrayList<FlowerBed> myFlowerbed = new ArrayList<>();
    private static ArrayList<Flower> myFlower = new ArrayList<>();
    private static Scanner keyboard;
    static Garden myGarden = new Garden();

    public static void main(String[] args) {
        myWindow = new JFrame();
        myWindow.setVisible(true);
        myWindow.setSize(1400, 800);
        myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myWindow.getContentPane().setBackground(new Color(20, 100, 20));
        FileUtils.readFlowerFromFile();
        FileUtils.readFlowerbedFromFile();
        myWindow.repaint();
        UserInterface.showMenu();
        Garden myGarden = new Garden();
    }
/*
    This method is used for saving the garden
    */
    protected static void saveGarden() {
        FileUtils.saveFlowerBedToFile(myFlowerbed);
        FileUtils.saveFlowerToFile(myFlower);

        exitWindow();
    }
/*
    This method is used for removing the garden
    */
    protected static void RemoveGarden() {
        if (myFlowerbed.size() < 1) {
            System.out.println("there is no flowerbed to remove");
            UserInterface.showMenu();
        } else {
            System.out.println("please select the sequence number of the flowerbed you want to remove");
            int counter = 1;
            for (FlowerBed flowerB : getMyFlowerBed()) {
                System.out.println(counter + ".\t FlowerBedX=" + flowerB.myX + " FlowerBedY=" + flowerB.myY + " FlowerBedNo=" + flowerB.myNo);
                counter++;
            }
            int inputRemoveNum = getIntInput();
            while (inputRemoveNum > counter - 1 || inputRemoveNum < 1) {
                System.out.println("please enter the correct number.");
                inputRemoveNum = getIntInput();
            }
            int indexNum = inputRemoveNum - 1;
            int FlowerindexNum = myFlowerbed.get(indexNum).myNo;
            for (int flowerIndex = myFlower.size() - 1; flowerIndex >= 0; flowerIndex--) {
                int myFlowerNo = myFlower.get(flowerIndex).myNo;
                if (myFlowerNo == FlowerindexNum) {
                    //System.out.println(myFlowerNo);
                    myFlower.remove(flowerIndex);
                }
            }
            int Count = 1;
            myFlowerbed.remove(indexNum);
            clearWindow();
        }
    }
/*
    This method is used for clearing the garden
    */
    public static void clearWindow() {
        myWindow.dispose();
        myWindow = new JFrame();
        myWindow.setVisible(true);
        myWindow.setSize(1400, 800);
        myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myWindow.getContentPane().setBackground(new Color(20, 100, 20));
        FileUtils.saveFlowerToFile(myFlower);
        FileUtils.saveFlowerBedToFile(myFlowerbed);
        myFlower.removeAll(myFlower);
        myFlowerbed.removeAll(myFlowerbed);
        FileUtils.readFlowerFromFile();
        FileUtils.readFlowerbedFromFile();
        myWindow.repaint();
        UserInterface.showMenu();
    }
/*
    This method is used for adding flowerbed into garden
    */
    protected static void addFB(String imagePath, int x, int y, int width, int height, int No) {
        FlowerBed fb;
        fb = new FlowerBed(imagePath, x, y, width, height, No);
        myWindow.add(fb);
    }
/*
    This method is used for adding flowerbed or flowers into garden
    */
    protected static void addImage(String imagePath, int x, int y, int width, int height, int No, String Type) {
        if (Type.equals("bed")) {
            FlowerBed fb;
            fb = new FlowerBed(imagePath, x, y, width, height, No);
            myWindow.add(fb);
        } else {
            Flower f;
            f = new Flower(imagePath, x, y, width, height, No, Type);
            myWindow.add(f);
        }
        System.out.println("Image added: " + imagePath);
        myWindow.repaint();
    }

    public static JFrame getMyWindow() {
        return myWindow;
    }
/*
    This method is used for adding flowerbed element into arraylist FlowerBed
    */
    public static ArrayList<FlowerBed> getMyFlowerBed() {
        return myFlowerbed;
    }
/*
    This method is used for adding flowerbed element into arraylist Flower
    */
    public static ArrayList<Flower> getMyFlower() {
        return myFlower;
    }
/*
    This method is used for getting the information about the flowerbed
    */
    public static void getFlowerbedInput(String FlowerbedPath) {
        System.out.println("Adding flowerbed:");
        System.out.println("Please input the flowerbed width:");
        int width = getIntInput();
        while (width > 1200 || width < 25) {
            System.out.println("please input width between 25 and 1200");
            width = getIntInput();
        }
        System.out.println("Please input the flowerbed height:");
        int height = getIntInput();
        while (height > 600 || height < 25) {
            System.out.println("please input height between 25 and 600");
            height = getIntInput();
        }
        System.out.println("Please input location x:");
        int imageX = getIntInput();
        while (imageX > 1200 || imageX < 0) {
            System.out.println("please input X between 0 and 1200");
            imageX = getIntInput();
        }
        System.out.println("Please input location y:");
        int imageY = getIntInput();
        while (imageY > 600 || imageY < 0) {
            System.out.println("please input Y between 0 and 600");
            imageY = getIntInput();
        }
        int No = myFlowerbed.size() + 1;
        FlowerBed fb = new FlowerBed(FlowerbedPath, imageX, imageY, width, height, No);
        myFlowerbed.add(fb);
        getFlowerInput(No - 1);
    }
/*
    This method is used for adding flowerbed element into arraylist FlowerBed
    */
    public static void addToFlowerBedArrayList(String path, int x, int y, int w, int h, int No) {
        FlowerBed fb = new FlowerBed(path, x, y, w, h, No);
        myFlowerbed.add(fb);
    }
/*
    This method is used for adding flower element into arraylist Flower
    */
    public static void addToFlowerArrayList(String path, int x, int y, int w, int h, int No, String type) {
        Flower flowers = new Flower(path, x, y, w, h, No, type);
        myFlower.add(flowers);
    }
/*
    This method is used for adding flower with a plain attern
    */
    public static void PlainPattern(int fbNo) {
        int counter = 1;
        ArrayList<String> fileNames = FileUtils.getFileNames("flower");
        for (String s : fileNames) {
            if (s.endsWith(".png")) {
                System.out.println(counter + "." + s);
            }
            counter++;
        }
        System.out.println("Please select the tyoe of flower you want:");
        int input = getIntInput();
        while (input < 1 || input > 5) {
            System.out.println("input number between 1-5");
            input = getIntInput();
        }
        String path = fileNames.get(input - 1);
        String Type;
        Type = path.replace(".png", "");
        System.out.println("You selected " + path);
        int x = myFlowerbed.get(fbNo).getX();
        int y = myFlowerbed.get(fbNo).getY();
        int w = myFlowerbed.get(fbNo).getWidth();
        int h = myFlowerbed.get(fbNo).getHeight();
        int heightNum = (int) Math.floor(h / 25);
        int widthNum = (int) Math.floor(w / 25);
        for (int i = 0; i < heightNum; i++) {
            for (int j = 0; j < widthNum; j++) {
                Flower f = new Flower(path, x + i * 25, y + j * 25, 25, 25, fbNo + 1, Type);
                myFlower.add(f);
                addImage(path, x + i * 25, y + j * 25, 25, 25, fbNo, Type);
            }
        }
        addImage(myFlowerbed.get(fbNo).getPath(), x, y, w, h, fbNo, "bed");
        UserInterface.showMenu();
    }
/*
    This method is used for adding flower with a vertical attern
    */
    public static void VerticalPattern(int fbNo) {
        int list = myFlowerbed.get(fbNo).getHeight() / 25;
        ArrayList<String> path = new ArrayList<>();
        ArrayList<String> fileNames = FileUtils.getFileNames("flower");
        ArrayList<String> type = new ArrayList<>();
        for (int i = 1; i <= list; i++) {
            int counter = 1;
            System.out.println("Please select the flower for row " + i);
            for (String s : fileNames) {
                if (s.endsWith(".png")) {
                    System.out.println(counter + "." + s);
                }
                counter++;
            }
            int input = getIntInput();
            while (input < 1 || input > 5) {
                System.out.println("input number between 1-5");
                input = getIntInput();
            }
            path.add(fileNames.get(input - 1));
            type.add(fileNames.get(input - 1).replace(".png", ""));
        }
        int x = myFlowerbed.get(fbNo).getX();
        int y = myFlowerbed.get(fbNo).getY();
        int w = myFlowerbed.get(fbNo).getWidth();
        int h = myFlowerbed.get(fbNo).getHeight();
        int heightNum = (int) Math.floor(h / 25);
        int widthNum = (int) Math.floor(w / 25);
        // System.out.println(heightNum);
        for (int i = 0; i < heightNum; i++) {
            for (int j = 0; j < widthNum; j++) {
                Flower f = new Flower(path.get(i), x + i * 25, y + j * 25, 25, 25, fbNo + 1, type.get(i));
                myFlower.add(f);
                addImage(path.get(i), x + i * 25, y + j * 25, 25, 25, fbNo, type.get(i));
            }
        }
        addImage(myFlowerbed.get(fbNo).getPath(), x, y, w, h, fbNo, "bed");
        UserInterface.showMenu();
    }
/*
    This method is used for adding flower with a horizontal attern
    */
    public static void HorizontalPattern(int fbNo) {
        int list = myFlowerbed.get(fbNo).getHeight() / 25;
        ArrayList<String> path = new ArrayList<>();
        ArrayList<String> fileNames = FileUtils.getFileNames("flower");
        ArrayList<String> type = new ArrayList<>();
        for (int i = 1; i <= list; i++) {
            int counter = 1;
            System.out.println("Please select the flower for line " + i);
            for (String s : fileNames) {
                if (s.endsWith(".png")) {
                    System.out.println(counter + "." + s);
                }
                counter++;
            }
            int input = getIntInput();
            while (input < 1 || input > 5) {
                System.out.println("input number between 1-5");
                input = getIntInput();
            }
            path.add(fileNames.get(input - 1));
            type.add(fileNames.get(input - 1).replace(".png", ""));
        }
        int x = myFlowerbed.get(fbNo).getX();
        int y = myFlowerbed.get(fbNo).getY();
        int w = myFlowerbed.get(fbNo).getWidth();
        int h = myFlowerbed.get(fbNo).getHeight();
        int heightNum = (int) Math.floor(h / 25);
        int widthNum = (int) Math.floor(w / 25);
        System.out.println(heightNum);
        for (int i = 0; i < heightNum; i++) {
            for (int j = 0; j < widthNum; j++) {
                Flower f = new Flower(path.get(i), x + j * 25, y + i * 25, 25, 25, fbNo + 1, type.get(i));
                myFlower.add(f);
                addImage(path.get(i), x + j * 25, y + i * 25, 25, 25, fbNo, type.get(i));
            }
        }
        addImage(myFlowerbed.get(fbNo).getPath(), x, y, w, h, fbNo, "bed");
        UserInterface.showMenu();
    }
/*
    This method is used for exiting the window
    */
    public static void exitWindow() {
        myWindow.dispose();
        System.exit(0);
    }
}
