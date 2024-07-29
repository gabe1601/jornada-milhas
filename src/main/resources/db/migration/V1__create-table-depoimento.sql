CREATE TABLE depoimento(

    id bigint not null auto_increment,
    nome varchar(100) not null,
    foto varchar(100) not null,
    depoimento varchar(500) not null,

    primary key (id)
);