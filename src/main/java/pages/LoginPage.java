package pages;

import base.TestBase;
import constants.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtil;

public class LoginPage extends TestBase {
    String username="";
    public LoginPage(){}


    public LoginPage login(String username){
       BrowserUtil.sendText(FindBy.XPATH,"","hi");
       return new LoginPage();
    }

    public String getPageTitle() {
        return webDriver.getTitle();
    }
}
