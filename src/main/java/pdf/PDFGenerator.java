package pdf;

import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.AreaBreak;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.VerticalAlignment;

import javax.print.Doc;
import java.io.*;

public class PDFGenerator {


    public void createPdfWithPageNos() throws IOException {
        String dest = "C:\\Users\\madmo\\OneDrive\\Desktop\\newbeginning\\sample.pdf";
        String dest2 = "C:\\Users\\madmo\\OneDrive\\Desktop\\newbeginning\\sample2.pdf";
        ByteArrayOutputStream outputStream =  new ByteArrayOutputStream();
        PdfWriter writer = new PdfWriter(outputStream);
        PdfDocument pdfDoc = new PdfDocument(writer);
        Document document = new Document(pdfDoc);
        String para1 = "Tutorials Point originated from the idea that there exists " +
                "a class of readers who respond better to online content and prefer to learn " +
                "new skills at their own pace from the comforts of their drawing rooms.";

        String para2 = "The journey commenced with a single tutorial on HTML in 2006 " +
                "and elated by the response it generated, we worked our way to adding fresh " +
                "tutorials to our repository which now proudly flaunts a wealth of tutorials " +
                "and allied articles on topics ranging from programming languages to web designing " +
                "to academics and much more.";

        // Creating Paragraphs
        Paragraph paragraph1 = new Paragraph(para1);
        Paragraph paragraph2 = new Paragraph(para2);

        document.add(paragraph2);


        document.add(new AreaBreak());

        document.add(paragraph1);
        document.close();

        PdfReader pdfReader = new PdfReader(new ByteArrayInputStream(outputStream.toByteArray()));
        ByteArrayOutputStream outputStream1 = new ByteArrayOutputStream();
//        two options , [use outputstream from the previous document , or create a new output stream]
//        for pdf writer
//        if we use new outputstream, it takes less data
        PdfDocument pdfDocument = new PdfDocument(pdfReader,new PdfWriter(outputStream1));
        Document document1 = new Document(pdfDocument);

        int pages  = pdfDocument.getNumberOfPages();


        for(int i=1;i<=pages;i++)
        {
            document1.showTextAligned(new Paragraph(String.format("%s of %s", i,pages)),20,20,i,TextAlignment.CENTER, VerticalAlignment.BOTTOM,0);
        }

        //all the processing of the pdf is done when we close the document ,
        document1.close();

//        outputstream1 is just to show that we can get output in byte array form
        System.out.println(outputStream1.toString());

        //        this stores it in pdf doc
        PdfReader pdfReader2 = new PdfReader(new ByteArrayInputStream(outputStream1.toByteArray()));
        PdfDocument pdfDocument2 = new PdfDocument(pdfReader2,new PdfWriter(dest2));
        Document document2 = new Document(pdfDocument2);
        document2.close();






    }

    public void createPdfDocument() throws FileNotFoundException {
        String dest = "C:\\Users\\madmo\\OneDrive\\Desktop\\newbeginning\\sample.pdf";
        PdfWriter writer = new PdfWriter(dest);
        PdfDocument pdfDoc = new PdfDocument(writer);
        Document document = new Document(pdfDoc);
        String para1 = "Tutorials Point originated from the idea that there exists " +
                "a class of readers who respond better to online content and prefer to learn " +
                "new skills at their own pace from the comforts of their drawing rooms.";

        String para2 = "The journey commenced with a single tutorial on HTML in 2006 " +
                "and elated by the response it generated, we worked our way to adding fresh " +
                "tutorials to our repository which now proudly flaunts a wealth of tutorials " +
                "and allied articles on topics ranging from programming languages to web designing " +
                "to academics and much more.";

        // Creating Paragraphs
        Paragraph paragraph1 = new Paragraph(para1);
        Paragraph paragraph2 = new Paragraph(para2);

        document.add(paragraph2);


        document.add(new AreaBreak());

        document.add(paragraph1);
        document.close();
    }

    byte[] createPdfDocumentByteArray(){
        ByteArrayOutputStream outputStream =  new ByteArrayOutputStream();
        PdfWriter writer = new PdfWriter(outputStream);
        PdfDocument pdfDoc = new PdfDocument(writer);
        Document document = new Document(pdfDoc);
        String para1 = "Tutorials Point originated from the idea that there exists " +
                "a class of readers who respond better to online content and prefer to learn " +
                "new skills at their own pace from the comforts of their drawing rooms.";

        String para2 = "The journey commenced with a single tutorial on HTML in 2006 " +
                "and elated by the response it generated, we worked our way to adding fresh " +
                "tutorials to our repository which now proudly flaunts a wealth of tutorials " +
                "and allied articles on topics ranging from programming languages to web designing " +
                "to academics and much more.";

        // Creating Paragraphs
        Paragraph paragraph1 = new Paragraph(para1);
        Paragraph paragraph2 = new Paragraph(para2);

        document.add(paragraph2);


        document.add(new AreaBreak());

        document.add(paragraph1);
        document.close();
        return outputStream.toByteArray();
    }
}
