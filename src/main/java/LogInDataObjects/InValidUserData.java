package LogInDataObjects;

import com.github.javafaker.Faker;

public interface InValidUserData {
    Faker faker = new Faker();
    int interactionCount = 5;
    String
            username = faker.name().firstName(),
            password = "secret_sauce";

    default void printFirstnameVariants() {
        int count = 0;

        while (count < interactionCount) {
            String firstname = faker.name().firstName();
            System.out.println("Firstname variant " + (count + 1) + ": " + firstname);
            count++;
        }
    }
}
