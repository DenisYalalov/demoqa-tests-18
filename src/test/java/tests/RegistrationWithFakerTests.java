package tests;

import lessonseven.RegistrationPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RegistrationWithFakerTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    @BeforeEach
    void setUp() {
        registrationPage = new RegistrationPage();
    }

    @Test
    public void registrationFormTest1() {
        UtilFaker myData = new UtilFaker();

        registrationPage.openPage();
        registrationPage.removingTheBanner();
        registrationPage.firstName(myData.name);
        registrationPage.lastName(myData.lastName);
        registrationPage.setEmail(myData.email);
        registrationPage.clickGender(myData.gender);
        registrationPage.setPhone(myData.userNumber);
        registrationPage.setBirthDay(myData.day, myData.month, myData.year);
        registrationPage.setSubjects(myData.subjects);
        registrationPage.clickHobbies(myData.hobbies);
        registrationPage.setUpload(myData.pictureLocation);
        registrationPage.setAddress(myData.userAddress);
        registrationPage.setState(myData.userState);
        registrationPage.setCity(myData.userCity);

        registrationPage.clickSubmit();

        registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name", myData.name + " " + myData.lastName);
        registrationPage.verifyResult("Student Email", myData.email);
        registrationPage.verifyResult("Gender", myData.gender);
        registrationPage.verifyResult("Mobile", myData.userNumber);
        registrationPage.verifyResult("Date of Birth", myData.day + " " + myData.month + "," + myData.year);
        registrationPage.verifyResult("Subjects", myData.subjects);
        registrationPage.verifyResult("Address", myData.userAddress);
        registrationPage.verifyResult("Hobbies", myData.hobbies);
        registrationPage.verifyResult("State and City", myData.userState + " " + myData.userCity);

    }


}
