
create database oidokocina;

create table producto(
	id int(10) not null auto_increment,
	descripcion varchar(100) not null,
	tipo_producto int(2) not null,
	precio double not null,
	primary key(id)
);

create table empleado(
	num_empleado int(10) not null,
	nombre varchar(150) not null,
	apellidos varchar(150) not null,
	rol boolean not null,
	primary key (num_empleado)
);

create table mesa(
	num_mesa int(2) not null,
	num_comensales int(3)not null,
	ocupada bool not null default 0,
	primary key (num_mesa)
);


create table factura(
	id int(10) not null auto_increment,
	fecha date not null,
	total double not null,
	pagado bool not null default 0,
	num_mesa int(10) not null,
	constraint num_mesaa_fk1 foreign key (num_mesa) references mesa(num_mesa),
	primary key (id)
);

create table linea_comanda(
	id int(10) not null auto_increment,
	num_empleado int(10) not null,
	id_factura int(10) not null,
	id_producto int(10) not null,
	num_mesa int(10) not null,
	cantidad int(3) not null,
	cantidad_cocinada int(3) not null,
	primary key(id),
	constraint id_producto_fk1 foreign key (id_producto) references producto(id),
	constraint id_empleadoo_fk1 foreign key (num_empleado) references empleado(num_empleado),
	constraint id_factura_fk1 foreign key (id_factura) references factura(id),
	constraint id_mesaa_fk1 foreign key (num_mesa) references mesa(num_mesa)
);

