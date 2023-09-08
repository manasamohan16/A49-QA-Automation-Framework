import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
public class Homework25 extends BaseTest {
    @Test
    public void renamePlaylist() {
        String newPlaylistName = "Manasa Intellij";
        String updatedPlaylistMsg = "Updated playlist \"Manasa Intellij.\"";
        LoginPage loginPage = new LoginPage(getThreadDriver());
        getThreadDriver().get(url);
        HomePage homePage = new HomePage(getThreadDriver());
        getThreadDriver().get(url);
        loginPage.login();
        homePage.doubleClickPlaylist();
        homePage.enterNewPlaylistName(newPlaylistName);
        Assert.assertEquals(homePage.getRenamePlaylistSuccessMsg(),updatedPlaylistMsg);
    }
}