package xueqiu6.pages;

import org.openqa.selenium.By;
import xueqiu6.uitls.AppDriver;

public class page雪球 {
//    AppiumDriver driver;
    private By cancel = By.id("image_cancel");
    private By search = By.id("home_search");
    private By profile = By.id("user_profile_icon");

    public String string;

//重写初始化方法
    public page雪球(){
        //判断该按钮是否存在
        if (AppDriver.driver.findElements(cancel).size() > 0){
            AppDriver.driver.findElement(cancel).click();
        }
    }

    public page搜索 enterSearch(){
        AppDriver.driver.findElement(search).click();
        return new page搜索();

    }

    public page个人 enterProfile(){
        AppDriver.driver.findElement(profile).click();
        return new page个人();

    }

}
