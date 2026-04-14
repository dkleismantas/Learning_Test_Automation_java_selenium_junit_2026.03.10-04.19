package utils;

import net.datafaker.Faker;

public class DataGenerator {
    public static String generateEmail() {
        Faker faker = new Faker();
        return faker.internet().emailAddress();
    }

    public static String generatePhoneNumber() {
        Faker faker = new Faker();
        return faker.phoneNumber().phoneNumber();
    }

    public static String generateFirstName() {
        Faker faker = new Faker();
        return faker.name().firstName();
    }

    public static String generateLastName() {
        Faker faker = new Faker();
        return faker.name().lastName();
    }
}
