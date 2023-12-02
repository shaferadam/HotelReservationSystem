CREATE TABLE IF NOT EXISTS room (
    roomID int NOT NULL AUTO_INCREMENT,
    roomNumber int,
    floor int,
    bedType varchar(20),
    isAvailable boolean,
    nightlyPrice double,
    PRIMARY KEY (roomID)
);


CREATE TABLE IF NOT EXISTS customer (
    custID int NOT NULL AUTO_INCREMENT,
    address varchar(40),
    custFirstName varchar(20),
    custLastName varchar(20),
    phoneNumber varchar(20),
    PRIMARY KEY (custID)
);

CREATE TABLE IF NOT EXISTS reservation(
	reservationID int NOT NULL AUTO_INCREMENT,
	roomID int,
	customerID int,
	startDate date,
	endDate date,
	PRIMARY KEY (reservationID)
);

		