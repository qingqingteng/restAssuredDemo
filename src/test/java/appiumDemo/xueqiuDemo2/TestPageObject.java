package appiumDemo.xueqiuDemo2;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.number.OrderingComparison.greaterThan;
import static org.hamcrest.number.OrderingComparison.lessThan;
import static org.junit.Assert.assertThat;

public class TestPageObject {
    private static AndroidDriver<AndroidElement> driver;

    @BeforeClass
    public static void beforeApi() throws MalformedURLException {

        DesiredCapabilities capabilityies = new DesiredCapabilities();
        capabilityies.setCapability("plactformName", "Android");
        capabilityies.setCapability("deviceName", "192.168.56.101:5555");
        capabilityies.setCapability("appPackage", "com.xueqiu.android");
        capabilityies.setCapability("appActivity", ".view.WelcomeActivityAlias");
        capabilityies.setCapability("noReset", true);
//        capabilityies.setCapability("showChromedriverLog",true);
        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilityies);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void  getPageObject() throws InterruptedException {
        appiumDemo.xueqiuDemo2.PageMain mainPage = new appiumDemo.xueqiuDemo2.PageMain(driver);
        mainPage.goto自选().get沪深股票();//进入沪深
        Page股票 page股票 = mainPage.goto自选().selectStock("长安汽车");//在沪深中选择股票
        assertThat(page股票.getName(),equalTo("长安汽车"));
        assertThat(page股票.getPrice(),lessThan(16.36));

    }


    @AfterClass
    public static void tearDonw(){
        driver.quit();
    }

}
