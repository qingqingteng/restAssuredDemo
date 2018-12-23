package apiDemo;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;
import java.net.URL;

public class TestPageObject {

    private static AndroidDriver<AndroidElement> driver;

    @BeforeClass
    public static void beforeApi() throws MalformedURLException {

        DesiredCapabilities capabilityies = new DesiredCapabilities();
        capabilityies.setCapability("plactformName", "Android");
        capabilityies.setCapability("deviceName", "192.168.56.101:5555");
        capabilityies.setCapability("appPackage", "io.appium.android.apis");
        capabilityies.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
        capabilityies.setCapability("noReset", true);
//        capabilityies.setCapability("showChromedriverLog",true);
        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilityies);
    }

    @Test
    public void  getPageObject(){
        MainPage mainPage = new MainPage();
//      使用PageFactory初始化pageobject对象
        PageFactory.initElements(new AppiumFieldDecorator(driver),mainPage);
        ViewsPage viewsPage = mainPage.gotoViews();
        PageFactory.initElements(new AppiumFieldDecorator(driver),viewsPage);
        PopPage popPage = viewsPage.gotoPopupView();
        PageFactory.initElements(new AppiumFieldDecorator(driver),popPage);
        popPage.makePopAdd();
//        System.out.println(popPage.getPopText());
    }


    @AfterClass
    public static void tearDonw(){
        driver.quit();
    }


}
