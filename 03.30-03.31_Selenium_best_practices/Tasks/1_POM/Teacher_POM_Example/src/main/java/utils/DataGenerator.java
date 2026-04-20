package utils;

import net.datafaker.Faker;

public class DataGenerator {
    public static String generateEmail() {
        return new Faker().internet().emailAddress();
    }
}
