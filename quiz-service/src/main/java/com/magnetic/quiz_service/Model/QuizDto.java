package com.magnetic.quiz_service.Model;

import lombok.Data;

//data transfer object
@Data
public class QuizDto {
    String categoryName;
    Integer numQuestions;
    String title;

}
