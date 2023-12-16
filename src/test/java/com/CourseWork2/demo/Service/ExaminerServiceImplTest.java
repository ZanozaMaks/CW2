package com.CourseWork2.demo.Service;

import com.CourseWork2.demo.Entity.Question;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Collection;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ExaminerServiceImplTest {
    @Autowired
    private ExaminerService examinerService;
    @MockBean
    private QuestionService questionService;

    @Test
    void getQuestions_success() {
        int sum = 1;
        Question a1 = new Question("1", "11");
        Question a2 = new Question("1", "11");

        Collection<Question> questions = Set.of(a1, a2);

        when(questionService.getAll()).thenReturn(questions);
        when(questionService.getRandomQuestion()).thenReturn(a1);

        Collection<Question> expectedQuestions = Set.of(a1);
        Collection<Question> actualQuestions = examinerService.getQuestions(sum);

        assertEquals(expectedQuestions, actualQuestions);

        verify(questionService).getAll();
        verify(questionService).getRandomQuestion();

        assertEquals(sum, actualQuestions.size());
    }
}
