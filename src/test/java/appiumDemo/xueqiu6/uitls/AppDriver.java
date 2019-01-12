package xueqiu6.uitls;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppDriver {
    public static AppiumDriver<WebElement> driver;
    public static void launchApp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName","android");
        capabilities.setCapability("deviceName","demo");
        capabilities.setCapability("appPackage","com.xueqiu.android");
        capabilities.setCapability("appActivity",".view.WelcomeActivityAlias");

        driver = new AppiumDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(6,TimeUnit.SECONDS);
    }
    public static void quit(){
        driver.quit();
    }
    public static void installApp(){
        //install app
    }
}
