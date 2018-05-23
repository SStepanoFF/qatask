package steps;

import booking.pages.widgets.SearchMenuWidget;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static core.utils.ElementsUtil.isElementPresent;
import static core.utils.WaitUtils.waitForJQueryLoad;

public class SearchMenuWidgetSteps extends CommonSteps {

    private SearchMenuWidget searchMenuWidget = new SearchMenuWidget(driver);

    public void setChildrenNumber(String number) {
        new Select(searchMenuWidget.getGroupChildrenField()).selectByValue(number);
    }

    public void setChildrenAges(List<String> ages) {
        for (int i = 0; i < ages.size(); i++) {
            new Select(searchMenuWidget.getChildrenAgeFields().get(i)).selectByValue(ages.get(i));
        }
    }

    public void setAdultNumber(String number) {
        new Select(searchMenuWidget.getGroupAdultsField()).selectByValue(number);
    }

    public void setRoomsNumber(String number) {
        new Select(searchMenuWidget.getRoomNumber()).selectByValue(number);
    }

    public void inputDestination(String destination) {
        searchMenuWidget.getDestinationInputField().sendKeys(destination);
    }

    public void clickChekinDateButton() {
        searchMenuWidget.getCheckinPickerButton().click();
    }

    public void selectCheckinDate(String date) {
        selectDayFromPicker(date, searchMenuWidget.getCheckinCalendarDates());
    }

    public void clickChekoutDateButton() {
        searchMenuWidget.getCheckoutPickerButton().click();
    }

    public void selectCheckoutDate(String date) {
        selectDayFromPicker(date, searchMenuWidget.getCheckoutCalendarDates());
    }

    private void selectDayFromPicker(String date, List<WebElement> pickerDates) {
        WebElement element = pickerDates.stream().filter(day -> day.getText().trim().equals(date)).findFirst()
                .orElseThrow(() -> new NotFoundException("Incorrect Day number: " + date));
        element.click();
    }

    public void clickSearchButton() {
        searchMenuWidget.getSearchButton().click();
        waitForJQueryLoad();
    }

    public void selectTravelPurposeCheckbox() {
        if (!searchMenuWidget.getTravelPurposeCheckBox().isSelected()) {
            searchMenuWidget.getTravelPurposeCheckBox().click();
        }
    }

    public void clickGuestToggleIfPresent() {
        if (isElementPresent(searchMenuWidget.getGuestsToggle())) {
            searchMenuWidget.getGuestsToggle().click();
        }
    }

}
