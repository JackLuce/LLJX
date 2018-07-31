package com.biz.lesson.model.student;

import com.biz.lesson.service.StudentService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @ClassName:EmployeeServiceTest
 * @Description:需要--------------------------事务
 * @Author:MinJieLuo
 * @Date:2018/7/26 16:39
 * @Version:1.0
 **/
public class StudentServiceTest {

    private ApplicationContext applicationContext = null;
    private StudentService studentService = null;

    @Before
    public void  setup(){
        System.out.println("setup");
        applicationContext = new ClassPathXmlApplicationContext("classpath:application-content.xml");
        studentService = applicationContext.getBean(StudentService.class);
    }

    @After
    public  void  tearDown(){
        applicationContext = null;
        System.out.println("teardown");
    }

    @Test
    public void testupdate(){
        studentService.update(12,"鬼谷传人");
    }
    @Test
    public void testupdate1(){
        studentService.update1(11,"小脑乎");
    }
    @Test
    public void testdeleteById(){
        Integer id=4;
        studentService.deleteById(id);
    }
    @Test
    public void testdeleteById1(){
        Integer id=3;
        studentService.deleteById1(id);
    }
    @Test
    public void testsearchBirthday(){
        List<Student> studentList = studentService.searchBirthday("2018-07-30");
        for (Student student:studentList) {
            System.out.println(student);
        }
    }
    @Test
    public void testfindByBirthdayBetween(){
        String d1 = "2018-07-28";
        String d2 = "2018-07-30";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = null;
        Date date2 = null;
        try {
            date1 = sdf.parse(d1);
            date2 = sdf.parse(d2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date date3 = new Date();
        System.out.println("date---------"+date1);
        System.out.println("date1---------"+date2);
        List<Student> studentList = studentService.findByBirthdayBetween(date1,date2);
        for (Student student: studentList){
            System.out.println(student);
        }
    }
}
