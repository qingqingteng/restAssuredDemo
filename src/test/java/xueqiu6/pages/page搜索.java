package xueqiu6.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import xueqiu6.uitls.AppDriver;

import java.util.*;
import java.util.stream.Collectors;

public class page搜索 {
//    AppiumDriver<WebElement> driver;
    private By search = By.id("search_input_text");
    private By stockName = By.id("stockName");
    private By cancel = By.id("action_close");
    private By userName = By.id("user_name");


    public page搜索 search(String keyword){

        AppDriver.driver.findElement(search).sendKeys(keyword);
        return this;
    }

    public List<String> getStockNames(){
        return  AppDriver.driver.findElements(stockName).stream().map(a->a.getText()).collect(Collectors.toList());

    }
    public List<String> getUserNames(){
        return  AppDriver.driver.findElements(userName).stream().map(a->a.getText()).collect(Collectors.toList());

    }
    //返回雪球首页
    public page雪球 gobackXueqiu(){
        AppDriver.driver.findElement(cancel).click();
        return new page雪球();
    }
}
