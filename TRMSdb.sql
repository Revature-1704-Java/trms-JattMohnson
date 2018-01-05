/* Creates user */
CREATE USER trmsAdmin
IDENTIFIED BY trmspass
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp;

GRANT connect to trmsAdmin;
GRANT resource to trmsAdmin;
GRANT create session TO trmsAdmin;
GRANT create table TO trmsAdmin;
GRANT create view TO trmsAdmin;

/* Creates tables */
CREATE TABLE trmsEmployee
(
    EmpId INTEGER NOT NULL,
    FName VARCHAR2(20) NOT NULL,
    LName VARCHAR2(20) NOT NULL,
    DirectSup INTEGER,
    DepHead INTEGER,
    BenCo INTEGER,
    Email VARCHAR2(40),
    Pass VARCHAR2(20),
    JobDescrip VARCHAR2(40),
    CONSTRAINT PK_trmsEmployee PRIMARY KEY  (EmpId)
);

CREATE TABLE Department
(
     DepartmentID INTEGER NOT NULL,
     DepartmentName VARCHAR2(15),
     DepartmentHead INT NOT NULL,
     CONSTRAINT PK_Department PRIMARY KEY (DepartmentID)
);

CREATE TABLE EventType 
(
    TypeID INTEGER NOT NULL,
    EventTypeDescrip VARCHAR2(31),
    ReimPercent NUMBER NOT NULL,
    CONSTRAINT PK_EventType PRIMARY KEY (TypeID)
);

CREATE TABLE GradingReference
(
    GradingRefID INTEGER NOT NULL,
    GradeTypeDescrip VARCHAR2(20),
    NeedsPres VARCHAR(3),
    CONSTRAINT PK_GradingReference PRIMARY KEY (GradingRefID)
);

CREATE TABLE ReimbursementStatus
(
    StatusID INTEGER NOT NULL,
    StatusDescrip VARCHAR2(40),
    CONSTRAINT PK_ReimbursementStatus PRIMARY KEY (StatusID)
);

CREATE TABLE trmsReimbursement
(
    ReimID INTEGER NOT NULL,
    EmpID INTEGER NOT NULL,
    ClassStart DATE NOT NULL,
    TimeStart NUMBER,
    ApprovalDate DATE NOT NULL,
    ClassLocation VARCHAR2(20),
    ClassDescrip VARCHAR2(20),
    ClassCost NUMBER NOT NULL,
    GradingRefID INTEGER NOT NULL,
    TypeID INTEGER NOT NULL,
    Justification VARCHAR2(50),
    Attatchment BLOB,
    HoursMissed INTEGER,
    Urgency VARCHAR2(15),
    StatusID INTEGER NOT NULL,
    CONSTRAINT PK_trmsReimbursement PRIMARY KEY (ReimID)
);

CREATE TABLE Messages
(
    messageID INT,
    senderID INT,
    recieverID INT,
    messageText VARCHAR2(150),
    mostRecent VARCHAR2(3),
    CONSTRAINT PK_Messages PRIMARY KEY  (messageID)
);


/* Creates foriegn keys linking tables */
ALTER TABLE Department ADD CONSTRAINT FK_DepartmentHead
FOREIGN KEY (DepartmentHead) REFERENCES trmsEmployee (EmpID);
    
ALTER TABLE trmsReimbursement ADD CONSTRAINT FK_EmpID
FOREIGN KEY (EmpID) REFERENCES trmsEmployee (EmpID);  

ALTER TABLE trmsReimbursement ADD CONSTRAINT FK_GradingRefID
FOREIGN KEY (GradingRefID) REFERENCES GradingReference (GradingRefID);

ALTER TABLE trmsReimbursement ADD CONSTRAINT FK_TypeID
FOREIGN KEY (TypeID) REFERENCES EventType (TypeID);

ALTER TABLE trmsReimbursement ADD CONSTRAINT FK_StatusID
FOREIGN KEY (StatusID) REFERENCES ReimbursementStatus (StatusID);

ALTER TABLE Messages ADD CONSTRAINT FK_senderID
FOREIGN KEY (senderID) REFERENCES trmsEmployee (EmpID);

ALTER TABLE Messages ADD CONSTRAINT FK_recieverID
FOREIGN KEY (recieverID) REFERENCES trmsEmployee (EmpID);

/* Populates Tables */
INSERT INTO EventType (TypeID, EventTypeDescrip, ReimPercent) VALUES (1, 'University Course', .8);
INSERT INTO EventType (TypeID, EventTypeDescrip, ReimPercent) VALUES (2, 'Seminar', .6);
INSERT INTO EventType (TypeID, EventTypeDescrip, ReimPercent) VALUES (3, 'Certification Preparation Class', .75);
INSERT INTO EventType (TypeID, EventTypeDescrip, ReimPercent) VALUES (4, 'Certification', 1);
INSERT INTO EventType (TypeID, EventTypeDescrip, ReimPercent) VALUES (5, 'Technical Training', .9);
INSERT INTO EventType (TypeID, EventTypeDescrip, ReimPercent) VALUES (6, 'Other', .3);

INSERT INTO ReimbursementStatus (StatusID, StatusDescrip) VALUES (1, 'Awaiting DirectSup Approval');
INSERT INTO ReimbursementStatus (StatusID, StatusDescrip) VALUES (2, 'Awaiting DepHead Approval');
INSERT INTO ReimbursementStatus (StatusID, StatusDescrip) VALUES (3, 'Awaiting BenCo Approval');
INSERT INTO ReimbursementStatus (StatusID, StatusDescrip) VALUES (4, 'Awaiting Grade');
INSERT INTO ReimbursementStatus (StatusID, StatusDescrip) VALUES (5, 'Awaiting Final Approval');
INSERT INTO ReimbursementStatus (StatusID, StatusDescrip) VALUES (6, 'Approved');

INSERT INTO GradingReference (GradingRefID, GradeTypeDescrip, NeedsPres) VALUES (1, 'GPA gradescale', 'no');
INSERT INTO GradingReference (GradingRefID, GradeTypeDescrip, NeedsPres) VALUES (2, 'GPA gradescale', 'yes');
INSERT INTO GradingReference (GradingRefID, GradeTypeDescrip, NeedsPres) VALUES (3, 'Letter Grade', 'no');
INSERT INTO GradingReference (GradingRefID, GradeTypeDescrip, NeedsPres) VALUES (4, 'Letter Grade', 'yes');

INSERT INTO trmsEmployee (EmpId, FName, LName, DirectSup, DepHead, BenCo, Email, Pass, JobDescrip) VALUES (1, 'Lisa', 'Generic', 3, 3, 2, 'LGen@notreal.com', 'wasspord', 'BenCo');
INSERT INTO trmsEmployee (EmpId, FName, LName, DirectSup, DepHead, BenCo, Email, Pass, JobDescrip) VALUES (2, 'Fred', 'Average', 3, 3, 1, 'FAvg@notreal.com', 'wasspord', 'BenCo');
INSERT INTO trmsEmployee (EmpId, FName, LName, DirectSup, DepHead, BenCo, Email, Pass, JobDescrip) VALUES (3, 'John', 'Normal', 3, 3, 1, 'JNor@notreal.com', 'wasspord', 'CEO');
INSERT INTO trmsEmployee (EmpId, FName, LName, DirectSup, DepHead, BenCo, Email, Pass, JobDescrip) VALUES (4, 'Mary', 'Plain', 3, 4, 1, 'MPla@notreal.com', 'wasspord', 'IT');
INSERT INTO trmsEmployee (EmpId, FName, LName, DirectSup, DepHead, BenCo, Email, Pass, JobDescrip) VALUES (5, 'Jason', 'Nothingspecial', 4, 4, 2, 'JNot@notreal.com', 'wasspord', 'IT');
INSERT INTO trmsEmployee (EmpId, FName, LName, DirectSup, DepHead, BenCo, Email, Pass, JobDescrip) VALUES (6, 'Jimmy', 'Grunt', 5, 4, 1, 'JGru@notreal.com', 'wasspord', 'IT');
INSERT INTO trmsEmployee (EmpId, FName, LName, DirectSup, DepHead, BenCo, Email, Pass, JobDescrip) VALUES (7, 'Phil', 'Nobody', 5, 4, 2, 'PNob@notreal.com', 'wasspord', 'IT');
INSERT INTO trmsEmployee (EmpId, FName, LName, DirectSup, DepHead, BenCo, Email, Pass, JobDescrip) VALUES (8, 'Mike', 'Zero', 3, 8, 1, 'MZer@notreal.com', 'wasspord', 'HR');
INSERT INTO trmsEmployee (EmpId, FName, LName, DirectSup, DepHead, BenCo, Email, Pass, JobDescrip) VALUES (9, 'Anna', 'Lowly', 8, 8, 2, 'ALow@notreal.com', 'wasspord', 'HR');

INSERT INTO Department (DepartmentID, DepartmentName, DepartmentHead) VALUES (1, 'Management', 3);
INSERT INTO Department (DepartmentID, DepartmentName, DepartmentHead) VALUES (2, 'Benco', 3);
INSERT INTO Department (DepartmentID, DepartmentName, DepartmentHead) VALUES (3, 'IT', 4);
INSERT INTO Department (DepartmentID, DepartmentName, DepartmentHead) VALUES (4, 'HR', 8);

