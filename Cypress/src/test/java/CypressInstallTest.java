import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.dj.elements.Elements;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;

public class CypressInstallTest {
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
    public void testNpmInstallCypress() {
        elements.getInstallButton().click(); // Click on the 'Install' button

        // Verify the 'NPM Install' text appears
        String npmInstallText = elements.getNpmInstallText().getText();
        assertEquals("NPM Install", npmInstallText);

        elements.getNpmInstallCypressButton().click(); // Click on 'npm install cypress'

        // Accessing the system clipboard to get the copied text
        String actualText = "";
        try {
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            actualText = (String) clipboard.getData(DataFlavor.stringFlavor);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Assert that the actual copied text matches the expected text
        String expectedText = "npm install cypress --save-dev";
        assertEquals(expectedText, actualText);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}