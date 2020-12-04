package com.auto.demo.app.xueqiu.page;

import org.openqa.selenium.By;

/**
 * 雪球App主页PO
 *
 * @author jingLv
 * @date 2020/12/02
 */
public class MainPage extends BasePage {

    public SearchPage toSearch() {
        click(By.id("com.xueqiu.android:id/home_search"));
        return new SearchPage(driver);
    }

    public void toStock() {

    }
}
