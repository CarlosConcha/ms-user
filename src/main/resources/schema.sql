CREATE TABLE BNS_USER(
  USR_ID INT NOT NULL AUTO_INCREMENT,
  USR_KEY VARCHAR(50) NOT NULL,
  USR_NAME VARCHAR(100) NOT NULL,
  USR_MAIL VARCHAR(50) NOT NULL,
  USR_PASSWORD VARCHAR(65) NOT NULL,
  USR_TOKEN VARCHAR NOT NULL,
  USR_CREATED_DATE TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  USR_UPDATE_DATE TIMESTAMP,
  USR_ACTIVE BOOLEAN DEFAULT TRUE,
  USR_LAST_LOGIN TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT PK_USR_ID PRIMARY KEY ( USR_ID ) 
);


CREATE TABLE BNS_PHONE(
	PHO_ID INT NOT NULL AUTO_INCREMENT,
	USR_ID INT NOT NULL,
	PHO_NUMBER INT NOT NULL,
	PHO_CITY_CODE INT NOT NULL,
	PHO_COUNTRY_CODE INT NOT NULL,
	CONSTRAINT PK_PHO_ID PRIMARY KEY ( PHO_ID )
);

ALTER TABLE BNS_PHONE ADD CONSTRAINT FK_PHO_USR_ID FOREIGN KEY (USR_ID) REFERENCES BNS_USER(USR_ID);

CREATE UNIQUE INDEX UQ_USR_MAIL ON BNS_USER(USR_MAIL);

