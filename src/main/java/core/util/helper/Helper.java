package core.util.helper;

import java.io.*;

import core.util.enums.ItemType;
import core.util.enums.OSType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Helper {
    private static final Logger log = LogManager.getLogger(Helper.class);



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
                        log.info("Command result - " + line);
                    }
                case UNKNOWN: default:
                    log.error("Operation System is not recognized");
            }
        } catch (IOException ioe) {
            log.error("Could not execute command");
            log.error(ioe);
        }
    }


}
