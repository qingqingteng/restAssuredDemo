package appiumDemo.apiDemo;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PopPage {
    @AndroidFindBy(accessibility = "Make a Popup!")
    WebElement makePop;
    @FindBy(xpath = "//android.widget.TextView[@text='Add']")
    WebElement add;

    public void makePopAdd(){
        makePop.click();
        add.click();

    }
    public String getPopText(){
        return makePop.getText();
    }
}
