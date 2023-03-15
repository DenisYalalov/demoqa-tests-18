package tests;

import com.github.javafaker.Faker;
import lessonseven.RegistrationPage;
import org.junit.jupiter.api.Test;

import static utils.RandomUtils.getRandomItemFromArray;

public class RegistrationWithFakerTests extends Base {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    public void registrationFormTest1() {
        Faker faker = new Faker();
        String city = new String();
        String City = city;
        String[] months = new String[0];

        String Name = faker.name().firstName();
        String LastName = faker.name().lastName();
        String Email = faker.internet().emailAddress();
        String Genter = faker.options().option("Male", "Female", "Other");
        String Number = String.valueOf(faker.number().numberBetween(1000000000, 2009999999));
        String userBirthDay_day = String.format("%02d", faker.number().numberBetween(1, 28));
        String userBirthDay_month = getRandomItemFromArray(months);
        String userBirthDay_year = String.valueOf(faker.number().numberBetween(1950, 2005));
        String Subjects = faker.options().option("English", "Physics", "Chemistry", "Computer Science",
                "Commerce", "Accounting", "Economics");
        String Hobbies = faker.options().option("Music", "Sports", "Reading");
        String PictureLocation = "1.jpeg";
        String Address = faker.address().streetName();
        String State = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");


        registrationPage.openPage();
        registrationPage.removingTheBanner();
        registrationPage.firstName(Name);
        registrationPage.lastName(LastName);
        registrationPage.setEmail(Email);
        registrationPage.setGender(Genter);
        registrationPage.setPhone(Number);
        registrationPage.setBirthDay(userBirthDay_day , userBirthDay_month, userBirthDay_year);
        registrationPage.setSubjects(Subjects);
        registrationPage.setHobbies(Hobbies);
        registrationPage.setUpload(PictureLocation);
        registrationPage.setAddress(Address);
        registrationPage.setCity(State);
        registrationPage.setCity(City);
        registrationPage.clickSubmit();

        registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name",  Name + " " + LastName );
        registrationPage.verifyResult("Student Email", Email);
        registrationPage.verifyResult("Gender", Genter);
        registrationPage.verifyResult("Mobile", Number);
        registrationPage.verifyResult("Date of Birth", userBirthDay_day + " " + userBirthDay_month + " " + userBirthDay_year);
        registrationPage.verifyResult("Current Address", Address);
        registrationPage.verifyResult("Subjects", Subjects);
        registrationPage.verifyResult("Hobbies", Hobbies);
        registrationPage.verifyResult("State and City", State + " " + City );


    }


}
