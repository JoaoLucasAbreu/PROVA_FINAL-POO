create table espm.moeda (
	id_moeda varchar(64) not null,
    tx_nome varchar(50) not null,
    tx_simbolo varchar(5) null,
    primary key pk_moeda (id_moeda)
    )
;

create table espm.cotacao (
	id_cotacao varchar(64) not null,
    id_moeda varchar(64)null,
    dt_cotacao date not null,
    vr_valor decimal(14,2) not null,
    primary key pk_cotacao (id_cotacao),
    foreign key (id_moeda) references moeda(id_moeda)
    )
;
