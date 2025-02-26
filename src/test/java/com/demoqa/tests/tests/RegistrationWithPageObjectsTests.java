package com.demoqa.tests.tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationWithPageObjectsTests extends TestBase {

    @Test
    void successRegistrationTest() {
        registrationPage.openPage()
                .setFirstName("Alex")
                .setLastName("Surkov")
                .setUserEmail("alex@mail.com")
                .setGender("Male")
                .setUserNumber("0123456789")
                .setBirthDay("30", "May", "2022")
                .setSubjectsInput("Civics")
                .setSubjectsInput("Math")
                .setHobbies("Music")
                .uploadPicture("img/1.png")
                .setAddress("Address city")
                .selectState("NCR")
                .selectCity("Delhi")
                .clickSubmit();

        registrationPage
                .checkVisibleTable()
                .verifyResult("Student Name", "Alex Surkov")
                .verifyResult("Student Email", "alex@mail.com");
    }
}
