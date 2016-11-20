package pdf;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfCopy;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MergePdfFiles {

    public static void main(String[] args) throws Exception {
        List<InputStream> componentFiles = new ArrayList<InputStream>();
        componentFiles.add(new FileInputStream(new File("output/1000.pdf")));
        componentFiles.add(new FileInputStream(new File("output/1000 (3).pdf")));
        componentFiles.add(new FileInputStream(new File("output/1000 (2).pdf")));
        componentFiles.add(new FileInputStream(new File("output/1000 (1).pdf")));

        FileOutputStream singlePdf = new FileOutputStream("output/single_pdf.pdf");
        // Concatenate the separate pages into a single PDF document
        Document doc = new Document();
        PdfCopy copier = new PdfCopy(doc, singlePdf);
        doc.open();
        PdfReader reader = null;
        for (InputStream componentFile : componentFiles) {
            if (componentFile != null) {
                reader = new PdfReader(componentFile);
                int numPages = reader.getNumberOfPages();
                // Get imported pages isn't zero based
                for (int i = 1; i <= numPages; i++) {
                    copier.addPage(copier.getImportedPage(reader, i));
                }
            }
            //close the import stream, so associated objects can be removed
            componentFile.close();
        }
        copier.close();
        singlePdf.close();
    }
}
