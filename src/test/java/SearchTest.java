import actions.HeaderActions;
import actions.SearchActions;
import asserts.SearchResultsAsserts;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.Collections;

public class SearchTest extends BaseTest {

    private HeaderActions headerActions = new HeaderActions();
    private SearchActions searchActions = new SearchActions();
    private SearchResultsAsserts searchResultsAsserts = new SearchResultsAsserts();

    @Test
    public void test() {
        headerActions.selectCurrency("euro");
        headerActions.selectLanguage("us");
        searchActions.selectDestination("Málaga, Andalucía, Spain");

        LocalDate initial = LocalDate.now();
        searchActions.selectCheckinDate(String.valueOf(initial.withDayOfMonth(initial.lengthOfMonth()).getDayOfMonth()));
        searchActions.selectCheckoutDate("1");

        searchActions.setChildNumberAndAge("1", Collections.singletonList("5"));
        searchActions.setAdultNumber("1");

        searchActions.clickSearchButton();

        searchActions.setRoomsNumber("2");
        searchActions.tickTravelPurposeCheckbox();
        searchActions.clickSearchButton();

        searchResultsAsserts.checkResultContainsItemsWithReviewMarkAndPrice(8.0, 200);
    }
}
