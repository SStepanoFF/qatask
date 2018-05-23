package steps;

import booking.pages.common.CommonPage;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static core.utils.ElementsUtil.isElementPresent;
import static core.utils.WaitUtils.waitForJQueryLoad;

public class SearchMenuWidgetSteps extends CommonSteps {

    //    private SearchMenuWidget searchMenuWidget = new SearchMenuWidget(driver);
    private CommonPage commonPage = new CommonPage(driver);

    public void setChildrenNumber(String number) {
        new Select(commonPage.getSearchMenuWidget().getGroupChildrenField()).selectByValue(number);
    }

    public void setChildrenAges(List<String> ages) {
        for (int i = 0; i < ages.size(); i++) {
            new Select(commonPage.getSearchMenuWidget().getChildrenAgeFields().get(i)).selectByValue(ages.get(i));
        }
    }

    public void setAdultNumber(String number) {
        new Select(commonPage.getSearchMenuWidget().getGroupAdultsField()).selectByValue(number);
    }

    public void setRoomsNumber(String number) {
        new Select(commonPage.getSearchMenuWidget().getRoomNumber()).selectByValue(number);
    }

    public void inputDestination(String destination) {
        commonPage.getSearchMenuWidget().getDestinationInputField().sendKeys(destination);
    }

    public void clickCheckinDateButton() {
        commonPage.getSearchMenuWidget().getCheckinPickerButton().click();
    }

    public void selectCheckinDate(String date) {
        selectDayFromPicker(date, commonPage.getSearchMenuWidget().getCheckinCalendarDates());
    }

    public void clickChekoutDateButton() {
        commonPage.getSearchMenuWidget().getCheckoutPickerButton().click();
    }

    public void selectCheckoutDate(String date) {
        selectDayFromPicker(date, commonPage.getSearchMenuWidget().getCheckoutCalendarDates());
    }

    private void selectDayFromPicker(String date, List<WebElement> pickerDates) {
        WebElement element = pickerDates.stream().filter(day -> day.getText().trim().equals(date)).findFirst()
                .orElseThrow(() -> new NotFoundException("Incorrect Day number: " + date));
        element.click();
    }

    public void clickSearchButton() {
        commonPage.getSearchMenuWidget().getSearchButton().click();
        waitForJQueryLoad();
    }

    public void selectTravelPurposeCheckbox() {
        if (!commonPage.getSearchMenuWidget().getTravelPurposeCheckBox().isSelected()) {
            commonPage.getSearchMenuWidget().getTravelPurposeCheckBox().click();
        }
    }

    public void clickGuestToggleIfPresent() {
        if (isElementPresent(commonPage.getSearchMenuWidget().getGuestsToggle())) {
            commonPage.getSearchMenuWidget().getGuestsToggle().click();
        }
    }

}
