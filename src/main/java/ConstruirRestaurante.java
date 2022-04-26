import Modelos.Producto;
import Modelos.Rol;
import Modelos.TipoProducto;
import UtilidadesBBDD.EmpleadoBD;
import UtilidadesBBDD.ProductoBD;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JButton;
import javax.swing.JFrame;






public class ConstruirRestaurante {
    private Image urlimg = new ImageIcon(geturlimg()).getImage();
    private JFrame ventana;
    private JPanel panel;
    private JButton camarero, admin, cliente, cocinero;


    ConstruirRestaurante(){
        ConstruirVentana();

    }

    private void ConstruirVentana()
    {                                               //se construye la ventana y panel principal
        ventana = new JFrame("OidoKocina");
        ventana.setSize(1200,720);
        ventana.setResizable(false);
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel = new JPanel(){
            @Override
            public void paint(Graphics g){
                g.drawImage(urlimg, 0, 0, getWidth(), getHeight(), this);
                super.paint(g);
            }
        };
        PanelFondo();
        ventana.setContentPane(panel);
        ventana.setVisible(true);
    }

    public class seticonimg extends javax.swing.JFrame{
        public seticonimg() {
        }
    }

    private void RestaurarPanel()   //metodo para inicializar paneles
    {
        panel.removeAll();
        panel.repaint();
        panel.revalidate();
    }

    private void PanelFondo()   //panel principal de bienvenida
    {
        RestaurarPanel();
        panel.setOpaque(false);

        /// Botón cocinero
        cocinero = new JButton("Cocinero");
        ActionListener oyenteCocinero = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelCocinero();
            }
        };
        cocinero.addActionListener(oyenteCocinero);
        String ruta = new File("").getAbsolutePath() + "\\src\\main\\imagenes\\cocinero.png" ;
        ImageIcon imagen = new ImageIcon(ruta);
        Image imagenLimitadaTamanyo = imagen.getImage().getScaledInstance(60, 60,  java.awt.Image.SCALE_SMOOTH);
        imagen.setImage(imagenLimitadaTamanyo);
        cocinero.setIcon(imagen);
        cocinero.setFocusPainted(true);


        /// Botón camarero
        camarero = new JButton("Camarero");
        ActionListener oyenteCamarero = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelCamarero();
            }
        };
        camarero.addActionListener(oyenteCamarero);
        ruta = new File("").getAbsolutePath() + "\\src\\main\\imagenes\\camarero.png" ;
        imagen = new ImageIcon(ruta);
        imagenLimitadaTamanyo = imagen.getImage().getScaledInstance(60, 60,  java.awt.Image.SCALE_SMOOTH);
        imagen.setImage(imagenLimitadaTamanyo);
        camarero.setIcon(imagen);
        camarero.setFocusPainted(true);

        /// Botón admin

        admin = new JButton("Administrador");
        ActionListener oyenteAdmin = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelAdministrador();
            }
        };
        admin.addActionListener(oyenteAdmin);
        ruta = new File("").getAbsolutePath() + "\\src\\main\\imagenes\\apoyo.png" ;
        imagen = new ImageIcon(ruta);
        admin.setIcon(imagen);
        admin.setFocusPainted(true);

        /// Botón cliente

        cliente = new JButton("Cliente");
        ActionListener oyenteCliente = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelcliente();
            }
        };
        cliente.addActionListener(oyenteCliente);
        ruta = new File("").getAbsolutePath() + "\\src\\main\\imagenes\\cliente.png" ;
        imagen = new ImageIcon(ruta);
        imagenLimitadaTamanyo = imagen.getImage().getScaledInstance(60, 60,  java.awt.Image.SCALE_SMOOTH);
        imagen.setImage(imagenLimitadaTamanyo);
        cliente.setIcon(imagen);
        cliente.setFocusPainted(true);

        panel.setLayout(null);

        cocinero.setBounds(860, 500, 250, 100);
        camarero.setBounds(610, 500, 250, 100);
        admin.setBounds(360, 500, 250, 100);
        cliente.setBounds(110, 500, 250, 100);

        panel.add(cocinero);
        panel.add(camarero);
        panel.add(cliente);
        panel.add(admin);



        cocinero.setFocusPainted(true);
        cocinero.setContentAreaFilled(true);
        cocinero.setBorder(BorderFactory.createMatteBorder(
                1, 1, 1, 1, Color.darkGray));
        cocinero.setBackground(Color.WHITE);


        camarero.setBorderPainted(true);
        camarero.setFocusPainted(true);
        camarero.setContentAreaFilled(true);
        camarero.setBorder(BorderFactory.createMatteBorder(
                1, 1, 1, 1, Color.darkGray));
        camarero.setBackground(Color.WHITE);


        admin.setBorderPainted(true);
        admin.setFocusPainted(true);
        admin.setContentAreaFilled(true);
        admin.setBorder(BorderFactory.createMatteBorder(
                1, 1, 1, 1, Color.darkGray));
        admin.setBackground(Color.WHITE);


        cliente.setBorderPainted(true);
        cliente.setFocusPainted(true);
        cliente.setContentAreaFilled(true);
        cliente.setBorder(BorderFactory.createMatteBorder(
                1, 1, 1, 1, Color.darkGray));
        cliente.setBackground(Color.WHITE);




    }


    private static String geturlimg(){
        String ruta = new File("").getAbsolutePath();
        return ruta  + "\\src\\main\\imagenes\\menuprincipal.jpg";
    }
    // Panel donde mostramos la carta, se puede hacer modo pestañas
    private void verCarta(){

        JButton atras = new JButton("atras");
        atras.setBounds(0,0,100,50);
        panel.add(atras);
        ActionListener oyenteAtras = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelcliente();
            }
        };
        atras.addActionListener(oyenteAtras);
        //panel donde van los productos
        List<Producto> lista;
        lista = ProductoBD.obtenerTodosProductos().stream().sorted(Comparator.comparing(Producto::getDescripcion)).collect(Collectors.toList());
        lista = lista.stream().filter(p->!p.getTipoProducto().equals(TipoProducto.BEBIDAS)&&
                !p.getTipoProducto().equals(TipoProducto.POSTRES)&&
                !p.getTipoProducto().equals(TipoProducto.ESPECIALIDADES)).collect(Collectors.toList());
        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(lista.stream().map(p->p.getDescripcion()).distinct().collect(Collectors.toList()).size(), 4, 5, 2));
        //productos en botones para poner bonico
        Producto np = new Producto();
        np = lista.get(0);

        for (Producto p:lista){
            if(p.equals(np)){// primera iteracion del bucle
                if(p.getTipoProducto().equals(TipoProducto.TAPA)){
                    panel2.add(new JButton(p.getDescripcion()));
                    panel2.add(new JButton(p.getPrecio().toString()));
                    np=p;
                }
                if(p.getTipoProducto().equals(TipoProducto.MEDIA)){
                    panel2.add(new JButton(p.getDescripcion()));
                    panel2.add(new JButton(""));
                    panel2.add(new JButton(p.getPrecio().toString()));
                    np=p;
                }
                if(p.getTipoProducto().equals(TipoProducto.RACION)){
                    panel2.add(new JButton(p.getDescripcion()));
                    panel2.add(new JButton(""));
                    panel2.add(new JButton(""));
                    panel2.add(new JButton(p.getPrecio().toString()));
                    np=p;
                }
            }
            //segunda iteración y siguientes, si p es distinto a np significa que entramos en un nuevo producto por tanto
            // tenemos que ver si ese producto nuevo es tapa media o racion y segun el anterior haya sido habra que rellenar
            else if (!p.getDescripcion().equals(np.getDescripcion())){
                //relleno del anterior segun sea tapa o media
                if(np.getTipoProducto().equals(TipoProducto.TAPA)){
                    panel2.add(new JButton(""));
                    panel2.add(new JButton(""));
                }
                if(np.getTipoProducto().equals(TipoProducto.MEDIA)){
                    panel2.add(new JButton(""));
                }
                //segun el siguiente producto, procedemos a su inicio y prodecemos al avance de la variable auxiliar
                if(p.getTipoProducto().equals(TipoProducto.TAPA)){
                    panel2.add(new JButton(p.getDescripcion()));
                    panel2.add(new JButton(p.getPrecio().toString()));
                    np=p;
                }
                if(p.getTipoProducto().equals(TipoProducto.MEDIA)){
                    panel2.add(new JButton(p.getDescripcion()));
                    panel2.add(new JButton(""));
                    panel2.add(new JButton(p.getPrecio().toString()));
                    np=p;
                }
                if(p.getTipoProducto().equals(TipoProducto.RACION)){
                    panel2.add(new JButton(p.getDescripcion()));
                    panel2.add(new JButton(""));
                    panel2.add(new JButton(""));
                    panel2.add(new JButton(p.getPrecio().toString()));
                    np=p;
                }
            }
            //comparamos si el siguiente tiene la misma descripción solo obtenemos el precio
            else if(np.getDescripcion().equals(p.getDescripcion())){
                panel2.add(new JButton(p.getPrecio().toString()));
                np=p;
            }

        }

        panel2.setOpaque(false);
        JScrollPane scrollPane = new JScrollPane(panel2);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(0, 50, 780, 500);// aqui se puede ajustar los parametros del scrool
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        panel.add(scrollPane);
    }

    // Panel cliente
    private void panelcliente (){
        urlimg = new ImageIcon(geturlimg()).getImage();
        RestaurarPanel();
        panel.setLayout(null);
        JButton vercarta = new JButton();
        vercarta.setBounds(400,200,400,400);
        String ruta = new File("").getAbsolutePath() + "\\src\\main\\imagenes\\menu.png" ;
        ImageIcon imagen = new ImageIcon(ruta);
        Image imagenLimitadaTamanyo = imagen.getImage().getScaledInstance(200, 200,  java.awt.Image.SCALE_SMOOTH);
        imagen.setImage(imagenLimitadaTamanyo);
        vercarta.setIcon(imagen);
        ActionListener oyenteCarta = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RestaurarPanel();
                verCarta();
            }
        };
        vercarta.addActionListener(oyenteCarta);
        vercarta.setBorderPainted(true);
        vercarta.setFocusPainted(true);
        vercarta.setContentAreaFilled(true);
        vercarta.setBorder(BorderFactory.createMatteBorder(
                1, 1, 1, 1, Color.darkGray));
        vercarta.setBackground(Color.WHITE);


        vercarta.setBorderPainted(true);
        vercarta.setFocusPainted(true);
        vercarta.setContentAreaFilled(true);
        vercarta.setBorder(BorderFactory.createMatteBorder(
                1, 1, 1, 1, Color.darkGray));
        vercarta.setBackground(Color.WHITE);

        panel.add(vercarta);
        botonAtras();
    }

    //panel administrador y subpaneles a continuacion
    private void panelAdministrador (){
        urlimg = new ImageIcon(geturlimg()).getImage();
        RestaurarPanel();
        panel.setLayout(null);
        //boton de Mesas
        JButton mesas = new JButton("Mesas");
        mesas.setBounds(730, 500, 250, 100);
        ActionListener oyenteMesas = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelMesa();
            }
        };
        mesas.addActionListener(oyenteMesas);
        mesas.setBorderPainted(true);
        mesas.setFocusPainted(true);
        mesas.setContentAreaFilled(true);
        mesas.setBorder(BorderFactory.createMatteBorder(
                1, 1, 1, 1, Color.darkGray));
        mesas.setBackground(Color.WHITE);
        String ruta13 = new File("").getAbsolutePath() + "\\src\\main\\imagenes\\mesa.png" ;
        ImageIcon imagen13 = new ImageIcon(ruta13);
        Image imagenLimitadaTamanyo13 = imagen13.getImage().getScaledInstance(60, 60,  java.awt.Image.SCALE_SMOOTH);
        imagen13.setImage(imagenLimitadaTamanyo13);
        mesas.setIcon(imagen13);
        panel.add(mesas);

        //boton de Empleados
        JButton empleados = new JButton("Empleados");
        empleados.setBounds(480, 500, 250, 100);
        ActionListener oyenteEmpleados = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelEmpleados();
            }
        };
        empleados.addActionListener(oyenteEmpleados);
        empleados.setBorderPainted(true);
        empleados.setFocusPainted(true);
        empleados.setContentAreaFilled(true);
        empleados.setBorder(BorderFactory.createMatteBorder(
                1, 1, 1, 1, Color.darkGray));
        empleados.setBackground(Color.WHITE);
        String direccion = new File("").getAbsolutePath() + "\\src\\main\\imagenes\\waiter.png" ;
        ImageIcon icono = new ImageIcon(direccion);
        Image imagenLimitada = icono.getImage().getScaledInstance(60, 60,  java.awt.Image.SCALE_SMOOTH);
        icono.setImage(imagenLimitada);
        empleados.setIcon(icono);
        panel.add(empleados);

        //boton de Productos
        JButton productos = new JButton("Productos");
        productos.setBounds(230, 500, 250, 100);
        ActionListener oyenteProductos = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelProductos();
            }
        };
        productos.addActionListener(oyenteProductos);
        productos.setBorderPainted(true);
        productos.setFocusPainted(true);
        productos.setContentAreaFilled(true);
        productos.setBorder(BorderFactory.createMatteBorder(
                1, 1, 1, 1, Color.darkGray));
        productos.setBackground(Color.WHITE);
        String ruta2 = new File("").getAbsolutePath() + "\\src\\main\\imagenes\\clipboard.png" ;
        ImageIcon imagen2 = new ImageIcon(ruta2);
        Image imagenLimitadaTamanyo2 = imagen2.getImage().getScaledInstance(60, 60,  java.awt.Image.SCALE_SMOOTH);
        imagen2.setImage(imagenLimitadaTamanyo2);
        productos.setIcon(imagen2);
        panel.add(productos);
        botonAtras();
    }

    //Subpaneles de administrador  MESAS
    private void panelMesa(){
        urlimg = new ImageIcon(geturlimg()).getImage();
        RestaurarPanel();
        panel.setLayout(null);

        //Etiqueta ID
        JLabel labelId = new JLabel("ID");
        labelId.setFont( new Font("TimesRoman",Font.BOLD,20));
        labelId.setForeground(Color.white);
        labelId.setBounds(150,150,60,20);
        panel.add(labelId);
        //Campo ID
        JTextField campoId = new JTextField();
        campoId.setBounds(170,150,50,20);
        panel.add(campoId);
        //Etiqueta NUM MESA
        JLabel labelNumMesa = new JLabel("Num. Mesa");
        labelNumMesa.setFont( new Font("TimesRoman",Font.BOLD,20));
        labelNumMesa.setForeground(Color.white);
        labelNumMesa.setBounds(150,170,120,20);
        panel.add(labelNumMesa);
        //Campo NUM MESA
        JTextField campoNumMesa = new JTextField();
        campoNumMesa.setBounds(260,170,50,20);
        panel.add(campoNumMesa);
        //Etiqueta NUM COMENSALES
        JLabel labelNumComensales = new JLabel("Num. Comensales");
        labelNumComensales.setFont( new Font("TimesRoman",Font.BOLD,20));
        labelNumComensales.setForeground(Color.white);
        labelNumComensales.setBounds(150,190,190,20);
        panel.add(labelNumComensales);
        //Campo NUM COMENSALES
        JTextField campoNumComensales = new JTextField();
        campoNumComensales.setBounds(330,190,50,20);
        panel.add(campoNumComensales);



        //Boton Crear Producto
        JButton botonCrear = new JButton("CREAR");
        botonCrear.setBounds(200,600,100,50);
        ActionListener oyenteCrear = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Producto nuevoProducto = new Producto();

            }
        };
        botonCrear.addActionListener(oyenteCrear);

        panel.add(botonCrear);
        //Boton Buscar MESA
        JButton botonBuscar = new JButton("Buscar");
        botonBuscar.setBounds(300,600,100,50);
        panel.add(botonBuscar);
        //Boton Modificar MESA
        JButton botonModificar = new JButton("MODIFICAR");
        botonModificar.setBounds(400,600,110,50);
        panel.add(botonModificar);
        //Boton Eliminar MESA
        JButton botonEliminar = new JButton("ELIMINAR");
        botonEliminar.setBounds(510,600,100,50);
        panel.add(botonEliminar);

        //boton Atras hacia panel camarero
        botonAtrasAdministrador();
    }
    //Subpaneles de administrador  EMPLEADOS
    private void panelEmpleados(){
        urlimg = new ImageIcon(geturlimg()).getImage();
        RestaurarPanel();
        panel.setLayout(null);
        //Etiqueta ID
        JLabel labelId = new JLabel("ID");
        labelId.setFont( new Font("TimesRoman",Font.BOLD,20));
        labelId.setForeground(Color.white);
        labelId.setBounds(150,150,60,20);
        panel.add(labelId);
        //Campo ID
        JTextField campoId = new JTextField();
        campoId.setBounds(170,150,50,20);
        panel.add(campoId);
        //Etiqueta NOMBRE
        JLabel labelNombre = new JLabel("Nombre");
        labelNombre.setFont( new Font("TimesRoman",Font.BOLD,20));
        labelNombre.setForeground(Color.white);
        labelNombre.setBounds(150,170,100,20);
        panel.add(labelNombre);
        //Campo NOMBRE
        JTextField campoNombre = new JTextField();
        campoNombre.setBounds(230,170,50,20);
        panel.add(campoNombre);
        //Etiqueta APELLIDOS
        JLabel labelApellidos = new JLabel("Apellidos");
        labelApellidos.setFont( new Font("TimesRoman",Font.BOLD,20));
        labelApellidos.setForeground(Color.white);
        labelApellidos.setBounds(150,190,100,20);
        panel.add(labelApellidos);
        //Campo APELLIDOS
        JTextField campoApellidos = new JTextField();
        campoApellidos.setBounds(240,190,50,20);
        panel.add(campoApellidos);
        //Etiqueta NUM.EMPLEADO
        JLabel labelNumEmpleado = new JLabel("Num. Empleado");
        labelNumEmpleado.setFont( new Font("TimesRoman",Font.BOLD,20));
        labelNumEmpleado.setForeground(Color.white);
        labelNumEmpleado.setBounds(150,210,150,20);
        panel.add(labelNumEmpleado);
        //Campo NUM.EMPLEADO
        JTextField campoNumEmpleado = new JTextField();
        campoNumEmpleado.setBounds(300,210,50,20);
        panel.add(campoNumEmpleado);
        //Etiqueta ROL
        JLabel labelRol = new JLabel("Rol");
        labelRol.setFont( new Font("TimesRoman",Font.BOLD,20));
        labelRol.setForeground(Color.white);
        labelRol.setBounds(150,230,60,20);
        panel.add(labelRol);
        //Campo ROL
        JComboBox comboRol = new JComboBox();
        comboRol.setBounds(190,230,130,20);
        comboRol.setBounds(190,230,130,20);
        comboRol.addItem(Rol.CAMARERO);
        comboRol.addItem(Rol.COCINERO);
        comboRol.addItem(Rol.ADMINISTRADOR);
        panel.add(comboRol);

        //Boton Crear EMPLEADO
        JButton botonCrear = new JButton("CREAR");
        botonCrear.setBounds(200,600,100,50);
        ActionListener oyenteCrear = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Producto nuevoProducto = new Producto();

            }
        };
        botonCrear.addActionListener(oyenteCrear);

        panel.add(botonCrear);
        //Boton Buscar EMPLEADO
        JButton botonBuscar = new JButton("Buscar");
        botonBuscar.setBounds(300,600,100,50);
        ActionListener oyenteBuscar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Producto nuevoProducto = new Producto();
                campoNombre.setText(EmpleadoBD.obtenerPorId(Integer.valueOf(campoId.getText())).getNombre());
                campoApellidos.setText(EmpleadoBD.obtenerPorId(Integer.valueOf(campoId.getText())).getApellidos());
                campoNumEmpleado.setText(EmpleadoBD.obtenerPorId(Integer.valueOf(campoId.getText())).getNum_empleado().toString());
                comboRol.setSelectedItem(EmpleadoBD.obtenerPorId(Integer.parseInt(campoId.getText())).getRol());
            }
        };
        botonBuscar.addActionListener(oyenteBuscar);

        panel.add(botonBuscar);
        //Boton Modificar EMPLEADO
        JButton botonModificar = new JButton("MODIFICAR");
        botonModificar.setBounds(400,600,110,50);
        panel.add(botonModificar);
        //Boton Eliminar EMPLEADO
        JButton botonEliminar = new JButton("ELIMINAR");
        botonEliminar.setBounds(510,600,100,50);
        panel.add(botonEliminar);
        //boton Atras hacia panel camarero
        botonAtrasAdministrador();
    }
    //Subpaneles de administrador  PRODUCTOS
    private void panelProductos(){
        urlimg = new ImageIcon(geturlimg()).getImage();
        RestaurarPanel();
        panel.setLayout(null);
        //Etiqueta ID
        JLabel labelId = new JLabel("ID");
        labelId.setFont( new Font("TimesRoman",Font.BOLD,20));
        labelId.setForeground(Color.white);
        labelId.setBounds(150,150,60,20);
        panel.add(labelId);
        //Campo ID
        JTextField campoId = new JTextField();
        campoId.setBounds(170,150,50,20);
        panel.add(campoId);
        //Etiqueta Codigo
        JLabel labelCodigo = new JLabel("CODIGO");
        labelCodigo.setFont( new Font("TimesRoman",Font.BOLD,20));
        labelCodigo.setForeground(Color.white);
        labelCodigo.setBounds(250,150,100,20);
        panel.add(labelCodigo);
        //Campo Codigo
        JTextField campoCodigo = new JTextField();
        campoCodigo.setBounds(330,150,50,20);
        panel.add(campoCodigo);

        //Etiqueta Tipo Producto
        JLabel labelTipoProducto = new JLabel("Tipo de Producto");
        labelTipoProducto.setFont( new Font("TimesRoman",Font.BOLD,20));
        labelTipoProducto.setForeground(Color.white);
        labelTipoProducto.setBounds(150,200,200,20);
        panel.add(labelTipoProducto);
        //Campo Tipo Producto
        JComboBox comboTipoProducto = new JComboBox<TipoProducto>();
        comboTipoProducto.addItem(TipoProducto.TAPA);
        comboTipoProducto.addItem(TipoProducto.MEDIA);
        comboTipoProducto.addItem(TipoProducto.RACION);
        comboTipoProducto.addItem(TipoProducto.ESPECIALIDADES);
        comboTipoProducto.addItem(TipoProducto.BEBIDAS);
        comboTipoProducto.addItem(TipoProducto.POSTRES);
        comboTipoProducto.setBounds(320,200,100,20);
        panel.add(comboTipoProducto);

        //Etiqueta Precio
        JLabel labelPrecio = new JLabel("Precio");
        labelPrecio.setFont( new Font("TimesRoman",Font.BOLD,20));
        labelPrecio.setForeground(Color.white);
        labelPrecio.setBounds(150,250,100,20);
        panel.add(labelPrecio);
        //Campo Precio
        JTextField campoPrecio = new JTextField();
        campoPrecio.setBounds(220,250,50,20);
        panel.add(campoPrecio);

        //Etiqueta DESCRIPCION
        JLabel labelDescripcion = new JLabel("Descripcion");
        labelDescripcion.setFont( new Font("TimesRoman",Font.BOLD,20));
        labelDescripcion.setForeground(Color.white);
        labelDescripcion.setBounds(150,270,130,20);
        panel.add(labelDescripcion);
        //Campo DESCRIPCION
        JTextField campoDescripcion = new JTextField();
        campoDescripcion.setBounds(270,270,200,20);
        panel.add(campoDescripcion);

        //Boton Crear Producto
        JButton botonCrear = new JButton("CREAR");
        botonCrear.setBounds(200,600,100,50);
        ActionListener oyenteCrear = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Producto nuevoProducto = new Producto();
                nuevoProducto.setId(Integer.parseInt(campoId.getText())); //filtrar las letras
                nuevoProducto.setTipoProducto(TipoProducto.valueOf(comboTipoProducto.getSelectedItem().toString()));
                nuevoProducto.setPrecio(Double.valueOf(campoPrecio.getText()));
                nuevoProducto.setDescripcion(campoDescripcion.getText());
                ProductoBD.crearProducto(nuevoProducto);
            }
        };
        botonCrear.addActionListener(oyenteCrear);
        panel.add(botonCrear);

        //Boton Buscar Producto
        JButton botonBuscar = new JButton("Buscar");
        botonBuscar.setBounds(300,600,100,50);
        ActionListener oyenteBuscar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Producto nuevoProducto = new Producto();
                campoDescripcion.setText(ProductoBD.obtenerPorId(Integer.valueOf(campoId.getText())).getDescripcion());
                campoPrecio.setText(ProductoBD.obtenerPorId(Integer.valueOf(campoId.getText())).getPrecio().toString());
                comboTipoProducto.setSelectedItem(ProductoBD.obtenerPorId(Integer.parseInt(campoId.getText())).getTipoProducto());
            }
        };
        botonBuscar.addActionListener(oyenteBuscar);
        panel.add(botonBuscar);

        //Boton Modificar Producto
        JButton botonModificar = new JButton("MODIFICAR");
        botonModificar.setBounds(400,600,110,50);
        ActionListener oyenteModificar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Producto productoModificar = new Producto();
                Producto nuevoProducto = new Producto();
                nuevoProducto.setId(Integer.valueOf(campoId.getText())); //filtrar las letras
                nuevoProducto.setTipoProducto(TipoProducto.valueOf(comboTipoProducto.getSelectedItem().toString()));
                nuevoProducto.setPrecio(Double.valueOf(campoPrecio.getText()));
                nuevoProducto.setDescripcion(campoDescripcion.getText());
                ProductoBD.actualizarProducto(nuevoProducto);
            }
        };
        botonModificar.addActionListener(oyenteModificar);
        panel.add(botonModificar);
        //Boton Eliminar Producto
        JButton botonEliminar = new JButton("ELIMINAR");
        botonEliminar.setBounds(510,600,100,50);
        ActionListener oyenteEliminar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Producto productoModificar = new Producto();
                Producto nuevoProducto = new Producto();
                nuevoProducto.setId(Integer.valueOf(campoId.getText())); //filtrar las letras
                ProductoBD.eliminarProducto(nuevoProducto);
            }
        };
        botonEliminar.addActionListener(oyenteEliminar);
        panel.add(botonEliminar);

        //boton Atras hacia panel camarero
        botonAtrasAdministrador();
    }

    //panel Camarero y subpaneles a continuacion
    private void panelCamarero (){
        urlimg = new ImageIcon(geturlimg()).getImage();
        RestaurarPanel();
        panel.setLayout(null);

        //boton de aforo
        JButton aforo = new JButton("Aforo");
        aforo.setBounds(230, 500, 250, 100);
        ActionListener oyenteAforo = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelAforo();
            }
        };
        aforo.addActionListener(oyenteAforo);
        aforo.setBorderPainted(true);
        aforo.setFocusPainted(true);
        aforo.setContentAreaFilled(true);
        aforo.setBorder(BorderFactory.createMatteBorder(
                1, 1, 1, 1, Color.darkGray));
        aforo.setBackground(Color.WHITE);
        String ruta6 = new File("").getAbsolutePath() + "\\src\\main\\imagenes\\crowd.png" ;
        ImageIcon imagen6 = new ImageIcon(ruta6);
        Image imagenLimitadaTamanyo = imagen6.getImage().getScaledInstance(60, 60,  java.awt.Image.SCALE_SMOOTH);
        imagen6.setImage(imagenLimitadaTamanyo);
        aforo.setIcon(imagen6);
        panel.add(aforo);

        //boton de pedidos
        JButton pedidos = new JButton("Pedidos");
        pedidos.setBounds(730, 500, 250, 100);
        ActionListener oyentepedidos = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelPedidos();
            }
        };
        pedidos.addActionListener(oyentepedidos);
        pedidos.setBorderPainted(true);
        pedidos.setFocusPainted(true);
        pedidos.setContentAreaFilled(true);
        pedidos.setBorder(BorderFactory.createMatteBorder(
                1, 1, 1, 1, Color.darkGray));
        pedidos.setBackground(Color.WHITE);
        String ruta3 = new File("").getAbsolutePath() + "\\src\\main\\imagenes\\products.png" ;
        ImageIcon imagen3 = new ImageIcon(ruta3);
        Image imagenLimitadaTamanyo3 = imagen3.getImage().getScaledInstance(60, 60,  java.awt.Image.SCALE_SMOOTH);
        imagen3.setImage(imagenLimitadaTamanyo3);
        pedidos.setIcon(imagen3);
        panel.add(pedidos);

        //boton de cuentas
        JButton cuentas = new JButton("Cuentas");
        cuentas.setBounds(480, 500, 250, 100);
        ActionListener oyentecuentas = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelCuentas();
            }
        };
        cuentas.addActionListener(oyentecuentas);
        cuentas.setBorderPainted(true);
        cuentas.setFocusPainted(true);
        cuentas.setContentAreaFilled(true);
        cuentas.setBorder(BorderFactory.createMatteBorder(
                1, 1, 1, 1, Color.darkGray));
        cuentas.setBackground(Color.WHITE);
        String ruta4 = new File("").getAbsolutePath() + "\\src\\main\\imagenes\\bill.png" ;
        ImageIcon imagen4 = new ImageIcon(ruta4);
        Image imagenLimitadaTamanyo4 = imagen4.getImage().getScaledInstance(60, 60,  java.awt.Image.SCALE_SMOOTH);
        imagen4.setImage(imagenLimitadaTamanyo4);
        cuentas.setIcon(imagen4);
        panel.add(cuentas);
        //boton atras
        botonAtras();
    }
    // subpanel de camarero AFORO
    private void panelAforo(){
        urlimg = new ImageIcon(geturlimg()).getImage();
        RestaurarPanel();
        panel.setLayout(null);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(20, 3, 20, 20));
        //productos en botones para poner bonico
        for (int i = 1;i<20;i++) {
            panel2.add(new JButton("Mesa "+i));
            panel2.add(new JButton("Ocupada/Libre"));
            panel2.add(new JButton("boton para ocupar mesa"));

        }
        panel2.setOpaque(false);
        JScrollPane scrollPane = new JScrollPane(panel2);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(0, 50, 780, 500);// aqui se puede ajustar los parametros del scrool
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        panel.add(scrollPane);

        //boton Atras hacia panel camarero
        botonAtrasCamarero();
    }
    // subpanel de camarero CUENTAS
    private void panelCuentas(){
        urlimg = new ImageIcon(geturlimg()).getImage();
        RestaurarPanel();
        panel.setLayout(null);

        //boton Atras hacia panel camarero
        botonAtrasCamarero();
    }
    // subpanel de camarero PEDIDOS
    private void panelPedidos(){
        urlimg = new ImageIcon(geturlimg()).getImage();
        RestaurarPanel();
        panel.setLayout(null);
        //Label Mesa
        JLabel labelMesa = new JLabel("Mesa:");
        labelMesa.setFont( new Font("TimesRoman",Font.BOLD,20));
        labelMesa.setForeground(Color.white);
        labelMesa.setBounds(100,150,70,20);
        panel.add(labelMesa);
        //Campo Mesa
        JTextField campoMesa = new JTextField();
        campoMesa.setBounds(160,150,50,20);
        panel.add(campoMesa);

        //Label Camarero
        JLabel labelCamarero = new JLabel("Camarero:");
        labelCamarero.setFont( new Font("TimesRoman",Font.BOLD,20));
        labelCamarero.setForeground(Color.white);
        labelCamarero.setBounds(250,150,100,20);
        panel.add(labelCamarero);
        //Campo Camarero
        JTextField campoCamarero = new JTextField();
        campoCamarero.setBounds(350,150,50,20);
        panel.add(campoCamarero);

        //Label Producto
        JLabel labelProducto = new JLabel("Producto:");
        labelProducto.setFont( new Font("TimesRoman",Font.BOLD,20));
        labelProducto.setForeground(Color.white);
        labelProducto.setBounds(100,200,100,20);
        panel.add(labelProducto);
        //Campo Producto
        JTextField campoProducto = new JTextField();
        campoProducto.setBounds(200,200,50,20);
        panel.add(campoProducto);

        //Label Cantidad
        JLabel labelCantidad = new JLabel("Cantidad:");
        labelCantidad.setFont( new Font("TimesRoman",Font.BOLD,20));
        labelCantidad.setForeground(Color.white);
        labelCantidad.setBounds(260,200,100,20);
        panel.add(labelCantidad);
        //Campo Cantidad
        JTextField campoCantidad = new JTextField();
        campoCantidad.setBounds(350,200,50,20);
        panel.add(campoCantidad);

        //Boton añadir producto a la comanda
        JButton aniadirProducto = new JButton("Añadir");
        aniadirProducto.setBounds(300,250,100,50);
        panel.add(aniadirProducto);

        //Boton tramitar comanda
        JButton enviarComanda = new JButton("Enviar Comanda");
        enviarComanda.setBounds(600,500,300,50);
        panel.add(enviarComanda);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(20, 3, 20, 20));
        //productos en botones para poner bonico

        panel2.setOpaque(false);
        JScrollPane scrollPane = new JScrollPane(panel2);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(400, 0, 780, 500);// aqui se puede ajustar los parametros del scrool
        scrollPane.setOpaque(false);
        //scrollPane.getViewport().setOpaque(false);
        panel.add(scrollPane);

        //boton Atras hacia panel camarero
        botonAtrasCamarero();
    }

    //panel de COCINERO
    private void panelCocinero (){

        urlimg = new ImageIcon(geturlimg()).getImage();
        RestaurarPanel();
        panel.setLayout(null);

        //Boton Comandas
        JButton verComandas = new JButton("Comandas");
        verComandas.setBounds(300,300,100,100);
        panel.add(verComandas);

        //boton atras
        botonAtras();
    }

    // metodos para botones estándar
    public void botonAtras(){
        JButton atras = new JButton();
        atras.setBounds(10,10,40,40);
        String ruta = new File("").getAbsolutePath() + "\\src\\main\\imagenes\\atras.png" ;
        ImageIcon imagen = new ImageIcon(ruta);
        Image imagenLimitadaTamanyo = imagen.getImage().getScaledInstance(40, 40,  java.awt.Image.SCALE_SMOOTH);
        imagen.setImage(imagenLimitadaTamanyo);
        atras.setIcon(imagen);
        atras.setContentAreaFilled(false);
        atras.setBorderPainted(false);
        atras.setFocusPainted(false);
        panel.add(atras);
        ActionListener oyenteAtras = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelFondo();
            }
        };
        atras.addActionListener(oyenteAtras);
    }
    public void botonAtrasCamarero(){
        JButton atras = new JButton();
        atras.setBounds(10,10,40,40);
        atras.setOpaque(false);
        String ruta = new File("").getAbsolutePath() + "\\src\\main\\imagenes\\atras.png" ;
        ImageIcon imagen = new ImageIcon(ruta);
        Image imagenLimitadaTamanyo = imagen.getImage().getScaledInstance(40, 40,  java.awt.Image.SCALE_SMOOTH);
        imagen.setImage(imagenLimitadaTamanyo);
        atras.setIcon(imagen);
        atras.setContentAreaFilled(false);
        atras.setBorderPainted(false);
        atras.setFocusPainted(false);
        panel.add(atras);
        ActionListener oyenteAtras = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelCamarero();
            }
        };
        atras.addActionListener(oyenteAtras);
    }
    public void botonAtrasAdministrador(){
        JButton atras = new JButton();
        atras.setBounds(10,10,40,40);
        atras.setOpaque(false);
        String ruta = new File("").getAbsolutePath() + "\\src\\main\\imagenes\\atras.png" ;
        ImageIcon imagen = new ImageIcon(ruta);
        Image imagenLimitadaTamanyo = imagen.getImage().getScaledInstance(40, 40,  java.awt.Image.SCALE_SMOOTH);
        imagen.setImage(imagenLimitadaTamanyo);
        atras.setIcon(imagen);
        atras.setContentAreaFilled(false);
        atras.setBorderPainted(false);
        atras.setFocusPainted(false);
        panel.add(atras);
        ActionListener oyenteAtras = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelAdministrador();
            }
        };
        atras.addActionListener(oyenteAtras);
    }




}
