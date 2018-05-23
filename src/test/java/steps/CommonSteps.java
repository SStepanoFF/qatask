package steps;

import core.properties.PropertiesNames;
import org.openqa.selenium.WebDriver;

import static core.properties.PropertiesController.getProperty;
import static core.utils.WebDriverUtil.getDriver;

// will contain any common steps such as alert/popup closing... etc
public class CommonSteps {

    protected WebDriver driver;

    public CommonSteps() {
        this.driver = getDriver();
    }

    public void openMainPage() {
        driver.get(getProperty(PropertiesNames.ENV_URL));
    }

}
