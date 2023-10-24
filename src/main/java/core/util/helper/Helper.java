package core.util.helper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import core.util.enums.OSType;

public class Helper {
    private static final Logger logger = LogManager.getLogger(Helper.class);

    public static void excCommand(OSType osType, String command) {
        try {
            switch (osType) {
                case WINDOWS:
                    ProcessBuilder builder = new ProcessBuilder(
                            "cmd.exe", "/c", command);
                    builder.redirectErrorStream(true);
                    Process p = builder.start();
                    BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
                    String line;
                    while (true) {
                        line = r.readLine();
                        if (line == null) {
                            break;
                        }
                        logger.info("Command result - " + line);
                    }
                case UNKNOWN:
                    logger.error("Operation System recognize failed");
            }
        } catch (IOException ioe) {
            logger.error("Could not execute command");
            logger.error(ioe);
        }
    }


}
