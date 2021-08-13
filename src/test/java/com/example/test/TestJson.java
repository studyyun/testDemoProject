package com.example.test;

import com.example.test.bean.User;

/**
 * 应用模块名称
 *
 * @author zhousy
 * @date 2021-07-02  10:16
 */
public class TestJson {

    public static void main(String[] args) {
        try {
            User user = new User("zhangsan");
            user.setAge(20);

            
            
        } catch (Exception e) {
            System.out.println("报错啦");
        }
        
        /*Students students = new Students();
        students.setAddress("长沙");
        students.setTaskId(46513L);
        user.setStudents(students);

        String s = JSONObject.toJSONString(user);
        System.out.println(s);
        JSONObject jsonObject = JSONObject.parseObject(s);
        String s1 = jsonObject.getString("students");
        System.out.println(s1);*/
        
        /*Students students = new Students();
        students.setAddress("changsha");
        students.setTaskId(123123L);

        Students students2 = new Students();
        students2.setAddress("beijing");
        students2.setTaskId(3213213L);

        List<Students> list = new ArrayList<Students>(){{
            this.add(students);
            this.add(students2);
        }};

        String listJson = JSONObject.toJSONString(list);
        System.out.println(listJson);

        List<Students> studentsList = JSONObject.parseArray(listJson, Students.class);
        

        user.setStudentsList(list);

        String userJson = JSONObject.toJSONString(user);
        System.out.println(userJson);*/


    }

}
