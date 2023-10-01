package org.example.ind11cw2.controller;

import org.example.ind11cw2.model.Question;
import org.example.ind11cw2.service.MathQuestionService;
import org.example.ind11cw2.service.QuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam/math")
public class MathQuestionController {

    private final QuestionService questionService;

    public MathQuestionController(MathQuestionService questionService) {
        this.questionService = questionService;
    }
    // localhost:8080/exam/java/add?question=foo
    @GetMapping("/add")
    public Question add(@RequestParam String question, @RequestParam String answer) {
        return questionService.add(question, answer);
    }

    @GetMapping("/remove")
    public Question remove(@RequestParam String question, @RequestParam String answer) {
        return questionService.remove(new Question(question, answer));
    }

    @GetMapping()
    public Collection<Question> all() {
        return questionService.getAll();
    }
}
