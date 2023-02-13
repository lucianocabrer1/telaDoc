package tests.commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.LocalDriverManager;

public class PageCommons {

    public WebDriver browser = LocalDriverManager.getDriver();

    public WebDriverWait wait = LocalDriverManager.getWait();

}
