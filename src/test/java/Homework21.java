import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest {
    String newPlaylistName = "Manasa Intellij";

    @Test
    public void renamePlaylist() {
        String updatedPlaylistMsg = "Updated playlist \"Manasa Intellij.\"";
        navigateToPage();
        provideEmail("manasa.mohan@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();
        doubleClickPlaylist();
        enterNewPlaylistName();
        Assert.assertEquals(getRenamePlaylistSuccessMsg(), updatedPlaylistMsg);


    }
}

