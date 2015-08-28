create table if not exists Player (
	PlayerId identity,
	firstName varchar(21) not null,
        lastName varchar(21) not null,
        age int not null,
        salary double not null,
        Player_Position varchar(21) not null,
        birthCountry varchar(30) not null,
        Player_Games int not null,
        Player_Goals int not null,
        discrim varchar(15) not null
);