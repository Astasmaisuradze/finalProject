package LogInDataObjects;

import com.github.javafaker.Faker;

public interface InValidUserData {
    Faker faker = new Faker();
    String
            username = faker.name().username(),
            password = "secret_sauce";
}
