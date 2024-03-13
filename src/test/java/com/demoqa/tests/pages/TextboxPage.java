package com.demoqa.tests.pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Browsers.FIREFOX;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextboxPage{
    SelenideElement
            userName = $("#userName"),
            userEmail =  $("#userEmail"),
            currentAddress =  $("#currentAddress"),
            permanentAddress =  $("#permanentAddress"),
            submitButton =  $("#submit"),
            resultName =  $("#output #name"),
            resultEmail =  $("#output #email"),
            resultCurrentAddress =  $("#output #currentAddress"),
            resultPermanentAddress =  $("#output #permanentAddress");
    public TextboxPage openPage(){
        open("/text-box");
        return this;
    }
    public TextboxPage setUserName(String value){
        userName.setValue(value);
        return this;
    }
    public TextboxPage setUserEmail(String value){
        userEmail.setValue(value);
        return this;
    }
    public TextboxPage setCurrentAddress(String value){
        currentAddress.setValue(value);
        return this;
    }
    public TextboxPage setPermanentAddress(String value){
        permanentAddress.setValue(value);
        return this;
    }
    public void submit(){
        submitButton.click();
    }
    public void verifyResult(String name, String email, String currentAddress, String permanentAddress){
        resultName.shouldHave(text(name));
        resultEmail.shouldHave(text(email));
        resultCurrentAddress.shouldHave(text(currentAddress));
        resultPermanentAddress.shouldHave(text(permanentAddress));
    }
}
