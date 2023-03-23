package tests;

import lessonseven.RegistrationPage;
import org.junit.jupiter.api.Test;

public class RegistrationWithFakerTests extends UtilFaker {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    public void registrationFormTest1() {

        registrationPage.openPage();
        registrationPage.removingTheBanner();
        registrationPage.firstName(name);
        registrationPage.lastName(lastName);
        registrationPage.setEmail(email);
        registrationPage.clickGender(gender);
        registrationPage.setPhone(userNumber);
        registrationPage.setBirthDay(dayOfBirth, monthOfBirth, yearOfBirth);
        registrationPage.setSubjects(Subjects);
        registrationPage.clickHobbies(Hobbies);
        registrationPage.setUpload(pictureLocation);
        registrationPage.setAddress(userAddress);
        registrationPage.setState(userState);
        registrationPage.setCity(userCity);

        registrationPage.clickSubmit();

        registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name", name + " " + lastName);
        registrationPage.verifyResult("Student Email", email);
        registrationPage.verifyResult("Gender", gender);
        registrationPage.verifyResult("Mobile", userNumber);
        registrationPage.verifyResult("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth);
        registrationPage.verifyResult("Subjects", Subjects);
        registrationPage.verifyResult("Address", userAddress);
        registrationPage.verifyResult("Hobbies", Hobbies);
        registrationPage.verifyResult("State and City", userState + " " + userCity);

    }
    @Test
    public void Test1(){
        System.out.println(name);
        System.out.println(name);
    }

}
