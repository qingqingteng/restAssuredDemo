package appiumDemo.xueqiu6.testcase;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        xueqiu6.testcase.loginTest.class,
        xueqiu6.testcase.searchStockTest.class,
        appiumDemo.xueqiu6.testcase.searchUserTest.class
        })
public class 搜索SuiteTest {
}
