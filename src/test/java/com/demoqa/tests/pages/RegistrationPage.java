package com.demoqa.tests.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.tests.pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    SelenideElement
       firstNameInput = $("#firstName"),
       lastNameInput = $("#lastName"),
       userEmailInput = $("#userEmail"),
        genderWrapper = $("#genterWrapper"),
        userNumberInput = $("#userNumber"),
        birthDayInput = $("#dateOfBirthInput"),
        subjectsInput = $("#subjectsInput"),
        hobbiesWrapper = $("#hobbiesWrapper"),
        uploadPicture = $("#uploadPicture"),
        currentAddress = $("#currentAddress"),
        stateSelect = $("#state"),
        stateCityWrapper = $("#stateCity-wrapper"),
        citySelect = $(byText("Select City")),
        submitBtn = $("#submit"),
        modalDialog = $(".modal-dialog"),
        tableResult = $(".table-responsive");

    public RegistrationPage openPage(){
        open("/automation-practice-form");
        return this;
    }
    public RegistrationPage setFirstName(String value){
        firstNameInput.setValue(value);
        return this;
    }
    public RegistrationPage setLastName(String value){
        lastNameInput.setValue(value);
        return this;
    }
    public RegistrationPage setUserEmail(String value){
        userEmailInput.setValue(value);
        return this;
    }

    public RegistrationPage setUserNumber(String value){
        userNumberInput.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value){
        genderWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setBirthDay(String day, String month, String year){
        birthDayInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubjectsInput(String value){
        subjectsInput.setValue(value).pressEnter();
        return this;
    }
    public RegistrationPage setHobbies(String value){
        hobbiesWrapper.$(byText(value)).click();
        return this;
    }
    public RegistrationPage uploadPicture(String value){
        uploadPicture.uploadFromClasspath(value);
        return this;
    }
    public RegistrationPage setAddress(String value){
        currentAddress.setValue(value);
        return this;
    }
    public RegistrationPage selectState(String value){
        stateSelect.click();
        stateCityWrapper.$(byText(value)).click();
        return this;
    }
    public RegistrationPage selectCity(String value){
        citySelect.click();
        stateCityWrapper.$(byText(value)).click();
        return this;
    }
    public void clickSubmit(){
        submitBtn.click();
    }
    public RegistrationPage checkVisibleTable(){
        modalDialog.should(appear);
        return this;
    }

    public RegistrationPage verifyResult(String element, String value){
        tableResult.$(byText(element))
                .sibling(0).shouldHave(text(value));
        return this;
    }

}
