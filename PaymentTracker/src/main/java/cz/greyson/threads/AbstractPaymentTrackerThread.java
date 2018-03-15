package cz.greyson.threads;

import cz.greyson.PaymentTrackerApplication;

/**
 * Abstract and common code of implemented threads
 *
 * @author Zdeněk Vacek on 13/03/2018
 */
public abstract class AbstractPaymentTrackerThread extends Thread {

    protected PaymentTrackerApplication paymentTrackerApplication;

    public AbstractPaymentTrackerThread(PaymentTrackerApplication paymentTrackerApplication) {
        this.paymentTrackerApplication = paymentTrackerApplication;
    }
}
