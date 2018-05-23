package asserts;

import booking.pages.widgets.SearchResultItemWidget;
import org.testng.Assert;
import states.SearchResultsStates;
import steps.SearchResultSteps;

import java.util.Objects;
import java.util.Optional;

public class SearchResultsAsserts {

    private SearchResultsStates searchResultsStates = new SearchResultsStates();
    private SearchResultSteps searchResultSteps = new SearchResultSteps();

    public void checkResultContainsItemsWithReviewMarkAndPrice(double reviewMark, double price) {
        SearchResultItemWidget resultItemWidget = null;
        while (searchResultsStates.isPageNextButtonActive() && Objects.isNull(resultItemWidget)) {
            resultItemWidget = searchResultsStates.getFirstSearchResultItemsByParameters(reviewMark, price);
            if (Objects.isNull(resultItemWidget)) {
                searchResultSteps.clickNextButton();
            }
        }
        Optional.ofNullable(resultItemWidget).ifPresent(item ->
                System.out.println("Searched item name is:" + item.getItemName().getText() +
                        "\nReview Mark: " + item.getReviewMarkIfPresent().getText() + "\nPrice:" + item.getItemPriceIfPresent().getText()));
        Assert.assertTrue(Objects.nonNull(resultItemWidget), "Searched item not found");
    }
}
