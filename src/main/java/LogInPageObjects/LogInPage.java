package LogInPageObjects;

import LogInDataObjects.LogInData;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LogInPage {
    WebDriver driver;

    public LogInPage(WebDriver driver){
        this.driver = driver;
    }

    By usernameInput = By.id("user-name");
    By passwordInput = By.id("password");
    By loginButton = By.id("login-button");

    @Step("Username Input:{0}")
    public LogInPage UsernameInput (String username){
        driver.findElement(usernameInput).sendKeys(LogInData.username);
        return this;
    }
    @Step("Password Input:{0}")
    public LogInPage PasswordInput (String password) {
        driver.findElement(passwordInput).sendKeys(LogInData.password);
        return this;
    }
    @Step("Click on Login Button")
    public LogInPage clickOnLogInButton() throws InterruptedException {
        driver.findElement(loginButton).click();
        Thread.sleep(5000);
        return this;
    }
}


