package com.testerhom.api.junit;

import org.junit.*;
import org.junit.experimental.categories.Category;
import org.junit.runners.MethodSorters;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Children2 extends Base {
    @BeforeClass
    public static void BeforeClassChildren2(){
        System.out.println("BeforeClassChildren2");

    }

    @AfterClass
    public static void AfterClassChildren2(){
        System.out.println("AfterClassChildren2");

    }

    @Before
    public void BeforeChildren2(){
        System.out.println("BeforeChildren2");
    }

    @Test()
    public void demo1Children2(){
        System.out.println("demo1Children2");
        assertThat(1,equalTo(2));
    }

    @Test
    public void demo0Children2(){
        System.out.println("demoChildren2");
    }

    @Test
    @Category(Stage.class)
    public void demo2Children2(){
        System.out.println("demo2Children2");
    }
}
