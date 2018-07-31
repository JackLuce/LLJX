package com.biz.lesson.model.student;

import com.biz.lesson.dao.student.StudentPagingAndSortingRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 * @ClassName:PagingAndSortingRespositoryTest
 * @Description:
 * @Author:MinJieLuo
 * @Date:2018/7/26 19:12
 * @Version:1.0
 **/
public class StudentPagingAndSortingRespositoryTest {

    private ApplicationContext applicationContext = null;
    private StudentPagingAndSortingRepository studentPagingAndSortingRepository = null;

    @Before
    public void  setup(){
        System.out.println("setup");
        applicationContext = new ClassPathXmlApplicationContext("classpath:application-content.xml");
        studentPagingAndSortingRepository = applicationContext.getBean(StudentPagingAndSortingRepository.class);
    }

    @After
    public  void  tearDown(){
        applicationContext = null;
        System.out.println("teardown");
    }

    @Test
    public void testPage(){
        //index是从0开始的，不是从1开始的
        Pageable pageable = new PageRequest(0,10    );
        Page<Student> page = studentPagingAndSortingRepository.findAll(pageable);
        System.out.println("getTotalElements--查询的总记录数:"+page.getTotalElements());
        System.out.println("getTotalPages--查询的总页数:"+page.getTotalPages());
        System.out.println("getContent--当前页面的集合："+page.getContent());
        System.out.println("getNumber--当前第几页:"+page.getNumber() + 1);
        System.out.println("getNumberOfElements--查询的当前页面的记录数:"+page.getNumberOfElements());
    }

    @Test
    public void testPageAndSort(){

        Sort.Order order = new Sort.Order(Sort.Direction.DESC,"id");
        Sort sort = new Sort(order);
        Pageable pageable = new PageRequest(0,6 ,sort );
        Page<Student> page = studentPagingAndSortingRepository.findAll(pageable);
        System.out.println("getTotalElements--查询的总记录数:"+page.getTotalElements());
        System.out.println("getTotalPages--查询的总页数:"+page.getTotalPages());
        System.out.println("getContent--当前页面的集合："+page.getContent());
        System.out.println("getNumber--当前第几页:"+page.getNumber() + 1);
        System.out.println("getNumberOfElements--查询的当前页面的记录数:"+page.getNumberOfElements());

    }




}

