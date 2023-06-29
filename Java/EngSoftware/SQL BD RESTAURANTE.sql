/*DB V1.1 */
 
create table Ingredientes(
  idI int,
  nome varchar,
  quantidade int,
  constraint PK_ingredientes primary key (idI)
);
 
create table Bebidas(
  idB int,
  nome varchar,
  quantidade_ing int,
  id_ingrediente int,
  constraint PK_bedidas
    primary key(idB),
   constraint ingredientes_bebidasFK
    foreign key (id_ingrediente) references Ingredientes(idI) on delete cascade
);

 
create table Pratos(
  idP int,
  nome varchar,
  quantidade_ing int,
  id_ingrediente int,
  constraint PK_pratos
    primary key(idP),
 constraint ingredientes_pratoFK
    foreign key (id_ingrediente) references Ingredientes(idI) on delete cascade
); 

create table PedidoDelivery(
  cod int,
  endereco varchar,
  bebida int,
  prato int,
  conclusao boolean,
  constraint PK_Delivery 
    primary key(cod),
  constraint prato_delivery_FK
    foreign key(prato) references Pratos(idP) ON delete cascade,
  constraint bebida_delivery_FK
    foreign key(bebida) references Bebidas(idB) ON delete cascade
);
  
create table PedidoFisico(
  cod int,
  mesa int,
  bebida int,
  prato int,
  conclusao boolean,
  constraint PK_Fisico primary key (cod),
  constraint prato_fisico_FK
    foreign key(prato) references Pratos(idP) ON delete cascade,
  constraint bebida_fisico_FK
    foreign key(bebida) references Bebidas(idB) ON delete cascade
);

create table Funcionario(
  login varchar,
  senha varchar,
  cargo varchar,
  ativo boolean
);

alter table Funcionario rename boolean to ativo;
alter table PedidoDelivery alter column endereco String

/*create function GastaIngredienteDeli (Prato Pratos, Bebida Bebidas, Ingrediente Ingredientes, beb int, pra int) returns text as $$
  begin
    update 
      public.Ingredientes 
    set 
      Ingrediente.quantidade = Ingrediente.quantidade - Prato.quantidade_ing
    where
      Prato.id_ingrediente = Ingrediente.id 
    and 
      Prato.id = pra;

    update
      public.Ingredientes 
    set 
      Ingrediente.quantidade = Ingrediente.quantidade - Bebida.quantidade_ing
    where
      Bebida.id_ingrediente = Ingrediente.id 
    and 
      Bebida.id = beb;

    return "";
  end;
$$ language plpgsql;

create function GastaIngredienteFisi (Prato Pratos, Bebida Bebidas, Ingrediente Ingredientes, beb int, pra int) returns text as $$
  begin
    update 
      public.Ingredientes 
    set 
      Ingrediente.quantidade = Ingrediente.quantidade - Prato.quantidade_ing
    where
      Prato.id_ingrediente = Ingrediente.id 
  and
    Prato.id = pra;
    update
      public.Ingredientes 
    set 
      Ingrediente.quantidade = Ingrediente.quantidade - Bebida.quantidade_ing
    where
      Bebida.id_ingrediente = Ingrediente.id 
    and
      Bebida.id = beb;
    return "";
  end;
$$ language plpgsql;

create trigger Exe_gastaIngredienteDeli
	on Ingredientes
	after insert on PedidoDelivery
  	execute function GastaIngrediente(Pratos.*, Bebidas.*, Ingredientes.*,PedidoDelivery.bebida, PedidoDelivery.prato);

create trigger Exe_gastaIngredienteFisi
	on Ingredientes
    after insert on PedidoFisico
  	execute function GastaIngrediente(Pratos.*, Bebidas.*, Ingredientes.*,PedidoFisico.bebida, PedidoFisico.prato);*/