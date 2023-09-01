import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework22 extends BaseTest {


    @Test
    public void renamePlaylist() {
        String newPlaylistName = "Manasa Intellij";
        String updatedPlaylistMsg = "Updated playlist \"Manasa Intellij.\"";
       LoginPage loginPage = new LoginPage(driver);
       HomePage homePage = new HomePage(driver);
       loginPage.login();
       homePage.doubleClickPlaylist();
       homePage.enterNewPlaylistName(newPlaylistName);
       Assert.assertEquals(homePage.getRenamePlaylistSuccessMsg(),updatedPlaylistMsg);
    }
}
