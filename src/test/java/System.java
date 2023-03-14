import org.junit.BeforeClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class System {
    private static WebDriver driver;
    private static WebDriverWait wait;
    private static JavascriptExecutor js;

    @BeforeClass
    public static void setup() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
        js = (JavascriptExecutor) driver;
    }
}