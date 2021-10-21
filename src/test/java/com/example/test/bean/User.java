package com.example.test.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Arrays;
import java.util.List;

/**
 * 应用模块名称
 *
 * @author zhousy
 * @date 2021-05-17  17:16
 */
public class User {
    
    @JSONField(name = "exno")
    private String name;
    
    private Integer age;
    
    private Students students;

    private List<Students> studentsList;
    
    private int[] intss = new int[]{0, 0, 0, 0};;
    
    private String message;

    public int[] getIntss() {
        return intss;
    }

    public void setIntss(int[] intss) {
        this.intss = intss;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Students getStudents() {
        return students;
    }

    public void setStudents(Students students) {
        this.students = students;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public User(String name) {
        this.name = name;
    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", students=" + students +
                ", studentsList=" + studentsList +
                ", intss=" + Arrays.toString(intss) +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Students> getStudentsList() {
        return studentsList;
    }

    public void setStudentsList(List<Students> studentsList) {
        this.studentsList = studentsList;
    }
}
