package appiumDemo.xueqiuDemo2;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

public class PageMain {
    RemoteWebDriver driver;
    By 自选 = By.xpath("//*[@text='自选']");
    By 行情 = By.xpath("//*[@text='行情']");

    //构造函数
    public PageMain(RemoteWebDriver driver){
        this.driver = driver;
    }


//    非静态方法，只能使用类的实例去调用该方法

    public appiumDemo.xueqiuDemo2.Page自选 goto自选(){
        driver.findElement(自选).click();
        return new appiumDemo.xueqiuDemo2.Page自选(driver);
    }

//    static静态方法，可以使用类名直接调用该方法
    public static String getStr(){
        return "hello";
    }


}
