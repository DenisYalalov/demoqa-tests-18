package configs;

import com.codeborne.selenide.Configuration;

public class OldConfigRunner {

    public void runWebConfig () {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.pollingInterval = 500;





    }

}

