import Modelos.Producto;
import Modelos.TipoProducto;
import UtilidadesBBDD.ProductoBD;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import java.awt.Graphics;
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
        ventana.setSize(1920,1080);
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
        imagenLimitadaTamanyo = imagen.getImage().getScaledInstance(60, 60,  java.awt.Image.SCALE_SMOOTH);
        imagen.setImage(imagenLimitadaTamanyo);
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

        panel.setLayout(new BorderLayout());
        panel.setBorder(new EmptyBorder(100,100,100,100));


        panel.add(cocinero,BorderLayout.NORTH);
        panel.add(camarero,BorderLayout.WEST);
        panel.add(cliente, BorderLayout.EAST);
        panel.add(admin, BorderLayout.SOUTH);

        cocinero.setBorderPainted(false);
        cocinero.setFocusPainted(false);
        cocinero.setContentAreaFilled(true);

        camarero.setBorderPainted(false);
        camarero.setFocusPainted(false);
        camarero.setContentAreaFilled(true);

        admin.setBorderPainted(false);
        admin.setFocusPainted(false);
        admin.setContentAreaFilled(true);

        cliente.setBorderPainted(false);
        cliente.setFocusPainted(false);
        cliente.setContentAreaFilled(true);

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
        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(ProductoBD.obtenerTodosProductos().size(), 3, 10, 5));
        //productos en botones para poner bonico
        for (Producto p : ProductoBD.obtenerTodosProductos()) {
            panel2.add(new JButton(p.getDescripcion()));
            panel2.add(new JButton(String.valueOf(p.getTipoProducto())));
            panel2.add(new JButton(String.valueOf(p.getPrecio())));

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
        JButton vercarta = new JButton("Carta");
        vercarta.setBounds(350,250,100,50);
        ActionListener oyenteCarta = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RestaurarPanel();
                verCarta();
            }
        };
        vercarta.addActionListener(oyenteCarta);

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
        mesas.setBounds(100,100,100,50);
        ActionListener oyenteMesas = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelMesa();
            }
        };
        mesas.addActionListener(oyenteMesas);
        panel.add(mesas);

        //boton de Empleados
        JButton empleados = new JButton("Empleados");
        empleados.setBounds(200,100,100,50);
        ActionListener oyenteEmpleados = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelEmpleados();
            }
        };
        empleados.addActionListener(oyenteEmpleados);
        panel.add(empleados);

        //boton de Productos
        JButton productos = new JButton("Productos");
        productos.setBounds(300,100,100,50);
        ActionListener oyenteProductos = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelProductos();
            }
        };
        productos.addActionListener(oyenteProductos);
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
        JTextField campoRol = new JTextField();
        campoRol.setBounds(180,230,50,20);
        panel.add(campoRol);

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
                nuevoProducto.setId(Integer.valueOf(campoId.getText())); //filtrar las letras
                nuevoProducto.setTipoProducto(TipoProducto.valueOf(comboTipoProducto.getName()));
                nuevoProducto.setPrecio(Double.valueOf(campoPrecio.getText()));
                //nuevoProducto.setDescripcion(campo);



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
                campoDescripcion.setText(ProductoBD.obtenerPorId(Integer.parseInt(campoId.getText())).getDescripcion());
                campoPrecio.setText(ProductoBD.obtenerPorId(Integer.parseInt(campoId.getText())).getPrecio().toString());
                comboTipoProducto.setSelectedItem(ProductoBD.obtenerPorId(Integer.parseInt(campoId.getText())).getTipoProducto());

            }
        };
        botonBuscar.addActionListener(oyenteBuscar);
        panel.add(botonBuscar);
        //Boton Modificar Producto
        JButton botonModificar = new JButton("MODIFICAR");
        botonModificar.setBounds(400,600,110,50);
        panel.add(botonModificar);
        //Boton Eliminar Producto
        JButton botonEliminar = new JButton("ELIMINAR");
        botonEliminar.setBounds(510,600,100,50);
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
        aforo.setBounds(100,100,100,50);
        ActionListener oyenteAforo = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelAforo();
            }
        };
        aforo.addActionListener(oyenteAforo);
        panel.add(aforo);

        //boton de pedidos
        JButton pedidos = new JButton("Pedidos");
        pedidos.setBounds(200,100,100,50);
        ActionListener oyentepedidos = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelPedidos();
            }
        };
        pedidos.addActionListener(oyentepedidos);
        panel.add(pedidos);

        //boton de cuentas
        JButton cuentas = new JButton("Cuentas");
        cuentas.setBounds(300,100,100,50);
        ActionListener oyentecuentas = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelCuentas();
            }
        };
        cuentas.addActionListener(oyentecuentas);
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

        //boton Atras hacia panel camarero
        botonAtrasCamarero();
    }

    //panel de COCINERO
    private void panelCocinero (){

        urlimg = new ImageIcon(geturlimg()).getImage();
        RestaurarPanel();
        panel.setLayout(null);

        //boton atras
        botonAtras();
    }

    // metodos para botones estándar
    public void botonAtras(){
        JButton atras = new JButton("atras");
        atras.setBounds(0,0,100,50);
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
        JButton atras = new JButton("atras");
        atras.setBounds(0,0,100,50);
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
        JButton atras = new JButton("atras");
        atras.setBounds(0,0,100,50);
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
