package com.biz.lesson.model.student;

import com.biz.lesson.dao.student.StudentJpaRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName:PagingAndSortingRespositoryTest
 * @Description:
 * @Author:MinJieLuo
 * @Date:2018/7/26 19:12
 * @Version:1.0
 **/
public class StudentJpaRespositoryTest {

    private ApplicationContext applicationContext = null;
    private StudentJpaRepository studentJpaRepository = null;

    @Before
    public void  setup(){
        System.out.println("setup");
        applicationContext = new ClassPathXmlApplicationContext("classpath:application-content.xml");
        studentJpaRepository = applicationContext.getBean(StudentJpaRepository.class);
    }

    @After
    public  void  tearDown(){
        applicationContext = null;
        System.out.println("teardown");
    }

    @Test
    public void testfind(){
        List<Integer> integerList = new ArrayList<Integer>();
        integerList.add(11);
        integerList.add(22);
        integerList.add(55);
        integerList.add(66);
        List<Student> studentList=studentJpaRepository.findAll(integerList);
        for (Student student:studentList) {
            System.out.println("-----"+student);
        }
        System.out.println("是否存在88---"+studentJpaRepository.exists(88));
        List<Student> studentList1=studentJpaRepository.findAll();
        for (Student student:studentList1) {
            System.out.println(student+"-----");
        }
    }



}

