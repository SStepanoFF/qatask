package steps;

import booking.pages.common.CommonPage;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;

import static core.utils.WaitUtils.waitForJQueryLoad;

public class HeaderSteps extends CommonSteps {

    protected CommonPage commonPage = new CommonPage(driver);

    public void clickSelectCurrencyButton() {
        commonPage.getSelectCurrencyButton().click();
        waitForJQueryLoad();
    }

    public void clickOnCurrency(String currency) {
        getCurrencyByName(currency).click();
        waitForJQueryLoad();
    }

    private WebElement getCurrencyByName(String currency) {
        return commonPage.getCurrencyList().stream().filter(element -> element.getText().toLowerCase().contains(currency
                .toLowerCase())).findFirst().orElseThrow(() -> new NotFoundException("Incorrect currency"));
    }

    public void clickSelectLanguageButton() {
        commonPage.getSelectLanguageButton().click();
        waitForJQueryLoad();
    }

    public void clickOnLanguage(String language) {
        getLanguageByName(language).click();
        waitForJQueryLoad();
    }

    private WebElement getLanguageByName(String language) {
        return commonPage.getLanguagesList().stream().filter(element -> element.getText().toLowerCase().contains(language
                .toLowerCase())).findFirst().orElseThrow(() -> new NotFoundException("Incorrect language"));
    }
}
