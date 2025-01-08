package com.mobiletesting;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class RealDeviceAutomation {
    public AndroidDriver driver;
    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities=new DesiredCapabilities();
        capabilities.setCapability("appium:deviceName","Redmi Note 12 Pro+ 5G");
        capabilities.setCapability("appium:udid","z5cy55ayjrdqscmz");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("appium:appPackage","com.miui.calculator");
        capabilities.setCapability("appium:appActivity",".cal.CalculatorActivity");
        capabilities.setCapability("appium:platformVersion","14.0");
        capabilities.setCapability("appium:noReset", true);
        driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        System.out.println("Automation Started");
    }
    @Test(priority = 0)
    public void addition() throws InterruptedException {
        Thread.sleep(2000);
        WebElement five =driver.findElement(By.id("com.miui.calculator:id/digit_5"));
        five.click();
        Thread.sleep(2000);
        WebElement plus=driver.findElement(AppiumBy.accessibilityId("plus"));
        plus.click();
        Thread.sleep(2000);
        WebElement eight =driver.findElement(By.id("com.miui.calculator:id/digit_8"));
        eight.click();
        Thread.sleep(2000);
        WebElement equal=driver.findElement(AppiumBy.accessibilityId("equals"));
        equal.click();

        //verify the result using assertion
        WebElement result=driver.findElement(By.id("com.miui.calculator:id/result"));
        String resultValue=result.getText();
        System.out.println(resultValue);
        Assert.assertEquals("= 13",resultValue,"The value expected is not getting");
    }
    @Test(priority = 1)
    public void subraction() throws InterruptedException {
        Thread.sleep(2000);
        WebElement five =driver.findElement(By.id("com.miui.calculator:id/digit_5"));
        five.click();
        Thread.sleep(2000);
        WebElement minus =driver.findElement(AppiumBy.accessibilityId("minus"));
        minus.click();
        Thread.sleep(2000);
        WebElement eight =driver.findElement(By.id("com.miui.calculator:id/digit_8"));
        eight.click();
        Thread.sleep(2000);
        WebElement equal=driver.findElement(AppiumBy.accessibilityId("equals"));
        equal.click();

        //verify the result using assertion
        WebElement result=driver.findElement(By.id("com.miui.calculator:id/result"));
        String resultValue=result.getText();
        System.out.println(resultValue);
        Assert.assertEquals("= -3",resultValue,"The value expected is not getting");
    }
    @Test(priority = 2)
    public void multiplication() throws InterruptedException {
        Thread.sleep(2000);
        WebElement num1=driver.findElement(By.id("com.miui.calculator:id/digit_8"));
        num1.click();
        Thread.sleep(2000);
        WebElement mult=driver.findElement(AppiumBy.accessibilityId("multiply"));
        mult.click();
        Thread.sleep(2000);
        WebElement num2=driver.findElement(By.id("com.miui.calculator:id/digit_8"));
        num2.click();
        Thread.sleep(2000);
        WebElement equal=driver.findElement(AppiumBy.accessibilityId("equals"));
        equal.click();

        //verify the result using assertion
        WebElement result=driver.findElement(By.id("com.miui.calculator:id/result"));
        String resultValue=result.getText();
        System.out.println(resultValue);
        Assert.assertEquals("= 64",resultValue,"The value expected is not getting");
    }
    @Test(priority = 3)
    public void division() throws InterruptedException {
        Thread.sleep(2000);
        WebElement num1=driver.findElement(By.id("com.miui.calculator:id/digit_8"));
        num1.click();
        Thread.sleep(2000);
        WebElement divide =driver.findElement(AppiumBy.accessibilityId("divide"));
        divide.click();
        Thread.sleep(2000);
        WebElement num2=driver.findElement(By.id("com.miui.calculator:id/digit_2"));
        num2.click();
        Thread.sleep(2000);
        WebElement equal=driver.findElement(AppiumBy.accessibilityId("equals"));
        equal.click();

        //verify the result using assertion
        WebElement result=driver.findElement(By.id("com.miui.calculator:id/result"));
        String resultValue=result.getText();
        System.out.println(resultValue);
        Assert.assertEquals("= 4",resultValue,"The value expected is not getting");
    }
}
