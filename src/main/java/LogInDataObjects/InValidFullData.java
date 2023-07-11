package LogInDataObjects;

import com.github.javafaker.Faker;

public interface InValidFullData {
    Faker faker = new Faker();

    String
            username = faker.name().firstName(),
            password = faker.internet().password();

    static void generateUsernamesAndPasswords() {
        int count = 0;
        while (count < 10) {
            System.out.println("Username: " + username);
            System.out.println("Password: " + password);
            System.out.println();
            count++;

        }
    }
}