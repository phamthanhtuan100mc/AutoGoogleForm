package core.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import core.util.Enum.ItemType;
import core.util.Enum.OSType;
import core.wrapper.ElementWrapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Helper {
    private static final Logger log = LogManager.getLogger(Helper.class);

    /**
     * Returns a path to file or directory which having file separator depend on OS: Windows, macOS, Linux
     *
     * @param destinationType determine the path destination is file or directory
     * @param args list name of folder to destination file or directory
     * @return the path to destination file or directory
     */
    public static String createFilePathByOS(ItemType destinationType, String... args) {
        String filePath = "";

        if (args.length > 0 && args != null) {
            for (String folder: args) {
                filePath = filePath.concat(folder).concat(File.separator);
            }
        }

        switch (destinationType) {
            case FILE:
                // delete last File separator when directory is file path
                filePath = filePath.substring(0, filePath.lastIndexOf(File.separator));
                break;
            case FOLDER:
                // do nothing when directory is folder path
                break;
        }

        return filePath;
    }

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

    /**
     * Read file and return file content as String text
     */
    public static String readFile() {

        return "";
    }
}
