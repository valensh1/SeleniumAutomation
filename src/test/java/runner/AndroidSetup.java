package runner;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

public class AndroidSetup {
    public static AndroidDriver driver;

    public static AppiumDriverLocalService service;

    // Static method to initialize the driver
    public static AndroidDriver initializeDriver() throws MalformedURLException, URISyntaxException {
        ConfigureAppium();  // Call to configure Appium server and driver
        return driver;
    }

    private static void ConfigureAppium() throws URISyntaxException, MalformedURLException {
        // Start the Appium server and configure the driver options as usual
        service = new AppiumServiceBuilder()
                .withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .withArgument(GeneralServerFlag.LOG_LEVEL, "debug")
                .build();
        service.start();
        System.out.println("Appium Server started");

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Pixel 9 Pro");
        options.setCapability("fullReset", false);
        options.setCapability("autoGrantPermissions", true);
        options.setApp("/Users/shaunvalentine/Documents/Computer Programming/Projects/SeleniumAutomation/src/AndroidNativeApplication/Costco.apk");
        options.setPlatformVersion("14.0");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("Android Driver initialized successfully");
    }
}