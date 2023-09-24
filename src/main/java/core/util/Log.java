package core.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {

    //Initialize Log4j instance
    private static final Logger log = LogManager.getLogger(Log.class);

    //Info Level Logs
    public static void INFO (String message) {
        log.info(message);
    }
    public static void INFO (Object object) {
        log.info(object);
    }

    //Warn Level Logs
    public static void WARN (String message) {
        log.warn(message);
    }
    public static void WARN (Object object) {
        log.warn(object);
    }

    //Error Level Logs
    public static void ERROR (String message) {
        log.error(message);
    }
    public static void ERROR (Object object) {
        log.error(object);
    }

    //Fatal Level Logs
    public static void FATAL (String message) {
        log.fatal(message);
    }
    public static void FATAL (Object object) {
        log.fatal(object);
    }

    //Debug Level Logs
    public static void DEBUG (String message) {
        log.debug(message);
    }
    public static void DEBUG (Object object) {
        log.debug(object);
    }

}
