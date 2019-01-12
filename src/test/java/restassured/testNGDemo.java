package restassured;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.CoreMatchers.equalTo;

public class testNGDemo {

    @Test
    public void function(){
        get("http://www.baidu.com").prettyPeek();
    }

    @Test
    public void testhomeGetUrl(){
//        get请求的参数直接拼接url中
        get("https://testerhome.com/api/v3/topics.json?limit=2&offset=0&type=last_actived").prettyPeek();
    }

    @Test
    public void testhomeGetFromParam(){
//        get的请求参数放在param的方法中
//        Response response = given()
//                .param("limit",2).and().and().param("offset",0).and().param("type","last_actived")
//                .get("https://testerhome.com/api/v3/topics.json");

        Response response =
                given()
                        .param("limit",2)
                        .param("offset",0)
                        .param("type","last_actived")
                        .get("https://testerhome.com/api/v3/topics.json");
        response.prettyPeek();
        Assert.assertEquals(response.statusCode(),200);
        response.prettyPeek();

    }

    @Test
    public void testhomeGetFromMap(){
//        get请求参数放入map中
        Map<String,Object> parameters = new HashMap<>();
        parameters.put("limit",2);
        parameters.put("offset",0);
        parameters.put("type","last_actived");
        int statusCode = given().params(parameters).get("https://testerhome.com/api/v3/topics.json").statusCode();
        System.out.println("statusCode=="+statusCode);
    }


    @Test(enabled = false)
    public void testhomePost(){
        Response response =
                given()
                        .param("limit",2)
                        .param("offset",0)
                        .param("type","last_actived")
                        .post("https://testerhome.com/api/v3/topics.json");
        response.prettyPeek();
        Assert.assertEquals(response.statusCode(),200);
        response.prettyPeek();

        Map<String,Object> parameters = new HashMap<>();
        parameters.put("limit",2);
        parameters.put("offset",0);
        parameters.put("type","last_actived");
        int statusCode = given().params(parameters).post("https://testerhome.com/api/v3/topics.json").statusCode();
        System.out.println("statusCode=="+statusCode);

    }

    @Test
    public void testerhomeTest(){
//首先验证结构
        get("https://testerhome.com/api/v3/topics.json?limit=2&offset=0&type=last_actived")
                .then().assertThat().body(matchesJsonSchemaInClasspath("schema/jsonSchema.json"));

//        使用rest assured的response进行断言，通过response拿出statusCode和json数据
        Response response = get("https://testerhome.com/api/v3/topics.json?limit=2&offset=0&type=last_actived");
        int statusCode = response.statusCode();
        Assert.assertEquals(statusCode,200,"接口是否正常打开");
        String title = response.jsonPath().getString("topics[0].title");
        Assert.assertEquals(title,"[精彩盘点] TesterHome 社区 2018年 度精华帖","对比title");
        int topicsCount = response.jsonPath().getList("topics").size();
        System.out.println("topicsCount=="+topicsCount);
        Assert.assertEquals(topicsCount,5);


        ArrayList list = new ArrayList();
        list.add("[精彩盘点] TesterHome 社区 2018年 度精华帖");
        list.add("您有一份来自社区的礼物请查收");
        list.add("[抱团取暖系列] 上海测试岗位集锦——总有对你胃口的职位");
        list.add("关于学习、关于成长的 9 条建议");
        list.add( "Android 包大小检查测试方案");

        for(int i=0;i<topicsCount;i++){
            Assert.assertEquals(list.get(i),response.jsonPath().getString("topics["+i+"].title"));
        }



//        直接用rest assured的then断言
        get("https://testerhome.com/api/v3/topics.json?limit=2&offset=0&type=last_actived")
        .then()
                .body("topics[0].title",equalTo("[精彩盘点] TesterHome 社区 2018年 度精华帖"))
                .statusCode(200);

    }



    @Test
    public void jasonSchema(){
        get("https://testerhome.com/api/v3/topics.json?limit=2&offset=0&type=last_actived")
                .then().assertThat().body(matchesJsonSchemaInClasspath("schema/jsonSchema.json"));

        get("https://testerhome.com/api/v3/topics.json?limit=2&offset=0&type=last_actived")
                .then().body(matchesJsonSchemaInClasspath("schema/jsonSchema.json"));


    }

}
