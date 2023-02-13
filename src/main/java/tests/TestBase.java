package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class TestBase implements IMethodTest{
    public WebDriver browser;
    public WebDriverWait wait;

    @BeforeClass(alwaysRun = true)
    public void beforeClass(ITestContext iTestContext) throws InterruptedException {
        browser = LocalDriverManager.getDriver();
        wait = LocalDriverManager.getWait();

        browser.get("https://www.way2automation.com/angularjs-protractor/webtables/");

    }

    @AfterClass(alwaysRun = true)
    public void afterTest(ITestContext iTestContext) {
        LocalDriverManager.getDriver().quit();
    }
}
