import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.time.Duration;

public class BaseTest {


    public static WebDriver driver = null;
    public static String url = "https://qa.koel.app/";

    @BeforeSuite
    public void setupSuit() throws MalformedURLException {
        String browser = System.getProperty("browser");
        driver = setupBrowser(browser);
    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }

    WebDriver setupBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        //To start the grid server run this command below in command line (go to download location first)
        //java -jar selenium-server-4.12.0.jar standalone --selenium-manager true
        String gridURL = "http://192.168.1.50:4444";
        switch (browser) {
            case "firefox":
                return setupFirefox();
            case "chrome":
                return setupChrome();
            case "safari":
                return setupSafari();
            case "grid-chrome":
                caps.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "grid-firefox":
                caps.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            default:
                return setupChrome();
        }
    }

    public WebDriver setupFirefox() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        return driver;
    }

    public WebDriver setupSafari() {
        WebDriverManager.safaridriver().setup();
        driver = new SafariDriver();
        return driver;
    }

    public WebDriver setupChrome() {
        WebDriverManager.chromedriver().setup();
        //Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        return driver;
    }


    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String BaseURL) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        url = BaseURL;
        navigateToPage();
    }


    public void navigateToPage() {
        driver.get(url);
    }

    public void provideEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void providePassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickSubmit() {
        WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        submit.click();
    }

    public void selectPlaylist() {
        WebElement playlistName = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
        playlistName.click();
    }

    public void clickDeletePlaylist() {
        WebElement deletePlaylist = driver.findElement(By.xpath("//button[@class='del btn-delete-playlist']"));
        deletePlaylist.click();
    }

    public String playlistDeletedNotification() {
        WebElement notificationMessage = driver.findElement(By.cssSelector("div.success.show"));
        return notificationMessage.getText();
    }

}

