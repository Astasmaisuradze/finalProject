package Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class ChromeRunner {
    public static WebDriver driver = new ChromeDriver();
    @BeforeTest
    public void openChrome(){
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @AfterTest
    public void closeChrome(){
        driver.quit();
    }
//aq eshveba brauzeri
}