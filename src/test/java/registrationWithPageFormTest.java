import org.junit.jupiter.api.Test;

public class registrationWithPageFormTest extends Base {

    @Test
    void registrationFormTest() {
        String UserState = "Haryana";
        String UserCity = "Karnal";
        registrationPage.openPage();
        registrationPage.removingTheBanner();
        registrationPage.firstName("denis");
        registrationPage.lastName("Yalalov");
        registrationPage.setEmail("denis@mail.com");
        registrationPage.setGender("Male");
        registrationPage.setPhone("9199199999");
        registrationPage.setBirthDay("21", "March", "2023");
        registrationPage.setSubjects("English");
        registrationPage.setHobbies("Music");
        registrationPage.setUpload("1.jpeg");
        registrationPage.setAddress("ufa102");
        registrationPage.setUserStateAndCity("Haryana");
        registrationPage.setCity("Karnal");
        registrationPage.clickSubmit();
        registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name", "Yalalov");
        registrationPage.verifyResult("Student Email", "denis@mail.com");
        registrationPage.verifyResult("Gender", "Male");
        registrationPage.verifyResult("Mobile", "9199199999");
        registrationPage.verifyResult("Date of Birth", "21 March,2023");
        registrationPage.verifyResult("Subjects", "English");
        registrationPage.verifyResult("Hobbies", "Music");
        registrationPage.verifyResult("State and City", UserState + " " + UserCity);

    }


}