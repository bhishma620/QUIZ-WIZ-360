package com.bhishma.springjpa.controller;

import com.bhishma.springjpa.model.Question;
import com.bhishma.springjpa.model.QuestionWrapper;
import com.bhishma.springjpa.model.Response;
import com.bhishma.springjpa.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("quiz")
@RestController
public class QuizController {
    @Autowired
    QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category,@RequestParam int noQ,@RequestParam String title){
        return quizService.createQuiz(category,noQ,title);
    }

    @GetMapping("get/{id}")
    public  ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable int id){
        return quizService.getQuizQuestions(id);
    }

    @PostMapping("submit/{id}")

    public ResponseEntity<Integer> submitQuiz(@PathVariable int id,@RequestBody List<Response> responses){
       return quizService.calculateResult(id,responses);
    }
}

