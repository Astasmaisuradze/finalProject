package LogInPageObjects;
import LogInDataObjects.LockedUserData;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LockedUserPage {
    WebDriver driver;

    public LockedUserPage(WebDriver driver){
        this.driver = driver;
    }

    By usernameInput = By.id("user-name");
    By passwordInput = By.id("password");
    By loginButton = By.id("login-button");

    @Step("Username Input:{0}")
    public LockedUserPage UsernameInput (){
        driver.findElement(usernameInput).sendKeys(LockedUserData.username);
        return this;
    }
    @Step("Password Input:{0}")
    public LockedUserPage PasswordInput () {
        driver.findElement(passwordInput).sendKeys(LockedUserData.password);
        return this;
    }
    @Step("Click on Login Button")
    public void clickOnLogInButton() throws InterruptedException {
        driver.findElement(loginButton).click();
        Thread.sleep(5000);
    }
}
