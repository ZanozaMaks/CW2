package com.CourseWork2.demo.Service;

import com.CourseWork2.demo.Entity.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int size);

}
