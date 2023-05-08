package exmaples.helpers;

import com.codeborne.selenide.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SelenideConfigLogger {

    Logger logger = LoggerFactory.getLogger(SelenideConfigLogger.class);

    public static SelenideConfigLogger getSelenideConfigLogger() {
        return new SelenideConfigLogger();
    }

    public static void logSelenideMainConfigValues() {
        getSelenideConfigLogger()
                .logBrowserName()
                .logBrowserSize()
                .logBrowserVersion()
                .logBrowserBaseUrl()
                .logBrowserRemote();
    }

    public SelenideConfigLogger logBrowserName() {
        logger.info("Selenide browser name: " + Configuration.browser);
        return this;
    }

    public SelenideConfigLogger logBrowserSize() {
        logger.info("Selenide browser size: " + Configuration.browserSize);
        return this;
    }

    public SelenideConfigLogger logBrowserVersion() {
        logger.info("Selenide browser version: " + Configuration.browserVersion);
        return this;
    }

    public SelenideConfigLogger logBrowserBaseUrl() {
        logger.info("Selenide base URL: " + Configuration.baseUrl);
        return this;
    }

    public SelenideConfigLogger logBrowserRemote() {
        logger.info("Selenide remote: " + Configuration.remote);
        return this;
    }

}

