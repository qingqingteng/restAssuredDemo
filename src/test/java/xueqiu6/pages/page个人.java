package xueqiu6.pages;

import org.openqa.selenium.By;
import xueqiu6.uitls.AppDriver;

public class page个人 {
    By login = By.id("tv_login");
    public page登录 entoLogin(){
        AppDriver.driver.findElement(login).click();
        return new page登录();
    }
}
