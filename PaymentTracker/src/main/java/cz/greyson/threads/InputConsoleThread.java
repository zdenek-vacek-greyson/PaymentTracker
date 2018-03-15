package cz.greyson.threads;

import com.google.common.base.Strings;
import cz.greyson.PaymentTrackerApplication;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author Zdeněk Vacek on 13/03/2018
 */
public class InputConsoleThread extends AbstractPaymentTrackerThread {

    final static Logger logger = Logger.getLogger(InputConsoleThread.class);

    public InputConsoleThread(PaymentTrackerApplication paymentTrackerApplication) {
        super(paymentTrackerApplication);
    }


    /**
     * Main thread method. Infinity loop for reading input from keyboard and his processing
     */
    public void run() {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        System.out.println();
        while (true) {
            System.out.print("> ");
            String inputLine = null;
            try {
                inputLine = bufferedReader.readLine();

                // skipping empty lines
                if (Strings.isNullOrEmpty(inputLine)) {
                    System.out.println("!!! (Invalid input) !!!");
                    continue;
                }

                // exit application
                if (inputLine.equals("exit") || inputLine.equals("quit")) {
                    logger.info("Konec programu");
                    stopApplication();
                }

                paymentTrackerApplication.getInputDataProcessor().processInputData(inputLine);

            } catch (Exception e) {
                System.out.println("!!! (Invalid input: \"" + inputLine + "\") !!!");
            }

            paymentTrackerApplication.getPrinterThread().printInternalMemory();
        }
    }

    /**
     * Helper method for application close
     * */
    private void stopApplication() {
        paymentTrackerApplication.getPrinterThread().interrupt();
        this.interrupt();
        System.exit(0);
    }
}
