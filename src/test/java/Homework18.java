import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {
    @Test
    public void playSong() throws InterruptedException {
        navigateToPage();
        provideEmail("manasa.mohan@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();
        clickPlayButton();
        Assert.assertTrue(songIsPlaying());
    }


    }

