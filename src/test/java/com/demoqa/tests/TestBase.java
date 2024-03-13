package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.tests.pages.RegistrationPage;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Browsers.CHROME;

public class TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
        System.setProperty("webdriver.chrome.driver", "D://Projects//demoqa-tests-20//chromedriver.exe");
        Configuration.browser = CHROME;
        //        Configuration.browser = FIREFOX;
    }
}
