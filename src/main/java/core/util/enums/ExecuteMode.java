package core.util.enums;

public enum ExecuteMode {
    LOCAL ("Local"),
    REMOTE ("Remote");

    private final String value;

    ExecuteMode(String value) {
        this.value = value;
    }

    public String toString() {
        return this.value;
    }
}
