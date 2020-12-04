package com.auto.demo.app.xueqiu.page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jingLv
 * @date 2020/12/02
 */
public class SearchPage extends BasePage {

    public SearchPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public SearchPage search(String keyword) {
        // 控件执行稳定性，循环点击，直到控件不存在了
        do {
            sendKeys(By.id("com.xueqiu.android:id/search_input_text"), keyword);
        } while (driver.findElements(By.id("name")).size() <= 0);
        return this;
    }

    public List<String> getSearchList() {
        List<String> nameList = new ArrayList<>();
        driver.findElements(By.id("name")).forEach(name -> nameList.add(((WebElement) name).getText()));
        return nameList;
    }

    public double getPrice() {
        click(By.id("name"));
        return Double.parseDouble(driver.findElement(By.id("current_price")).getText());
    }

}
