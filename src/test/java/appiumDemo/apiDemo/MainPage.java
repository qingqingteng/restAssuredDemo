package appiumDemo.apiDemo;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class MainPage {
    @AndroidFindBy(accessibility = "Views")
//    @FindBy(id = "Views")
    WebElement views;
    WebElement text;

    public ViewsPage gotoViews(){
        views.click();
        ViewsPage viewsPage = new ViewsPage();
        return viewsPage;
    }
}
