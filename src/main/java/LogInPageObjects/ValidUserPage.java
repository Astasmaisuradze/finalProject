package LogInPageObjects;

import LogInDataObjects.ValidUserData;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ValidUserPage {
    WebDriver driver;

    public ValidUserPage(WebDriver driver){
        this.driver = driver;
    }

    By usernameInput = By.id("user-name");
    By passwordInput = By.id("password");
    By loginButton = By.id("login-button");

    @Step("Username Input:{0}")
    public ValidUserPage UsernameInput (String username){
        driver.findElement(usernameInput).sendKeys(ValidUserData.username);
        return this;
    }
    @Step("Password Input:{0}")
    public ValidUserPage PasswordInput (String password) {
        driver.findElement(passwordInput).sendKeys(ValidUserData.password);
        return this;
    }
    @Step("Click on Login Button")
    public ValidUserPage clickOnLogInButton() throws InterruptedException {
        driver.findElement(loginButton).click();
        Thread.sleep(5000);
        return this;
    }
}


