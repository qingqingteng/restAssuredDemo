package com.testerhom.api.junit;

import org.junit.*;
import org.junit.experimental.categories.Category;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Children extends Base {
    @BeforeClass
    public static void BeforeClassChildren(){
        System.out.println("BeforeClassChildren");

    }

    @AfterClass
    public static void AfterClassChildren(){
        System.out.println("AfterClassChildren");

    }

    @Before
    public void BeforeChildren(){
        System.out.println("BeforeChildren");
    }

    @Test
    @Category(Stage.class)//打便签可以是一个类（class）或者接口（interface）
    public void demo1Children(){
        System.out.println("demo1Children");
    }

    @Ignore("just for demonstration")
    @Test
    public void demo0Children(){
        System.out.println("demoChildren");
    }

    @Test
    @Category(Product.class)
    public void demo2Children(){
        System.out.println("demo2Children");
    }
}
