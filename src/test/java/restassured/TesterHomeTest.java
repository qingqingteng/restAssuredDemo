package restassured;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import sun.misc.BASE64Decoder;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.useRelaxedHTTPSValidation;
import static org.hamcrest.Matchers.*;

public class TesterHomeTest {
    @BeforeClass
    public static void beforeClass(){
        useRelaxedHTTPSValidation();

//        全局RestAssured对象
        RestAssured.baseURI="https://testerhome.com/";
        RestAssured.proxy("http://127.0.0.1:7777");
//        RestAssured.filters((require,response,context)->{//使用filter机制添加cookie
//            require.cookie("testerhome","tengqingqing");
//            return context.next(require,response);
//        });

    }
    @Test
//    接口数据是json
    public void testJsonTopics(){

//        第一种：直接使用restAssured的then进行断言，then的body方法里的第一个参数写入数据查找的路径，第二个参数写入hamcrest的mather比较器
        given()
//                .filter((require,response,context)->{
//                    require.cookie("testerhome","tengqingqing");
//                    return context.next(require,response);
//                })//使用filter机制添加cookie
//                .proxy("http://127.0.0.1:8888")
                .when().get("api/v3/topics.json").prettyPeek()
                        .then()
//                .body("topics.id",hasItems(17660,17561))
//                .body("topics.id[0]",equalTo(17660))
//                .body("topics.find {it.id == 16756}.title",equalTo("WEB 自动化性能测试"))
//                .body("topics[-1].user.Login",equalTo("westwind"))//topics[-1]数组中的最后一个
                .statusCode(200)
                .time(lessThan(2000L));

//      第二种：从restAssured的response中提取相应的接口数据，然后对数据进行Assert或者是harmcrest断言
        Response response =
        given().when().get("https://testerhome.com/api/v3/topics.json").prettyPeek()
        .then()
//                .body("topics.id",hasItems(17660,17561))
//                .body("topics.id[0]",equalTo(17660))
//                .body("topics.find {it.id == 16756}.title",equalTo("WEB 自动化性能测试"))
//                .body("topics[-1].user.Login",equalTo("westwind"))//topics[-1]数组中的最后一个
                .statusCode(200)
                .extract().response();

//        直接通过response的path方法或者jsonPath.get方法都可以拿到数据
        int id = response.path("topics.id[0]");
        int id1 = response.jsonPath().getInt("topics.id[0]");
        Assert.assertEquals(id,id1);
        int size = response.path("topics.size()");
        System.out.println("topics size===="+size);
    }

    @Test
//    接口数据是xml
    public void testXML(){
//        第一种：直接使用restAssured的then进行断言，then的body方法里的第一个参数写入数据查找的路径，第二个参数写入hamcrest的mather比较器
                given().log().all()
//                .proxy("http://127.0.0.1:8888")//走代理获取接口数据，然后通过代理抓包工具分析log
                        .when()
                        .get("http://127.0.0.1:8000/demo.xml").prettyPeek()
                        .then()
                        .body("**.find {it.@type =='supplies'}.item.name[0]",equalTo("Paper"))
                        .body("shopping.category.find {it.@type =='supplies'}.size()",equalTo(1))
                        .body("shopping.category.size()",equalTo(3));

//      第二种：从restAssured的response中提取相应的接口数据，然后对数据进行Assert或者是harmcrest断言
        Response response =
        given().log().all()
//                .proxy("http://127.0.0.1:8888")//走代理获取接口数据，然后通过代理抓包工具分析log
        .when()
                .get("http://127.0.0.1:8000/demo.xml").prettyPeek()
        .then()
                .body("**.find {it.@type =='supplies'}.item.name[0]",equalTo("Paper"))
                .body("shopping.category.find {it.@type =='supplies'}.size()",equalTo(1))
                .body("shopping.category.size()",equalTo(3)).extract().response();
//通过XmlPath类取出相应的数据，感觉多此一举
        XmlPath xmlPath = new XmlPath(response.andReturn().body().asString());
        int size = xmlPath.getList("shopping.category").size();
        System.out.println("size==="+size);
        Assert.assertEquals(size,3);
        String name = xmlPath.getString("shopping.category[0].item[0].name");
        System.out.println("hame====="+name);

//直接通过response的path方法或者xmlPaht方法都可以获取数据
        String name111 = response.path("shopping.category[0].item[0].name");
        String name222 = response.xmlPath().getString("shopping.category[0].item[0].name");
        Assert.assertEquals(name111,name222);
        System.out.println(name111+"-----"+name222);
        int size111 = response.path("shopping.category.size()");
        System.out.println("size111==="+size111);
    }

    @Test
    public void baidu(){
        Map<String,Object> data = new HashMap<>();
        data.put("x",1);
        data.put("y","sxsss");
        given()
                .contentType(ContentType.JSON).body(data)
                .proxy("http://127.0.0.1:8888")
        .when()
                .post("http://www.baidu.com/s")
        .then()
                .statusCode(200);
    }


    @Test
    public void testAuth(){
        given().auth().basic("hogwarts","123456")
                .get("http://shell.testing-studio.com:9002/")
        .then().statusCode(200);

    }


    @Test
    public void testBase64(){
        given().log().all()
                .filter((req,res,context)->{
                    Response responseOriginal = context.next(req,res);
                    ResponseBuilder responseBuilder = new ResponseBuilder().clone(responseOriginal);
//                    System.out.println(responseOriginal.getBody().asString().trim());
                    responseBuilder.setBody(
                                    Base64.getDecoder().decode(
                                            responseOriginal.getBody().asString().trim()));
//                    responseBuilder.setContentType(ContentType.JSON);
                    return  responseBuilder.build();

                })
        .when()
                .get("http://127.0.0.1:8001/security_topics.json")
        .then().log().all()
                .statusCode(200)
                .body("topics.id[0]",equalTo(17670))
        ;
    }
}
