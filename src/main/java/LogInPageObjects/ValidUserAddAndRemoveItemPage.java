package LogInPageObjects;
import LogInDataObjects.ValidUserAndPassData;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ValidUserAddAndRemoveItemPage {
    WebDriver driver;
    WebDriverWait wait;

    public ValidUserAddAndRemoveItemPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By usernameInput = By.id("user-name");
    By passwordInput = By.id("password");
    By loginButton = By.id("login-button");
    By inventoryItem = By.xpath("//div[@class='inventory_item'][1]//button");
    By shoppingCartBadge = By.className("shopping_cart_badge");
    By removeButton = By.xpath("//div[@class='cart_item'][1]//button");

    @Step("Username Input:{0}")
    public ValidUserAddAndRemoveItemPage usernameInput() {
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInput));
        usernameField.sendKeys(ValidUserAndPassData.username);
        return this;
    }

    @Step("Password Input:{0}")
    public ValidUserAddAndRemoveItemPage passwordInput() {
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
        passwordField.sendKeys(ValidUserAndPassData.password);
        return this;
    }

    @Step("Click on Login Button")
    public void clickOnLogInButton() throws InterruptedException {
        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginBtn.click();
        Thread.sleep(5000);
    }

    @Step("Click on Inventory Item")
    public void clickOnInventoryItem() {
        WebElement itemButton = wait.until(ExpectedConditions.elementToBeClickable(inventoryItem));
        itemButton.click();
    }

    @Step("Click on Shopping Cart Badge")
    public void clickOnShoppingCartBadge() {
        WebElement cartBadge = wait.until(ExpectedConditions.elementToBeClickable(shoppingCartBadge));
        cartBadge.click();
    }

    @Step("Click on Remove Button")
    public void clickOnRemoveButton() {
        WebElement removeBtn = wait.until(ExpectedConditions.elementToBeClickable(removeButton));
        removeBtn.click();
    }
}