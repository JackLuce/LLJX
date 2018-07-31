package com.biz.lesson.model.student;

import com.biz.lesson.dao.student.StudentJpaRepository;
import com.biz.lesson.dao.student.StudentRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName:EmployeeRepositoryTest
 * @Description:
 * @Author:MinJieLuo
 * @Date:2018/7/26 13:11
 * @Version:1.0
 **/
public class StudentRepositoryTest {
    private ApplicationContext applicationContext = null;
    private StudentRepository studentRepository = null;

    @Before
    public void  setup(){
        System.out.println("setup");
        applicationContext = new ClassPathXmlApplicationContext("classpath:application-content.xml");
        studentRepository = applicationContext.getBean(StudentRepository.class);
    }

    @After
    public  void  tearDown(){
        applicationContext = null;
        System.out.println("teardown");
    }

    @Test
    public void testFindByName(){
        Student student = studentRepository.findByName("zhangsan");
        System.out.println(student);
        //org.springframework.data.jpa.repository.support.SimpleJpaRepository@1dc2de84
        System.out.println(studentRepository );
    }
    /*@Test
    public void testfindByNameStrartingWithAndAgeLessThan(){
        List<Student> studentList=studentRepository.findByNameStartingWithAndAgeLessThan("zhangsan",26);

        for (Student student: studentList) {
            System.out.println(student);
        }
        System.out.println(studentRepository );
    }
    @Test
    public void testfindByNameEndingWithAndAgeLessThan(){
        List<Student> studentList=studentRepository.findByNameEndingWithAndAgeLessThan("san",26);

        for (Student student: studentList) {
            System.out.println(student);
        }
        System.out.println(studentRepository );
    }
    @Test
    public void testfindByNameInOrAgeLessThan(){
        List<String> nameList=new ArrayList<String>();
        nameList.add("zhangsan4");
        nameList.add("zhangsan5");
        nameList.add("zhangsan6");
        List<Student> studentList=studentRepository.findByNameInOrAgeLessThan(nameList,26);

        for (Student student: studentList) {
            System.out.println(student);
        }
        System.out.println(studentRepository );
    }
    @Test
    public void testfindByNameInAndAgeLessThan(){
        List<String> nameList=new ArrayList<String>();
        nameList.add("zhangsan4");
        nameList.add("zhangsan5");
        nameList.add("zhangsan6");
        List<Student> employeeList=studentRepository.findByNameInAndAgeLessThan(nameList,26);

        for (Student employee: employeeList) {
            System.out.println(employee);
        }
        System.out.println(studentRepository );
    }
    */
    @Test
    public void testgetEmployeeById(){
        Student student = studentRepository.getStudentById();
            System.out.println(student);
    }
    @Test
    public void testqueryParamsl(){
        List<Student> studentList = studentRepository.queryParamsl("zhangsan99",28);
        for (Student student: studentList){
            System.out.println(student);
        }
    }
    @Test
    public void testqueryParams2(){
        List<Student> studentList = studentRepository.queryParams2("zhangsan99",28);
        for (Student student: studentList){
            System.out.println(student);
        }
    }
    @Test
    public void testqueryLike1(){
        List<Student> studentList = studentRepository.queryLike1("生-2");
        for (Student student: studentList){
            System.out.println(student);
        }
    }
    @Test
    public void testqueryLike2(){
        List<Student> studentList = studentRepository.queryLike2("zhangsan");
        for (Student student: studentList){
            System.out.println(student);
        }
    }
    @Test
    public void testfindByCodeStartingWith(){
        List<Student> studentList = studentRepository.findByCodeStartingWith("16");
        for (Student student: studentList){
            System.out.println(student);
        }
    }
    @Test
    public void testfindByBirthdayBetween(){
        String d1 = "2018-07-28";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = null;
        try {
            date = sdf.parse(d1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date date1 = new Date();
        System.out.println("date---------"+date);
        System.out.println("date1---------"+date1);
        List<Student> studentList = studentRepository.findByBirthdayBetween(date,date1);
        for (Student student: studentList){
            System.out.println(student);
        }
    }

}
