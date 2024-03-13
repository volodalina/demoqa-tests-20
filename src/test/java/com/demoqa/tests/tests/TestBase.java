package com.demoqa.tests.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.tests.pages.RegistrationPage;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;

import java.util.Locale;

import static com.codeborne.selenide.Browsers.CHROME;

public class TestBase {
//        String firstName = "Alex",
//            lastName = "Surkov",
//            userEmail = "alex@mail.com";
    RegistrationPage registrationPage = new RegistrationPage();
    Faker faker = new Faker();
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
