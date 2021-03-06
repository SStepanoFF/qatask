package booking.pages.common;

import booking.pages.widgets.ISearchMenuWidget;
import booking.pages.widgets.SearchMenuWidget;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

@Getter
public class CommonPage {

    protected WebDriver driver;

    @FindBy(css = "*[data-id='currency_selector']")
    private WebElement selectCurrencyButton;

    @FindBy(css = "#current_currency_foldout li")
    private List<WebElement> currencyList;

    @FindBy(css = "*[data-id='language_selector']")
    private WebElement selectLanguageButton;

    @FindBy(css = "#current_language_foldout li")
    private List<WebElement> languagesList;

    @FindBy(id = "frm")
    private WebElement searchForm;

    public CommonPage(WebDriver webDriver) {
        this.driver = webDriver;
        PageFactory.initElements(this.driver, this);
    }

    public ISearchMenuWidget getSearchMenuWidget() {
        return new SearchMenuWidget(getSearchForm());
    }

}
