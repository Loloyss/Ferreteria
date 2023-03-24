USE ferreteria;
create table poblaciones (
    cod_postal char(5) primary key,
    poblacion varchar (30) not null,
    provincia varchar(25) not null
);
create table articulos (
   cod_art char(2) not null,
   ref_art char(3) not null,
   denomina varchar(30) not null unique,
   precio float not null check (precio >=0.1 and precio < 1000),
   descuento float check (descuento >=0 and descuento <51),
   constraint clave_articulos primary key (cod_art,ref_art),
   constraint precio_mayor_dscto check (precio>descuento)
);
create table medidas(
    codigo char(2) not null,
    referencia char(3) not null,
    medida varchar(10) not null,
    stock smallint not null check (stock >= 0 and stock < 1000),
    constraint clave_medidas primary key (codigo,referencia,medida),
    constraint clave_ajena_medidas
        foreign key (codigo,referencia) references articulos(cod_art,ref_art) on delete cascade
);
create table compras (
    cod_cli char(4) not null references clientes,
    cod_art char(2) not null,
    referencia char(3) not null,
    medida varchar(10) not null,
    fecha date not null default SYSDATE(),
    unidades smallint not null check (unidades>0 and unidades<1000),
    constraint clave_compras primary key (cod_cli,cod_art,referencia,medida,fecha),
    constraint ajena_compras_articulos foreign key(cod_art,referencia)
    references articulos(cod_art,ref_art),
    constraint ajena_compras_medidas foreign key(cod_art,referencia,medida)
    references medidas(codigo,referencia,medida)
);

create table clientes (
    codigo char(4) primary key,
    nombre varchar (40) not null,
    direccion varchar(50) not null,
    sexo char,
    dni varchar(10) not null,
    fecha_alta date not null,
    telefono varchar(14),
    cod_postal char(5) not null references poblaciones,
    FOREIGN KEY (codigo)REFERENCES compras(cod_cli),
    FOREIGN KEY (cod_postal)REFERENCES poblaciones(cod_postal)
  );

create table proveedores (
    CIF varchar(10) primary key,
    razon_soc varchar (40) not null,
    direccion varchar(50) not null,
    cod_postal char(5) not null references poblaciones on delete cascade,
    FOREIGN KEY (cod_postal) REFERENCES poblaciones(cod_postal)
);

create table sucursales (
    cif varchar(10) not null references proveedores on delete cascade,
    cod_postal char(5)  not null references poblaciones,
    direccion varchar(50) not null,
    constraint clave_sucursales primary key (cif,cod_postal),
    FOREIGN KEY (cif)REFERENCES proveedores(CIF),
    FOREIGN KEY (cod_postal)REFERENCES proveedores(cod_postal)
);

create table premios (
    cif varchar(10) not null references proveedores on delete cascade,
    premio varchar(40) primary key,
    FOREIGN KEY (cif)REFERENCES proveedores(CIF)
);


create table suministros (
    cif_pro varchar(10) not null references proveedores on delete cascade,
    cod_art char(2) not null,
    referencia char(3) not null,
    medida varchar(10) not null,
    fecha datetime not null default SYSDATE(),
    unidades smallint not null check (unidades>0 and unidades<1000),
    precio INT not null check (precio>0 and precio<1000),
    constraint clave_suministros primary key (cif_pro,cod_art,referencia,medida,fecha),
    constraint ajena_suministros_medidas foreign key(cod_art,referencia,medida)
    references medidas(codigo,referencia,medida) on delete cascade
);

insert into poblaciones values ('13300','Valdepe�as','Ciudad Real');
insert into poblaciones values ('13500','Puertollano','Ciudad Real');
insert into poblaciones values ('45001','Toledo','Toledo');
insert into poblaciones values ('28002','Parla','Madrid');

insert into clientes values ('0001','Javier Gallego Hurtado','C/Ferrocarril, 1','V','11111111','1/9/2013','926111111','13300');
insert into clientes values ('0002','Cristina Parra Mellado','C/Mesta, 2','M','22222222','2/9/2013','926222222','13300');
insert into clientes values ('0003','Jose Lopez Mora','C/Tomillo, 3','V','33333333','3/9/2013','926333333','13500');
insert into clientes values ('0004','Javier Nieto Prado','C/Azucena, 4','V','44444444','4/9/2013','926444444','13500');
insert into clientes values ('0005','Ana Ruiz Torres','C/Geranio, 5','M','55555555','5/9/2013','926555555','13500');
insert into clientes values ('0006','Luisa Megia Barrio','C/Cencibel, 6','M','66666666','6/9/2013','926666666','13300');

insert into proveedores values ('11111111A','SUMINISTROS LA MANCHA','C/Obispo, 11','45001');
insert into proveedores values ('22222222B','FERRETERIAS INDUSTRIALES','C/Castillo, 22','28002');
insert into proveedores values ('33333333C','INDUSTRIAL TOLEDANA','C/Libertad, 33','45001');

insert into sucursales values ('11111111A','13500','Paseo San Gregorio, 82');
insert into sucursales values ('11111111A','13300','Real, 2');

insert into premios values ('11111111A','Calidad 2010');
insert into premios values ('11111111A','Calidad 2011');

insert into articulos values ('TO','001','Tornillos de rosca-chapa',0.2,0);
insert into articulos values ('TO','002','Tornillos de punta',0.5,0);
insert into articulos values ('MA','001','Martillo mango madera',20,0);

insert into medidas values ('TO','001','10 mm.',110);
insert into medidas values ('TO','001','20 mm.',120);
insert into medidas values ('TO','001','30 mm.',130);
insert into medidas values ('TO','002','10 mm.',210);
insert into medidas values ('TO','002','20 mm.',220);
insert into medidas values ('MA','001','unica',30);

insert into compras values ('0001','MA','001','unica','23/03/2014',1);
insert into compras values ('0002','TO','002','10 mm.','23/03/2014',10);
insert into compras values ('0002','TO','002','20 mm.','23/03/2014',20);
insert into compras values ('0003','MA','001','unica','23/03/2014',4);


insert into suministros values ('11111111B','MA','001','unico','21/03/2014',10,20);
insert into suministros values ('11111111A','MB','002','unica','25/04/2014',20,18);
insert into suministros values ('22222222B','MC','003','unica','23/03/2014',30,17);
