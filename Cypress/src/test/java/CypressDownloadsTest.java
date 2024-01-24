import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.dj.elements.Elements;
public class CypressDownloadsTest {

    private WebDriver driver;
    private Elements elements;

    @Before
    public void setUp() {
        String basePath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", basePath + "/src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize(); // Maximizing the window to ensure visibility of the 'Install' button
        driver.get("https://www.cypress.io/");

        elements = new Elements();
        PageFactory.initElements(driver, elements);
    }

    @Test
    public void testWeeklyDownloadsCount() {

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elements.getOSSElement());

        // Assuming the 'Weekly Downloads' text is visible without scrolling
        String downloadsText = elements.getWeeklyDownloadsText().getText();
        assertEquals("Weekly downloads", downloadsText);

        String downloadsCount = elements.getDownloadsCount().getText();
        assertTrue("Downloads count should be displayed", downloadsCount != null && !downloadsCount.isEmpty());
        // Here you can add more specific assertions to validate the format of the downloads count

        System.out.println("Weekly Downloads Count: " + downloadsCount);
    }
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}