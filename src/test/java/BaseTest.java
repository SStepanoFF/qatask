import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import steps.CommonSteps;

import static core.utils.WebDriverUtil.getDriver;
import static core.utils.WebDriverUtil.maximizeWindow;
import static core.utils.WebDriverUtil.setDefaultImplicitlyTimeout;

public class BaseTest {

    protected WebDriver driver;
    protected CommonSteps commonSteps = new CommonSteps();

    @BeforeSuite
    public void setup() {
        driver = getDriver();
        maximizeWindow();
        setDefaultImplicitlyTimeout();
        commonSteps.openMainPage();
    }

    @AfterSuite
    public void tearDown() {
        this.driver.close();
    }
}
