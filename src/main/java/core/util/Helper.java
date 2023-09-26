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
                
                break;
            case FOLDER:
                break;
        }

        return filePath;
    }
}
