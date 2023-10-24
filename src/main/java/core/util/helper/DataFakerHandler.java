package core.util.helper;

import net.datafaker.Faker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Locale;

public class DataFakerHandler {
    private static Faker faker;

    public static Faker createFaker() {
        faker = new Faker();
        return faker;
    }

    public static Faker createFakerByLocation(String locate) {
        faker = new Faker(new Locale(locate));
        return faker;
    }

    public static Faker getFaker() {
        if (faker == null) {
            createFaker();
        }
        return faker;
    }

    public void setFaker(Faker faker) {
        DataFakerHandler.faker = faker;
    }
}
