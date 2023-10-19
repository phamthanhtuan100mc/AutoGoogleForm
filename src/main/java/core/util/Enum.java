package core.util;

public class Enum {
    public enum QuestionType {
        CHECKBOX,
        CHECKBOX_GRID,
        DATE,
        DROP_DOWN,
        LINEAR_SCALE,
        MULTIPLE_CHOICE,
        MULTIPLE_CHOICE_GRID,
        PARAGRAPH,
        SHORT_ANSWER,
        TIME,
        NULL
    }

    public enum ItemType {
        FOLDER,
        FILE
    }

    public enum OSType {
        WINDOWS,
        LINUX,
        MACOSX,
        AIX,
        UNKNOWN
    }

    public enum BrowserType {
        CHROME ("chrome"),
        FIREFOX ("firefox"),
        EDGE ("edge"),
        SAFARI ("safari");

        private final String value;

        private BrowserType(String value) {
            this.value = value;
        }

        public String toString() {
            return this.value;
        }
    }

    public enum ExecuteMode {
        LOCAL ("Local"),
        REMOTE ("Remote");

        private final String value;

        private ExecuteMode(String value) {
            this.value = value;
        }

        public String toString() {
            return this.value;
        }
    }
}
