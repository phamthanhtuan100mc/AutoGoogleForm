package core.util.enums;

public enum BrowserType {
    CHROME ("chrome"),
    FIREFOX ("firefox"),
    EDGE ("edge"),
    SAFARI ("safari");

    private final String value;

    BrowserType(String value) {
        this.value = value;
    }

    public String toString() {
        return this.value;
    }
}
