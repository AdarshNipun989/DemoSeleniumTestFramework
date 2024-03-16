package testcases;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginPageTest extends TestBase {
    LoginPage loginPage;
    @BeforeMethod
    public void setup(){
        initialization();
        loginPage=new LoginPage();
    }

    @Test
    public void verifyTitleOfPage(){
        loginPage.login("dmcks")
                .getPageTitle();
        String title=loginPage.getPageTitle();
        Assert.assertEquals(title,"abc");
    }

    @AfterMethod
    public void tearDown(){
        webDriver.quit();
    }
}
