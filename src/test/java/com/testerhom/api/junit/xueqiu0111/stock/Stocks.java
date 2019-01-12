package com.testerhom.api.junit.xueqiu0111.stock;


import io.restassured.response.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;

@RunWith(Parameterized.class)
public class Stocks extends Login {
    @Parameterized.Parameters(name = "category={4},size={2}")
    public static List<Object[]> data(){
        return Arrays.asList(new Object[][] {
                { 2, 4, 10000,"SZ","所有" },//all
                { 2, 5, 10000,"SZ","沪深" },//沪深
                { 2, 6, 10000,"NASDAQ","美股" },//美股
                { 2, 7, 10000,"HK","港股",},//港股
                { 2, 7, 0,"HK","港股"},//港股
                { 2, 7, 1,"HK","港股"},//港股
                { 2, 7, 5,"HK","港股"},//港股
        });
    }
    @Parameterized.Parameter
    public static Integer category;
    @Parameterized.Parameter(1)
    public static Integer type;
    @Parameterized.Parameter(2)
    public static Integer size;
    @Parameterized.Parameter(3)
    public static String exchange;
    @Parameterized.Parameter(4)
    public static String name;

    public static ArrayList stockTypeArr;//存放不同种类股票的id

    @Test
    public void getAllStockType() {
        Response response =
        given().log().all()
                .queryParam("_t","1GENYMOTION55e8412c2d7d8f06fe04b20f5cfcdb70.3023201624.1547260387303.1547260978267")
                .queryParam("_s","3c9b44")
                .queryParam("system","true")
                .queryParam("category","2")
                .cookie("xq_a_token",access_token)
                .cookie("u","3023201624")
                .when().get("https://api.xueqiu.com/v4/stock/portfolio/list.json")
                .then().log().all()
                .statusCode(200).extract().response();

        stockTypeArr = response.path("portfolios.portfolio.id");
        System.out.println("index 0====="+stockTypeArr.indexOf(0));

    }

    @Test
    public void getStock(){
        given().log().all()
                .spec(requestSpecification)
                .queryParam("type",type)
                .queryParam("category",category)
                .queryParam("size",size)
                .when().get("https://api.xueqiu.com/v4/stock/portfolio/stock_list.json")
                .then().log().all()
                .statusCode(200)
//                .body("stocks.exchange",hasItems(exchange))
                .body("stocks.code.size()",lessThanOrEqualTo(size));
    }
}



