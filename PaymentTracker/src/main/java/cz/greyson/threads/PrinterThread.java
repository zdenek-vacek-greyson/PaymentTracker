package cz.greyson.threads;

import cz.greyson.PaymentTrackerApplication;

import java.util.Set;

/**
 * @author Zdeněk Vacek on 13/03/2018
 */
public class PrinterThread extends AbstractPaymentTrackerThread {

    // 60 x 1000 = 60s
    private static final long CONSOLE_REFRESH_PERIOD_IN_MILLIS = 60 * 1000L;

    public PrinterThread(PaymentTrackerApplication paymentTrackerApplication) {
        super(paymentTrackerApplication);
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(CONSOLE_REFRESH_PERIOD_IN_MILLIS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            printInternalMemory();
        }
    }

    void printInternalMemory() {
        System.out.println();
        System.out.println();
        System.out.println("///////////////////////////////////////////////////");
        Set<String> keys = paymentTrackerApplication.getInternalMemory().keySet();
        for (String key : keys) {
            System.out.println(key + " " + paymentTrackerApplication.getInternalMemory().get(key));
        }
        System.out.println("///////////////////////////////////////////////////");
        System.out.println();
        System.out.println();
    }
}
