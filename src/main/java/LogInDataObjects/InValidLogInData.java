package LogInDataObjects;

import com.github.javafaker.Faker;

public interface InValidLogInData {
    Faker faker = new Faker();
    String
            username = faker.name().username(),
            password = "secret_sauce";
}
