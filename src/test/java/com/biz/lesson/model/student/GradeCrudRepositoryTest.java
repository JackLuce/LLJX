package com.biz.lesson.model.student;

import com.biz.lesson.dao.student.StudentJpaRepository;
import com.biz.lesson.service.GradeService;
import com.biz.lesson.service.StudentService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 *
 **/
public class GradeCrudRepositoryTest {
    private ApplicationContext applicationContext = null;
    private GradeService gradeService = null;

    @Before
    public void  setup(){
        System.out.println("setup");
        applicationContext = new ClassPathXmlApplicationContext("classpath:application-content.xml");
        gradeService = applicationContext.getBean(GradeService.class);
        }

    @After
    public  void  tearDown(){
        applicationContext = null;
        System.out.println("teardown");
    }
    @Test
    public void testSave(){
        List<Grade> list = new ArrayList<Grade>();
        Grade grade = null;
        for (int i =1;i<=6;i++){
            grade = new Grade();
            grade.setGradeId(i);
            grade.setGradeName(i+"班");
            list.add(grade);
        }
        gradeService.save(list);
    }

    @Test
    public void testdeleteAll(){
        gradeService.deleteAll();
    }
}
