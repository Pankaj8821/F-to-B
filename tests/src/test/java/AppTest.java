import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AppTest {

    @Test
    public void testFrontendLoads() throws InterruptedException {

        System.out.println("🚀 Starting Selenium Test...");

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();

        // ❌ REMOVE headless (so browser is visible)
        // options.addArguments("--headless");

        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
	options.addArguments("--disable-gpu");   // 🔥 fix GPU issue
	options.addArguments("--disable-software-rasterizer");
	options.addArguments("--disable-extensions");
	options.addArguments("--disable-dev-tools");
	options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        System.out.println("🌐 Opening frontend URL...");

        driver.get("http://localhost:3000");

        Thread.sleep(5000); // 👈 Wait so you can SEE browser

        System.out.println("📄 Page Loaded Successfully");

        String pageSource = driver.getPageSource();

        System.out.println("🔍 Verifying content...");

        Assert.assertTrue(pageSource.contains("Frontend"));

        System.out.println("✅ Test Passed!");

        Thread.sleep(3000); // 👈 keep browser open for observation

        driver.quit();

        System.out.println("🛑 Browser closed");
    }
}
