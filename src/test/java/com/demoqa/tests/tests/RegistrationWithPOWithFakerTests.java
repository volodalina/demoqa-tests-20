package com.demoqa.tests.tests;

import org.junit.jupiter.api.Test;

import static com.demoqa.tests.utils.RandomUtils.*;

public class RegistrationWithPOWithFakerTests extends TestBase {
    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            userNumber = faker.phoneNumber().subscriberNumber(10),
            currentAddress = faker.address().fullAddress(),
            gender = getRandomGender(),
            day = String.format("%02d", faker.number().numberBetween(1, 28)),
//          day = String.valueOf(getRandomInt(10, 28)),
            month = getRandomMonth(),
            year = String.valueOf(faker.number().numberBetween(1990, 2100)),
            hobbies = getRandomHobbies(),
    //      hobbies = faker.options().option("Sports", "Reading", "Music");
            state = getRandomState(),
            city = getRandomCity(state),
            subject = getRandomSubject(),
            picture = "img/1.png";
    @Test
    void successRegistrationTest() {
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setBirthDay(day, month, year)
                .setSubjectsInput(subject)
                .setHobbies(hobbies)
                .uploadPicture(picture)
                .setAddress(currentAddress)
                .selectState(state)
                .selectCity(city)
                .clickSubmit();

        registrationPage
                .checkVisibleTable()
                .verifyResult("Student Name", firstName + " " + lastName)
                .verifyResult("Student Email", userEmail);
    }
}
