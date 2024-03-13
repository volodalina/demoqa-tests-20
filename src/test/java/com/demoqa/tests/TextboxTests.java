package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.tests.pages.TextboxPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Browsers.FIREFOX;
import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextboxTests extends TestBase{

    TextboxPage textboxPage = new TextboxPage();

    @Test
    void successTest() {
        textboxPage.openPage()
                .setUserName("Alex Egorov")
                .setUserEmail("alex@egorov.com")
                .setCurrentAddress("Some address 1")
                .setPermanentAddress("Another address 1")
                .submit();

        textboxPage.verifyResult("Alex Egorov",
                "alex@egorov.com",
                "Some address 1",
                "Another address 1"
                );
    }
}
