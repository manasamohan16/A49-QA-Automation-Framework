package stepDefinition;

import Pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginStepDefinitions {
    WebDriver driver;
    WebDriverWait wait;
    @Before
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @After
    public void closeBrowser(){
        driver.quit();
    }
    @Given("I open Login page")
    public void openLoginPage() {
        driver.get("https://qa.koel.app/");
    }

    // Without PAGE OBJECTS

//    @When("I enter email {string}")
//    public void i_enter_email(String email) {
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='email']"))).sendKeys(email);
//    }
//    @And("I enter password {string}")
//    public void i_enter_password(String password) {
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='password']"))).sendKeys(password);
//    }
//    @And("I submit")
//    public void clickSubmit() {
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='submit']"))).click();
//    }
//    @Then("I am logged in")
//    public void userIsLoggedIn() {
//        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.avatar"))).isDisplayed());
//    }

    // Using PAGE OBJECTS

    @When("I enter email {string}")
    public void i_enter_email(String email) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.provideEmail(email);
    }
    @And("I enter password {string}")
    public void i_enter_password(String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.providePassword(password);
    }
    @And("I submit")
    public void clickSubmit() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickSubmit();
    }
    @Then("I am logged in")
    public void userIsLoggedIn() {
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isAvatarDisplayed());
    }

}