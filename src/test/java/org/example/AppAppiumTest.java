package org.example;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.example.utils.Constants;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class AppAppiumTest {

    private AppiumDriverLocalService appiumServiceBuilder() {
        return new AppiumServiceBuilder()
                .withAppiumJS(new File(Constants.APPIUM_PATH))
                .withIPAddress(Constants.APPIUM_IP_ADDRESS)
                .usingPort(Constants.APPIUM_IP_ADDRESS_PORT)
                .build();
    }

    @SuppressWarnings("resource")
    @Test
    public void setup() throws MalformedURLException, URISyntaxException {

        URL serverUrl = new URI(Constants.APPIUM_SERVER).toURL();

        //starting appium automatically
        appiumServiceBuilder().start();

        // Getting device details for automation
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName(Constants.DEVICE_NAME)
                .setApp(Constants.APK_PATH);

        AndroidDriver androidDriver = new AndroidDriver(serverUrl, options);
        androidDriver.quit();

        appiumServiceBuilder().stop();
    }
}