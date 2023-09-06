package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {


    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    @FindBy(css = ".playlist:nth-child(3)")
    private WebElement firstPlaylist;
    @FindBy(css = "[name='name']")
    private WebElement playlistNameField;
    @FindBy(css = "div.success.show")
    private WebElement renamePlaylistSuccessMsg;


    public void doubleClickPlaylist() {
        doubleClick(firstPlaylist);
    }

    public void enterNewPlaylistName(String playlistName) {
        findElement(playlistNameField).sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.BACK_SPACE));
        findElement(playlistNameField).sendKeys(playlistName);
        findElement(playlistNameField).sendKeys(Keys.ENTER);
    }

    public String getRenamePlaylistSuccessMsg() {
        return findElement(renamePlaylistSuccessMsg).getText();
    }
}