package tests;

import com.github.javafaker.Faker;

import java.util.Map;

import static java.lang.String.valueOf;

public class UtilFaker {
    public static Faker faker = new Faker();
    public static String Subjects;

    static {
        Subjects = faker.options().option("English", "Physics", "Chemistry", "Computer Science",
                "Commerce", "Accounting", "Economics");
    }

    public static String Hobbies;

    static {
        Hobbies = faker.options().option("Music", "Sports", "Reading");
    }

    static String Name = faker.name().firstName();
    static String LastName = faker.name().lastName();

    static String Email = faker.internet().emailAddress();

    static String Gender = faker.options().option("Male", "Female", "Other");


    static String userNumber = 8 + faker.phoneNumber().subscriberNumber(9);

    static String dayOfBirth = valueOf(faker.number().numberBetween(1, 28));

    static String monthOfBirth = faker.options().option("January", "February",
            "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");

    static String yearOfBirth = valueOf(faker.number().numberBetween(1950, 2000));

    static String PictureLocation = "1.jpeg";

    static String userAddress = faker.address().streetName();

    static String userState = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");


    static Map<String, String[]> mapStateWithCity = Map.of(
            "NCR", new String[]{"Gurgaon", "Noida"},
            "Uttar Pradesh", new String[]{"Agra", "Lucknow", "Merrut"},
            "Haryana", new String[]{"Karnal", "Panipat"},
            "Rajasthan", new String[]{"Jaipur", "Jaiselmer"}
    );
    static String state = faker.options().option(mapStateWithCity.keySet().toArray()).toString();
    static String userCity = faker.options().option(mapStateWithCity.get(state));


}





