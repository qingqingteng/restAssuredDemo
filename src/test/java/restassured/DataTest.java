package restassured;

import com.beust.jcommander.Parameter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;


@RunWith(Parameterized.class)
public class DataTest {

    @Parameterized.Parameters(name = "{0} vs {1}")
    public static Integer[][] data(){
        return new Integer[][]{
                {0,0},{1,2}
        };
    }
    @Parameterized.Parameter
    public  int first;
    @Parameterized.Parameter(1)
    public int second;

    @Test
    public void testDemo(){
        assertThat(first,equalTo(second));
    }

    @Test
    public void baidu(){
        given().get("http://www.baidu.com/s?wd=201"+first)
        .then()
                .statusCode(200)
                .body("html.head.title",equalTo("201"+second+"_百度搜索"));


    }
}
