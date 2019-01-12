package appiumDemo.xueqiuDemo;

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
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;
import static org.hamcrest.number.OrderingComparison.greaterThan;
import static org.hamcrest.number.OrderingComparison.lessThan;
import static org.hamcrest.CoreMatchers.*;

import appiumDemo.xueqiuDemo.PageMain;

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
        appiumDemo.xueqiuDemo.PageMain mainPage = new PageMain();
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)),mainPage);
        Page自选 自选page = mainPage.goto自选();//定义类的实例，使用实例调用非静态方法
//        System.out.println(appiumDemo.apiDemo.xueqiuDemo.MainPage.getStr());//直接使用类名调用静态方法
        PageFactory.initElements(new AppiumFieldDecorator(driver,Duration.ofSeconds(10)),自选page);
        自选page.get沪深股票();
        Page股票 page股票 = 自选page.selectStock("长安汽车");
        PageFactory.initElements(new AppiumFieldDecorator(driver,Duration.ofSeconds(10)),page股票);
//        assertEquals(page股票.getName(),"长安汽车");//junit中的断言
//        assertTrue(page股票.getPrice() > 16.36);//junit中的断言
        assertThat(page股票.getName(),equalTo("长安汽车"));
        assertThat(page股票.getPrice(),lessThan(16.36));

    }


    @AfterClass
    public static void tearDonw(){
        driver.quit();
    }

}
