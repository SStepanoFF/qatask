package booking.pages;

import booking.pages.common.CommonPage;
import booking.pages.widgets.ISearchResultItemWidget;
import booking.pages.widgets.SearchResultItemWidget;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class SearchResultsPage extends CommonPage {

    @FindBy(css = "#hotellist_inner div[class*='sr_item_default']")
    private List<WebElement> searchResultItemsList;

    @FindBy(className = "paging-next")
    private WebElement nextPageButton;

    public SearchResultsPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(this.driver, this);
    }

    public List<ISearchResultItemWidget> getSearchResultItems() {
        return getSearchResultItemsList().stream().map(SearchResultItemWidget::new).collect(Collectors.toList());
    }

}
