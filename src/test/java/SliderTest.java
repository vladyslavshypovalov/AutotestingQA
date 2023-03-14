import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SliderTest {

    private static WebDriver driver;
    private static WebDriverWait wait;

    private static JavascriptExecutor js;

    System.setup();

    @Test
    public void testSlider() {

        driver.get("https://demoqa.com/Widgets");
//        driver.get("https://demoqa.com/slider");
        WebElement fixedBanner = driver.findElement(By.id("fixedban"));
        js.executeScript("arguments[0].parentNode.removeChild(arguments[0]);", fixedBanner);

        WebElement sliderLink = driver.findElement(By.xpath("//div[@id='content']/div[2]/div/div[1]/div[4]/div"));
        sliderLink.click();

        WebElement slider = driver.findElement(By.xpath("//div[@id='sliderContainer']/div/span/input"));
        WebElement sliderValue = driver.findElement(By.xpath("//div[@id='sliderContainer']/span"));

        Actions builder = new Actions(driver);


        int startX = slider.getLocation().getX();
        int endX = slider.getSize().getWidth();
        builder.moveToElement(slider).click().dragAndDropBy(slider, endX, 0).perform();
        wait.until(ExpectedConditions.textToBePresentInElement(sliderValue, "100"));
        Assert.assertEquals(slider.getAttribute("value"), "100");
    }

    @AfterClass
    public static void teardown() {
        driver.quit();
    }
}
