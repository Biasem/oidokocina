import Modelos.Producto;
import Modelos.TipoProducto;
import UtilidadesBBDD.EmpleadoBD;
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
         System.out.println(EmpleadoBD.obtenerPorNumEmpleado(1).getRol().ordinal());
    }
}