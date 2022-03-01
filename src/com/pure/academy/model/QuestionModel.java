package com.pure.academy.model;

import java.util.HashMap;
import java.util.Map;

public class QuestionModel {
	private String actualQuestion;
	private Map<String, Boolean> answerMap = new HashMap();

	public String getActualQuestion() {
		return actualQuestion;
	}
	public void setActualQuestion(String actualQuestion) {
		this.actualQuestion = actualQuestion;
	}


	public Map<String, Boolean> getAnswerMap() {
		return answerMap;
	}
	public void setAnswerMap(Map<String, Boolean> answerMap) {
		this.answerMap = answerMap;
	}

    public void addAnswer(String answer, boolean isCorrect) {
		answerMap.put(answer, Boolean.valueOf(isCorrect));
	}

}
