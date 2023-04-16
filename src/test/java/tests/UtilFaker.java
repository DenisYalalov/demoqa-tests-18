package tests;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

public class UtilFaker {


    Faker faker = new Faker();
    String subjects;

    {
        subjects = faker.options().option("English", "Physics", "Chemistry", "Computer Science",
                "Commerce", "Accounting", "Economics");
    }

    String hobbies;

    {
        hobbies = faker.options().option("Music", "Sports", "Reading");
    }

    String name = faker.name().firstName();
    String lastName = faker.name().lastName();

    String email = faker.internet().emailAddress();

    String gender = faker.options().option("Male", "Female", "Other");


    String userNumber = 8 + faker.phoneNumber().subscriberNumber(9);
    Date myBirthday = faker.date().birthday();
    SimpleDateFormat sdfyear = new SimpleDateFormat("yyyy");
    String year = sdfyear.format(myBirthday) ;
    SimpleDateFormat sdfmonth = new SimpleDateFormat("MMMM",Locale.ENGLISH);
    String month = sdfmonth.format(myBirthday) ;
    SimpleDateFormat sdfday = new SimpleDateFormat("dd");
    String day = sdfday.format(myBirthday);



    String pictureLocation = "1.jpeg";

    String userAddress = faker.address().streetName();


    Map<String, String[]> mapStateWithCity = Map.of(
            "NCR", new String[]{"Delhi", "Gurgaon", "Noida"},
            "Uttar Pradesh", new String[]{"Agra", "Lucknow", "Merrut"},
            "Haryana", new String[]{"Karnal", "Panipat"},
            "Rajasthan", new String[]{"Jaipur", "Jaiselmer"}
    );
    String state = faker.options().option(mapStateWithCity.keySet().toArray()).toString();
    String usercity = faker.options().option(mapStateWithCity.get(state));


}





