package com.jianfu.appium.appium_hybird;

import java.io.File;
import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
    private AppiumDriver<WebElement> driver;

    @Before
    public void setUp() throws Exception {
        // set up appium
        File classpathRoot = new File(System.getProperty("user.dir"));
        System.out.println(classpathRoot.toString());
        File app = new File(classpathRoot, "/src/test/resource/android-debug.apk");
        System.out.println(app.exists());
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "edbcddf");
        // capabilities.setCapability("automationName", "Selendroid");
        capabilities.setCapability("app", app.getAbsolutePath());
        // capabilities.setCapability("appPackage", "com.jianfukeji.dispensary");
        capabilities.setCapability("autoWebview", true);
        capabilities.setCapability("platformVersion", "4.4.4");
        capabilities.setCapability("browserName", "");

        driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void testWebView() throws InterruptedException {
        Thread.sleep(20000);
        try {
            WebElement username = driver.findElement(By.id("username"));
            username.sendKeys("Some name");
        } catch (NoSuchElementException e) {
            System.out.println(e);
        }

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Some name");
        Thread.sleep(50000);
    }
}
