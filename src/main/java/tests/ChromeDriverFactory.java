package tests;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

class ChromeDriverFactory {

    static WebDriver createInstance() {
        ChromeDriverManager.chromedriver().setup(); // chromedriver.exe
        System.setProperty("webdriver.chrome.logfile", System.getProperty("user.dir") + "/logChromeDriver.txt");
        System.setProperty("webdriver.chrome.verboseLogging", "true");
        ChromeOptions options = new ChromeOptions();
       // options.addArguments("--headless");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-web-security");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--start-maximized");
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
        //clearoptions.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
        options.setCapability(ChromeOptions.CAPABILITY, logPrefs);

        WebDriver browser = new ChromeDriver(options);
        return browser;
    }

    static WebDriverWait createWait(WebDriver browser, Duration timeOut) {
        return new WebDriverWait(browser, timeOut);
    }
}