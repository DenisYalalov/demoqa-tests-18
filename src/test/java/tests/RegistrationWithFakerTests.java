package tests;

import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;
import lessonseven.registrationPage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationWithFakerTests extends Base {
    registrationPage registrationPage = new registrationPage();

    @Test
    public void registrationFormTest1() {
        Faker faker = new Faker();

        String value = faker. name().firstName(),
                lastName = faker. name().lastName(),
                email = faker.internet().emailAddress(),
                currentAddress = faker.address().fullAddress();

        registrationPage.openPage();
        registrationPage.removingTheBanner();
        registrationPage.firstName(value);
        registrationPage.lastName(lastName);
        registrationPage.setEmail(email);
        registrationPage.setGender("Male");
        registrationPage.setPhone("9199199999");
        registrationPage.setBirthDay("21", "March", "2023");

        open("https://demoqa.com/automation-practice-form");
        Selenide.executeJavaScript("$('#fixedban').remove()");
        Selenide.executeJavaScript("$('footer').remove()");

        $("#firstName").setValue("denis");
        $("#lastName").setValue("Yalalov");
        $("#userEmail").setValue("denis@mail.com");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("9199199999");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-dropdown-container").$(byText("March")).click();
        $(".react-datepicker__year-dropdown-container").$(byText("2000")).click();
        $(".react-datepicker__month-container").$(byText("20")).click();
        $("#subjectsInput").setValue("English").pressEnter();
        $("#hobbies-checkbox-3").parent().$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("1.jpeg");
        $("#currentAddress").setValue(currentAddress);
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Uttar Pradesh")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Agra")).click();
        $("#submit").click();
        $(".modal-open").shouldHave(text("Thanks for submitting the form"));
        $(".modal-body").shouldHave(text("denis"));
        $(".modal-body").shouldHave(text("denis@mail.com"));
        $(".modal-body").shouldHave(text("Male"));
        $(".modal-body").shouldHave(text("9199199999"));
        $(".modal-body").shouldHave(text("20 March,2000"));
        $(".modal-body").shouldHave(text("English"));
        $(".modal-body").shouldHave(text("Music"));
        $(".modal-body").shouldHave(text("Ufa102"));
        $(".modal-body").shouldHave(text("Uttar Pradesh Agra"));
        $("#closeLargeModal").click();
        registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name", value + " " + lastName);
        registrationPage.verifyResult("Student Email", email);
        registrationPage.verifyResult("Gender", "Male");
        registrationPage.verifyResult("Mobile", "9199199999");
        registrationPage.verifyResult("Date of Birth", "21 March,2023");
        registrationPage.verifyResult("Current Address", currentAddress);
        registrationPage.verifyResult("Subjects", "English");
        registrationPage.verifyResult("Hobbies", "Music");
        String UserState = new String();
        String UserCity = new String();
        registrationPage.verifyResult("State and City", UserState + " " + UserCity);

    }


}
