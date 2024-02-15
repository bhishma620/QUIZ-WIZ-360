package com.bhishma.springjpa.service;

import com.bhishma.springjpa.dao.QuestionDao;
import com.bhishma.springjpa.dao.QuizDao;
import com.bhishma.springjpa.model.Question;
import com.bhishma.springjpa.model.QuestionWrapper;
import com.bhishma.springjpa.model.Quiz;
import com.bhishma.springjpa.model.Response;
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
   QuizDao quizDao;

    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<String> createQuiz(String category, int noQ, String title) {
      try {
          List<Question> questions = questionDao.findRandomQuestionsByCategory(category, noQ);

          Quiz quiz = new Quiz();
          quiz.setTitle(title);
          quiz.setQuestionList(questions);

          quizDao.save(quiz);

          return new ResponseEntity<>("Success", HttpStatus.CREATED);
      }
      catch(Exception e){
          e.getStackTrace();
      }
      return new ResponseEntity<>("Failed",HttpStatus.BAD_REQUEST);


    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(int id) {
try {
    Optional<Quiz> quiz = quizDao.findById(id);

    List<Question> questionsFromDb = quiz.get().getQuestionList();

    List<QuestionWrapper> questionForUser = new ArrayList<>();

    for (Question q : questionsFromDb) {
        QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
        questionForUser.add(qw);
    }

    return new ResponseEntity<>(questionForUser, HttpStatus.OK);

}
catch (Exception e){
    e.getStackTrace();
}
return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Integer> calculateResult(int id, List<Response> responses) {
try {
    Quiz quiz = quizDao.findById(id).get();

    List<Question> questions = quiz.getQuestionList();

    int correct = 0;
    int i = 0;

    for (Response response : responses) {

        if (response.getResponse().equals(questions.get(i).getRightAnswer()))
            correct++;

        i++;
    }
    return new ResponseEntity<>(correct, HttpStatus.OK);
}
catch (Exception e){
    e.getStackTrace();
}
return new ResponseEntity<>(0,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
