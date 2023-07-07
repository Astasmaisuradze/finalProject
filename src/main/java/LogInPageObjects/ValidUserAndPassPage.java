package LogInPageObjects;

import LogInDataObjects.ValidUserAndPassData;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ValidUserAndPassPage {
    WebDriver driver;

    public ValidUserAndPassPage(WebDriver driver){
        this.driver = driver;
    }

    By usernameInput = By.id("user-name");
    By passwordInput = By.id("password");
    By loginButton = By.id("login-button");

    @Step("Username Input:{0}")
    public ValidUserAndPassPage UsernameInput (String username){
        driver.findElement(usernameInput).sendKeys(ValidUserAndPassData.username);
        return this;
    }
    @Step("Password Input:{0}")
    public ValidUserAndPassPage PasswordInput (String password) {
        driver.findElement(passwordInput).sendKeys(ValidUserAndPassData.password);
        return this;
    }
    @Step("Click on Login Button")
    public ValidUserAndPassPage clickOnLogInButton() throws InterruptedException {
        driver.findElement(loginButton).click();
        Thread.sleep(5000);
        return this;
    }
}


