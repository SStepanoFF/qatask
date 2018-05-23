package booking.pages.widgets;

import org.openqa.selenium.WebElement;

public interface ISearchResultItemWidget extends ICommonWidget {

    WebElement getItemName();

    WebElement getReviewMarkIfPresent();

    WebElement getItemPriceIfPresent();

}
