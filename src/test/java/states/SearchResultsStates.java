package states;

import booking.pages.MainBookingPage;
import booking.pages.widgets.SearchResultItemWidget;
import steps.HeaderSteps;

import java.util.Objects;

public class SearchResultsStates extends HeaderSteps {

    private MainBookingPage mainBookingPage = new MainBookingPage(driver);

    public SearchResultItemWidget getFirstSearchResultItemsByParameters(double reviewMark, double price) {
        return mainBookingPage.getSearchResultItems().stream().filter(item -> Objects.nonNull(item.getReviewMarkIfPresent()) &&
                Double.parseDouble(item.getReviewMarkIfPresent().getText()) >= reviewMark && Objects.nonNull(item.getItemPriceIfPresent()) &&
                getItemPrice(item.getItemPriceIfPresent().getText()) <= price).findFirst().orElse(null);
    }

    private double getItemPrice(String textPrice) {
        String price = textPrice.substring(textPrice.length() - 5).replaceAll("\\D", "").trim();
        return Double.parseDouble(price);
    }

    public boolean isPageNextButtonActive() {
        return mainBookingPage.getNextPageButton().isEnabled();
    }
}
