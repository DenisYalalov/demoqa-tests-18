package configs;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${env}.properties"
})

public interface WebDriverConfig extends Config {
    @Key("baseUrl")
    @DefaultValue("https://demoqa.com/")
    String getBaseUrl();
    @DefaultValue("CHROME")
    @Key("browser")
    String getBrowser();
    @Key("remoteUrl")
    String getRemoteUrl();
    @DefaultValue("1920x1080")
    @Key("browserSize")
    String getBrowserSize();
    @DefaultValue("100")
    @Key("browserVersion")
    String getBrowserVersion();




}
