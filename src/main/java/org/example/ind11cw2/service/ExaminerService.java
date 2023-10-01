package org.example.ind11cw2.service;

import org.example.ind11cw2.model.Question;

import java.util.Collection;
import java.util.Collections;

public interface ExaminerService {

    Collection<Question> getQuestions(int amount);
}
