package com.movix.listener;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.movixla.service.ats.client.ReceptionClientPro;
import com.movixla.service.ats.client.ReceptionListenerPro;
import com.movixla.service.ats.common.ReceptionablePro;

public final class ReceptionListenerJPGG {

    private static final String CLIENT_ID = "TEST_JPGG";
    private static final Logger LOGGER = LoggerFactory.getLogger(ReceptionListenerJPGG.class);

    private ReceptionListenerJPGG() {
    }

    public static void main(String[] args) {

        String[] filter = { "9999COsms/0", "1020COsms/0", "35555COsms/0" };
        ReceptionListenerPro listener = new ReceptionListenerPro() {

            @Override
            public void receive(List<ReceptionablePro> receptionables) {

                for (ReceptionablePro receptionablePro : receptionables) {
                    LOGGER.debug("{}", receptionablePro);
                }

            }

        };

        LOGGER.debug("listener={}", listener);

        new ReceptionClientPro(CLIENT_ID).onReception(filter, listener);

    }
}
