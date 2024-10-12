package runner;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

public class iOSSetup {
    public static IOSDriver driver;

    public static AppiumDriverLocalService service;

    // Static method to initialize the driver
    public static IOSDriver initializeDriver() throws MalformedURLException, URISyntaxException {
        if (driver == null) {
            ConfigureAppium();  // Call to configure Appium server and driver
        }
        return driver;
    }

    private static void ConfigureAppium() throws URISyntaxException, MalformedURLException {
        try {
            service = new AppiumServiceBuilder()
                    .withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                    .withIPAddress("127.0.0.1")
                    .usingPort(4723)
                    .withArgument(GeneralServerFlag.LOG_LEVEL, "debug")
                    .build();
            service.start();
            System.out.println("Appium Server started");
        } catch (Exception e) {
            System.err.println("Failed to start Appium Server: " + e.getMessage());
            throw e;
        }

        XCUITestOptions options = new XCUITestOptions();
        options.setDeviceName("iPhone 16 Pro Max");
//        options.setApp("com.example.apple-samplecode.UICatalog"); // Can also use this instead of file path below to run on simulator IF app is already installed on the simulator being used
        options.setApp("/Users/shaunvalentine/Library/Developer/Xcode/DerivedData/UIKitCatalog-fljewjtblzbnuzgqkhvgnyxvzzco/Build/Products/Debug-iphonesimulator/UIKitCatalog.app"); // MUST find the .app folder to grab application for the simulator
        options.setPlatformVersion("18.0");
        options.setWdaLaunchTimeout(Duration.ofSeconds(20));

        try {
            driver = new IOSDriver(new URL("http://127.0.0.1:4723"), options);
            if (driver != null) {
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                System.out.println("IOSDriver initialized successfully");
            } else {
                System.err.println("Failed to initialize IOSDriver");
            }
        } catch (Exception e) {
            System.err.println("Error initializing IOSDriver: " + e.getMessage());
            throw e;
        }
    }
}