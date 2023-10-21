package core.util.helper;

import core.util.enums.ItemType;

import java.io.File;

public class StringHandler {

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
}
