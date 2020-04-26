CREATE TABLE UserMod(
	id SERIAL PRIMARY KEY,
	name VARCHAR(30) NOT NULL,
	sex CHAR NOT NULL,
	email VARCHAR(30) NOT NULL,
	password VARCHAR(20) NOT NULL
);

INSERT INTO UserMod (name, sex, email, password)
	values ('João José', 'M', 'joao.jose@gmail.com', '12345678');
INSERT INTO UserMod (name, sex, email, password)

	values ('José João', 'M', 'jose.joao@gmail.com', '87654321');

INSERT INTO UserMod (name, sex, email, password)
	values ('Maria Joana', 'F', 'maria.joana@gmail.com', '15917537');

INSERT INTO UserMod (name, sex, email, password)
	values ('Joana Maria', 'F', 'joana.maria@gmail.com', '95197537');