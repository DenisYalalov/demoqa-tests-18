package configs;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static exmaples.helpers.LoggerHelper.logAndPassMyParameter;

public class OldConfigRunner2 {
    public void runWebConfig() {


        Configuration.browserSize = logAndPassMyParameter("browser_size", "1920х1080");
        Configuration.baseUrl = logAndPassMyParameter("baseurl", "https://demoqa.com");
        Configuration.browser = logAndPassMyParameter("browser", "chrome");
        Configuration.browserVersion = logAndPassMyParameter("browser_version", "100.0");
        Configuration.pageLoadStrategy = "eager";
        Configuration.pollingInterval = 500;
        Configuration.remote = logAndPassMyParameter("selenoid_url", "https://user1:1234@selenoid.autotests.cloud/wd/hub");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
    }
}
