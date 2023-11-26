package com.iweb.test;

import com.iweb.test.DAO.GradeDAO;
import com.iweb.test.DAO.StudentDAO;
import com.iweb.test.DAO.impl.GradeDAOImpl;
import com.iweb.test.DAO.impl.StudentDAOImpl;
import com.iweb.test.entity.Grade;
import com.iweb.test.entity.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * java database connection
 * 在java中操作和读取数据库的一种方案
 *
 * @author Liu Xiong
 * @date 14/11/2023 下午6:25
 */
public class TestJDBC {
    public static void main(String[] args) {
        Student s = new Student();
        List<Student> stus = new ArrayList<>();

        // s.setName("lyhKun");
        // s.setAddress("南京工业大学南苑厕所");
        // s.setGender("女");
        // s.setQqnumber(118L);
        // s.setBirthday(new Date());
        // s.setId(1);

        StudentDAO studentDAO = new StudentDAOImpl();
        // studentDAO.testInsert();
        // System.out.println(studentDAO.listAll());
        GradeDAO gradeDAO = new GradeDAOImpl();
        System.out.println(studentDAO.listByIdWithGrade(1));
        List<Student> students = studentDAO.listAllWithGrade();
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println("=============");
        students = studentDAO.listAllWithGrade(1, 2);
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
