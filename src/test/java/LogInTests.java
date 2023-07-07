import LogInPageObjects.InValidPassPage;
import LogInPageObjects.ValidUserAndPassPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import LogInPageObjects.InValidUserPage;
import java.time.Duration;

public class LogInTests {
    WebDriver driver;

    @BeforeMethod(description = "Setup browser before testing")

    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com/");
    }


    @Test
    public void validUserLogIn() throws InterruptedException {
        ValidUserAndPassPage home = new ValidUserAndPassPage(driver);
        home
                .UsernameInput()
                .PasswordInput()
                .clickOnLogInButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement inventoryElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inventory_container")));
        String inventoryText = inventoryElement.getText();
        System.out.println("Inventory Text: " + inventoryText);
        Assert.assertTrue("Inventory container is displayed", inventoryElement.isDisplayed());
        Assert.assertNotEquals(inventoryText, "Expected Inventory Text", "Inventory text is correct");
    }




    @Test
    public void inValidUserLogIn() throws InterruptedException{
        InValidUserPage home = new InValidUserPage(driver);
        home
                .UsernameInput()
                .PasswordInput()
                .clickOnLogInButton();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@data-test='error']")));
        String errorText = errorElement.getText();
        System.out.println("Error Text: " + errorText);
        Assert.assertTrue("Error element is displayed", errorElement.isDisplayed());
        Assert.assertNotEquals(errorText, "Expected Error Text", "Error text is correct");
    }


    @Test
    public void inValidPassLogIn() throws InterruptedException{

        InValidPassPage home = new InValidPassPage(driver);
        home
                .UsernameInput()
                .PasswordInput()
                .clickOnLogInButton();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@data-test='error']")));
        String errorText = errorElement.getText();
        System.out.println("Error Text: " + errorText);
        Assert.assertTrue("Error element is displayed", errorElement.isDisplayed());
        Assert.assertNotEquals(errorText, "Expected Error Text", "Error text is correct");
    }



    @AfterMethod
    public void tearDown() {
        driver.close();
    }

}