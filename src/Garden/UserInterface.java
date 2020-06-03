/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Garden;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import static Garden.Garden.HorizontalPattern;
import static Garden.Garden.PlainPattern;
import static Garden.Garden.getFlowerbedInput;
import static Garden.Garden.VerticalPattern;

/**
 *
 * @author Wenjia Wang
 */
public class UserInterface {

    private static Scanner kb;
/*
    This method is used for showing the menu
    */
    public static void showMenu() {
        kb = new Scanner(System.in);
        System.out.println("Welcome to my garden!\n");
        System.out.println("Please select:");
        System.out.println("1.\tAdd flowerbed");
        System.out.println("2.\tRemove folwerbed");
        System.out.println("3.\tSave and exit");
        //System.out.println("4.\tRead from file");
        int command = getIntInput();
        switch (command) {
            case 1:
                Garden.getFlowerbedInput("grass.png");
                break;
            case 2:
                Garden.RemoveGarden();
                //System.out.println("Removing flowerbed:");
                break;
            case 3:
                Garden.saveGarden();
                break;
            default:
                System.out.println("Please input a value from 1 to 3");
                UserInterface.showMenu();
        }
    }
/*
    This method is used for validating the user input, making sure it is a integer
    */
    public static int getIntInput() {
        int input = 0;
        try {
            input = Integer.parseInt(kb.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("That is not an int; "
                    + "please try again");
            input = getIntInput();
        } finally {
            return input;
        }
    }
/*
    This method is used for getting flower pattern input
    */
    public static void getFlowerInput(int fbNo) {
        System.out.println("Please select the type of the flower pattern you want:");
        System.out.println("1.\tplain");
        System.out.println("2.\thorizontal");
        System.out.println("3.\tvertical");
        int command2 = getIntInput();
        switch (command2) {
            case 1:
                PlainPattern(fbNo);
                break;
            case 2:
                HorizontalPattern(fbNo);
                break;
            case 3:
                VerticalPattern(fbNo);
                break;
            default:
                System.out.println("Please input a value from 1 to 3");
        }

    }

}
