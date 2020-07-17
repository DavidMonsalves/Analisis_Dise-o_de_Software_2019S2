
-- dentro de la BD chat ejecutar las tablas
create table public.usuario(
    id_usuario int not null,
    user_name varchar(100) not null,
    password varchar(100) not null,
    roles varchar(100) default 'ROLE_USER',
    active boolean default TRUE,
	tipo varchar(50) not null,
    primary key (id_usuario)
);

create table public.pago(
    id_pago int not null,
	id_consulta int,
    tarjeta varchar(100),
    monto varchar(100) default '$10000',
    primary key (id_pago)
);

create table public.consulta(
    id_consulta int not null,
    id_tecnico int,
    id_cliente int not null,
	titulo varchar(100) not null,
	descripcion varchar(500) not null,
	categoria varchar(100) not null,
	aceptada varchar(4) default 'NO',
    primary key (id_consulta),
    foreign key (id_tecnico) references usuario(id_usuario),
    foreign key (id_cliente) references usuario(id_usuario)
);

create table public.calificacion(
	id_calificacion int not null,
    id_tecnico int,
	id_consulta int,
    calificacion int,
	primary key(id_calificacion),
    foreign key (id_tecnico) references usuario(id_usuario),
    foreign key (id_consulta) references consulta(id_consulta)
);

create table public.mensaje(
    id_mensaje int not null,
    id_consulta int not null,
    id_emisor int not null,
    mensaje text,
    primary key (id_mensaje),
    foreign key (id_emisor) references usuario(id_usuario),
    foreign key (id_consulta) references consulta(id_consulta)
);