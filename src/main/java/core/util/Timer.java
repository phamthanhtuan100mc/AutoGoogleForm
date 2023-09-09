package core.util;

public class Timer {
    public static void sleep(int millisecond) {
        try {
            Thread.sleep(millisecond);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
