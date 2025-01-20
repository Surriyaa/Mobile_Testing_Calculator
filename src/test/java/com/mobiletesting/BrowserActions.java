package com.mobiletesting;

import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BrowserActions {

    private AndroidDriver driver;

    // Initialize the driver before running tests
    @BeforeTest
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("emulator-5554");
        options.setPlatformName("Android");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.setAppPackage("com.android.chrome");
        options.setNoReset(true);
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);
    }

    // Clean up after the tests
    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    // Gesture: Swipe Up
    public void swipeUp() {
        int startX = driver.manage().window().getSize().width / 2;
        int startY = (int) (driver.manage().window().getSize().height * 0.8);
        int endY = (int) (driver.manage().window().getSize().height * 0.2);

        TouchAction action = new TouchAction(driver);
        action.press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(startX, endY))
                .release()
                .perform();
    }

    // Gesture: Swipe Down
    public void swipeDown() {
        int startX = driver.manage().window().getSize().width / 2;
        int startY = (int) (driver.manage().window().getSize().height * 0.2);
        int endY = (int) (driver.manage().window().getSize().height * 0.8);

        TouchAction action = new TouchAction(driver);
        action.press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(startX, endY))
                .release()
                .perform();
    }

    // Gesture: Tap
    public void tap(WebElement element) {
        TouchAction action = new TouchAction(driver);
        action.tap(PointOption.point(element.getLocation().getX(), element.getLocation().getY()))
                .perform();
    }
    public void pinch(WebElement element) {
        // Get element dimensions
        int centerX = element.getLocation().getX() + (element.getSize().getWidth() / 2);
        int centerY = element.getLocation().getY() + (element.getSize().getHeight() / 2);

        // Coordinates for two fingers
        int finger1StartX = centerX + 100;
        int finger1StartY = centerY + 100;
        int finger1EndX = centerX + 10;
        int finger1EndY = centerY + 10;

        int finger2StartX = centerX - 100;
        int finger2StartY = centerY - 100;
        int finger2EndX = centerX - 10;
        int finger2EndY = centerY - 10;

        // Perform pinch
        TouchAction action1 = new TouchAction(driver)
                .press(PointOption.point(finger1StartX, finger1StartY))
                .moveTo(PointOption.point(finger1EndX, finger1EndY))
                .release();

        TouchAction action2 = new TouchAction(driver)
                .press(PointOption.point(finger2StartX, finger2StartY))
                .moveTo(PointOption.point(finger2EndX, finger2EndY))
                .release();

        new MultiTouchAction(driver).add(action1).add(action2).perform();
    }
    public void zoom(WebElement element) {
        // Get element dimensions
        int centerX = element.getLocation().getX() + (element.getSize().getWidth() / 2);
        int centerY = element.getLocation().getY() + (element.getSize().getHeight() / 2);

        // Coordinates for two fingers
        int finger1StartX = centerX + 10;
        int finger1StartY = centerY + 10;
        int finger1EndX = centerX + 100;
        int finger1EndY = centerY + 100;

        int finger2StartX = centerX - 10;
        int finger2StartY = centerY - 10;
        int finger2EndX = centerX - 100;
        int finger2EndY = centerY - 100;

        // Perform zoom
        TouchAction action1 = new TouchAction(driver)
                .press(PointOption.point(finger1StartX, finger1StartY))
                .moveTo(PointOption.point(finger1EndX, finger1EndY))
                .release();

        TouchAction action2 = new TouchAction(driver)
                .press(PointOption.point(finger2StartX, finger2StartY))
                .moveTo(PointOption.point(finger2EndX, finger2EndY))
                .release();

        new MultiTouchAction(driver).add(action1).add(action2).perform();
    }


    @Test
    public void testBrowserActions() throws InterruptedException, AWTException {
        driver.get("https://www.amazon.com");
        Thread.sleep(5000);

        // Locate and interact with the search bar
        WebElement searchBar=driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View[2]/android.view.View[2]/android.view.View[1]/android.view.View/android.widget.EditText"));
        tap(searchBar);

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_I);
        robot.keyRelease(KeyEvent.VK_I);
        Thread.sleep(1000);
        robot.keyPress(KeyEvent.VK_P);
        robot.keyRelease(KeyEvent.VK_P);Thread.sleep(1000);
        robot.keyPress(KeyEvent.VK_H);
        robot.keyRelease(KeyEvent.VK_H);Thread.sleep(1000);
        robot.keyPress(KeyEvent.VK_O);
        robot.keyRelease(KeyEvent.VK_O);Thread.sleep(1000);
        robot.keyPress(KeyEvent.VK_N);
        robot.keyRelease(KeyEvent.VK_N);Thread.sleep(1000);
        robot.keyPress(KeyEvent.VK_E);
        robot.keyRelease(KeyEvent.VK_E);Thread.sleep(2000); // Let the simulation complete
        WebElement searchButton=driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View[2]/android.view.View[2]/android.view.View[2]/android.view.View/android.view.View"));

        tap(searchButton);

        Thread.sleep(5000);

        // Perform swipe gestures
        swipeUp();
        Thread.sleep(2000);
        swipeDown();
        WebElement element1= driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View[3]/android.view.View[1]"));
        zoom(element1);
        Thread.sleep(5000);
        pinch(element1);

    }

}
