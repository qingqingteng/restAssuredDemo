/*
    junit demo
 */

package restassured;

import io.restassured.path.json.JsonPath;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.useRelaxedHTTPSValidation;
import static org.hamcrest.CoreMatchers.equalTo;

//@RunWith(Parameterized.class)
public class demo {
    @Parameterized.Parameters(name = "{index}: baiduSearch wd={0} expect={1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { 0, 0 }, { 1, 1 }, { 2, 1 }, { 3, 2 }, { 4, 3 }, { 5, 5 }, { 6, 8 }
        });
    }
    @Parameterized.Parameter // first data value (0) is default
    public /* NOT private */ int fInput;

    @Parameterized.Parameter(1)
    public /* NOT private */ int fExpected;

    @Test
    public void baiduParameter(){
        given().log().all()
                .queryParam("wd",fInput)
        .when()
                .get("http://www.baidu.com/s")
        .then().log().all()
                .statusCode(200)
                .body("html.head.title",equalTo(fExpected+"_百度搜索"));
    }

    @Test
    public void baidu(){
        given().log().all()
                .queryParam("wd","mp3")
        .when()
                .get("http://www.baidu.com/s")
        .then().log().all()
                .statusCode(200)
                .body("html.head.title",equalTo("mp3"+"_百度搜索"));
    }


    @Test
    public void testhome(){
//        given().log().all()
//                .formParam("--YY\\x0d\\x0aContent-Disposition","form-data")
//                .formParam("name","\\\"version\\\"\\x0d\\x0a\\x0d\\x0a2.5.5\\x0d\\x0a--YY\\x0d\\x0aContent-Disposition:form-data; name=\\\"data\\\"\\x0d\\x0a\\x0d\\x0a{\\\"appKey\\\":\\\"dc32f0087e504608a75f06533a57ca76\\\",\\\"appVersion\\\":\\\"\\xe9\\x9b\\xaa\\xe7\\x90\\x83\\xe8\\x82\\xa1\\xe7\\xa5\\xa8-11.13\\\",\\\"from\\\":\\\"1\\\",\\\"sdkVersion\\\":\\\"2.5.5\\\",\\\"mobilemodels\\\":\\\"iPhone8,1\\\",\\\"systemVersion\\\":\\\"11.3\\\",\\\"items\\\":[{\\\"content\\\":\\\"OPEN APP\\\",\\\"channel\\\":\\\"ZhichiYaYa\\\",\\\"time\\\":\\\"1546739107000\\\",\\\"logType\\\":\\\"19\\\",\\\"title\\\":\\\"[2019-01-06 09:45:07.292]START APP\\\",\\\"udid\\\":\\\"6F2E6E00-7D3D-41B8-B7BE-AC7763837649\\\",\\\"uid\\\":\\\"6F2E6E00-7D3D-41B8-B7BE-AC7763837649\\\",\\\"companyid\\\":\\\"02d8249765694de6b688f6edea8e8760\\\",\\\"type\\\":\\\"5\\\",\\\"network\\\":\\\"4G\\\"}]}\\x0d\\x0a--YY\\x0d\\x0aContent-Disposition:form-data")
//                .formParam("name","\\\"from\\\"\\x0d\\x0a\\x0d\\x0a3\\x0d\\x0a--YY--\\x0d\\x0a")
//                .header("Cookie","aliyungf_tc=AQAAAIOdZhLUkwMAZUvAt5NAHujI9ps7; acw_tc=3ccdc16515466536671545067e5358a862fe986045b321b81e89ab68f23bc0")
//                .when()
//                .post("https://api.sobot.com/chat/sdk/user/v1/collect.action")
//                .then().log().all()
//                .body("code",equalTo("1"));


        /*

        rest assured可以直接解析html、xml、json的数据。
        注意这个接口返回的结果是html里嵌套json数据，所以rest assured不能直接把数据解析出来！
        返回数据如下：
        <html>
            <body>{"code":1,"data":null,"msg":null}</body>
        </html>
        解决方案：先拿出html的body数据，然后在拿出body里面的json数据，最后断言

        参考官网的Example
        Getting and parsing a response body:

        // Example with JsonPath
        String json = get("/lotto").asString()
        List<String> winnderIds = from(json).get("lotto.winners.winnerId");

        // Example with XmlPath
        String xml = post("/shopping").andReturn().body().asString()
        Node category = from(xml).get("shopping.category[0]");

         */

//        从接口返回的数据中取出body的内容
        String bodystrFromXml =
                given().log().all()
                        .formParam("--YY\\x0d\\x0aContent-Disposition","form-data")
                        .formParam("name","\\\"version\\\"\\x0d\\x0a\\x0d\\x0a2.5.5\\x0d\\x0a--YY\\x0d\\x0aContent-Disposition:form-data; name=\\\"data\\\"\\x0d\\x0a\\x0d\\x0a{\\\"appKey\\\":\\\"dc32f0087e504608a75f06533a57ca76\\\",\\\"appVersion\\\":\\\"\\xe9\\x9b\\xaa\\xe7\\x90\\x83\\xe8\\x82\\xa1\\xe7\\xa5\\xa8-11.13\\\",\\\"from\\\":\\\"1\\\",\\\"sdkVersion\\\":\\\"2.5.5\\\",\\\"mobilemodels\\\":\\\"iPhone8,1\\\",\\\"systemVersion\\\":\\\"11.3\\\",\\\"items\\\":[{\\\"content\\\":\\\"OPEN APP\\\",\\\"channel\\\":\\\"ZhichiYaYa\\\",\\\"time\\\":\\\"1546739107000\\\",\\\"logType\\\":\\\"19\\\",\\\"title\\\":\\\"[2019-01-06 09:45:07.292]START APP\\\",\\\"udid\\\":\\\"6F2E6E00-7D3D-41B8-B7BE-AC7763837649\\\",\\\"uid\\\":\\\"6F2E6E00-7D3D-41B8-B7BE-AC7763837649\\\",\\\"companyid\\\":\\\"02d8249765694de6b688f6edea8e8760\\\",\\\"type\\\":\\\"5\\\",\\\"network\\\":\\\"4G\\\"}]}\\x0d\\x0a--YY\\x0d\\x0aContent-Disposition:form-data")
                        .formParam("name","\\\"from\\\"\\x0d\\x0a\\x0d\\x0a3\\x0d\\x0a--YY--\\x0d\\x0a")
                        .header("Cookie","aliyungf_tc=AQAAAIOdZhLUkwMAZUvAt5NAHujI9ps7; acw_tc=3ccdc16515466536671545067e5358a862fe986045b321b81e89ab68f23bc0")
                .when()
                        .post("https://api.sobot.com/chat/sdk/user/v1/collect.action")
                .andReturn()
                        .body().asString();
        System.out.println("bodystrFromXml = " + bodystrFromXml);
//        使用JsonPath解析json数据
        JsonPath jsonPath = new JsonPath(bodystrFromXml);
//        取出json数据中的code字段，进行断言
        Assert.assertEquals(jsonPath.getString("code"),"1");

    }

    @Test
    public void testGetUrl(){
        useRelaxedHTTPSValidation();//如果网址是https，使用此方法不会去强行校验证书
        given().log().all()
        .when()
                .get("https://testerhome.com")
        .then().log().all()
                .statusCode(200).body("html.head.title",equalTo("TesterHome"));
    }



}
