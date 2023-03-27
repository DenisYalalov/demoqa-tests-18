package tests;

import com.github.javafaker.Faker;

import java.util.Map;

import static java.lang.String.valueOf;

public class UtilFaker {


    Faker faker = new Faker();
    String Subjects;

    {
        Subjects = faker.options().option("English", "Physics", "Chemistry", "Computer Science",
                "Commerce", "Accounting", "Economics");
    }

    String Hobbies;

    {
        Hobbies = faker.options().option("Music", "Sports", "Reading");
    }

    String name = faker.name().firstName();
    String lastName = faker.name().lastName();

    String email = faker.internet().emailAddress();

    String gender = faker.options().option("Male", "Female", "Other");


    String userNumber = 8 + faker.phoneNumber().subscriberNumber(9);

    String dayOfBirth = valueOf(faker.number().numberBetween(1, 28));

    String monthOfBirth = faker.options().option("January", "February",
            "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");

    String yearOfBirth = valueOf(faker.number().numberBetween(1950, 2000));

    String pictureLocation = "1.jpeg";

    String userAddress = faker.address().streetName();

    String userState = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");


    Map<String, String[]> mapStateWithCity = Map.of(
            "NCR", new String[]{"Delhi", "Gurgaon", "Noida"},
            "Uttar Pradesh", new String[]{"Agra", "Lucknow", "Merrut"},
            "Haryana", new String[]{"Karnal", "Panipat"},
            "Rajasthan", new String[]{"Jaipur", "Jaiselmer"}
    );
    String state = faker.options().option(mapStateWithCity.keySet().toArray()).toString();
    String userCity = faker.options().option(mapStateWithCity.get(state));


}





