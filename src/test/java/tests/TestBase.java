package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import lessonseven.RegistrationPage;

public class TestBase {
    RegistrationPage registrationPage;
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.pollingInterval = 500;


    }
    @BeforeEach
    void setUp() {
        registrationPage = new RegistrationPage();
    }

}
