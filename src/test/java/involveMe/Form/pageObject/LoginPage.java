package involveMe.Form.pageObject;

import involveMe.Form.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(css = ".e-zoom-span")
    protected List<WebElement> titleList;
    @FindBy(css = ".form-control.e-zoom-input")
    protected List<WebElement> fieldsList;
    @FindBy(css = ".btn.btn-primary")
    protected WebElement loginButton;
    @FindBy(css = ".form-horizontal.form-login :nth-child(6)")
    protected WebElement forgotPassword;


    @Step("logim to involve me website")
    public void login(String titleName, String fieldData) {
        waitForPageFinishLoading();
        for (int i = 0; i < titleList.size(); i++) {
            scrollToElement(titleList.get(i));
            if (getText(titleList.get(i)).equalsIgnoreCase(titleName)) {
                fillText(fieldsList.get(i), fieldData);
                break;
            }
        }
    }

    @Step("click on login button")
    public void clickLoginButton() {
        waitForPageFinishLoading();
        scrollToElement(loginButton);
        click(loginButton);
    }


}
