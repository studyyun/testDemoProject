package com.example.test.annotationContext;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 应用模块名称
 *
 * @author zhousy
 * @date 2021-06-29  14:52
 */
public class TestApplication {

    public static void main(String[] args) {
        /*AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.registerBean(TestBeanPostProcessor.class);
        applicationContext.registerBean(DateBean.class);
        applicationContext.refresh();
        DateBean bean = applicationContext.getBean(DateBean.class);
        System.out.println(bean.toString());*/

        /*AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AnnotationBean.class, AnnotationBean2.class);
        AnnotationBean bean = applicationContext.getBean(AnnotationBean.class);
        bean.hello();
        bean.changsha();*/

        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext()) {
            /*context.scan("com.example.demo.annotationContext");
            context.refresh();
            AnnotationBean bean = context.getBean("getBean",AnnotationBean.class);
            System.out.println(bean.toString());
            System.out.println(bean.annotationBean2.toString());
            AnnotationBean bean_one = context.getBean("getBean",AnnotationBean.class);
            System.out.println(bean_one.toString());
            AnnotationBean bean_two = context.getBean("getBean_two",AnnotationBean.class);
            System.out.println(bean_two.toString());
            System.out.println(bean_two.annotationBean2.toString());
            bean.changsha();
            bean.hello();*/
            context.register(AppConfig.class, AppConfig2.class);
            context.refresh();
            AppConfig appConfig = context.getBean(AppConfig.class);
            System.out.println(appConfig.appConfig2);
        }
    }

}
