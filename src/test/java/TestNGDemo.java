import org.testng.Assert;
import org.testng.annotations.*;

public class TestNGDemo {

    @BeforeClass
    public void Beforeclass(){
        System.out.println("Beforeclass");

    }


    @AfterClass
    public void Afterclass(){
        System.out.println("Afterclass");
    }

    @BeforeMethod
    public void BeforeMethod(){
        System.out.println("BeforeMethod");
    }

    @AfterMethod
    public void AfterMethod(){
        System.out.println("AfterMethod");
    }

    @BeforeTest
    public void BeforeTest(){
        System.out.println("BeforeTest");
    }

    @AfterTest
    public void AfterTest(){
        System.out.println("AfterTest");
    }


//    未完成的用例，不希望被执行
    @Test(enabled = false)
    public void function(){
        System.out.println("not run");
    }


    @Test(groups = {"groups1"})
    public void abc(){
        System.out.println("this is abc");
    }

    @Test(groups = {"groups1"})
    public void abc1(){
        System.out.println("this is abc1");
    }

    @Test(groups = {"groups2"})
    public void function1(){
        System.out.println("function1");
    }

    @Test
    public void function2(){
        System.out.println("function2");
    }

    @Test(dependsOnMethods = {"function2","function1"})
    public void function3(){
        System.out.println("function3");
    }

//    参数化
    @Test(enabled = false)
    @Parameters("username")
    public void functionParameter(String testStr){
        System.out.println("name== " + testStr);
    }

    @Test
    public void assertTest(){
        String str1 = "111";
        String str2 = "1112";
        Assert.assertEquals(str1,str2,"判断是否相等");

        boolean b1 = true;
        boolean b2 = false;
        Assert.assertTrue(b1,"判断是否为true");
        Assert.assertFalse(b2,"判断是否为false");

        Object object = null;
        Assert.assertNull(object,"判断是否为null");
        Assert.assertNotNull(object,"判断是否不为null");


    }



}
