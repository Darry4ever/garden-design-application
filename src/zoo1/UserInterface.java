/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zoo1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joelewis
 */
public class UserInterface {
    private static Scanner kb;
    
    public static void showMenu(){
        kb = new Scanner(System.in);
        System.out.println("Welcome to my Zoo!\n");
        System.out.println("Please select:");
        System.out.println("1.\tAdd animal");
        System.out.println("2.\tRemove animal");  
        int command = getIntInput();
        switch(command){
            
            case 1:
                getImageInput();
            break;
            case 2:
                System.out.println("Removing animal:");
                //now, how are we going to remove an animal
            break;
            
            default:
                System.out.println("Please input a value from 1 to 2");
        }    
    }
    
    private static int getIntInput(){
        int input = 0;
        try{
            input = Integer.parseInt(kb.nextLine());
        }
        catch(NumberFormatException e){
            System.out.println("That is not an int; "
                                + "please try again");
            input = getIntInput();
        }
        finally{
            return input;    
        }
    }
    
    private static void getImageInput(){
        System.out.println("Adding animal:");
        System.out.println("Please input path to animal image:");
        String path = kb.nextLine();    //NO! NOT LIKE THIS!
        
        // How do you want the user to choose the image? SEE LECTURE PPT
        
        //OK, when the user has chosen the image, you need to get the x,y,width,height,
        //and then call:
        //Zoo1.addImage(path, imageX, imageY, width, height);
        
        
    }
    
    
}
