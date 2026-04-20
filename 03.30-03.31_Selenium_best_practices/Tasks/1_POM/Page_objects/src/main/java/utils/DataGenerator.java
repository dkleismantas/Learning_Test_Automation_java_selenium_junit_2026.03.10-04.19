package utils;

import net.datafaker.Faker;

public class DataGenerator {

    static Faker faker = new Faker();

    public static String generateEmail() {
        return faker.internet().emailAddress();
    }

    public static String generatePhoneNumber() {
        return faker.phoneNumber().phoneNumber();
    }

    public static String generateFirstName() {
        return faker.name().firstName();
    }

    public static String generateLastName() {
        return faker.name().lastName();
    }
}
