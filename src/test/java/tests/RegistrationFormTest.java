package tests;
import com.codeborne.selenide.Selenide;
import lessonseven.RegistrationPage;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationFormTest extends Base {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    public void registrationFormTest1() {

        registrationPage.openPage();
        registrationPage.removingTheBanner();
        registrationPage.firstName("denis");
        registrationPage.firstName("Yalalov");
        registrationPage.setEmail("denis@mail.com");
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
        $("#currentAddress").setValue("ufa102");
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

    }



}
