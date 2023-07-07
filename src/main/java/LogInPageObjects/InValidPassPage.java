package LogInPageObjects;
import LogInDataObjects.InValidPassData;
import org.openqa.selenium.WebDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;


public class InValidPassPage {
    WebDriver driver;

    public InValidPassPage(WebDriver driver){
        this.driver = driver;
    }

    By usernameInput = By.id("user-name");
    By passwordInput = By.id("password");
    By loginButton = By.id("login-button");

    @Step("Username Input:{0}")
    public InValidPassPage UsernameInput (String username){
        driver.findElement(usernameInput).sendKeys(InValidPassData.username);
        return this;
    }
    @Step("Password Input:{0}")
    public InValidPassPage PasswordInput (String password) {
        driver.findElement(passwordInput).sendKeys(InValidPassData.password);
        return this;
    }
    @Step("Click on Login Button")
    public InValidPassPage clickOnLogInButton() throws InterruptedException {
        driver.findElement(loginButton).click();
        Thread.sleep(5000);
        return this;
    }
}
