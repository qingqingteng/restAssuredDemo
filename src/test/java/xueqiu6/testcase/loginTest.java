package xueqiu6.testcase;

import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import xueqiu6.pages.page搜索;
import xueqiu6.pages.page雪球;
import xueqiu6.uitls.AppDriver;

import java.net.MalformedURLException;

import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class loginTest {

//    定义数据驱动的数据来源
    @Parameterized.Parameters
    public static Object[][] data(){
        return new Object[][]{
                {"13774395119","xueqiu123"}
        };
    }
//    定义数据驱动变量
    @Parameterized.Parameter
    public String phone;
    @Parameterized.Parameter(1)
    public String password;

    @BeforeClass
    public static void beforeClass() throws MalformedURLException {
        AppDriver.launchApp();
    }

    @AfterClass
    public static void afterClass(){
        AppDriver.driver.quit();
    }
    @After
    public void after(){
    }

    @Test
    public void login(){
      page雪球 page雪球 = new page雪球();
      page雪球.enterProfile().entoLogin().login(phone,password);

    }
}
