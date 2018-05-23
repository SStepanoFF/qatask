package booking.pages.widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import static core.utils.WebDriverUtil.setDefaultImplicitlyTimeout;
import static core.utils.WebDriverUtil.setImplicitlyTimeout;

public abstract class CommonWidget {

    protected WebElement root;

    public CommonWidget(WebElement root) {
        this.root = root;
    }

    public WebElement getElementIfPresent(By by) {
        try {
            setImplicitlyTimeout(1);
            return root.findElement(by);
        } catch (NoSuchElementException e) {
            return null;
        } finally {
            setDefaultImplicitlyTimeout();
        }
    }
}
