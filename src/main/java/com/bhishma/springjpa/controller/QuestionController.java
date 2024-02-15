package com.bhishma.springjpa.controller;


import com.bhishma.springjpa.model.Question;
import com.bhishma.springjpa.service.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {
    @Autowired
    QuestionsService questionsService;
    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){

        return questionsService.getAllQuestions();

    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category){
        return questionsService.getQuestionsByCategory(category);
    }

    @PostMapping("add")
    public  ResponseEntity<String> addQuestion(@RequestBody Question question){
        return questionsService.addQuestion(question);
    }



}
