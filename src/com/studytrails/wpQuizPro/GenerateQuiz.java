package com.studytrails.wpQuizPro;

public class GenerateQuiz {

	public static String createQuizInsert(QuizQuestion question) {
		StringBuilder questionInsert = new StringBuilder();
		question.setAnswer_data(generateAnswerData(question));
		questionInsert.append("insert into wp_wp_pro_quiz_question values(").append(question.getId()).append(",")
			.append(question.getQuiz_id()).append(",").append(question.getOnline()).append(",")
			.append(question.getSort()).append(",\"").append(question.getTitle()).append("\",")
			.append(question.getPoints()).append(",\"").append(question.getQuestion()).append("\",\"")
			.append(question.getCorrect_msg()).append("\",\"").append(question.getIncorrect_msg()).append("\",")
			.append(question.getCorrect_same_text()).append(",").append(question.getTip_enabled()).append(",\"")
			.append(question.getTip_msg()).append("\",\"").append(question.getAnswer_type()).append("\",")
			.append(question.getShow_points_in_box()).append(",").append(question.getAnswer_points_activated())
			.append(",\"").append(question.getAnswer_data()).append("\",").append(question.getCategory_id()).append(",")
			.append(question.getAnswer_points_diff_modus_activated()).append(",").append(question.getDisable_correct())
			.append(",").append(question.getMatrix_sort_answer_criteria_width()).append(");");
		return questionInsert.toString();
	}

	public static String generateAnswerData(QuizQuestion question) {
		StringBuilder answerData = new StringBuilder();
		String s1 = buildAnswer(question, 0);
		String s2 = buildAnswer(question, 1);
		String s3 = buildAnswer(question, 2);
		// String s4 = buildAnswer(question, 3);
		answerData.append("a:3:{").append(s1).append(s2).append(s3)
			./* append(s4). */append("}");
		return answerData.toString();
	}

	private static String buildAnswer(QuizQuestion question, int i) {
		String answer = "";
		if (i == 0)
			answer = question.answer1;
		else if (i == 1)
			answer = question.answer2;
		else if (i == 2)
			answer = question.answer3;
		else if (i == 3)
			answer = question.answer4;
		StringBuilder builder = new StringBuilder();
		builder.append("i:").append(i).append(";")
			.append("O:27:\\\"WpProQuiz_Model_AnswerTypes\\\":7:{s:10:\\\" * _answer\\\";s:").append(answer.length())
			.append(":\\\"").append(answer).append("\\\";")
			.append("s:8:\\\" * _html\\\";b:0;s:10:\\\" * _points\\\";i:1;s:11:\\\" * _correct\\\";b:")
			.append(i == question.correctAnswer ? 1 : 0).append(
				";s:14:\\\" * _sortString\\\";s:0:\\\"\\\";s:18:\\\" * _sortStringHtml\\\";b:0;s:10:\\\" * _mapper\\\";N;}");
		return builder.toString();
	}

	public static void main(String[] args) {
		QuizQuestion question = new QuizQuestion();
		System.out.println(GenerateQuiz.createQuizInsert(question));
	}
}
