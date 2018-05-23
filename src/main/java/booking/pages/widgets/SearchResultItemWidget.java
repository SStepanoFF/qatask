package booking.pages.widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchResultItemWidget extends CommonWidget implements ISearchResultItemWidget {

    public SearchResultItemWidget(WebElement root) {
        super(root);
    }

    public WebElement getItemName() {
        return root.findElement(By.className("sr-hotel__name"));
    }

    public WebElement getReviewMarkIfPresent() {
        return getElementIfPresent(By.className("review-score-badge"));
    }

    public WebElement getItemPriceIfPresent() {
        return getElementIfPresent(By.className("totalPrice"));
    }

}
