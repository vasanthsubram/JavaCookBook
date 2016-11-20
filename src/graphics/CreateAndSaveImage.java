package graphics;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author vsubramanian
 */
public class CreateAndSaveImage {

    public static void main(String[] args) {

        //  Create  an image to save
        RenderedImage rendImage = myCreateImage();

        // Write generated image to a file
        try {
           // Save as JPEG                      
           File file = new File(System.getProperty("user.dir") +"/newimage.jpg");
           file.createNewFile();
            ImageIO.write(rendImage, "jpg", file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
// Returns a generated image.
   static RenderedImage myCreateImage() {
        int width = 100;
        int height = 100;

        // Create a buffered image in which to draw
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        // Create a graphics contents on the buffered image
        Graphics2D g2d = bufferedImage.createGraphics();

        // Draw graphics
        g2d.setColor(Color.white);
        g2d.fillRect(0, 0, width, height);
        g2d.setColor(Color.black);
        g2d.fillOval(0, 0, width, height);

        // Graphics context no longer needed so dispose it
        g2d.dispose();

        return bufferedImage;
    }
}
