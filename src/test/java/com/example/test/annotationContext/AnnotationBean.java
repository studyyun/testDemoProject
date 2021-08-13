package com.example.test.annotationContext;

import org.springframework.stereotype.Component;

/**
 * 应用模块名称
 *
 * @author zhousy
 * @date 2021-07-09  15:31
 */
@Component
public class AnnotationBean {

//    @Autowired
    public AnnotationBean2 annotationBean2;

    public AnnotationBean() {
    }

    public AnnotationBean(AnnotationBean2 annotationBean2) {
        this.annotationBean2 = annotationBean2;
    }

    public void hello() {
        System.out.println("hello,baby");
    }

    public void changsha() {
        annotationBean2.address();
    }

    public void init() {
        System.out.println("初始化AnnotationBean，init()");
    }

    public void destory() {
        System.out.println("销毁AnnotationBean，destory()");
    }
    
}
