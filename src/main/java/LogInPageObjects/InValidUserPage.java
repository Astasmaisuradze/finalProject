package LogInPageObjects;
import LogInDataObjects.InValidUserData;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InValidUserPage {
    WebDriver driver;

    public InValidUserPage(WebDriver driver){
        this.driver = driver;
    }

    By usernameInput = By.id("user-name");
    By passwordInput = By.id("password");
    By loginButton = By.id("login-button");

    @Step("Username Input:{0}")
    public InValidUserPage UsernameInput (){
        driver.findElement(usernameInput).sendKeys(InValidUserData.username);
        return this;
    }
    @Step("Password Input:{0}")
    public InValidUserPage PasswordInput () {
        driver.findElement(passwordInput).sendKeys(InValidUserData.password);
        return this;
    }
    @Step("Click on Login Button")
    public void clickOnLogInButton() throws InterruptedException {
        driver.findElement(loginButton).click();
        Thread.sleep(5000);
    }
}
