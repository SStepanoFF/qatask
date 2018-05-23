package booking.pages.widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface ICommonWidget {

    WebElement getElementIfPresent(By by);
}
