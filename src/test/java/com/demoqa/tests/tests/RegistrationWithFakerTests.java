package com.demoqa.tests.tests;


import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.demoqa.tests.utils.RandomUtils.getRandomEmail;

public class RegistrationWithFakerTests extends TestBase{
    @Test
    void successfulRegistrationTest(){
        Faker faker = new Faker(new Locale("ru"));
        String firstName = faker.name().firstName(),
                lastName = faker.name().lastName(),
                userEmail = getRandomEmail(10),
                currentAddress = faker.address().fullAddress();

        open("/automation-practice-form");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("0123456789");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__year-select").selectOption("2022");
        $(".react-datepicker__day--002:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("Civics").pressEnter();
        $("#subjectsInput").setValue("Math").pressEnter();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("img/1.png");
        $("#currentAddress").setValue(currentAddress);
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text(firstName), text(lastName), text("0123456789"));
    }
}
