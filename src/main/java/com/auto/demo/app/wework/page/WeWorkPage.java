package com.auto.demo.app.wework.page;

import org.openqa.selenium.By;

/**
 * @author jingLv
 * @date 2020/12/03
 */
public class WeWorkPage extends BasePage {

    public WeWorkPage() {
        super("com.tencent.wework", ".login.controller.LoginWxAuthActivity");
    }

    public SchedulePage toSchedule() {
        click(By.xpath("//*[@text='日程']"));
        return new SchedulePage(driver);
    }
}
