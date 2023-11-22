package appiumtests;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ChromeSearchTng {
    private AndroidDriver<MobileElement> driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Set desired capabilities for Appium
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Infinix Hot 12 Play");
        capabilities.setCapability(AndroidMobileCapabilityType.BROWSER_NAME, "Chrome");
        capabilities.setCapability("automationName", "UiAutomator2");

        // Initialize the AndroidDriver with the desired capabilities
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        // Set an implicit wait to wait for elements to load
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test(priority = 1)
    public void testSearchScenario1() {
        // Scenario 1: Open Chrome and navigate to Google
        driver.get("https://www.google.com");

        // Find the search input field and enter a keyword
        MobileElement searchInput = driver.findElement(By.name("q"));
        searchInput.sendKeys("Appium automation");
        searchInput.submit();

        // Add assertions or verification steps here
    }

    @Test(priority = 2)
    public void testSearchScenario2() {
        // Scenario 2: Clear the search field and enter a different keyword
        MobileElement searchInput = driver.findElement(By.name("q"));
        searchInput.clear();
        searchInput.sendKeys("Mobile testing with Appium");
        searchInput.submit();

        // Add assertions or verification steps here
    }

    @AfterClass
    public void tearDown() {
        // Scenario 3: Close the Chrome browser
        driver.quit();
    }
}
