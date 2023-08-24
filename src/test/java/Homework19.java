import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest {
    @Test
    public void deletePlaylist() {
        String expectedMessage = "Deleted playlist \"Intellij.\"";
        navigateToPage();
        provideEmail("manasa.mohan@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();
        selectPlaylist();
        clickDeletePlaylist();
        Assert.assertEquals(playlistDeletedNotification(),expectedMessage);
    }
}
