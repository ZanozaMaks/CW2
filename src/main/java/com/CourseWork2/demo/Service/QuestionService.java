package com.CourseWork2.demo.Service;

import com.CourseWork2.demo.Entity.Question;

import java.util.Collection;

public interface QuestionService {

    Question add (String question, String answer);
    Question add (Question question);
    Question remove (String question, String answer);
    Collection <Question> getAll();
    Question getRandomQuestion();
}
