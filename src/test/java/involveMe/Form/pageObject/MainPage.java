package involveMe.Form.pageObject;

import involveMe.Form.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (css = "")
    protected WebElement createProjectButton ;




}
