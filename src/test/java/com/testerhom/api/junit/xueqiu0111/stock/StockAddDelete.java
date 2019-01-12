package com.testerhom.api.junit.xueqiu0111.stock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@RunWith(Parameterized.class)
public class StockAddDelete extends Login {
    @Parameterized.Parameters(name = "股票名字={0}")
    public static List<Object[]> data(){
        return Arrays.asList(new Object[][]{
                {"PDD"},
                {"SOGO"}
        });
    }
    @Parameterized.Parameter
    public static String codeName;

    @Test
    public void stockDelete(){
        given().log().all()
                .spec(requestSpecification)
                .formParam("code",codeName)
                .when().post("https://api.xueqiu.com/stock/portfolio/delstock.json")
                .then().log().all()
                .body("success",equalTo(true))
                .statusCode(200);

        given().log().all()
                .spec(requestSpecification)
                .queryParam("type","6")
                .queryParam("category","2")
                .queryParam("size",10000)
                .when().get("https://api.xueqiu.com/v4/stock/portfolio/stock_list.json")
                .then().log().all()
                .statusCode(200)
                .body("stocks.code",not(hasItems(codeName)))
        ;

    }

    @Test
    public void stockAdd(){
        given().log().all()
                .spec(requestSpecification)
                .formParam("symbol",codeName)
                .formParam("category","2")
                .when().post("https://api.xueqiu.com/v4/stock/portfolio/addstock.json")
                .then().log().all()
                .body("success",equalTo(true))
                .statusCode(200);

        given().log().all()
                .spec(requestSpecification)
                .queryParam("type","6")
                .queryParam("category","2")
                .queryParam("size",10000)
                .when().get("https://api.xueqiu.com/v4/stock/portfolio/stock_list.json")
                .then().log().all()
                .statusCode(200)
                .body("stocks.code",hasItems(codeName))
        ;

    }
}
