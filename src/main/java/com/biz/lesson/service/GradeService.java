package com.biz.lesson.service;

import com.biz.lesson.dao.student.GradeCrudRepository;
import com.biz.lesson.dao.student.GradeRepository;
import com.biz.lesson.model.student.Grade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * 班级管理
 **/
@Service
public class GradeService {

    @Autowired
    private GradeRepository gradeRepository;

    @Autowired
    private GradeCrudRepository gradeCrudRepository;

    @Transactional
    public void save(List<Grade> gradeList){
        gradeCrudRepository.save(gradeList);
    }

    @Transactional
    public void deleteAll(){
        gradeCrudRepository.deleteAll();
    }

}
