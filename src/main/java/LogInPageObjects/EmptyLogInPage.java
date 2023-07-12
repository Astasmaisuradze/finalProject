package LogInPageObjects;
import LogInDataObjects.EmptyLogInData;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmptyLogInPage {
    WebDriver driver;

    public EmptyLogInPage(WebDriver driver) {
        this.driver = driver;
    }

    By usernameInput = By.id("user-name");
    By passwordInput = By.id("password");
    By loginButton = By.id("login-button");

    @Step("Username Input:{0}")
    public EmptyLogInPage UsernameInput() {
        driver.findElement(usernameInput).sendKeys(EmptyLogInData.username);
        return this;
    }

    @Step("Password Input:{0}")
    public EmptyLogInPage PasswordInput() {
        driver.findElement(passwordInput).sendKeys(EmptyLogInData.password);
        return this;
    }

    @Step("Click on Login Button")
    public void clickOnLogInButton() throws InterruptedException {
        driver.findElement(loginButton).click();
        Thread.sleep(5000);
    }

}