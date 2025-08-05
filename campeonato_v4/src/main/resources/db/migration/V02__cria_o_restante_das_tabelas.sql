CREATE TABLE jogador (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         nome VARCHAR(50) NOT NULL,
                         nascimento DATE NOT NULL,
                         genero VARCHAR(10) NOT NULL,
                         altura FLOAT NOT NULL,
                         time_id INT NOT NULL,
                         FOREIGN KEY (time_id) REFERENCES time(id)
) ENGINE=InnoDB;

CREATE TABLE estadio (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         nome VARCHAR(100) NOT NULL,
                         endereco VARCHAR(100) NOT NULL,
                         time_id INT NOT NULL,
                         FOREIGN KEY (time_id) REFERENCES time(id)
) ENGINE=InnoDB;

CREATE TABLE campeonato (
                            id INT AUTO_INCREMENT PRIMARY KEY,
                            ano INT NOT NULL,
                            nome VARCHAR(100) NOT NULL
) ENGINE=InnoDB;

CREATE TABLE campeonato_time (
                                 id INT AUTO_INCREMENT PRIMARY KEY,
                                 campeonato_id INT NOT NULL,
                                 time_id INT NOT NULL,
                                 FOREIGN KEY (campeonato_id) REFERENCES campeonato(id),
                                 FOREIGN KEY (time_id) REFERENCES time(id)
) ENGINE=InnoDB;

CREATE TABLE partida (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         dataPartida DATE NOT NULL,
                         campeonato_id INT NOT NULL,
                         timeMandante_id INT NOT NULL,
                         timeVisitante_id INT NOT NULL,
                         golsMandante INT NOT NULL DEFAULT 0,
                         golsVisitante INT NOT NULL DEFAULT 0,
                         FOREIGN KEY (campeonato_id) REFERENCES campeonato(id),
                         FOREIGN KEY (timeMandante_id) REFERENCES time(id),
                         FOREIGN KEY (timeVisitante_id) REFERENCES time(id)
) ENGINE=InnoDB;