package com.testerhom.api.junit;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Base {
    @BeforeClass
    public static void BeforeClass(){
        System.out.println("BeforeClass");

    }

    @AfterClass
    public static void AfterClass(){
        System.out.println("AfterClass");

    }

    @Before
    public void Before(){
        System.out.println("Before");
    }

    @Test
    public void demo1(){
        System.out.println("demo1");
    }

    @Test
    public void demo0(){
        System.out.println("demo");
    }

    @Test
    public void demo2(){
        System.out.println("demo2");
    }
}
