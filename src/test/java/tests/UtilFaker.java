package tests;

import com.github.javafaker.Faker;

public class UtilFaker {
    public static Faker faker = new Faker();
    public static String Subjects;

    static {
        Subjects = faker.options().option("English", "Physics", "Chemistry", "Computer Science",
                "Commerce", "Accounting", "Economics");
    }
        public static String Hobbies ;
    static {
        Hobbies = faker.options().option("Music", "Sports", "Reading");
}
    public static String Name;
    static {
        Name = faker.name().firstName();
    }
    public static String  LastName;
    static {
         LastName = faker.name().lastName();
    }
    public static String Email;
    static {
        Email = faker.internet().emailAddress();
    }
    public static String Gender;
    static {
         Gender = faker.options().option("Male", "Female", "Other");
    }
    public static String userNumber;
    static {
        userNumber = 8 + faker.phoneNumber().subscriberNumber(9);
    }
    public static String userBirthDay_day;
    static {
       userBirthDay_day = java.lang.String.valueOf(faker.number().numberBetween(1, 30));
    }
    public static String userBirthDay_month ;
    static {
         userBirthDay_month = faker.options().option("January", "February",
                "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
    }
    public static String userBirthDay_year;
    static {
        userBirthDay_year = java.lang.String.valueOf(faker.number().numberBetween(1950, 2000));
    }
    public static String PictureLocation;
    static {
         PictureLocation = "1.jpeg";

    }
    public static String userAddress ;
    static {
        userAddress = faker.address().streetName();
    }
    public static String userState;
    static {
        userState = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");

    }
    public static String userCity;
    private static final java.lang.String String = userCity ;

    static {
        userCity = String;

        if (userState == "NCR") {
            userCity = faker.options().option("Gurgaon", "Delhi", "Noida");
        } else if (userState == "Uttar Pradesh") {
            userCity = faker.options().option("Merrut", "Lucknow", "Agra");
        } else if (userState == "Haryana") {
            userCity = faker.options().option("Panipat", "Karnal");
        } else {
            userCity = faker.options().option("Jaiselmer", "Jaipur");
        }

    }



}

