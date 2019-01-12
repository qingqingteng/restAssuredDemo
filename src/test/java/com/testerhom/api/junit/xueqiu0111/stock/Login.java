package com.testerhom.api.junit.xueqiu0111.stock;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.BeforeClass;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.useRelaxedHTTPSValidation;

public class Login {
        public static String access_token;
        public static String uid;
        public static RequestSpecification requestSpecification;

    @BeforeClass
    public static void login(){
//        useRelaxedHTTPSValidation();
//        Response response = given().log().all()
//                .queryParam("_t","1GENYMOTION55e8412c2d7d8f06fe04b20f5cfcdb70.8967748507.1547209375171.1547210171606")
//                .queryParam("_s","74d4e3")
//                .cookie("xq_a_token","1GENYMOTION55e8412c2d7d8f06fe04b20f5cfcdb70")
//                .cookie("u","8967748507")
//                .formParam("sid","1GENYMOTION55e8412c2d7d8f06fe04b20f5cfcdb70")
//                .formParam("client_secret","txsDfr9FphRSPov5oQou74")
//                .formParam("grant_type","password")
//                .formParam("areacode","86")
//                .formParam("captcha","")
//                .formParam("client_id","JtXbaMn7eP")
//                .formParam("telephone","13774395119")
//                .formParam("password","5d93ceb70e2bf5daa84ec3d0cd2c731a")
//                .formParam("x","0.370")
//                .when().post("https://api.xueqiu.com:443/provider/oauth/token")
//        .then().statusCode(200).extract().response();
//
//        access_token = response.path("access_token");
//        uid = response.path("uid");

        access_token = "58fef2ae1eae5037dff87bff41549fb117d4ec80";
        uid = "3023201624";

        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.addCookie("xq_a_token",access_token);
        requestSpecBuilder.addCookie("u","3023201624");
        requestSpecBuilder.addQueryParam("_t","1GENYMOTION55e8412c2d7d8f06fe04b20f5cfcdb70.3023201624.1547260387303.1547265562385");
        requestSpecBuilder.addQueryParam("_s","4729bf");
        requestSpecBuilder.addFormParam("x","0.358");
        requestSpecification = requestSpecBuilder.build();

    }

}


//POST /provider/oauth/token?_t=1GENYMOTION55e8412c2d7d8f06fe04b20f5cfcdb70.8967748507.1547209375171.1547210171606&_s=74d4e3 HTTP/1.1
//        Accept-Encoding: gzip, deflate
//        Accept-Language: en-US,en;q=0.8,zh-CN;q=0.6,zh;q=0.4
//        User-Agent: Xueqiu Android 10.7
//        Cookie: xq_a_token=7c96a7e59639e6400607e1e36e471f128814b7bf;u=8967748507
//        Content-Type: application/x-www-form-urlencoded; charset=UTF-8
//        Host: api.xueqiu.com
//        Connection: close
//        Content-Length: 219
//
//        sid=1GENYMOTION55e8412c2d7d8f06fe04b20f5cfcdb70&
//        client_secret=txsDfr9FphRSPov5oQou74&grant_type=password&
//        areacode=86&captcha=&client_id=JtXbaMn7eP&telephone=13774395119&
//        password=5d93ceb70e2bf5daa84ec3d0cd2c731a&x=0.370&
//
//        {
//        "access_token": "58fef2ae1eae5037dff87bff41549fb117d4ec80",
//        "refresh_token": "1742cfc105db3b0925d7ae9038c5c8cc1a095def",
//        "uid": 3023201624,
//        "is_new": false,
//        "scope": "all",
//        "expires_in": 43200,
//        "user": {
//        "id": 3023201624,
//        "screen_name": "mmtqq",
//        "name": null,
//        "province": null,
//        "city": null,
//        "location": null,
//        "description": null,
//        "url": null,
//        "domain": null,
//        "gender": null,
//        "verified": null,
//        "created_at": 1545189131709,
//        "areaCode": "86",
//        "type": "1",
//        "followers_count": null,
//        "friends_count": null,
//        "status_count": null,
//        "last_status_id": null,
//        "last_comment_id": null,
//        "step": "null",
//        "verified_description": null,
//        "blog_description": null,
//        "profile": "/3023201624",
//        "recommend": null,
//        "stock_status_count": null,
//        "intro": null,
//        "status": 0,
//        "st_color": "1",
//        "following": false,
//        "follow_me": false,
//        "blocking": false,
//        "allow_all_stock": false,
//        "truncated": false,
//        "stocks_count": null,
//        "verified_type": null,
//        "ability": null,
//        "donate_snowcoin": 0,
//        "donate_count": 0,
//        "lastRecordAt": null,
//        "maskedEmail": null,
//        "anonymous": false,
//        "profile_image_url": "community/default/avatar.png,community/default/avatar.png!180x180.png,community/default/avatar.png!50x50.png,community/default/avatar.png!30x30.png",
//        "photo_domain": "http://xavatar.imedao.com/",
//        "cube_count": null
//        }
//        }