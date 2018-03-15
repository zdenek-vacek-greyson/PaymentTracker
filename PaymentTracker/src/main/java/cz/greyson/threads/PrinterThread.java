package cz.greyson.threads;

import cz.greyson.PaymentTrackerApplication;
import org.apache.log4j.Logger;

import java.util.Set;

/**
 * @author Zdeněk Vacek on 13/03/2018
 */
public class PrinterThread extends AbstractPaymentTrackerThread {

    final static Logger logger = Logger.getLogger(PrinterThread.class);

    // 60 x 1000 = 60s
    private static final long CONSOLE_REFRESH_PERIOD_IN_MILLIS = 60 * 1000L;

    public PrinterThread(PaymentTrackerApplication paymentTrackerApplication) {
        super(paymentTrackerApplication);
    }

    /**
     * Main thread method. Infinity loop for reading input from keyboard and his processing
     */
    public void run() {
        while (true) {
            try {
                Thread.sleep(CONSOLE_REFRESH_PERIOD_IN_MILLIS);
            } catch (InterruptedException e) {
                logger.debug(e.getMessage());
            }
            printInternalMemory();
        }
    }

    /**
     * Helper method for internal memory printing
     * */
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
