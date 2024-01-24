import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.dj.elements.Elements;

public class CypressBonusSmartOrchestrationTest {
    private WebDriver driver;
    private Elements elements;

    @Before
    public void setUp(){
    String basePath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", basePath + "/src/main/resources/chromedriver.exe");

    driver = new ChromeDriver();
        driver.manage().window().maximize(); // Maximizing the window to ensure visibility of the 'Install' button
        driver.get("https://www.cypress.io/");

    elements = new Elements();
        PageFactory.initElements(driver, elements);
    }

    @Test
    public void testSmartOrchestrationToTestAnalytics() {
        Actions actions = new Actions(driver);
        actions.moveToElement(elements.getProductButton()).perform(); // Hover over 'Product'

        // Verify 'Smart Orchestration' is present
        assertTrue("Smart Orchestration option should be visible",
                elements.getSmartOrchestrationOption().isDisplayed());

        // Click on 'Smart Orchestration'
        elements.getSmartOrchestrationOption().click();

        // Scroll to 'Test Analytics'
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elements.getTestAnalyticsText());

        // Get the style attribute of the circle element
        String circleStyle = elements.getCircleAroundTestAnalytics().getAttribute("style");

        // Check if the style attribute contains the border property
        if (circleStyle.contains("border:")) {
            String[] styleParts = circleStyle.split("border:");
            if (styleParts.length > 1) {
                String borderStyle = styleParts[1].split(";")[0].trim();
                // Now extract the color part
                String[] borderStyleParts = borderStyle.split(" ");
                if (borderStyleParts.length > 2) {
                    String borderColor = borderStyleParts[2];

                    // Define the expected green color in RGB format
                    String expectedBorderColor = "rgb(0, 128, 0)"; // Replace with the actual expected color

                    // Assert that the extracted border color matches the expected color
                    assertEquals("The border color of the circle should be green", expectedBorderColor, borderColor);
                }
            }
        }
    }
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}