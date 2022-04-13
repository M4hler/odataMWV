package org.example.databroker.handlers;

import cds.gen.poaccrualdataservice.Accept1Context;
import cds.gen.poaccrualdataservice.Accept2Context;
import cds.gen.poaccrualdataservice.Accept3Context;
import cds.gen.poaccrualdataservice.Accept4Context;
import cds.gen.poaccrualdataservice.POAccrualData;
import cds.gen.poaccrualdataservice.POAccrualData_;
import com.sap.cds.ql.Select;
import com.sap.cds.ql.cqn.CqnSelect;
import com.sap.cds.services.handler.EventHandler;
import com.sap.cds.services.handler.annotations.On;
import com.sap.cds.services.handler.annotations.ServiceName;
import com.sap.cds.services.persistence.PersistenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@ServiceName("POAccrualDataService")
public class POAccrualDataServiceHandler implements EventHandler {
    @Autowired
    private PersistenceService persistenceService;

    @On(event = Accept1Context.CDS_NAME)
    public void onAccept1(Accept1Context context) {
        System.out.println("Called accept1: " + context.getOpsys() + " " + context.getEbeln() + " " + context.getEbelp());
        context.setCompleted();
    }

    @On(event = Accept2Context.CDS_NAME)
    public void onAccept2(Accept2Context context) {
        System.out.println("Called accept2: " + context.getOpsys() + " " + context.getEbeln() + " " + context.getEbelp());
        context.setCompleted();
    }

    @On(event = Accept3Context.CDS_NAME)
    public void onAccept3(Accept3Context context) {
        System.out.println("Called accept3: " + context.getOpsys() + " " + context.getEbeln() + " " + context.getEbelp());
        CqnSelect select = Select.from(POAccrualData_.class).where(x -> x.OPSYS().eq(context.getOpsys())
                .and(x.EBELN().eq(context.getEbeln())
                .and(x.EBELP().eq(context.getEbelp()))));
        POAccrualData po = persistenceService.run(select).single(POAccrualData.class);
        context.setCompleted();
    }

    @On(event = Accept4Context.CDS_NAME)
    public void onAccept4(Accept4Context context) {
        System.out.println("Called accept4: " + context.getOpsys() + " " + context.getEbeln() + " " + context.getEbelp());
        CqnSelect select = Select.from(POAccrualData_.class).where(x -> x.OPSYS().eq(context.getOpsys())
                .and(x.EBELN().eq(context.getEbeln())
                        .and(x.EBELP().eq(context.getEbelp()))));
        POAccrualData po = persistenceService.run(select).single(POAccrualData.class);
        //context.setResult(po);
    }
}
