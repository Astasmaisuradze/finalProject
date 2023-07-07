import LogInDataObjects.InValidPassData;
import LogInDataObjects.InValidUserData;
import LogInPageObjects.*;
import Utils.ChromeRunner;
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
import java.time.Duration;

public class LogInTests extends ChromeRunner {
    WebDriver driver;

    @BeforeMethod(description = "Setup browser before testing")

    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com/");
    }


    @Test(priority = 6)
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
    @Test(priority = 7)
    public void validUserLogInWithBuy() throws InterruptedException {
        ValidUserAndPassPage home = new ValidUserAndPassPage(driver);
        home
                .UsernameInput()
                .PasswordInput()
                .clickOnLogInButton();
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement addToCartButton = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn_inventory")));
        addToCartButton.click();
        WebElement cartBadge = driver.findElement(By.cssSelector(".shopping_cart_badge"));
        String cartItemCount = cartBadge.getText();
        System.out.println("Cart item count: " + cartItemCount);
        Assert.assertNotEquals(cartItemCount, "1", "Product is added to the cart");
    }



    @Test(priority = 5)
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
        InValidUserData invalidUserData = new InValidUserData() {};
        invalidUserData.printFirstnameVariants();

    }


    @Test(priority = 4)
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
        InValidPassData invalidPassData = new InValidPassData() {};
        invalidPassData.printPasswordVariants(5);
    }

    @Test(priority = 2)
    public void lockedUserLogIn() throws InterruptedException{
        LockedUserPage home = new LockedUserPage(driver);
        home
                .UsernameInput()
                .PasswordInput()
                .clickOnLogInButton();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@data-test='error']")));
        String errorText = errorElement.getText();
        System.out.println("Error Text: " + errorText);
        Assert.assertTrue("Error element is displayed", errorElement.isDisplayed());
        Assert.assertEquals(errorText, "Error text is correct", "Error text is correct");

    }

    @Test(priority = 3)
    public void problemUserLogIn() throws InterruptedException{
        ProblemUserPage home = new ProblemUserPage(driver);
        home
                .UsernameInput()
                .PasswordInput()
                .clickOnLogInButton();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@data-test='error']")));
        String errorText = errorElement.getText();
        System.out.println("Error Text: " + errorText);
        Assert.assertTrue("Error element is displayed", errorElement.isDisplayed());
        Assert.assertEquals(errorText, "Error text is correct", "Error text is correct");

    }

    @Test(priority = 1)
    public void emptyUserDataLogIn() throws InterruptedException{
        EmptyLogInPage home = new EmptyLogInPage(driver);
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