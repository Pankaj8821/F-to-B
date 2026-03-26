import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AppTest {

    @Test
    public void testFrontendLoads() {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
//	options.addArguments("--headless"); 
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        WebDriver driver = new ChromeDriver(options);

        driver.get("http://localhost:3000");

        String pageSource = driver.getPageSource();

        Assert.assertTrue(pageSource.contains("Frontend"));

        driver.quit();
    }
}
