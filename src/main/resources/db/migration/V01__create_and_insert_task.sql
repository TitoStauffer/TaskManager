CREATE TABLE Task(
    id SERIAL PRIMARY KEY,
    designation VARCHAR(50) NOT NULL,
    createData DATE NOT NULL,
    finishData DATE
);

INSERT INTO Task (designation, createData)
VALUES ('Desenhar diagrama de classes', NOW());

INSERT INTO Task (designation, createData)
VALUES ('Inserir Valores Nas Tabelas', NOW());

INSERT INTO Task (designation, createData)
VALUES ('Criar Regras de Negócios', NOW());

INSERT INTO Task (designation, createData)
VALUES ('Upar projeto pro git', NOW());