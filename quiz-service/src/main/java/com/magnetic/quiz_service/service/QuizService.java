package com.magnetic.quiz_service.service;



import com.magnetic.quiz_service.Model.QuestionWrapper;
import com.magnetic.quiz_service.Model.Quiz;
import com.magnetic.quiz_service.Model.Response;
import com.magnetic.quiz_service.feign.QuizInterface;
import com.magnetic.quiz_service.repo.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    QuizRepo quizRepo;
    @Autowired
    QuizInterface quizInterface;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        List<Integer> questions=quizInterface.getQuestionsForQuiz(category,numQ).getBody();

        Quiz quiz=new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionIds(questions);

        quizRepo.save(quiz);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(int id) {
        Quiz quiz=quizRepo.findById(id).get();
        List<Integer> questionIds=quiz.getQuestionIds();
        ResponseEntity<List<QuestionWrapper>> questions=quizInterface.getQuestionsFromId(questionIds);
        return questions;
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
        ResponseEntity<Integer> score=quizInterface.getScore(responses);
        return score;
    }
}
