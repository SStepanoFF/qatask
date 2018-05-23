package core.utils;

import core.properties.PropertiesNames;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static core.properties.PropertiesController.getProperty;

public final class WebDriverUtil {

    private static WebDriver driver;

    private WebDriverUtil() {
    }

    public static WebDriver getDriver() {
        if (Objects.isNull(driver)) {
            setDriver(BrowserType.getDriverType(getProperty(PropertiesNames.DEFAULT_BROWSER)));
        }
        return driver;
    }

    public static void setDriver(BrowserType driverType) {
        switch (driverType) {
            case CHROME:
                System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--lang=en-GB");
                driver = new ChromeDriver(options);
                break;
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
        }
    }

    public static void maximizeWindow() {
        getDriver().manage().window().maximize();
    }

    public static void setImplicitlyTimeout(long timeout) {
        getDriver().manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
    }

    public static void setDefaultImplicitlyTimeout() {
        setImplicitlyTimeout(Long.parseLong(getProperty(PropertiesNames.IMPLICITLY_WAIT)));
    }

    public enum BrowserType {
        CHROME("chrome"),
        FIREFOX("firefox");

        private String browserTypeValue;

        BrowserType(String browserType) {
            this.browserTypeValue = browserType;
        }

        public static BrowserType getDriverType(String browserType) {
            return Stream.of(BrowserType.values()).filter((type) -> browserType.equalsIgnoreCase(type.browserTypeValue)).
                    findFirst().orElseThrow(() -> new NotFoundException("Incorrect browser type"));
        }
    }
}
