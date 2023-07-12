package LogInPageObjects;
import LogInDataObjects.ProblemUserData;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProblemUserPage {
    WebDriver driver;

    public ProblemUserPage(WebDriver driver){
        this.driver = driver;
    }

    By usernameInput = By.id("user-name");
    By passwordInput = By.id("password");
    By loginButton = By.id("login-button");

    @Step("Username Input:{0}")
    public ProblemUserPage UsernameInput (){
        driver.findElement(usernameInput).sendKeys(ProblemUserData.username);
        return this;
    }
    @Step("Password Input:{0}")
    public ProblemUserPage PasswordInput () {
        driver.findElement(passwordInput).sendKeys(ProblemUserData.password);
        return this;
    }
    @Step("Click on Login Button")
    public void clickOnLogInButton() throws InterruptedException {
        driver.findElement(loginButton).click();
        Thread.sleep(5000);
    }
}