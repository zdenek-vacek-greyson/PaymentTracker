package cz.greyson;

import cz.greyson.processor.InputArgumentProcessor;
import cz.greyson.processor.InputDataProcessor;
import cz.greyson.threads.InputConsoleThread;
import cz.greyson.threads.PrinterThread;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * MainClass of PaymentTracker application.
 *
 * @author Zdeněk Vacek on 13/03/2018
 */
public class PaymentTrackerApplication {
    /* Internal application memory */
    private Map<String, BigDecimal> internalMemory;

    /* Thread for input console */
    private InputConsoleThread inputConsoleThread;
    /* Thread for internal memory printer */
    private PrinterThread printerThread;

    private InputArgumentProcessor inputArgumentProcessor;
    private InputDataProcessor inputDataProcessor;

    public PaymentTrackerApplication() {
        internalMemory = new HashMap<>();

        inputArgumentProcessor = new InputArgumentProcessor();
        inputDataProcessor = new InputDataProcessor(this);

        inputConsoleThread = new InputConsoleThread(this);
        printerThread = new PrinterThread(this);
    }

    public static void main(String[] args) throws Exception {
        PaymentTrackerApplication paymentTrackerApplication = new PaymentTrackerApplication();

        // possible initialization from input file
        List<String> inputLines = paymentTrackerApplication.inputArgumentProcessor.processInputArguments(args);
        paymentTrackerApplication.inputDataProcessor.processInputData(inputLines);

        paymentTrackerApplication.printerThread.start();
        paymentTrackerApplication.inputConsoleThread.start();
    }

    /* GETTERS & SETTERS */

    public synchronized Map<String, BigDecimal> getInternalMemory() {
        return internalMemory;
    }

    public PrinterThread getPrinterThread() {
        return printerThread;
    }

    public InputDataProcessor getInputDataProcessor() {
        return inputDataProcessor;
    }
}
