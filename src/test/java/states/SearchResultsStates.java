package states;

import booking.pages.SearchResultsPage;
import booking.pages.widgets.ISearchResultItemWidget;
import steps.HeaderSteps;

import java.util.Objects;

public class SearchResultsStates extends HeaderSteps {

    private SearchResultsPage searchResultsPage = new SearchResultsPage(driver);

    public ISearchResultItemWidget getFirstSearchResultItemsByParameters(double reviewMark, double price) {
        return searchResultsPage.getSearchResultItems().stream().filter(item -> Objects.nonNull(item.getReviewMarkIfPresent()) &&
                Double.parseDouble(item.getReviewMarkIfPresent().getText()) >= reviewMark &&
                Objects.nonNull(item.getItemPriceIfPresent()) &&
                getItemPrice(item.getItemPriceIfPresent().getText()) <= price).findFirst().orElse(null);
    }

    private double getItemPrice(String textPrice) {
        String price = textPrice.substring(textPrice.length() - 5).replaceAll("\\D", "").trim();
        return Double.parseDouble(price);
    }

    public boolean isPageNextButtonActive() {
        return searchResultsPage.getNextPageButton().isEnabled();
    }
}
