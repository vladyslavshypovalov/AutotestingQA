import com.sun.source.doctree.SystemPropertyTree;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTest {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrom.driver","C:\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/");

         String getURL = "https://demoqa.com/";



    }






}
