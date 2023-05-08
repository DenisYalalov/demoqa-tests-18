package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import configs.OwnerWebConfigRunner;
import exmaples.helpers.Attach;
import exmaples.helpers.SelenideConfigLogger;
import io.qameta.allure.selenide.AllureSelenide;
import lessonseven.RegistrationPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {
    RegistrationPage registrationPage;
    @BeforeAll
    static void beforeAll() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        new OwnerWebConfigRunner().runWebConfig();
        SelenideConfigLogger.logSelenideMainConfigValues();

    }
    @BeforeEach
    void setUp() {
        registrationPage = new RegistrationPage();
    }
    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();

    }

}
