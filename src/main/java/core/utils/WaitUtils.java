package core.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static core.properties.PropertiesController.getProperty;
import static core.properties.PropertiesNames.PAGE_LOAD_TIMEOUT;
import static core.utils.WebDriverUtil.getDriver;

public final class WaitUtils {

    private WaitUtils() {
    }

    public static void waitForJQueryLoad() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Long.parseLong(getProperty(PAGE_LOAD_TIMEOUT)));
        ExpectedCondition<Boolean> jQueryLoad = driver -> ((Long) ((JavascriptExecutor) getDriver())
                .executeScript("return jQuery.active") == 0);
        wait.until(jQueryLoad);
    }
}
