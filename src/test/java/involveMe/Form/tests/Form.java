package involveMe.Form.tests;


import involveMe.Form.pageObject.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Form extends BaseTest {

    LoginPage loginPage;

    @BeforeClass
    @Step("Edit role")
    public void definePermission() {
        driver.get("https://app.involve.me/login");
        loginPage = new LoginPage(driver);
        loginPage.login("Email","https://app.involve.me/login");
        loginPage.login("Password","Q1w2e3r401!");
        loginPage.clickLoginButton();
    }

    @Test(description = "create new form")
     @Description("login and create new form")
    public void createForm01(){


    }

}
