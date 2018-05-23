package booking.pages.widgets;

import org.openqa.selenium.WebElement;

import java.util.List;

public interface ISearchMenuWidget extends ICommonWidget {

    WebElement getDestinationInputField();

    List<WebElement> getDestinationList();

    WebElement getCheckinPickerButton();

    WebElement getCheckoutPickerButton();

    List<WebElement> getCheckinoutPickersList();

    WebElement getGuestsToggle();

    WebElement getSearchButton();

    WebElement getRoomNumber();

    WebElement getGroupAdultsField();

    WebElement getGroupChildrenField();

    List<WebElement> getChildrenAgeFields();

    WebElement getTravelPurposeCheckBox();

    List<WebElement> getCheckinCalendarDates();

    List<WebElement> getCheckoutCalendarDates();
}
