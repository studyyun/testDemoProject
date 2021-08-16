package com.example.test.annotationContext;

/**
 * 应用模块名称
 *
 * @author zhousy
 * @date 2021-07-09  15:31
 */
//@Component
public class AnnotationBean3 {

    /*@Bean(initMethod = "init",destroyMethod = "destory",name = {"alies","alies2"})
    @Description("this is a test bean")*/
    public AnnotationBean otherAnnotationBean(){
        return new AnnotationBean();
    }

    public void test() {
        System.out.println("i am three");
    }
}
