package involveMe.Form.pageObject;

import involveMe.Form.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Templates extends BasePage {

    public Templates(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".c-thumbnail.gallery-item h3[title]")
    protected List<WebElement> templateName;
    @FindBy(css = "tr:nth-of-type(3)  .c-thumbnail.gallery-item > .caption > .e-button-container > a > button[role='button']")
    protected List<WebElement> templateButtons;


    @Step("click On Button From Template")
    public void clickOnButtonFromTemplate(String template, String buttonName) {
        try {
            waitForPageFinishLoading();
            for (int i = 0; i < templateName.size(); i++) {
                scrollToElement(templateName.get(i));
                if (getText(templateName.get(i)).equalsIgnoreCase(template)) {
                    for (WebElement el : templateButtons) {
                        mouseHoverOnElement(el);
                        if (getText(el).equalsIgnoreCase(buttonName)) {
                            waitForElementToBeClickable(el);
                            click(el);
                            break;
                        }
                    }
                }
            }
        }catch(Exception e){
            System.out.println("The button not found");
        }
    }





}
