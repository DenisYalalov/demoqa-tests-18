import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }


    @Test
     void fillFromTest() {
        open("/text-box");

         $("[id=userName]").setValue("denis");
         $("#userEmail").setValue("denis@mail.ru");
         $("#currentAddress").setValue("Some Address 1");
         $("#permanentAddress").setValue("Another Address 2");
         $("#submit").click();

         $("#output").shouldHave(text("denis"), text("denis@mail.ru"), text("Some Address 1"),
                text("Another Address 2"));
    }
}
