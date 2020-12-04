package com.auto.demo.app.wework.page;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * @author jingLv
 * @date 2020/12/03
 */
class SchedulePageTest {

    static SchedulePage schedulePage;

    @BeforeAll
    static void beforeAll() {
        WeWorkPage weWorkPage = new WeWorkPage();
        schedulePage = weWorkPage.toSchedule();
    }

    @Test
    void addDate() {
        Assertions.assertTrue(schedulePage.addDate("上班打卡", null).getNowDate(null).contains("上班打卡"));
    }

    @Test
    void getNowDate() {
    }

    @AfterAll
    static void afterAll() {
        schedulePage.quit();
    }
}