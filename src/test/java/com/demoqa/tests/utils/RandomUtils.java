package com.demoqa.tests.utils;
import com.github.javafaker.Faker;

import java.security.SecureRandom;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    public static void main(String[] args) {
        System.out.println(getRandomString(10));
        System.out.println(getRandomEmail(10));
        System.out.println(getRandomInt(10, 999));
        System.out.println(getRandomPhone());
        System.out.println(getRandomGender());
        System.out.println(getRandomUuid());
    }

    public static String getRandomString(int len) {
        String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }

    public static String getRandomEmail(int len) {
        return  getRandomString(10) + "@gmail.ru";
    }

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String getRandomPhone() {
        return String.format("+%s (%s) %s - %s - %s", getRandomInt(1, 9), getRandomInt(111, 999),
                getRandomInt(111, 999), getRandomInt(11, 99), getRandomInt(11, 90));
    }

    public static String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};

        return getRandomItemFromArray(genders);
    }
    public static String getRandomMonth() {
        String[] genders = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        return getRandomItemFromArray(genders);
    }

    public static String getRandomHobbies() {
        String[] hobbies = {"Sports", "Reading", "Music"};
        return getRandomItemFromArray(hobbies);
    }

    public static String getRandomState() {
        String[] hobbies = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
        return getRandomItemFromArray(hobbies);
    }
    public static String getRandomSubject() {
        String[] subject = {"Math", "English", "Chemistry", "Civics", "Computer Science", "Arts", "Physics", "Economics"};
        return getRandomItemFromArray(subject);
    }

    public static String getRandomCity(String state) {
        if (state.equals("NCR")) {
            String[] city = {"Delhi", "Gurgaon", "Noida"};
            return getRandomItemFromArray(city);
        } else if (state.equals("Uttar Pradesh")) {
            String[] city = {"Agra", "Lucknow", "Merrut"};
            return getRandomItemFromArray(city);
        } else if (state.equals("Haryana")) {
            String[] city = {"Karnal", "Panipat"};
            return getRandomItemFromArray(city);
        } else if (state.equals("Rajasthan")) {
            String[] city = {"Jaipur", "Jaiselmer"};
            return getRandomItemFromArray(city);
        }
        return null;
    }

    private static String getRandomItemFromArray(String[] values){
        int index = getRandomInt(0, values.length - 1);
        return values[index];
    }

    public static String getRandomUuid() {
        return UUID.randomUUID().toString();
    }

    public static String getRandomFirstName() {
        return new Faker().name().firstName();
    }
}
