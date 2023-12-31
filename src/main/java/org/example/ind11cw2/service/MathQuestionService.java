package org.example.ind11cw2.service;

import org.example.ind11cw2.exceptions.NoQuestionsFound;
import org.example.ind11cw2.model.Question;
import org.example.ind11cw2.repository.JavaQuestionRepository;
import org.example.ind11cw2.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("math")
public class MathQuestionService implements QuestionService {

    private final Random random = new Random();

    private final QuestionRepository repository;

    public MathQuestionService(@Qualifier("mathRepository") QuestionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Question add(String question, String answer) {
        return repository.add(new Question(question, answer));
    }

    @Override
    public Question add(Question question) {
        return repository.add(question);
    }

    @Override
    public Question remove(Question question) {
        return repository.remove(question);
    }

    @Override
    public Collection<Question> getAll() {
        return repository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        var questions = repository.getAll();
        var randomIndex = random.nextInt(questions.size());
        int index = 0;
        var it = questions.iterator();
        while (it.hasNext()) {
            var question = it.next();
            if (index == randomIndex) {
                return question;
            }
            index++;
        }
        /*
        Укороченная версия
        for (Question question : questions) {
            if (index == randomIndex) {
                return question;
            }
            index++;
        }
         */
        throw new NoQuestionsFound();
    }
}
