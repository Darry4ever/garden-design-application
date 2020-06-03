/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Garden;

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
 * @author Wenjia Wang
 */
public class FileUtils {
/*
    This method is used for loading image
    */
    public static BufferedImage loadImage(String imagePath) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(imagePath));
            System.out.println("Image loaded: " + imagePath);
        } catch (IOException e) {
            System.out.println("Problem loading image: " + imagePath);
            e.printStackTrace();
        }
        return image;
    }
/*
    This method is used for getting file names
    */
    public static ArrayList<String> getFileNames(String dirPath) {
        ArrayList<String> names = new ArrayList<String>();
        File dir = new File(dirPath);
        if (dir.isDirectory()) {
            for (File f : dir.listFiles()) {
                names.add(f.getPath());
            }
        }
        return names;
    }
/*
    This method is used for saving flowerbed to file
    */
    public static boolean saveFlowerBedToFile(ArrayList<FlowerBed> toWrite) {
        try (FileWriter fw = new FileWriter("garden.txt", false);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw)) {
            for (FlowerBed im : toWrite) {
                out.println(im.constructor());
            }

        } catch (IOException e) {

            return false;
        }
        System.out.println("garden saved to file");
        return true;

    }
/*
    This method is used for saving flowers into file
    */
    public static boolean saveFlowerToFile(ArrayList<Flower> toWrite) {
        try (FileWriter fw = new FileWriter("Flower.txt", false);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw)) {
            for (Flower im : toWrite) {
                out.println(im.toString());
            }
//                    for (FlowerBed im: toWrite){
//                        out.println(im.toString());
//                    }
        } catch (IOException e) {

            return false;
        }
        System.out.println("flower saved to file");
        return true;

    }
/*
    This method is used for reading flowerbed from file
    */
    public static void readFlowerbedFromFile() {
        Path filePath = Paths.get("garden.txt");
        if (!Files.exists(filePath)) {
            System.out.println("There is no file to read from.");
        }
        try (BufferedReader reader = Files.newBufferedReader(filePath)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                if (line.startsWith("ImageDisplay")) {
                    FlowerBedimageFromString(line);
                } else {
                    System.out.println("Bad line in file: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file:" + filePath);
            e.printStackTrace();
        }

    }
/*
    This method is used for reading flowers from file
    */
    public static void readFlowerFromFile() {
        Path filePath = Paths.get("Flower.txt");
        if (!Files.exists(filePath)) {
            System.out.println("There is no file to read from.");
        }
        try (BufferedReader reader = Files.newBufferedReader(filePath)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                if (line.startsWith("ImageDisplay")) {
                    FlowerimageFromString(line);
                } else {
                    System.out.println("Bad line in file: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file:" + filePath);
            e.printStackTrace();
        }
    }
/*
    This method is used for get flowers information from the file
    */
    private static void FlowerimageFromString(String line) {
        String[] data = line.split(",");

        String[] r1 = data[1].split("=");
        int x = Integer.parseInt(r1[1]);

        String[] r2 = data[2].split("=");
        int y = Integer.parseInt(r2[1]);

        String[] r3 = data[3].split("=");
        int w = Integer.parseInt(r3[1]);

        String[] r4 = data[4].split("=");
        int h = Integer.parseInt(r4[1]);

        String[] r5 = data[5].split("=");
        String path = r5[1];

        String[] r6 = data[6].split("=");
        int No = Integer.parseInt(r6[1]);

        Garden.addToFlowerArrayList(path, x, y, w, h, No, "flower");
        Garden.addImage(path, x, y, w, h, No, "flower");
    }
/*
    This method is used for get flowerbed information from the file
    */
    private static void FlowerBedimageFromString(String line) {
        String[] data = line.split(",");

        String[] r1 = data[1].split("=");
        int x = Integer.parseInt(r1[1]);

        String[] r2 = data[2].split("=");
        int y = Integer.parseInt(r2[1]);

        String[] r3 = data[3].split("=");
        int w = Integer.parseInt(r3[1]);

        String[] r4 = data[4].split("=");
        int h = Integer.parseInt(r4[1]);

        String[] r5 = data[5].split("=");
        String path = r5[1];

        String[] r6 = data[6].split("=");
        int No = Integer.parseInt(r6[1]);
        Garden.addFB(path, x, y, h, h, No);
        Garden.addToFlowerBedArrayList(path, x, y, w, h, No);
    }

}
