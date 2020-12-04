package com.auto.demo.app.wework.page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 日程PO
 *
 * @author jingLv
 * @date 2020/12/03
 */
public class SchedulePage extends BasePage {

    //todo:多版本app、多平台的app 定位符通常有差别
    private final By taskName = By.id("b0e");
    private final By save = byText("保存");
    private final By taskList = By.id("gg_");
    private By add = By.id("gq0");

    public SchedulePage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public SchedulePage addDate(String name, String time) {
        click(add);
        sendKeys(taskName, name);
        click(save);
        return this;
    }

    public List<String> getNowDate(String day) {
        if (day != null) {
            //todo:选择日期
        }
        return driver.findElements(taskList)
                .stream()
                .map(x -> x.getText())
                .collect(Collectors.toList());
    }
}
