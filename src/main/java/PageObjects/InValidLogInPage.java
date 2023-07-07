package PageObjects;

import DataObjects.InValidLogInData;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InValidLogInPage {
    WebDriver driver;

    public InValidLogInPage(WebDriver driver){
        this.driver = driver;
    }

    By usernameInput = By.id("user-name");
    By passwordInput = By.id("password");
    By loginButton = By.id("login-button");

    @Step("Username Input:{0}")
    public InValidLogInPage UsernameInput (String username){
        driver.findElement(usernameInput).sendKeys(InValidLogInData.username);
        return this;
    }
    @Step("Password Input:{0}")
    public InValidLogInPage PasswordInput (String password) {
        driver.findElement(passwordInput).sendKeys(InValidLogInData.password);
        return this;
    }
    @Step("Click on Login Button")
    public InValidLogInPage clickOnLogInButton() throws InterruptedException {
        driver.findElement(loginButton).click();
        Thread.sleep(5000);
        return this;
    }
}
