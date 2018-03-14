package cz.greyson.threads;

import cz.greyson.PaymentTrackerApplication;

/**
 * @author Zdeněk Vacek on 13/03/2018
 */
public abstract class AbstractPaymentTrackerThread extends Thread {

    protected PaymentTrackerApplication paymentTrackerApplication;

    public AbstractPaymentTrackerThread(PaymentTrackerApplication paymentTrackerApplication) {
        this.paymentTrackerApplication = paymentTrackerApplication;
    }
}
