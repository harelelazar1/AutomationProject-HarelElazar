package involveMe.Form.tests;


import involveMe.Form.pageObject.LoginPage;
import involveMe.Form.pageObject.MainPage;
import involveMe.Form.pageObject.ProjectTypePage;
import involveMe.Form.pageObject.Templates;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FormTest extends BaseTest {

    LoginPage loginPage;
    MainPage mainPage;
    ProjectTypePage projectPage;
    Templates templates;

    @BeforeClass
    @Step("Edit role")
    public void definePermission() {
        driver.get("https://app.involve.me/login");
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
        projectPage = new ProjectTypePage(driver);
        templates = new Templates(driver);
        loginPage.login("Email","harelelazar@gmail.com");
        loginPage.login("Password","Q1w2e3r401!");
        loginPage.clickLoginButton();
    }

    @Test(description = "create new form")
     @Description("login and create new form")
    public void createForm01(){
        mainPage.clickCreateProjectButton();
        projectPage.chooseProjectName("Form");
        templates.clickOnButtonFromTemplate("COVID-19 Event Registration" , "Choose");

    }



}
