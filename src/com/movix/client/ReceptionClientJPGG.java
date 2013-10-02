package com.movix.client;

import com.movix.shared.Operador;
import com.movixla.service.ats.client.ReceptionClient;
import com.movixla.service.ats.common.RawReceptionable;
import com.movixla.service.ats.common.RawSMSReception;
import com.movixla.service.scheduling.client.UTCDate;

public class ReceptionClientJPGG {

    private static final String CLIENT_ID = "TEST_JPGG_ATS";
    private static String text = "HOLA";
    private static String la = "5035332";
    private static Operador operator = Operador.CLARO_SALVADOR;
    private static String msisdn = "1234567890";
    private static UTCDate date = UTCDate.now();

    public static void main(String[] args) {
        RawReceptionable receptionable = new RawSMSReception(text, la, operator, msisdn, date);
        ReceptionClient instance = ReceptionClient.getInstance(CLIENT_ID);
        instance.receive(receptionable);
        instance.done();
        System.exit(0);
    }

}
