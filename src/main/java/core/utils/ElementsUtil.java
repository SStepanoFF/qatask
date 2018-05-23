package core.utils;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;

import static core.utils.WebDriverUtil.setDefaultImplicitlyTimeout;
import static core.utils.WebDriverUtil.setImplicitlyTimeout;

public final class ElementsUtil {

    public static final int TIMEOUT = 1;

    private ElementsUtil() {
    }

    public static boolean isElementPresent(WebElement element) {
        try {
            setImplicitlyTimeout(TIMEOUT);
            if (element == null) {
                return false;
            }
            element.isDisplayed();
            return true;
        } catch (ElementNotVisibleException e) {
            return true;
        } catch (NotFoundException e) {
            return false;
        } finally {
            setDefaultImplicitlyTimeout();
        }
    }

}
