package pdf;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 *
 * @author nicholasj
 */
public class SimplePdfMaker {

    private static final int LEFT_MARGIN = 72;
    private static final int RIGHT_MARGIN = 72;
    private static final int TOP_MARGIN = 36;
    private static final int BOTTOM_MARGIN = 72;
    private String content;

    public SimplePdfMaker(String content) {
        this.content = content;
    }

    public void toPdf(OutputStream out) throws Exception {
        try {
            Font font = new Font(Font.TIMES_ROMAN);
            font.setStyle(Font.BOLDITALIC);
            font.setSize(12f);
            Document document = new Document(PageSize.LETTER, LEFT_MARGIN, RIGHT_MARGIN, TOP_MARGIN, BOTTOM_MARGIN);
            PdfWriter pdfWriter = PdfWriter.getInstance(document, out);

            document.open();
            document.add(new Paragraph(content, font));
            document.close();

            pdfWriter.flush();
            pdfWriter.close();

        } catch (Exception ex) {
            throw new Exception("Error occurred generating pdf", ex);
        }
    }

    public static void main(String[] args) throws Exception{
        String str = "A problem well stated is a problem half solved";
        new SimplePdfMaker(str).toPdf(new FileOutputStream("output/0000001000.pdf"));
        
        String str1 = "If the human mind was simple enough to understand, we'd be too simple to understand it";
        new SimplePdfMaker(str1).toPdf(new FileOutputStream("output/0000001000 (1).pdf"));

        String str2 = "To Iterate is Human, to Recurse, Divine.";
        new SimplePdfMaker(str2).toPdf(new FileOutputStream("output/0000001000 (2).pdf"));

        String str3 = "On the 7th day God began debugging";
        new SimplePdfMaker(str3).toPdf(new FileOutputStream("output/0000001000 (3).pdf"));

    }
    
}
