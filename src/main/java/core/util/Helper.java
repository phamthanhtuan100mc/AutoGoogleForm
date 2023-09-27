package core.util;

import java.io.File;
import core.util.Enum.ItemType;

public class Helper {
    public static String createFilePath(ItemType destinationType, String... args) {
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
}
