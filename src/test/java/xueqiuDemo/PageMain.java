package xueqiuDemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import xueqiuDemo.Page自选;

public class PageMain {
    @FindBy(xpath = "//*[@text='自选']")
    WebElement 自选;
    @FindBy(xpath = "//*[@text='行情']")
    WebElement 行情;

    public xueqiuDemo.Page自选 goto自选(){
        自选.click();
        return new Page自选();
    }


}
