package tests.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import tests.commons.PageCommons;

import java.util.HashMap;
import java.util.List;

public class HomePage extends PageCommons {

    @FindBy(xpath="/html/body/table/thead/tr[2]/td/button")
    WebElement addUsser;
    public HomePage(){
        PageFactory.initElements(browser,this);
    }

    public void addUssers(HashMap<String, String> data) throws InterruptedException {
        SoftAssert softAssertion= new SoftAssert();

        addUsser.click();

        Thread.sleep(2000);

        PopUp popUp = new PopUp();

        ExpectedConditions.visibilityOf(popUp.firstName);

        String name = data.get("name");

        popUp.firstName.sendKeys(name);
        popUp.lastName.sendKeys(data.get("lastName"));
        popUp.userName.sendKeys(data.get("userName"));
        popUp.password.sendKeys(data.get("password"));
        popUp.enterpriseAAA.click();

        Select role = new Select(popUp.roleId);
        role.selectByVisibleText(data.get("roleId"));

        popUp.email.sendKeys(data.get("email"));
        popUp.phone.sendKeys(data.get("phone"));

        ExpectedConditions.elementToBeClickable(popUp.success);
        popUp.success.click();

        Thread.sleep(2000);

        List<WebElement> table = browser.findElements(By.xpath("/html/body/table/tbody/tr"));

        Integer size = table.size();

        for(int i = 1; i <= size ; i++){
            String rw = "/html/body/table/tbody/tr[" + i + "]/td[1]";

            WebElement row = browser.findElement(By.xpath(rw));

            if(row.getText().equals(name)) {
                softAssertion.assertEquals(row.getText(), name);
                break;
            }
        }

    }

    public void deleteUser(HashMap<String, String> data) throws InterruptedException {
        addUssers(data);

        WebElement delete = browser.findElement(By.xpath("/html/body/table/tbody/tr[1]/td[11]/button"));

        delete.click();

        WebElement ok = browser.findElement(By.xpath("//*[text()='OK']"));

        ExpectedConditions.elementToBeClickable(ok);

        List<WebElement> table = browser.findElements(By.xpath("/html/body/table/tbody/tr"));

        Integer size = table.size();

        String name = data.get("name");
        for(int i = 1; i <= size ; i++){
            String rw = "/html/body/table/tbody/tr[" + i + "]/td[1]";

            WebElement row = browser.findElement(By.xpath(rw));

            if(row.getText().equals(name)) {
                Assert.assertEquals(row.getText(), name, "Dont delete row");
                break;
            }
            else if(i == size && !row.getText().equals(name)){
                Assert.assertNotEquals(row.getText(), name, "Delete row successfull");
            }

        }
    }
}
