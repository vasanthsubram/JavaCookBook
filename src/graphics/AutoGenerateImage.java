package graphics;

import java.awt.*;
import java.awt.image.*;

public class AutoGenerateImage extends java.applet.Applet {

    Image i;
    int width = 200;
    int height = 200;

    public void init() {
        int[] pixels = new int[width * height];
        int c;
        double radianConversion = Math.PI / 180.0;
        for (int index = 0, y = 0; y < height; y++) {
            c = ((0xff)
                    & (byte) (Math.abs(Math.sin((y + height) * radianConversion)) * 255));
            for (int x = 0; x < width; x++) {
                pixels[index++] = ((0xff << 24) | (c << 16) | (c << 8) | c);
            }
        }
        i = createImage(new MemoryImageSource(width, height, pixels, 0, width));
      
        setFont(new Font("TimesRoman", Font.BOLD | Font.ITALIC, 32));
    }

    public void paint(Graphics g) {
        g.drawImage(i, 0, 0, this);
        g.drawString("JavaWorld", 30, 80);
    }
}
