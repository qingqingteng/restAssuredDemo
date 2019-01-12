package appiumDemo.xueqiu6.testcase;

import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import xueqiu6.uitls.AppDriver;
import appiumDemo.xueqiu6.pages.page雪球;
import appiumDemo.xueqiu6.pages.page搜索;


import java.net.MalformedURLException;

import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class searchUserTest {
     page搜索 page搜索;

//    定义数据驱动的数据来源
    @Parameterized.Parameters
    public static Object[][] data(){
        return new Object[][]{
                {"seveniruby","seveniruby"},
                {"seveniruby_2","seveniruby_2"}
        };
    }
//    定义数据驱动变量
    @Parameterized.Parameter
    public String keyword;
    @Parameterized.Parameter(1)
    public String name;

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
//        搜索完成后返回雪球首页
        page搜索.gobackXueqiu();
    }

    @Test
    public void searchUserName(){
        page雪球 page雪球 = new page雪球();
        page搜索 = page雪球.enterSearch();
        assertThat(
                page搜索.search(keyword).getUserNames().get(0),
                Matchers.equalTo(name));
    }
}
