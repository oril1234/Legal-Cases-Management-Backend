CREATE TABLE PERSON
(
    id int(9) NOT NULL,
    firstname varchar(30) NOT NULL,
    lastname varchar(30) NOT NULL,
    email varchar(40) NOT NULL,
    phoneNumber varchar(20) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE STUDENTS
(
    id int(9) NOT NULL,
    firstname varchar(30) NOT NULL,
    lastname varchar(30) NOT NULL,
    email varchar(40) NOT NULL,
    phoneNumber varchar(20) NOT NULL,
    clinicalSupervisorId int(9) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE CLINICALSUPERVISORS
(
    id int(9) NOT NULL,
    firstname varchar(30) NOT NULL,
    lastname varchar(30) NOT NULL,
    email varchar(40) NOT NULL,
    phoneNumber varchar(20) NOT NULL,
    sinceYear int(4) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE CLIENTS
(
    id int(9) NOT NULL,
    firstname varchar(30) NOT NULL,
    lastname varchar(30) NOT NULL,
    email varchar(40) NOT NULL,
    phoneNumber varchar(20) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE LEGALCASES
(
    id int NOT NULL,
    dateAdded Date NOT NULL,
    subject varchar(30) NOT NULL,
    caseType varchar(30) NOT NULL,
    status varchar(30) NOT NULL,
    courtCaseId int,
    clinicName varchar(30) NOT NULL,
    clientId int(9) NOT NULL,
    PRIMARY KEY (id)
);