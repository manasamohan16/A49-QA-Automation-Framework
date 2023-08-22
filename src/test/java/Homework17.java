import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest {

    @Test
    public void addSongToPlaylist() throws InterruptedException {
        String newSongAddedNotificationText = "Added 1 song into \"ManasaTest.\"";
        navigateToPage();
        provideEmail("manasa.mohan@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();
        searchSong("ketsa");
        viewAllSongs();
        clickFirstSong();
        clickAddToButton();
        selectPlaylist();
        Assert.assertEquals(getNotificationMessage(), newSongAddedNotificationText);
    }

}

