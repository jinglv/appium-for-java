package com.auto.demo.app.wework.page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author jingLv
 * @date 2020/12/03
 */
public class BasePage {

    AppiumDriver<MobileElement> driver;
    WebDriverWait webDriverWait;

    public BasePage(String packageName, String activityName) {
        startApp(packageName, activityName);
    }

    public BasePage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, 60);
    }

    public void startApp(String appPackage, String appActivity) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("appPackage", appPackage);
        capabilities.setCapability("appActivity", appActivity);
        capabilities.setCapability("automationName", "UiAutomator1");
        capabilities.setCapability("noReset", "true");
        capabilities.setCapability("dontStopAppOnReset", "true");
        capabilities.setCapability("skipLogcatCapture", "true");

        URL remoteUrl = null;
        try {
            remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver = new AndroidDriver<>(Objects.requireNonNull(remoteUrl), capabilities);
        // 隐式等待
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        webDriverWait = new WebDriverWait(driver, 60);
    }

    public By byText(String text) {
        return By.xpath("//*[@text='" + text + "']");
    }

    public MobileElement find(By by) {
        return driver.findElement(by);
    }

    public MobileElement find(String text) {
        return driver.findElement(byText(text));
    }

    public void click(By by) {
        //todo: 异常处理
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by)).click();
    }

    public void click(String text) {
        //todo: 异常处理
        find(text).click();
    }


    public void sendKeys(By by, String content) {
        driver.findElement(by).sendKeys(content);
    }

    //todo:
    public void waitElement() {

    }

    public void quit() {
        driver.quit();
        driver = null;
    }
}
