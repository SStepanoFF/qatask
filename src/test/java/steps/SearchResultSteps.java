package steps;

import booking.pages.MainBookingPage;

import static core.utils.WaitUtils.waitForJQueryLoad;

public class SearchResultSteps extends CommonSteps {

    private MainBookingPage mainBookingPage = new MainBookingPage(driver);

    public void clickNextButton() {
        mainBookingPage.getNextPageButton().click();
        waitForJQueryLoad();
    }
}