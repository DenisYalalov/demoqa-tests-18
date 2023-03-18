package tests;

import lessonseven.RegistrationPage;
import org.junit.jupiter.api.Test;

import static tests.UtilFaker.*;

public class RegistrationWithFakerTests extends Base {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    public void registrationFormTest1() {

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
