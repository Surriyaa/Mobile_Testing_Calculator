
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.annotation.concurrent.Immutable;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserActions {
    AndroidDriver driver;
    public void swipeUp() {
        int startX = driver.manage().window().getSize().width / 2;
        int startY = driver.manage().window().getSize().height * 3 / 4;
        int endY = driver.manage().window().getSize().height / 4;

        new TouchAction(driver)
                .press(PointOption.point(startX, startY))
                .moveTo(PointOption.point(startX, endY))
                .release()
                .perform();
    }

    @Test
    public void browserAction() throws MalformedURLException, InterruptedException, AWTException {

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("emulator-5554");
        options.setPlatformName("Android");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.setAppPackage("com.android.chrome");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);
        Thread.sleep(4000);


        driver.get("https://www.amazon.com");
        Thread.sleep(10000);

        WebElement element=driver.findElement(By.xpath("\t\n" +
                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View[1]/android.view.View[1]/android.view.View[2]/android.view.View[2]/android.view.View[1]/android.view.View[1]/android.view.View"));

        element.click();
       Thread.sleep(2000);

      Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_I);
        robot.keyRelease(KeyEvent.VK_I);
        robot.keyPress(KeyEvent.VK_P);
        robot.keyRelease(KeyEvent.VK_P);
        robot.keyPress(KeyEvent.VK_H);
        robot.keyRelease(KeyEvent.VK_H);
        robot.keyPress(KeyEvent.VK_O);
        robot.keyRelease(KeyEvent.VK_O);
        robot.keyPress(KeyEvent.VK_N);
        robot.keyRelease(KeyEvent.VK_N);
        robot.keyPress(KeyEvent.VK_E);
        robot.keyRelease(KeyEvent.VK_E);



        Thread.sleep(2000); // Let the simulation complete
        WebElement search=driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View[1]/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View/android.widget.Button\n"));

        search.click();
        Thread.sleep(10000);
        swipeUp();






    }
}
