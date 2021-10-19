package com.cnn;

import java.util.*;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

/* Converts different image file formats into binary and checks them
   against each other to identify if it's the same image

   Images are normally made up of 2D arrays with each pixel specifying
   the ARGB (int values). This in case, Java provides imageio and
   Bufferedimage to read [x][y] of the image and get rgb of
   each pixel automatically.

   If two images are different, how similar are they? Can we draw a correlation
   between them?
*/

public class Recog {
	
	public static boolean imageValidation(InputStream inputStream, File[] fA) {
		boolean flag = false;
        int i = 0;
        int j = 0;
        String s = "";
        
        
        /* Scans the first image and stores the binary string into store */
        try{
           // System.out.println("Enter the (filename).(format) : ");
           // Scanner stdin = new Scanner(System.in);
           // FileInputStream in = new FileInputStream(stdin.nextLine());
//            FileInputStream in = inputStream;
            StringBuilder sb = new StringBuilder();
            while((i = inputStream.read()) !=-1) {
                sb.append(Integer.toBinaryString(i & 0xFF));
            }
            s = sb.toString();
//            in.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("file not found, added .jpg or .png?");
        }
        catch(IOException a) {
            System.out.println("input is invalid");
        }
      
        
        /* Scans the second image and compares it against the first */
        try {
           // System.out.println("Enter the other (filename).(format) : ");
          //  Scanner stdin = new Scanner(System.in);
           // FileInputStream in = new FileInputStream(stdin.nextLine());
            for(File image : fA)
            {
            	String c = "";
            	FileInputStream in = new FileInputStream(image);
                StringBuilder sb = new StringBuilder();
                while((i = in.read()) != -1) {
                    sb.append(Integer.toBinaryString(i & 0xFF));
                }
                c = sb.toString();
                if (c.equals(s)) {
                    System.out.println("MATCH. The images are the same image in different formats.");
                    flag = true;
                }
                else {
                    System.out.println("NO MATCH. The images are totally different.");
                }
                if(flag)
                {
                	break;
                }
                in.close();
            }
        }        
        catch (FileNotFoundException e) {}
        catch(IOException a) {}
		return flag;
    }

	public static void main(String[] args) {
        int i = 0;
        int j = 0;
        String s = "";
        String c = "";
        
        /* Scans the first image and stores the binary string into store */
        try{
            System.out.println("Enter the (filename).(format) : ");
            Scanner stdin = new Scanner(System.in);
            FileInputStream in = new FileInputStream(stdin.nextLine());
            StringBuilder sb = new StringBuilder();
            while((i = in.read()) !=-1) {
                sb.append(Integer.toBinaryString(i & 0xFF));
            }
            s = sb.toString();
            in.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("file not found, added .jpg or .png?");
        }
        catch(IOException a) {
            System.out.println("input is invalid");
        }
        
        /* Scans the second image and compares it against the first */
        try {
            System.out.println("Enter the other (filename).(format) : ");
            Scanner stdin = new Scanner(System.in);
            FileInputStream in = new FileInputStream(stdin.nextLine());
            StringBuilder sb = new StringBuilder();
            while((i = in.read()) != -1) {
                sb.append(Integer.toBinaryString(i & 0xFF));
            }
            c = sb.toString();
            if (c.equals(s)) {
                System.out.println("MATCH. The images are the same image in different formats.");
            }
            else {
                System.out.println("NO MATCH. The images are totally different.");
            }
            in.close();
        }        
        catch (FileNotFoundException e) {}
        catch(IOException a) {}
      
        
    }

   
}
