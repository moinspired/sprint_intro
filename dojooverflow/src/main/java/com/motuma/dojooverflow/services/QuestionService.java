package com.motuma.dojooverflow.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.motuma.dojooverflow.models.Question;
import com.motuma.dojooverflow.repositories.QuestionRepository;

@Service
public class QuestionService {
	private QuestionRepository questionRepo;
	
	public QuestionService(QuestionRepository questionRepo) {
		this.questionRepo = questionRepo;
	}
	
	public List<Question> getAllQuestions(){
		return (List<Question>) questionRepo.findAll();
	}
	
	public Question getQuestion(Long id) {
		return questionRepo.findOne(id);
	}
	public void addQuestion(Question question) {
		questionRepo.save(question);
	}
}
