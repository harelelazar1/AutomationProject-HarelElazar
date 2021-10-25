package involveMe.Form.pageObject;

import involveMe.Form.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (css = ".bg-teal-500.hidden.md\\:block.px-3.py-2.rounded.text-white")
    protected WebElement createProjectButton ;




    @Step("click Create Project Button")
    public void clickCreateProjectButton (){
        waitForPageFinishLoading();
        waitForElementToBeClickable(createProjectButton);
        click(createProjectButton);
    }















}
