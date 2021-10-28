package involveMe.Form.pageObject;

import involveMe.Form.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage extends BasePage {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".bg-teal-500.hidden.md\\:block.px-3.py-2.rounded.text-white")
    protected WebElement createProjectButton;
    @FindBy(css = ".px-6.py-2.text-lg")
    protected WebElement startButton;
    @FindBy(css = ".leading-tight.text-lg.font-medium.truncate")
    protected List<WebElement> projectNameList;
    @FindBy(css = ".flex.justify-right.items-center>a")
    protected List<WebElement> editProjectIconList;
    @FindBy(css = ".flex.justify-right.items-center .dropdown>button")
    protected List<WebElement> dropdownProjectIconList;
    @FindBy(css = "#app > div.max-w-full.sm\\:px-12.md\\:px-0.md\\:max-w-3xl.lg\\:max-w-6xl.mx-auto.relative.pb-24 > div > div.mt-4.md\\:mt-0.w-full.max-w-4xl > div.md\\:ml-6.lg\\:ml-8.xl\\:ml-12.mt-8.grid.row-gap-4.md\\:row-gap-8.md\\:col-gap-8.md\\:grid-cols-2.lg\\:grid-cols-3 > div:nth-child(3) > div.absolute.right-0.left-0.mt-8.mx-3.z-100.flex-1 > div.flex.items-center.justify-between.mb-2 > div.flex.justify-right.items-center > div > ul > li")
    protected List<WebElement> dropdownList;




    @Step("Click On start button ")
    public void clickOnStartButton () {
        waitForTextToBeInElement(startButton,"Start");
        click(startButton);
    }


    @Step("Click On dropdown Project Button and choose from list")
    public void clickOnDropdownProjectButton (String projectName , String nameFromList) {
        waitForPageFinishLoading();
        for (int i = 0; i < projectNameList.size(); i++) {
            scrollToElement(projectNameList.get(i));
            if (getText(projectNameList.get(i)).equalsIgnoreCase(projectName)){
                scrollToElement(dropdownProjectIconList.get(i));
                click(dropdownProjectIconList.get(i));
                for (WebElement el:dropdownList) {
                    if (getText(el).equalsIgnoreCase(nameFromList)){
                        scrollToElement(el);
                        click(el);
                        break;
                    }
                }
            }
        }
    }


    @Step("Click On Edit Project Button")
    public void clickOnEditProjectButton (String projectName) {
     waitForPageFinishLoading();
        for (int i = 0; i < projectNameList.size(); i++) {
            scrollToElement(projectNameList.get(i));
            if (getText(projectNameList.get(i)).equalsIgnoreCase(projectName)){
                scrollToElement(editProjectIconList.get(i));
                click(editProjectIconList.get(i));
                break;
            }
        }
    }


    @Step("Check Project Name")
    public boolean checkProjectName(String projectName) {
        try {
            waitForPageFinishLoading();
            for (WebElement el : projectNameList) {
                scrollToElement(el);
                if (getText(el).equalsIgnoreCase(projectName)) {
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
        return false;
    }


    @Step("Click on Project Name")
    public void clickOnProjectName(String projectName) {
        waitForPageFinishLoading();
        for (WebElement el : projectNameList) {
            scrollToElement(el);
            if (getText(el).equalsIgnoreCase(projectName)) {
                waitForElementToBeClickable(el);
                click(el);
                break;
            }
        }
    }

    @Step("click Create Project Button")
    public void clickCreateProjectButton() {
        waitForPageFinishLoading();
        if (isDisplayed(createProjectButton)) {
            click(createProjectButton);
        } else{
            click(startButton);
        }
    }


}
