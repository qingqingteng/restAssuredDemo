package appiumDemo.xueqiuDemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Page股票 {
    @FindBy(id = "action_bar_stock_name")
    WebElement name;
    @FindBy(id = "stock_current_price")
    WebElement price;

    public Double getPrice(){
        return Double.valueOf(price.getText());
    }

    public String getName(){
        return name.getText();
    }
}
