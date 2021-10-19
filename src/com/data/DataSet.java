package com.data;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static com.tools.CommonUtils.rng;

/**
 * This is the dataset class that loads in the whole dataset.
 */
public class DataSet {
   // private static int MAX_INSTANCES = 100;
   
   private static int MAX_INSTANCES = 50;
    private static boolean FAST = !true;
    private static int imageSize ;

    private final ArrayList<Instance> instances;


    public DataSet(final String directoryName) {
        final File dir = new File(directoryName);
        System.out.println("directoryName : "+dir);
        instances = new ArrayList<>();
        System.out.println("instances : "+instances);
        for (File file : dir.listFiles()) {
            // check all files
        	//System.out.println("for loop");
        	System.out.println("file.isFile()"+file.isFile());
        	System.out.println("file.getName" +file.getName().endsWith(".jpg"));
            if (!file.isFile() || !file.getName().endsWith(".jpg")) {
            	System.out.println("if loop");
                continue;
            }
            // String path = file.getAbsolutePath();
            BufferedImage img, scaledBI = null ;
            try {
                // load in all images
                img = ImageIO.read(file);
                // every image's name is in such format: label_image_XXXX(4 digits) though this
                // code could handle more than 4 digits.
                String name = file.getName();
                int len=name.length();
                //int locationOfUnderscoreImage = name.indexOf("_image");
                //System.out.println("locationOfUnderscoreImage"+locationOfUnderscoreImage);

                // Resize the image if requested. Any resizing allowed, but should really be one
                // of 8x8, 16x16, 32x32, or 64x64 (original data is 128x128).
                if (imageSize != 128) {
                	//System.out.println("Image size: "+imageSize);
                    scaledBI = new BufferedImage(imageSize, imageSize, BufferedImage.TYPE_INT_RGB);
                    Graphics2D g = scaledBI.createGraphics();
                    g.drawImage(img, 0, 0, imageSize, imageSize, null);
                    g.dispose();
                }

               /* Instance instance = new Instance(scaledBI == null ? img : scaledBI,name.substring(0, locationOfUnderscoreImage).toUpperCase());
                instance.setFileName(file.getName());
                instances.add(instance);*/
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(1);
            }
        }

        if (FAST) {
            while (instances.size() > MAX_INSTANCES) {
                instances.remove((int) (rng.nextDouble() * instances.size()));
            }
        }
    }

    public static void setImageSize(final int imageSize) {
        DataSet.imageSize = imageSize;
    }

    // get the size of the dataset
    public int getSize() {
        return instances.size();
    }

    // Return the list of images.
    public List<Instance> getImages() {
        return instances;
    }
}
