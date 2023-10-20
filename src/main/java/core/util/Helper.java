package core.util;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import core.util.Enum.ItemType;
import core.util.Enum.OSType;
import core.wrapper.driver.DriverProperty;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.json.Json;

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
     * Read file setup in json and return driver config
     */
    public static DriverProperty loadBrowserSetting(String filePath, String runConfig) {

        Gson gson = new Gson();
        try {
            Reader reader = Files.newBufferedReader(Paths.get(filePath));
            JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);
            JsonObject runConfigObject = jsonObject.getAsJsonObject(runConfig);
            DriverProperty property = gson.fromJson(runConfigObject, DriverProperty.class);

            return property;
        } catch (IOException ioe) {
            log.error(ioe.getMessage());
            return null;
        }
    }
}
