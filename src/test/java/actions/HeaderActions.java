package actions;

import steps.HeaderSteps;

public class HeaderActions {

    private HeaderSteps headerSteps = new HeaderSteps();

    public void selectCurrency(String currency) {
        headerSteps.clickSelectCurrencyButton();
        headerSteps.clickOnCurrency(currency);
    }

    public void selectLanguage(String language) {
        headerSteps.clickSelectLanguageButton();
        headerSteps.clickOnLanguage(language);
    }
}
