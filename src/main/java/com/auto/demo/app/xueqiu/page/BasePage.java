package com.auto.demo.app.xueqiu.page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

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

    public BasePage() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("appPackage", "com.xueqiu.android");
        capabilities.setCapability("appActivity", ".view.WelcomeActivityAlias");
        capabilities.setCapability("automationName", "UiAutomator1");
        capabilities.setCapability("noReset", "true");
        // capabilities.setCapability("dontStopAppOnReset", "true");

        URL remoteUrl = null;
        try {
            remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver = new AndroidDriver<>(Objects.requireNonNull(remoteUrl), capabilities);
        // 隐式等待
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public BasePage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public MobileElement find(By by) {
        return driver.findElement(by);
    }

    public void click(By by) {
        //todo: 异常处理
        driver.findElement(by).click();
    }


    public void sendKeys(By by, String content) {
        driver.findElement(by).sendKeys(content);
    }

    public void waitElement() {
        // TODO:元素等待实现
    }

    public void quit() {
        driver.quit();
        driver = null;
    }
}
