package appiumDemo.xueqiu6.pages;

import org.openqa.selenium.By;
import xueqiu6.uitls.AppDriver;

public class page登录 {
    By tv_login_by_phone_or_others = By.id("tv_login_by_phone_or_others");
    By tv_login_with_account = By.id("tv_login_with_account");
    By login_account = By.id("login_account");
    By login_password = By.id("login_password");
    By login_button = By.id("button_next");

    public page雪球 login(String phone, String password){
        AppDriver.driver.findElement(tv_login_by_phone_or_others).click();
        AppDriver.driver.findElement(tv_login_with_account).click();
        AppDriver.driver.findElement(login_account).sendKeys(phone);
        AppDriver.driver.findElement(login_password).sendKeys(password);
        AppDriver.driver.findElement(login_button).click();
        return new page雪球();
    }
}
