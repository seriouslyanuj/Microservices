package com.magnetic.question_service.repo;

import com.magnetic.question_service.Model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepo extends JpaRepository<Question,Integer> {

    List<Question> findByCategory(String Category);
    @Query(value="SELECT q.id FROM question q WHERE q.category =?1 ORDER BY RANDOM() LIMIT ?2",nativeQuery = true)
    List<Integer> findRandomQuestionsByCategory(String category, int numQ);
}
