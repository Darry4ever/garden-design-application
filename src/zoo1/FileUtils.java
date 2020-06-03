/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zoo1;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 *
 * @author joelewis
 * A utility class to perform common file read, write, and other I/O
 */
public class FileUtils {
    
    public static BufferedImage loadImage(String imagePath){
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(imagePath));
            System.out.println("Image loaded: "+imagePath);
        } catch (IOException e) {
            System.out.println("Problem loading image: "+imagePath);
            e.printStackTrace();
        }
        return image;
    }
    
    public static ArrayList<String> getFileNames(String dirPath){
        ArrayList<String> names = new ArrayList<String>();
        File dir = new File(dirPath);
        if(dir.isDirectory()){
            for(File f: dir.listFiles()){
                names.add(f.getPath());
            }
        }
        return names;
    }
    
    public static boolean saveZooToFile(ArrayList<ImageDisplay> toWrite) {
        try (FileWriter fw = new FileWriter("zoo.txt", false);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw)) {
                    for(ImageDisplay im: toWrite){
                        out.println(im.toString());
                    }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        System.out.println("Zoo saved to file");
        return true; 
    }
    
    public static void readZooFromFile(){
        Path filePath = Paths.get("zoo.txt");
        if(!Files.exists(filePath)){
            System.out.println("There is no file to read from.");
        }
        try (BufferedReader reader = Files.newBufferedReader(filePath)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                if(line.startsWith("ImageDisplay")){
                    imageFromString(line);
                }
                else{
                    System.out.println("Bad line in file: "+line);
                }   
            }
        } catch (IOException e) {
            System.out.println("Error reading file:" + filePath);
            e.printStackTrace();
        }
    }
    
    private static void imageFromString(String line){
        
    }
    
    
}
