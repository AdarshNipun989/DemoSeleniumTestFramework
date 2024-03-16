package base;

import org.openqa.selenium.WebDriver;
import com.jayway.jsonpath.JsonPath;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.JsonToStringUtil;

import java.io.*;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver webDriver;
    static String configFile= JsonToStringUtil.readFileAsString("src/main/java/configs/config.json");

    public TestBase(){

    }

    public static void initialization(){
        String broswer=JsonPath.read(configFile,"$.browser");
        String url=JsonPath.read(configFile,"$.url");
        if(broswer.equals("chrome")){
            webDriver= new ChromeDriver();
        }
        if(broswer.equals("firefox")){
            webDriver= new FirefoxDriver();
        }
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webDriver.navigate().to(url);
    }



}
