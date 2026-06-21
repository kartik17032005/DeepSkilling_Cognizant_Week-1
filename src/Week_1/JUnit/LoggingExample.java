package Week_1.JUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingExample {
    private static final Logger logger = LoggerFactory.getLogger(LoggingExample.class);

    public static void main(String[] args) {
        runLogging();
    }

    public static void runLogging() {
        logger.error("This is an error message");
        logger.warn("This is a warning message");
        logger.info("This is an info message");
        logger.debug("This is a debug message");

        String username = "Kartik";
        int id = 101;
        logger.info("User {} with ID {} logged in successfully", username, id);
    }
}
