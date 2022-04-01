create table producto(
	id int(10) not null auto_increment,
	descripcion varchar(100) not null,
	tipo_producto int(2) not null,
	precio double not null,
	primary key(id)
);

create table empleado(
	id int(10) not null auto_increment,
	nombre varchar(150) not null, 
	apellidos varchar(150) not null,
	num_empleado int(10) not null,
	rol boolean,
	primary key (id)
);

create table mesa(
	id int(10) not null auto_increment,
	num_mesa int(2),
	primary key (id)
);

create table empleado_mesa(
	id_empleado int(10),
	id_mesa int(10),
	constraint id_empleado_fk foreign key (id_empleado) references empleado(id),
	constraint id_mesa_fk foreign key (id_mesa) references mesa(id)
);

create table factura(
	id int(10) not null auto_increment,
	fecha date not null,
	total double not null,
	id_mesaa int(10) not null,
	primary key (id),
	constraint id_mesaa_fk foreign key (id_mesaa) references mesa(id)
);

create table linea_comanda(
	id int(10) not null auto_increment,
	id_empleadoo int(10) not null,
	id_factura int(10) not null,
	primary key(id),
	constraint id_empleadoo_fk foreign key (id_empleadoo) references empleado(id),
	constraint id_factura_fk foreign key (id_factura) references factura(id)
);

create table linea_comanda_producto(
	id_producto int(10) not null,
	id_linea_comanda int(10) not null,
	cantidad int(2) not null,
	constraint id_producto_fk foreign key (id_producto) references producto(id),
	constraint id_linea_comanda_fk foreign key (id_linea_comanda) references linea_comanda(id)
);