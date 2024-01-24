import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;
import org.dj.elements.Elements;

public class CypressProductTest {
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
    public void testProductToVisualReviews() {
        Actions actions = new Actions(driver);
        actions.moveToElement(elements.getProductButton()).perform(); // Hover over 'Product'
        elements.getVisualReviewsButton().click(); // Click on 'Visual Reviews'

        // Verify the title of the 'Visual Reviews' section
        String expectedTitle = "Review and debug failures visually";
        String actualTitle = elements.getVisualReviewsTitle().getText();
        assertEquals(expectedTitle, actualTitle);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}