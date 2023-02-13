package tests.app;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tests.commons.PageCommons;

public class PopUp extends PageCommons {

    @FindBy(name="FirstName")
    WebElement firstName;

    @FindBy(name="LastName")
    WebElement lastName;

    @FindBy(name="UserName")
    WebElement userName;

    @FindBy(name="Password")
    WebElement password;

    @FindBy(name="RoleId")
    WebElement roleId;

    @FindBy(name="Email")
    WebElement email;

    @FindBy(name="Mobilephone")
    WebElement phone;

    @FindBy(xpath="//*[text()='Save']")
    WebElement success;

    @FindBy(xpath="/html/body/div[3]/div[2]/form/table/tbody/tr[5]/td[2]/label[1]/input")
    WebElement enterpriseAAA;

    public PopUp(){
        PageFactory.initElements(browser,this);
    }


}
