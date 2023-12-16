package com.CourseWork2.demo.Service;

import com.CourseWork2.demo.Entity.Question;
import com.CourseWork2.demo.Exception.ExaminerServiceException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int size) {

        if (questionService.getAll().size() < size)
            throw new ExaminerServiceException("запрошено большее количество вопросов, чем хранится в сервисе.");

        Collection<Question> result = new HashSet<>();
        while (result.size() < size) {
            result.add(questionService.getRandomQuestion());
        }
        return result;
    }
}
