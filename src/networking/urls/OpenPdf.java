package networking.urls;

import java.awt.Desktop;
import java.io.File;

public class OpenPdf {
    public static void main(String[] args) {
        try {
            File pdfFile = new File("c:/rail.pdf");
            if (pdfFile.exists()) {
                if (Desktop.isDesktopSupported()) {
                    Desktop.getDesktop().open(pdfFile);
                } else {
                    System.out.println("Awt Desktop is not supported!");
                }
            } else {
                System.out.println("File does not exist!");
            }
            System.out.println("Done");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
