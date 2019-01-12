package com.testerhom.api.junit.xueqiu0111.stock;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({
        Stocks.class,
        StockAddDelete.class
})
public class StockSuite {
}
