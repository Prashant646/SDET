package ui;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.prashant.UI.WebDriverFactory;
import org.testng.annotations.AfterTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class SeleniumTrickyTests {

    WebDriver driver;

    public void testShadowElements() {
        driver = WebDriverFactory.getInstance().getDriver("Chrome");
        driver.get("http://watir.com/examples/shadow_dom.html");
        WebElement shadowDiv = driver.findElement(By.xpath("//div[@id='shadow_host']"));
        SearchContext searchContext = shadowDiv.getShadowRoot();
        WebElement element = searchContext.findElement(By.cssSelector("#shadow_content>span"));
        System.out.println(element.getText());
    }

    public void ExploreNewCode() {

     /*   driver.findElement(By.xpath("")).sendKeys(Keys.chord(Keys.CONTROL, "t"));
        driver.findElement(By.xpath("")).sendKeys(Keys.chord(Keys.CONTROL, "t"));

        Set<String> windows = driver.getWindowHandles();
        for (String window : windows) {
            if (window.startsWith("")) driver.switchTo().window(window);
        }
        driver.switchTo().window("");*/

        driver = WebDriverFactory.getInstance().getDriver("Chrome");
        driver.get("https://www.google.com");
        driver.findElement(By.xpath("//textarea[@name='q']")).sendKeys("helloo");
        driver.findElement(By.xpath("//textarea[@name='q']")).sendKeys(Keys.ENTER);
        //driver.findElement(By.xpath("(//input[@value='Google Search'])[2]")).click();
        String parentWindow = driver.getWindowHandle();

        WebElement element = driver.findElement(By.xpath("(//a[@jsname='UWckNb'])[1]"));
        String url = element.getAttribute("href");

        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).click(element).keyUp(Keys.CONTROL).build().perform();
    }

    public void practiceFrames() {

        driver = WebDriverFactory.getInstance().getDriver("Chrome");
        driver.get("https://www.tutorialspoint.com/selenium/practice/frames.php");

        WebElement frameElement = driver.findElement(By.xpath("//iframe[@src='new-tab-sample.php'][1]"));
        driver.switchTo().frame(frameElement);
        driver.findElement(By.xpath("//header[@class='header selenium bg-white p-3 ']//a[@href='https://www.tutorialspoint.com']")).click();
        driver.switchTo().defaultContent();

        String text = driver.findElement(By.xpath("//h1[@class='mb-3 fw-normal border-bottom text-left pb-2 mb-4']")).getText();
        System.out.println(text);
        driver.switchTo().newWindow(WindowType.TAB);

        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.pollingEvery(Duration.ofSeconds(20)).ignoring(NullPointerException.class).pollingEvery(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        Actions actions = new Actions(driver);
    }

    public void testJava8() {

        driver = WebDriverFactory.getInstance().getDriver("Chrome");
        List<WebElement> allPhones = driver.findElements(By.xpath("//div[@class='shelf-item']//div[@class='val']"));
        allPhones.stream().filter(phoneEle -> Integer.parseInt(phoneEle.getText()) > 999).collect(Collectors.toList());

        try {
            Connection connection = DriverManager.getConnection("url", "username", "password");

            PreparedStatement statement = connection.prepareStatement("query");
            statement.setString(1, "username");
            ResultSet set = statement.executeQuery();


        } catch (Exception e) {

        }


    }


    @AfterTest
    public void tearDown() {
        // WebDriverFactory.getInstance().quitDriver();
    }
}
