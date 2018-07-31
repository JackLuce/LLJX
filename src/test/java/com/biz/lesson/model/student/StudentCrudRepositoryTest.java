package com.biz.lesson.model.student;

import com.biz.lesson.dao.student.StudentJpaRepository;
import com.biz.lesson.service.StudentService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
public class StudentCrudRepositoryTest {
    private ApplicationContext applicationContext = null;
    private StudentService studentService = null;
    private StudentJpaRepository studentJpaRepository = null;

    @Before
    public void  setup(){
        System.out.println("setup");
        applicationContext = new ClassPathXmlApplicationContext("classpath:application-content.xml");
        studentService = applicationContext.getBean(StudentService.class);
        studentJpaRepository = applicationContext.getBean(StudentJpaRepository.class);

    }

    @After
    public  void  tearDown(){
        applicationContext = null;
        System.out.println("teardown");
    }
    @Test
    public void testSave(){
        List<Student> list = new ArrayList<Student>();
        List<Subject> subjectList1 = new ArrayList<Subject>();
        List<Subject> subjectList2 = new ArrayList<Subject>();
        Subject subject1 = new Subject("java");
        Subject subject2 = new Subject("SAP");
        Subject subject3 = new Subject("UI");
        subjectList1.add(subject1);
        subjectList1.add(subject2);
        subjectList2.add(subject3);
        Student student = null;
        for (int i =1;i<=66;i++){
            student = new Student();
            student.setName("学生-"+i);
            student.setId(i);
            Grade grade = null;
            if((i%2) == 0){
            student.setSex("男");
            }else{
            student.setSex("女");
            }
            student.setBirthday(new Date());
            if((i%4) == 0){
            student.setCode("161700"+i);
            grade = new Grade("六班");
            student.setGrade(grade);
            student.setSubjectList(subjectList1);
            list.add(student);
            }else {
            student.setCode("181100"+i);
            grade = new Grade("八班");
            student.setGrade(grade);
            student.setSubjectList(subjectList2);
            list.add(student);
            }
        }
        studentService.save(list);
    }

    @Test
    public  void testfindAll(){
        List<Student> studentList = studentJpaRepository.findAll();

        for (Student student: studentList) {
            System.out.println(student);
        }
    }
    @Test
    public void testdeleteAll(){
        studentService.deleteAll();
    }
}
