package VentanasApp;

import Modelos.Empleado;
import Modelos.Producto;
import Modelos.Rol;
import Modelos.TipoProducto;
import UtilidadesBBDD.EmpleadoBD;
import UtilidadesBBDD.ProductoBD;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;


public class PanelAdministrador extends JPanel {

    static void panelAdministrador(JPanel panel){
        //urlimg = new ImageIcon(geturlimg()).getImage();
        PanelPrincipal.RestaurarPanel(panel);
        panel.setLayout(null);
        //boton de Mesas
        JButton mesas = new JButton("Mesas");
        mesas.setBounds(730, 500, 250, 100);
        ActionListener oyenteMesas = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelMesa(panel);
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
                panelEmpleados(panel);
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
                panelProductos(panel);
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
        //boton atras
        PanelPrincipal.botonAtras();
    }

    //Subpaneles de administrador  MESAS
    private static void panelMesa(JPanel panel){
        //urlimg = new ImageIcon(geturlimg()).getImage();
        PanelPrincipal.RestaurarPanel(panel);
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
        PanelPrincipal.botonAtrasAdministrador();
    }
    //Subpaneles de administrador  EMPLEADOS
    private static void panelEmpleados(JPanel panel){
        //urlimg = new ImageIcon(geturlimg()).getImage();
        PanelPrincipal.RestaurarPanel(panel);
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
                Empleado empleado = new Empleado();
                empleado = EmpleadoBD.obtenerPorId(Integer.valueOf(campoId.getText()));
                campoNombre.setText(empleado.getNombre());
                campoApellidos.setText(empleado.getApellidos());
                campoNumEmpleado.setText(empleado.getNum_empleado().toString());
                comboRol.setSelectedItem(empleado.getRol());
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
        PanelPrincipal.botonAtrasAdministrador();
    }
    //Subpaneles de administrador  PRODUCTOS
    private static void panelProductos(JPanel panel){
        //urlimg = new ImageIcon(geturlimg()).getImage();
        PanelPrincipal.RestaurarPanel(panel);
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
            public void actionPerformed(ActionEvent e) {//cambiar por una llamada a la bbdd creando un nuevo producto y acceder a este producto
                Producto producto = new Producto();
                producto = ProductoBD.obtenerPorId(Integer.valueOf(campoId.getText()));
                campoDescripcion.setText(producto.getDescripcion());
                campoPrecio.setText(producto.getPrecio().toString());
                comboTipoProducto.setSelectedItem(producto.getTipoProducto());
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
        PanelPrincipal.botonAtrasAdministrador();
    }

}
