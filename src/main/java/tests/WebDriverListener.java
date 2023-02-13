package tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

import java.time.Duration;

public class WebDriverListener implements IInvokedMethodListener {

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        if ((method.getTestMethod().isBeforeClassConfiguration())) {
            WebDriver driver = ChromeDriverFactory.createInstance();

            Duration timeOut = Duration.ofSeconds(10);

            WebDriverWait wait = ChromeDriverFactory.createWait(driver, timeOut);
            LocalDriverManager.setWebDriver(driver);
            LocalDriverManager.setWebDriverWait(wait);
        }
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
    }

}