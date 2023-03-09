package pages;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsModal;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();
    private final SelenideElement userState = $("#state");
    private final SelenideElement userCity = $("#city");
    private final SelenideElement stateCityWrapper = $("#stateCity-wrapper");
    private final SelenideElement submitButton =  $("#submit");

    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName");
    private String city;


    public void openPage() {
        open("https://demoqa.com/automation-practice-form");
        Selenide.executeJavaScript("$('#fixedban').remove()");
        Selenide.executeJavaScript("$('footer').remove()");

    }

    public void FirstName(String value) {
        firstNameInput.setValue("denis");

    }

    public void lastName(String value) {
        lastNameInput.setValue("Yalalov");

    }

    public void clearlastName() {
        lastNameInput.clear();

    }

    public void setEmail(String value) {
        $("#userEmail").setValue(value);
    }

    public void setGender(String value) {
        $("#genterWrapper").$(byText(value)).click();
    }

    public void setPhone(String value) {
        $("#userNumber").setValue(value);

    }

    public RegistrationPage setBirthDay(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage verifyResultsModalAppears() {
        registrationResultsModal.verifyModalAppears();


        return this;
    }

    public RegistrationPage verifyResult(String key, String value) {
        registrationResultsModal.verifyResult(key, value);


        return this;

    }

    public void setSubjects(String value) {
        $("#subjectsInput").setValue(value).pressEnter();
        ;


    }

    public void setHobbies(String value) {
        $("#hobbies-checkbox-3").parent().$(byText(value)).click();

    }

    public void setUpload(String value) {
        $("#uploadPicture").uploadFromClasspath(value);

    }

    public void setAddress(String value) {
        $("#currentAddress").setValue(value);

    }

    public RegistrationPage setUserStateAndCity(String value) {
        userState.click();
        stateCityWrapper.$(byText(value)).click();
        userCity.click();
        stateCityWrapper.$(byText("Karnal")).click();

        return this;
    }

    public void submitForm() {
        submitButton.click();
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void clickSubmit() {
        $("#submit").click();
    }

    public void clickClose() {
    }
}