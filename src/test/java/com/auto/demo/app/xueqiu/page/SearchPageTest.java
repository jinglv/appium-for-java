package com.auto.demo.app.xueqiu.page;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.net.MalformedURLException;

/**
 * @author jingLv
 * @date 2020/12/02
 */
class SearchPageTest {

    static SearchPage searchPage;

    @BeforeAll
    static void beforeAll() throws MalformedURLException {
        searchPage = new MainPage().toSearch();
    }

    @ParameterizedTest
    @CsvSource({
            "alibaba,         阿里巴巴",
            "jd,        京东"
    })
    void search(String keyword, String name) {
        Assertions.assertEquals(searchPage.search(keyword).getSearchList().get(0), name);
    }

    @Test
    void getPrice() {
        Assertions.assertTrue(searchPage.search("alibaba").getPrice() > 2);
    }

    @AfterAll
    static void afterAll() {
        searchPage.quit();
    }
}