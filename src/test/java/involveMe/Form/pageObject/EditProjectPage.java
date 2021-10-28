package involveMe.Form.pageObject;

import involveMe.Form.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class EditProjectPage extends BasePage {
    public EditProjectPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".form-group.outcome-selection-wrapper .row >:nth-child(1)")
    protected WebElement projectType;
    @FindBy(css = ".row>:nth-child(1) .modal-btn-start.swal-button")
    protected WebElement startEditingButton;
    @FindBy(css = ".form-group #project-name")
    protected WebElement projectNameField;



    @Step("Choose Project Type")
    public void chooseProjectType(){
        waitForPageFinishLoading();
        click(projectType);
        click(startEditingButton);
    }

    @Step("Enter project name")
    public void enterProjectName(String projectName){
        waitForPageFinishLoading();
        click(projectNameField);
        fillText(projectNameField,projectName);
    }





}








