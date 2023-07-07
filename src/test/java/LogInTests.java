import LogInDataObjects.InValidUserData;
import LogInDataObjects.ValidUserData;
import LogInPageObjects.ValidUserPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import LogInPageObjects.InValidUserPage;

public class LogInTests {
    WebDriver driver;

    @BeforeMethod(description = "Setup browser before testing")

    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.navigate().to("https://www.saucedemo.com/");
    }


    @Test
    public void validLogIn() throws InterruptedException {
        ValidUserPage home = new ValidUserPage(driver);
        home
                .UsernameInput(ValidUserData.username)
                .PasswordInput(ValidUserData.password)
                .clickOnLogInButton();

    }

    @Test
    public void inValidLogIn() throws InterruptedException{
        InValidUserPage home = new InValidUserPage(driver);
        home
                .UsernameInput(InValidUserData.username)
                .PasswordInput(InValidUserData.password)
                .clickOnLogInButton();
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

}
