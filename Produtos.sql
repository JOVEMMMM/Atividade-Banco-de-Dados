-- criando a tabela

create table Produtos (
	id int,
	Nome varchar(40),
	Valor decimal(4,2), --1000,10
	Quantidade int,
);

select * 
from Produtos;

-- adicionando dados na tabela
insert into Produtos(id, Nome, Valor, Quantidade)
values 
	(1, 'Camisa', 60, 10),
	(2, 'Calça', 45, 15),
	(3, 'Tenis', 80, 8);

-- Atualizando dados da tabela

update Produtos
set Valor = 53.10
where id = 1;

-- Deletando linhas da tabela

delete from Produtos
where id = 2;

-- excluir uma tabela

drop table Produtos;