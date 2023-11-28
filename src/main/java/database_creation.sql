CREATE TABLE IF NOT EXISTS room (
    roomID int NOT NULL AUTO_INCREMENT,
    roomNumber int,
    floor int,
    bedType varchar(20),
    isAvailable boolean,
    nightlyPrice double,
    PRIMARY KEY (roomID)
);