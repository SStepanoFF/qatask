package actions;

import steps.SearchMenuWidgetSteps;

import java.util.List;

public class SearchActions extends HeaderActions {

    private SearchMenuWidgetSteps searchMenuWidgetSteps = new SearchMenuWidgetSteps();

    public void selectDestination(String destination) {
        searchMenuWidgetSteps.inputDestination(destination);
    }

    public void selectCheckinDate(String date) {
        searchMenuWidgetSteps.clickChekinDateButton();
        searchMenuWidgetSteps.selectCheckinDate(date);
    }

    public void selectCheckoutDate(String date) {
        searchMenuWidgetSteps.clickChekoutDateButton();
        searchMenuWidgetSteps.selectCheckoutDate(date);
    }

    public void setChildNumberAndAge(String number, List<String> ages) {
        searchMenuWidgetSteps.clickGuestToggleIfPresent();
        searchMenuWidgetSteps.setChildrenNumber(number);
        searchMenuWidgetSteps.setChildrenAges(ages);
        searchMenuWidgetSteps.clickGuestToggleIfPresent();
    }

    public void setAdultNumber(String number) {
        searchMenuWidgetSteps.clickGuestToggleIfPresent();
        searchMenuWidgetSteps.setAdultNumber(number);
        searchMenuWidgetSteps.clickGuestToggleIfPresent();
    }

    public void setRoomsNumber(String number) {
        searchMenuWidgetSteps.clickGuestToggleIfPresent();
        searchMenuWidgetSteps.setRoomsNumber(number);
        searchMenuWidgetSteps.clickGuestToggleIfPresent();
    }

    public void clickSearchButton() {
        searchMenuWidgetSteps.clickSearchButton();
    }

    public void tickTravelPurposeCheckbox() {
        searchMenuWidgetSteps.selectTravelPurposeCheckbox();
    }
}
