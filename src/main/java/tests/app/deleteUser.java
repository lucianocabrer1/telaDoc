package tests.app;

import org.testng.annotations.Test;
import tests.TestBase;

import java.util.HashMap;

@Test(groups = {"prueba"})

public class deleteUser extends TestBase {
    public void LoginPractis() throws Exception {

        HomePage homePage = new HomePage();

        HashMap<String, String> data = new HashMap<String, String>();

        data.put("name", "Luciano");
        data.put("lastName", "Cabrera");
        data.put("userName", "LEC");
        data.put("password", "1234");
        data.put("roleId","Sales Team");
        data.put("email","asd@gmail.com");
        data.put("phone","1123344");

        homePage.deleteUser(data);
    }
}