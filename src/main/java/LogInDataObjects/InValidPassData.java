package LogInDataObjects;

import com.github.javafaker.Faker;

public interface InValidPassData {
    Faker faker = new Faker();
    String
            username = "standard_user",
            password = faker.internet().password();
}
