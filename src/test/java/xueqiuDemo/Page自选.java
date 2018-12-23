package xueqiuDemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import xueqiuDemo.Page股票;

import java.util.List;

public class Page自选 {
    @FindBy(xpath = "//*[@text='股票']")
    WebElement 股票;
    @FindBy(xpath = "//*[@text='沪深']")
    WebElement 沪深;
    @FindBy(id = "stockName")
    List<WebElement> stocks;

    public void get沪深股票(){
        股票.click();
        沪深.click();
        stocks.forEach(e->System.out.println(e.getText()));

    }


    public xueqiuDemo.Page股票 selectStock(String name) {
        for (WebElement element: stocks)
        {
            if (element.getText().equals(name)) {
                element.click();
                break;
            }
        }

        return new Page股票();

    }

}
