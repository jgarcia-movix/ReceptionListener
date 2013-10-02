package com.movix.listener;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.movixla.service.ats.client.ReceptionClient;
import com.movixla.service.ats.client.ReceptionListener;
import com.movixla.service.ats.common.ActionReception;
import com.movixla.service.ats.common.Receptionable;
import com.movixla.service.ats.common.ReceptionableVisitorAdapter;
import com.movixla.service.ats.common.RechargeReception;
import com.movixla.service.ats.common.SMSReception;
import com.movixla.service.its.client.OutcomeListener;
import com.movixla.service.its.client.SendingClient;
import com.movixla.service.its.common.Outcome;

public final class ReceptionListenerJPGG {

    private static final String CLIENT_ID = "TEST_JPGG_CLIENT";
    private static final Logger LOGGER = LoggerFactory.getLogger(ReceptionListenerJPGG.class);

    private ReceptionListenerJPGG() {
    }

    public static void main(String[] args) {

        new SendingClient(CLIENT_ID).onOutcomeResponse(new OutcomeListener() {

            @Override
            public void outcomeReceived(Outcome arg0) {
                // LOGGER.debug("Outcome={}", arg0);
            }

        });

        ReceptionClient.getInstance(CLIENT_ID).onReception(new String[] { "5332ClaroSVsms/0" }, new ReceptionListener() {

            @Override
            public void receive(List<Receptionable> receptionables) {
                for (Receptionable receptionable : receptionables) {
                    receptionable.accept(new ReceptionableVisitorAdapter() {

                        @Override
                        public void visitRechargeReception(RechargeReception rechargeReception) {
                            LOGGER.debug("{}", rechargeReception);
                        }

                        @Override
                        public void visitActionReception(ActionReception actionReception) {
                            LOGGER.debug("{}", actionReception);
                        }

                        @Override
                        public void visitSMSReception(SMSReception smsReception) {
                            LOGGER.debug("{}", smsReception);
                        }
                    });
                }
            }
        });

    }
}
