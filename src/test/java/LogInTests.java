import LogInDataObjects.InValidLogInData;
import LogInDataObjects.LogInData;
import LogInPageObjects.LogInPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import LogInPageObjects.InValidLogInPage;

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
        LogInPage home = new LogInPage(driver);
        home
                .UsernameInput(LogInData.username)
                .PasswordInput(LogInData.password)
                .clickOnLogInButton();

    }

    @Test
    public void inValidLogIn() throws InterruptedException{
        InValidLogInPage home = new InValidLogInPage(driver);
        home
                .UsernameInput(InValidLogInData.username)
                .PasswordInput(InValidLogInData.password)
                .clickOnLogInButton();
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

}
