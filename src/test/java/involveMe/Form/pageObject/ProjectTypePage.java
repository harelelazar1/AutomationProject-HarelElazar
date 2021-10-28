package involveMe.Form.pageObject;

import involveMe.Form.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProjectTypePage extends BasePage {
    public ProjectTypePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".col-md-12.content-chooser .title")
    protected List<WebElement> projectName;


    @Step("choose Project Name")
    public void chooseProjectName(String project) {
        waitForPageFinishLoading();
        for (WebElement el : projectName) {
            scrollToElement(el);
            if (getText(el).equalsIgnoreCase(project)) {
                waitForElementToBeClickable(el);
                click(el);
                break;
            }
        }
    }


}
