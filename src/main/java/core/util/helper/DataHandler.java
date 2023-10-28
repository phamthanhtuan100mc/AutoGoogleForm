package core.util.helper;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import core.wrapper.driver.DriverProperty;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DataHandler {
    private static final Logger logger = LogManager.getLogger(DataHandler.class);

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
            property.setMode(property.isRemote() ? "Remote" : "Local");

            return property;
        } catch (IOException ioe) {
            logger.error(ioe.getMessage());
            return null;
        }
    }
}
