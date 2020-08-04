DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS state;
DROP TABLE IF EXISTS country;

CREATE TABLE country (
  id varchar(36) NOT NULL,
  name varchar(50) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ;

CREATE TABLE state (
  id varchar(36) NOT NULL,
  name varchar(50) NOT NULL,
  country VARCHAR(36) DEFAULT NULL,
  PRIMARY KEY (id),
  constraint fk_country_state FOREIGN KEY(country) REFERENCES country(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ;

CREATE TABLE  user(
    id VARCHAR(36) NOT NULL,
    name VARCHAR(50) NOT NULL,
    country VARCHAR(36) DEFAULT NULL,
    PRIMARY KEY (id),
    constraint fk_country_user FOREIGN KEY(country) REFERENCES country(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ;
