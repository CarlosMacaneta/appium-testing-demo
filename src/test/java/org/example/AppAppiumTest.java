package org.example;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class AppAppiumTest {

    @Test
    public void setup() throws MalformedURLException, URISyntaxException {

        URL serverUrl = new URI("http://127.0.0.1:4723/").toURL();

        // Getting device details for automation
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("your_device_name")
                .setApp("your_apk");

        AndroidDriver androidDriver = new AndroidDriver(serverUrl, options);
        androidDriver.quit();
    }
}