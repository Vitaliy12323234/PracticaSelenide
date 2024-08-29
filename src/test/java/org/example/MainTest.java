package org.example;

import io.qameta.allure.Step;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;
public class MainTest {
    private SoftAssertions softAssertions;
    @BeforeEach
    void setUp() {
        softAssertions = new SoftAssertions();
        openAndLogin();
    }
    @AfterEach
    void tearDown() {
        try {
            softAssertions.assertAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeWebDriver();
        }
    }
    @Step("Открытие сайта и авторизация")
    static void openAndLogin() {
        Open.opens();
        SignIn.login();
    }
    @Nested
    class ValidNewsTests {

        @Test
        void testNews() {
            News.addValidNews();
        }
        @Test
        void testCreate() {
            CreateInfo.create();
        }
        @Test
        void testRedact() {
            Redact.redactMews();
        }
        @Test
        void testDelete() {
            Delete.deleteNews();
            softAssertions.assertThat($x("//selector").exists()).isFalse();
        }
    }
    @Nested
    class NoTests {
        @Test
        void testAdd() {
            NoNews.noaddNews();
        }
    }
}
