//service for PO accrual data
service POAccrualDataService {
    entity POAccrualData {
        key OPSYS : String(2);
        key EBELN : String(15);
        key EBELP : Integer;

        status : Integer;
    }

    action accept1(OPSYS : String(2), EBELN : String(15), EBELP : Integer);
    action accept2(OPSYS : String(2), EBELN : String(15), EBELP : Integer);
    action accept3(OPSYS : String(2), EBELN : String(15), EBELP : Integer);
    action accept4(OPSYS : String(2), EBELN : String(15), EBELP : Integer) returns POAccrualData;
}