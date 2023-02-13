package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LocalDriverManager {
    public static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();
    public static ThreadLocal<WebDriverWait> wait = new ThreadLocal<>();

    public static WebDriver getDriver() {
        Assert.assertNotNull(webDriver.get());
        return webDriver.get();
    }

    public static WebDriverWait getWait() {
        Assert.assertNotNull(wait.get());
        return wait.get();
    }

    static void setWebDriver(WebDriver driver) {
        webDriver.set(driver);
    }

    static void setWebDriverWait(WebDriverWait webDriverWait) {
        wait.set(webDriverWait);
    }

}