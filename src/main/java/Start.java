import pdf.PDFGenerator;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Start {

    public static void main(String args[]) throws IOException {
        PDFGenerator pdfGenerator = new PDFGenerator();
        pdfGenerator.createPdfWithPageNos();

    }




}
