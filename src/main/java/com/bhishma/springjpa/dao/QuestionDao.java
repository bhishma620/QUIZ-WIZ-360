package com.bhishma.springjpa.dao;

import com.bhishma.springjpa.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface QuestionDao extends JpaRepository<Question,Integer> {

    List<Question>findAllByCategory(String category);

    @Query(value = "SELECT * FROM question q WHERE q.category = :category ORDER BY rand() LIMIT :noQ",nativeQuery = true)
    List<Question> findRandomQuestionsByCategory(String category, int noQ);
}
