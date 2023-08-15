import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.net.ssl.HttpsURLConnection;
import java.time.Duration;

public class Homework16 extends BaseTest{
    @Test
    public void RegistrationNavigation() throws InterruptedException {

        //      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://qa.koel.app/";
        driver.get(url);
        Thread.sleep(2000);
        WebElement registrationLink = driver.findElement(By.xpath("//a[@href='registration']"));
        registrationLink.click();

        String registrationURL = "https://qa.koel.app/registration";
        Assert.assertEquals(driver.getCurrentUrl(), registrationURL);
        driver.quit();


    }
}
