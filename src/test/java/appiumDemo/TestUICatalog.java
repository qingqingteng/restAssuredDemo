package appiumDemo;

import io.appium.java_client.ios.IOSDriver;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestUICatalog {

    private static IOSDriver driver;

    @BeforeClass
    public static void beforeApi() throws MalformedURLException{

        DesiredCapabilities capabilityies = new DesiredCapabilities();
//        模拟器
        capabilityies.setCapability("platformName","iOS");
        capabilityies.setCapability("platformVersion","12.1");
        capabilityies.setCapability("deviceName","iPhone 7");
        capabilityies.setCapability("app","/Users/qingqing/Demo/ios-uicatalog/build/Release-iphonesimulator/UICatalog.app");
        capabilityies.setCapability("automationName","XCUITest");
        capabilityies.setCapability("startIWDP",true);
//        capabilityies.setCapability("usePrebuiltWDA",true);

//        真机
//        capabilityies.setCapability("platformName","iOS");
//        capabilityies.setCapability("platformVersion","11.3");
//        capabilityies.setCapability("deviceName","tqq");
//        capabilityies.setCapability("bundleId","com.examplexxx.apple-samplecodexx.UICatalog");
//        capabilityies.setCapability("udid","4aacea19a03098be588fdbdb074c7a1bafd73fc6");
//        capabilityies.setCapability("automationName","XCUITest");
//        capabilityies.setCapability("startIWDP",true);
//        capabilityies.setCapability("usePrebuiltWDA",true);


        driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilityies);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

    }

    @Test
    public void webViewTest() throws InterruptedException {
        driver.findElementByIosNsPredicate("label = 'Buttons'").click();
    }


}
