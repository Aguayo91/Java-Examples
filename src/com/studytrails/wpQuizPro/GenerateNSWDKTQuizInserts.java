package com.studytrails.wpQuizPro;

public class GenerateNSWDKTQuizInserts {
	public static void main(String[] args) {
		GenerateNSWDKTQuizInserts gen = new GenerateNSWDKTQuizInserts();
		QuizQuestion question = new QuizQuestion();
		question.setQuestion("Question1");
		question.setTitle("Test Question");
		question.setCategory_id(3);
		question.setAnswer1("answer1");
		question.setAnswer2("answer2");
		question.setAnswer3("answer3");
//		question.setAnswer4("answer4");
		question.setAnswer_type("multiple");
		question.setCorrectAnswer(1);
		question.setId(161);
		question.setQuiz_id(2);
		question.setOnline(1);
//		question.setSort(1);
		question.setPoints(1);
		question.setMatrix_sort_answer_criteria_width(20);
		System.out.println(GenerateQuiz.createQuizInsert(question));

	}
}
