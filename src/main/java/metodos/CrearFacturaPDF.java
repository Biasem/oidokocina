package metodos;

import Modelos.LineaComanda;
import Modelos.Producto;
import UtilidadesBBDD.EmpleadoBD;
import UtilidadesBBDD.ProductoBD;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class CrearFacturaPDF {
    public static void crearFactura(List<LineaComanda> listaComandaIdProductoYCantidad){
        List<Producto> listaProductos = ProductoBD.obtenerTodosProductos();
        double cantidadTotalAPagar = 0;

        try  {
            PDDocument document = new PDDocument();
            PDPage page1 = new PDPage(PDRectangle.A6);
            document.addPage(page1);

            PDPageContentStream contentStream = new PDPageContentStream(document, page1);

            PDImageXObject pdImage = PDImageXObject.createFromFile(new File("").getAbsolutePath() +"\\src\\main\\imagenes\\duck.jpg", document);
            contentStream.drawImage(pdImage, 240, 365, pdImage.getWidth() / 10, pdImage.getHeight() / 10);

            contentStream.beginText();


            contentStream.setFont(PDType1Font.TIMES_BOLD, 12);
            contentStream.newLineAtOffset( 10, page1.getMediaBox().getHeight() - 22);
            contentStream.setLeading(18.5f);

            contentStream.showText("Número de Mesa: " + listaComandaIdProductoYCantidad.get(0).getNum_mesa());
            contentStream.newLine();
            contentStream.showText("Camarero: " + EmpleadoBD.obtenerPorNumEmpleado(listaComandaIdProductoYCantidad.get(0).getNumEmpleado()).getNombre());
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
            for(LineaComanda lc : listaComandaIdProductoYCantidad){
                contentStream.showText(listaProductos.stream().filter(p ->p.getId()==lc.getIdProducto()).collect(Collectors.toList()).get(0).getDescripcion());
                contentStream.newLineAtOffset(250, 0);
                double precioPorCantidad = lc.getCantidadProducto()+listaProductos.stream().filter(p ->p.getId()==lc.getIdProducto()).collect(Collectors.toList()).get(0).getPrecio();
                cantidadTotalAPagar += lc.getCantidadProducto() * precioPorCantidad;
                contentStream.showText(""+precioPorCantidad);
                contentStream.newLine();
                contentStream.newLineAtOffset(-250, 0);
                contentStream.showText(listaProductos.stream().filter(p ->p.getId()==lc.getIdProducto()).collect(Collectors.toList()).get(0).getTipoProducto().toString());
                contentStream.newLineAtOffset(150, 0);
                contentStream.showText(""+lc.getCantidadProducto());
                contentStream.newLineAtOffset(-150, 0);
                contentStream.newLine();

            }

            contentStream.newLine();
            contentStream.showText("TOTAL");
            contentStream.newLineAtOffset(250, 0);
            contentStream.showText(""+cantidadTotalAPagar);

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
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
