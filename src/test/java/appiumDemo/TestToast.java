package appiumDemo;

import org.junit.BeforeClass;
import org.junit.Test;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class TestToast {

    private static AndroidDriver<AndroidElement> driver;

    @BeforeClass
    public static void beforeApi() throws MalformedURLException{

        DesiredCapabilities capabilityies = new DesiredCapabilities();
        capabilityies.setCapability("platformName","Android");
        capabilityies.setCapability("deviceName","192.168.56.101:5555");
        capabilityies.setCapability("appPackage","io.appium.android.apis");
        capabilityies.setCapability("appActivity","io.appium.android.apis.ApiDemos");
        capabilityies.setCapability("noReset",true);
//        capabilityies.setCapability("showChromedriverLog",true);
        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilityies);

    }


    @Test
    public void pageSource() throws InterruptedException {
        driver.findElementByAccessibilityId("Views").click();
        driver.findElementByAndroidUIAutomator(
                "new UiScrollable(new UiSelector()).scrollIntoView("
                        + "new UiSelector().text(\"Popup Menu\"));").click();
        driver.findElementByAccessibilityId("Make a Popup!").click();
        driver.findElementByXPath("//android.widget.TextView[@text='Add']").click();
        for(int i=0;i<5;i++){
            System.out.println(driver.getPageSource());
            System.out.println("toast");
            System.out.println(driver.findElementByXPath("//*[@class='android.widget.Toast']").getText());
        }


    }


}
