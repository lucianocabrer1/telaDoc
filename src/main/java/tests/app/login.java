package tests.app;

import org.testng.annotations.Test;
import tests.TestBase;

@Test(groups = {"prueba"})
//@Parameters("browser")
public class login extends TestBase {
    public void LoginPractis() throws Exception {
        PopUp loginPage = new PopUp();

        //loginPage.login("admin", "admin");
    }
}