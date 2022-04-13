
DROP TABLE IF EXISTS POAccrualDataService_POAccrualData;

CREATE TABLE POAccrualDataService_POAccrualData (
  OPSYS NVARCHAR(2) NOT NULL,
  EBELN NVARCHAR(15) NOT NULL,
  EBELP INTEGER NOT NULL,
  status INTEGER,
  PRIMARY KEY(OPSYS, EBELN, EBELP)
);
