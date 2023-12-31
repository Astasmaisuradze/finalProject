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

public class LoggedTests {
    WebDriver driver;

    @BeforeMethod(description = "Setup browser before testing")
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com/");
    }

    private void logIn() {
        WebElement usernameInput = driver.findElement(By.id("user-name"));
        usernameInput.sendKeys("standard_user");

        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
    }
    public void applyFilterAndSort() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement filterButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("svg-inline--fa")));
        filterButton.click();

        WebElement priceHighToLow = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-test='product_sort_container']//option[text()='Price (high to low)']")));
        priceHighToLow.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("inventory_item_name")));
    }



    @Test(priority = 1)
    public void logInAndAccessInventoryPage() {
        logIn();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement menuButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("react-burger-menu-btn")));
        menuButton.click();
        WebElement inventoryLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("All Items")));
        inventoryLink.click();
        String currentURL = driver.getCurrentUrl();
        Assert.assertTrue("Inventory page is displayed", currentURL.contains("https://www.saucedemo.com/inventory.html"));
    }

    @Test(priority = 2)
    public void logInAndLogOutFromMenuBar() {
        logIn();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement menuButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("react-burger-menu-btn")));
        menuButton.click();
        WebElement logoutLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logout_sidebar_link")));
        logoutLink.click();
        WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-button")));
        Assert.assertTrue("Login button is displayed", loginButton.isDisplayed());
        String currentURL = driver.getCurrentUrl();
        Assert.assertFalse("Inventory page is displayed", currentURL.contains("https://www.saucedemo.com/inventory.html"));
    }

    @Test(priority = 3)
    public void logInAndApplyFilterAndSort() {
        logIn();
        applyFilterAndSort();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement inventoryContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inventory_container")));
        String inventoryText = inventoryContainer.getText();
        System.out.println("Inventory Text: " + inventoryText);
        Assert.assertTrue("Inventory container is displayed", inventoryContainer.isDisplayed());

    }

    @AfterMethod(description = "Close browser after testing")
    public void tearDown() {
        driver.quit();
    }
}