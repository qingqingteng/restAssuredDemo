package xueqiuDemo2;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Page自选 {
    RemoteWebDriver driver;
    By 股票 = By.xpath("//*[@text='股票']");
    By 沪深 = By.xpath("//*[@text='沪深']");
    By stocks = By.id("stockName");


    public Page自选(RemoteWebDriver driver){
        this.driver = driver;
    }

    public void get沪深股票(){
        driver.findElement(股票).click();
        driver.findElement(沪深).click();
        driver.findElements(stocks).forEach(e->System.out.println(e.getText()));
    }


    public xueqiuDemo2.Page股票 selectStock(String name) {
        for (WebElement element: driver.findElements(stocks))
        {
            if (element.getText().equals(name)) {
                element.click();
                break;
            }
        }

        return new xueqiuDemo2.Page股票(driver);

    }

}
