package appiumtests;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class CalculatorTest {

    public static void main(String[] args) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.UDID, "084113125P054404");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
       // capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Infinix HOT 12 Play"); // Replace with your device name
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.transsion.calculator"); // Calculator app package name
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.transsion.calculator.Calculator"); // Calculator app activity name
       // capabilities.setCapability("appium:automationName", "uiautomator2");
        DesiredCapabilities capabilities1 = new DesiredCapabilities();
        capabilities1.setCapability("automationName", "UiAutomator2");
        AndroidDriver driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), capabilities1);
        //AndroidDriver<MobileElement> driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), capabilities);

       // capabilities.setCapability(MobileCapabilityType.UDID, "084113125P054404");
        // Wait for the calculator app to load (you can customize this wait time)
        // Note: You may need to identify elements differently based on your app's structure
        // Example: MobileElement digit1 = driver.findElementById("digit_1");

        // Perform actions
        // Example: digit1.click();

        // Close the calculator app
        driver.closeApp();

        // Quit the Appium driver session
        driver.quit();
    }
}
