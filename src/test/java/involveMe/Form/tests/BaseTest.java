package involveMe.Form.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;

public class BaseTest {
    //protected WebDriver driver;
    public RemoteWebDriver driver;
    String BrowserVersion;
    String BrowserName;

    @BeforeClass
    @Step("Setting and open the driver")
    public void setup(ITestContext testContext) throws MalformedURLException {
        System.out.println("====================\n" + "Start class: " + getClass().getName());
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        // options.addArguments("--headless");
        driver = new ChromeDriver(options);
        testContext.setAttribute("WebDriver", this.driver);
        driver.manage().window().maximize();
    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
