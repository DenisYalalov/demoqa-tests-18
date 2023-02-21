package pages;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsModal;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class registrationPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();
    private final SelenideElement userState = $("#state");
    private final SelenideElement userCity = $("#city");
    private final SelenideElement stateCityWrapper = $("#stateCity-wrapper");

    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName");
    private String city;

    public void openPage() {
        open("/automation-practice-form");

    }
    public registrationPage removingTheBanner() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public void firstName(String value) {
        firstNameInput.setValue(value);
    }

    public void lastName(String value) {
        lastNameInput.setValue(value);
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

    public registrationPage setBirthDay(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public registrationPage verifyResultsModalAppears() {
        registrationResultsModal.verifyModalAppears();
        return this;
    }

    public registrationPage verifyResult(String key, String value) {
        registrationResultsModal.verifyResult(key, value);
        return this;
    }

    public void setSubjects(String value) {
        $("#subjectsInput").setValue(value).pressEnter();
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

    public registrationPage setUserStateAndCity(String value) {
        userState.click();
        stateCityWrapper.$(byText(value)).click();
        userCity.click();
        stateCityWrapper.$(byText("Karnal")).click();
        return this;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void clickSubmit() {
        $("#submit").click();
    }
}