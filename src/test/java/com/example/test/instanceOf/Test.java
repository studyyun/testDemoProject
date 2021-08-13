package com.example.test.instanceOf;

/**
 * 应用模块名称
 *
 * @author zhousy
 * @date 2021-02-26  9:56
 */
public class Test {

    public void test1(Father father){
        if (father instanceof Son){
            System.out.println("我是大儿子");
        }
        if (father instanceof TwoSon){
            System.out.println("我是二儿子");
        }
        if (father instanceof ThreeSon){
            System.out.println("我是三儿子");
        }
    }

    public static void main(String[] args) {
//        new Test().test1(new Son());
        new Test().test1(new TwoSon());
//        new Test().test1(new ThreeSon());
    }

}
