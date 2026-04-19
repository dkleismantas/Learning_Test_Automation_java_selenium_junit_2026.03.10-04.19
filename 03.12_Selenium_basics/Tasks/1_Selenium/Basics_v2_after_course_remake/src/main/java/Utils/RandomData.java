package Utils;

import net.datafaker.Faker;

public class RandomData {
    static Faker faker = new Faker();

    public static String randomEmailAddress() {
        return faker.internet().emailAddress();
    }
}
