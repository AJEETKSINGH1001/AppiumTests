package appiumtests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import javax.lang.model.element.Element;

public class ChromeSearchTest {
    public static void main(String[] args) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        // Set the device capabilities
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Infinix Hot 12 Play");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability("automationName", "UiAutomator2");
        // Set the Chrome-specific capability
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
      //  capabilities.setCapability(MobileCapabilityType.APP, "com.android.chrome");
        // Initialize the Appium driver with the Appium server URL and desired capabilities
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        // Set an implicit wait time to wait for elements to load
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

     // Test Scenarios
        try {
            // Scenario 1: Open Chrome and navigate to Google
            driver.get("https://www.google.com");

            // Find the search input field and enter a keyword
            Element searchInput = (Element) driver.executeAsyncScript("q");
            ((WebElement) searchInput).sendKeys("Appium automation");
            ((WebElement) searchInput).submit();

            // Wait for the search results to load
            Thread.sleep(5000);

            // Scenario 2: Clear the search field and enter a different keyword
            ((WebElement) searchInput).clear();
            ((WebElement) searchInput).sendKeys("Mobile testing with Appium");
            ((WebElement) searchInput).submit();

            // Wait for the search results to load
            Thread.sleep(5000);

            // Scenario 3: Go back to the previous search results page
            driver.navigate().back();

            // Scenario 4: Go forward to the search results page again
            driver.navigate().forward();

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            // Scenario 5: Close the Chrome browser
            driver.quit();
        }
    }
}
