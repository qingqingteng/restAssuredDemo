package xueqiu6.testcase;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        loginTest.class,
        searchStockTest.class,
        searchUserTest.class
        })
public class 搜索SuiteTest {
}
