import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;


public class DemoQAPracticeFormTest {
    private WebDriver driver;
    private JavascriptExecutor js;
    private String firstName;
    private String lastName;
    private  String userEmail;
    private String GenderName;
    private String userNumber;
    private String date;
    private String  subjects;
    private String HobbyName;
    private String Address;
    private String state;
    private String city;

    System.setup();


    @Test
    public void testPracticeForm() throws InterruptedException {
        firstName = "Jon";
        lastName = "Doe";
        userEmail = "johndoe@test.com";
        GenderName = "Female";
        userNumber = "1234567890";
        date = "14 Mar 1995";
        subjects = "Soccer";
        HobbyName = "Sports";
        Address = "123 Main St, Anytown USA";
        state = "NCR";
        city = "Delhi";

//        removeFixedBannerInFooter();
        fillName();
        fillEmail();
        fillGender();
        fillMobile();
        fillDateofbirth();
        fillSubject();
        fillHobbies();
        //fillPicture();
        fillAddress();
        fillState();
        fillCity();
//        removeFooter();
        clickSubmit();
        arrangeSubmittingForm();
    }
    private void removeFixedBannerInFooter(){
        WebElement fixedBanner = driver.findElement(By.id("fixedban"));
        js.executeScript("arguments[0].parentNode.removeChild(arguments[0]);", fixedBanner);
    }
    private void removeFooter(){
        WebElement footer = driver.findElement(By.tagName("footer"));
        js.executeScript("arguments[0].parentNode.removeChild(arguments[0]);", footer);
    }
    private void fillName(){
        driver.findElement(By.id("firstName")).sendKeys(firstName);
        driver.findElement(By.id("lastName")).sendKeys(lastName);
    }
    private void fillEmail(){
        driver.findElement(By.id("userEmail")).sendKeys(userEmail);
    }
    private void fillGender(){
        WebElement genderWrapperElement = driver.findElement(By.id("genterWrapper"));
        var genderRadio = genderWrapperElement.findElement(By.xpath("//label[text()='" + GenderName + "']"));

        js.executeScript("arguments[0].click();", genderRadio);
    }
    private void fillMobile(){
        driver.findElement(By.id("userNumber")).sendKeys(userNumber);
    }
    private void fillDateofbirth(){
        WebElement dateOfBirthInput = driver.findElement(By.id("dateOfBirthInput"));
        js.executeScript("arguments[0].value='"+date +"';", dateOfBirthInput);
    }
    private void fillSubject(){
        driver.findElement(By.id("subjectsInput")).sendKeys(subjects);
    }
    private void fillHobbies(){
        WebElement genderWrapperElement = driver.findElement(By.id("hobbiesWrapper"));
        var genderRadio = genderWrapperElement.findElement(By.xpath("//label[text()='" + HobbyName + "']"));

        js.executeScript("arguments[0].click();", genderRadio);
    }
    private void fillPicture(){
        driver.findElement(By.id("uploadPicture")).sendKeys("C:\\Users\\qwert\\Downloads");
    }
    private void fillAddress(){
        driver.findElement(By.id("currentAddress")).sendKeys(Address);
    }
    private void fillState(){
        WebElement stateElement = driver.findElement(By.id("state"));
        js.executeScript("arguments[0].scrollIntoView(true);", stateElement);
        stateElement.click();
        WebElement stateOptionElement = driver.findElement(By.xpath("//div[text()='" + state + "']"));
        stateOptionElement.click();
    }

    private void fillCity(){
        WebElement cityElement = driver.findElement(By.id("city"));
        js.executeScript("arguments[0].scrollIntoView(true);", cityElement);
        cityElement.click();
        WebElement cityOptionElement = driver.findElement(By.xpath("//div[text()='" + city + "']"));

        cityOptionElement.click();
    }
    private void clickSubmit(){
        WebElement submitElement = driver.findElement(By.id("submit"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].scrollIntoView(true);", submitElement);
        submitElement.click();
    }
    private void arrangeSubmittingForm() {
        String actualMessage = driver.findElement(By.cssSelector(".modal-body")).getText();

        String expectedMessage = "Label Values\n" +
                "Student Name " + firstName + " " + lastName + "\n" +
                "Student Email "+ userEmail  +"\n" +
                "Gender "+ GenderName + "\n" +
                "Mobile " + userNumber + "\n" +
                "Date of Birth 13 March,2023\n" +
                "Subjects\n" +
                "Hobbies " + HobbyName +"\n" +
                "Picture\n" +
                "Address " + Address + "\n" +
                "State and City "+ state + " " + city;

        assertEquals(expectedMessage, actualMessage);
    }

    @After
    public void tearDown() {
        driver.quit();
    }



}