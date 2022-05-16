import Modelos.Producto;
import Modelos.TipoProducto;
import UtilidadesBBDD.ProductoBD;
import UtilidadesBBDD.UtilidadesBD;
import java.awt.Dimension;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
public class pruebas extends UtilidadesBD{

    public static void main(String[] args) throws Exception {
        try (PDDocument document = new PDDocument()) {

            PDPage page1 = new PDPage(PDRectangle.A6);
            document.addPage(page1);

            PDPageContentStream contentStream = new PDPageContentStream(document, page1);

            PDImageXObject pdImage = PDImageXObject.createFromFile(new File("").getAbsolutePath() +"\\src\\main\\imagenes\\duck.jpg", document);
            contentStream.drawImage(pdImage, 240, 365, pdImage.getWidth() / 10, pdImage.getHeight() / 10);

            contentStream.beginText();


            contentStream.setFont(PDType1Font.TIMES_BOLD, 12);
            contentStream.newLineAtOffset( 10, page1.getMediaBox().getHeight() - 22);
            contentStream.setLeading(18.5f);

            contentStream.showText("Número de Mesa: " + 4);
            contentStream.newLine();
            contentStream.showText("Camarero: " + "ruben");
            contentStream.newLine();
            contentStream.newLine();


            contentStream.showText("PRODUCTO");
            contentStream.newLineAtOffset(120, 0);
            contentStream.showText("CANTIDAD");
            contentStream.newLineAtOffset(105, 0);
            contentStream.showText("PRECIO");
            contentStream.newLine();
            contentStream.newLineAtOffset(-225, 0);


            //PRODUCTOS
            for(int x=0;x<5;x++){
                contentStream.showText("producto"+x);
                contentStream.newLineAtOffset(150, 0);
                contentStream.showText("cantidad"+x);
                contentStream.newLineAtOffset(100, 0);
                contentStream.showText("total"+x);
                contentStream.newLine();
                contentStream.newLineAtOffset(-250, 0);

            }

            contentStream.newLine();
            contentStream.showText("TOTAL");
            contentStream.newLineAtOffset(250, 0);
            contentStream.showText(""+223231);

            contentStream.newLineAtOffset(-250,-page1.getMediaBox().getHeight()+200);
            contentStream.showText(LocalDate.now().toString());


            contentStream.endText();

            //LINEAS NEGRAS
            PDRectangle bbox = page1.getBBox();
            contentStream.moveTo(bbox.getLowerLeftX() ,360);
            contentStream.lineTo(bbox.getUpperRightX(),360);
            contentStream.setLineWidth( 2f);
            contentStream.stroke();


            contentStream.close();

            document.save("document.pdf");
        }
    }
}