package tests;

import com.github.javafaker.Faker;
import lessonseven.RegistrationPage;
import org.junit.jupiter.api.Test;

public class RegistrationWithFakerTests extends Base {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    public void registrationFormTest1() {
        Faker faker = new Faker();
        String city = new String();
        String userCity = city;



        String Name = faker.name().firstName();
        String LastName = faker.name().lastName();
        String Email = faker.internet().emailAddress();
        String Gender = faker.options().option("Male", "Female", "Other");
        String userNumber = 8 + faker.phoneNumber().subscriberNumber(9);
        String userBirthDay_day = String.valueOf(faker.number().numberBetween(1, 28));
        String userBirthDay_month = faker.options().option("January", "February",
                "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
        String userBirthDay_year = String.valueOf(faker.number().numberBetween(1950, 2000));
        String Hobbies = faker.options().option("Music", "Sports", "Reading");
        String Subjects = faker.options().option("English", "Physics", "Chemistry", "Computer Science",
                "Commerce", "Accounting", "Economics");
        String PictureLocation = "1.jpeg";
        String Address = faker.address().streetName();
        String State = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");




        registrationPage.openPage();
        registrationPage.removingTheBanner();
        registrationPage.firstName(Name);
        registrationPage.lastName(LastName);
        registrationPage.setEmail(Email);
        registrationPage.clickGender(Gender);
        registrationPage.setPhone(userNumber);
        registrationPage.setBirthDay(userBirthDay_day , userBirthDay_month, userBirthDay_year);
        registrationPage.setSubjects(Subjects);
        registrationPage.clickHobbies(Hobbies);
        registrationPage.setUpload(PictureLocation);
        registrationPage.setAddress(Address);
        registrationPage.setCity(State);
        registrationPage.setCity(userCity);

        registrationPage.clickSubmit();

        registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name",  Name + " " + LastName );
        registrationPage.verifyResult("Student Email", Email);
        registrationPage.verifyResult("Gender", Gender);
        registrationPage.verifyResult("Mobile", userNumber);
        registrationPage.verifyResult("Date of Birth", userBirthDay_day + " " + userBirthDay_month + " " + userBirthDay_year);
        registrationPage.verifyResult("Subjects", Subjects);
        registrationPage.verifyResult("Current Address", Address);
        registrationPage.verifyResult("Hobbies", Hobbies);
        registrationPage.verifyResult("State and City", State + " " + userCity );

        registrationPage.clickClose();


    }


}
