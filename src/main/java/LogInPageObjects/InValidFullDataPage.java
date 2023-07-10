package LogInPageObjects;
import LogInDataObjects.InValidFullData;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InValidFullDataPage {
    WebDriver driver;

    public InValidFullDataPage(WebDriver driver) {
        this.driver = driver;
    }

    By usernameInput = By.id("user-name");
    By passwordInput = By.id("password");
    By loginButton = By.id("login-button");

    @Step("Username Input:{0}")
    public InValidFullDataPage UsernameInput() {
        driver.findElement(usernameInput).sendKeys(InValidFullData.username);
        return this;
    }

    @Step("Password Input:{0}")
    public InValidFullDataPage PasswordInput() {
        driver.findElement(passwordInput).sendKeys(InValidFullData.password);
        return this;
    }

    @Step("Click on Login Button")
    public void clickOnLogInButton() throws InterruptedException {
        driver.findElement(loginButton).click();
        Thread.sleep(5000);
    }

}

