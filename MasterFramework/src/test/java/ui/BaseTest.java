package ui;

import org.openqa.selenium.WebDriver;
import org.prashant.UI.WebDriverFactory;
import org.prashant.UI.pages.BasePage;
import org.prashant.UI.pages.LoginPage;
import org.prashant.UI.pages.Page;

public class BaseTest {

    Page page;
    WebDriver driver;

    //@BeforeMethod
    public void setup(){
        driver = WebDriverFactory.getInstance().getDriver("Chrome");
        driver.get("https://www.amazon.in/");
        page = new BasePage(driver);
        LoginPage loginPage = page.getInstance(LoginPage.class);
    }
}
