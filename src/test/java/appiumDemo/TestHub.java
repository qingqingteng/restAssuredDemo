package appiumDemo;

import io.appium.java_client.android.AndroidDriver;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestHub {
    AndroidDriver driver;

    @Test
    public void testRemoteHub() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformVersion","6.0");
        desiredCapabilities.setCapability("deviceName","demo");
        desiredCapabilities.setCapability("appPackage","com.xueqiu.android");
        desiredCapabilities.setCapability("appActivity",".view.WelcomeActivityAlias");
        desiredCapabilities.setCapability("platformName","android");

        driver = new AndroidDriver(new URL("http://192.168.56.1:4444/wd/hub"),desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.findElementById("cancel").click();
        driver.findElementByXPath("//*[@text='交易']").click();

        driver.quit();

    }
}
