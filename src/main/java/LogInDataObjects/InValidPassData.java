package LogInDataObjects;
import com.github.javafaker.Faker;

public interface InValidPassData {
    Faker faker = new Faker();
    String
            username = "standard_user",
            password = faker.internet().password();

    default void printPasswordOptions(int interactionCount) {
        for (int i = 0; i < interactionCount; i++) {
            String password = faker.internet().password();
            System.out.println("Password options " + (i + 1) + ": " + password);
        }
    }
}