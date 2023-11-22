package appiumtests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ChromeTest {
    public static void main(String[] args) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        // Set the device capabilities
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Infinix Hot 12 Play");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability("automationName", "UiAutomator2");
        // Set the Chrome-specific capability
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        // Initialize the Appium driver with the Appium server URL and desired capabilities
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        // Set an implicit wait time to wait for elements to load
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Open Google in Chrome
        driver.get("https://www.google.com");

        // You can interact with the page here (e.g., searching on Google)

        // Close the browser and quit the driver
        
    }
}
