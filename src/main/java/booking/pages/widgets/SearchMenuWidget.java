package booking.pages.widgets;

import booking.pages.common.CommonPage;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

@Getter
public class SearchMenuWidget extends CommonPage {

    @FindBy(id = "ss")
    private WebElement destinationInputField;

    @FindBy(css = "*[data-component='search/destination/input'] li")
    private List<WebElement> destinationList;

    @FindBy(css = "*[data-mode='checkin']")
    private WebElement checkinPickerButton;

    @FindBy(css = "*[data-mode='checkout']")
    private WebElement checkoutPickerButton;

    @FindBy(css = ".c2-month-table")
    private List<WebElement> checkinoutPickersList;

    @FindBy(id = "xp__guests__toggle")
    private WebElement guestsToggle;

    @FindBy(css = "button[class*='sb-searchbox__button'")
    private WebElement searchButton;

    @FindBy(id = "no_rooms")
    private WebElement roomNumber;

    @FindBy(id = "group_adults")
    private WebElement groupAdultsField;

    @FindBy(id = "group_children")
    private WebElement groupChildrenField;

    @FindBy(css = "select[data-group-child-age]")
    private List<WebElement> childrenAgeFields;

    @FindBy(name = "sb_travel_purpose")
    private WebElement travelPurposeCheckBox;

    public SearchMenuWidget(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(this.driver, this);
    }

    public List<WebElement> getCheckinCalendarDates() {
        return getCheckinoutPickersList().get(0).findElements(By.cssSelector("td[class*=c2-day"));
    }

    public List<WebElement> getCheckoutCalendarDates() {
        return getCheckinoutPickersList().get(17).findElements(By.cssSelector("td[class*=c2-day"));
    }

}
