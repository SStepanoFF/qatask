package steps;

import booking.pages.SearchResultsPage;

import static core.utils.WaitUtils.waitForJQueryLoad;

public class SearchResultSteps extends CommonSteps {

    private SearchResultsPage searchResultsPage = new SearchResultsPage(driver);

    public void clickNextButton() {
        searchResultsPage.getNextPageButton().click();
        waitForJQueryLoad();
    }
}