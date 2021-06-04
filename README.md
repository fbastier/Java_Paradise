# Java Paradise

1 - depot diagramme de classe UML 

2 - Base de données sous Mysql

```SQL
DROP DATABASE IF EXISTS ParadiseSQL;

CREATE DATABASE ParadiseSQL;
USE ParadiseSQL;

CREATE TABLE PlaceTable (
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(80),
    PRIMARY KEY (id)
);

CREATE INDEX Index_Name ON PlaceTable(name); 

CREATE TABLE TripTable (
    id BIGINT NOT NULL AUTO_INCREMENT,
    departurePlace VARCHAR(80),
    arrivalPlace VARCHAR(80),
    price DOUBLE(8,2),
    PRIMARY KEY (id),
    CONSTRAINT FK_Departure FOREIGN KEY (departurePlace) REFERENCES PlaceTable(name),
    CONSTRAINT FK_Arrival FOREIGN KEY (arrivalPlace) REFERENCES PlaceTable(name)
);

SHOW TABLES;
```
