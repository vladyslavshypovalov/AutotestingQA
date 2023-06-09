import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class BrowserWindowsTest {

    static WebDriver driver;

    System.setup();

    @Test
    public void testNewTab() {

        String mainWindow = driver.getWindowHandle();


        WebElement newTabButton = driver.findElement(By.id("tabButton"));
        newTabButton.click();


        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle : windowHandles) {
            if (!handle.equals(mainWindow)) {
                driver.switchTo().window(handle);
                break;
            }
        }


        WebElement newTabText = driver.findElement(By.id("sampleHeading"));
        String actualText = newTabText.getText();
        String expectedText = "This is a sample page";
        Assert.assertEquals(actualText, expectedText);


        driver.close();
        driver.switchTo().window(mainWindow);
        Assert.assertEquals(mainWindow, driver.getWindowHandle());
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}