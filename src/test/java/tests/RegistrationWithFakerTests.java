package tests;

import com.github.javafaker.Faker;
import lessonseven.RegistrationPage;
import org.junit.jupiter.api.Test;

public class RegistrationWithFakerTests extends Base {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    public void registrationFormTest1() {
        Faker faker = new Faker();

        String Name = faker.name().firstName();
        String LastName = faker.name().lastName();
        String Email = faker.internet().emailAddress();
        String Gender = faker.options().option("Male", "Female", "Other");
        String userNumber = 8 + faker.phoneNumber().subscriberNumber(9);
        String userBirthDay_day = String.valueOf(faker.number().numberBetween(1, 30));
        String userBirthDay_month = faker.options().option("January", "February",
                "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
        String userBirthDay_year = String.valueOf(faker.number().numberBetween(1950, 2000));
        String Hobbies = faker.options().option("Music", "Sports", "Reading");
        String Subjects = faker.options().option("English", "Physics", "Chemistry", "Computer Science",
                "Commerce", "Accounting", "Economics");
        String PictureLocation = "1.jpeg";
        String userAddress = faker.address().streetName();
        String userState = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");

        String city;

        if (userState == "NCR") {
            city = faker.options().option("Gurgaon", "Delhi", "Noida");
        } else if (userState == "Uttar Pradesh") {
            city = faker.options().option("Merrut", "Lucknow", "Agra");
        } else if (userState == "Haryana") {
            city = faker.options().option("Panipat", "Karnal");
        } else {
            city = faker.options().option("Jaiselmer", "Jaipur");
        }
        String userCity = city;


        registrationPage.openPage();
        registrationPage.removingTheBanner();
        registrationPage.firstName(Name);
        registrationPage.lastName(LastName);
        registrationPage.setEmail(Email);
        registrationPage.clickGender(Gender);
        registrationPage.setPhone(userNumber);
        registrationPage.setBirthDay(userBirthDay_day, userBirthDay_month, userBirthDay_year);
        registrationPage.setSubjects(Subjects);
        registrationPage.clickHobbies(Hobbies);
        registrationPage.setUpload(PictureLocation);
        registrationPage.setAddress(userAddress);
        registrationPage.setState(userState);
        registrationPage.setCity(userCity);

        registrationPage.clickSubmit();

        registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name", Name + " " + LastName);
        registrationPage.verifyResult("Student Email", Email);
        registrationPage.verifyResult("Gender", Gender);
        registrationPage.verifyResult("Mobile", userNumber);
        registrationPage.verifyResult("Date of Birth", userBirthDay_day + " " + userBirthDay_month + "," + userBirthDay_year);
        registrationPage.verifyResult("Subjects", Subjects);
        registrationPage.verifyResult("Address", userAddress);
        registrationPage.verifyResult("Hobbies", Hobbies);
        registrationPage.verifyResult("State and City", userState + " " + userCity);


    }


}
