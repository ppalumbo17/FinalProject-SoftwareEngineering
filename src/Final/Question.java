package Final;

import java.util.ArrayList;

public class Question {
	private String question;
	private ArrayList<Answer> answers;
	
	
	
	public Question(String question, ArrayList<Answer> answers) {
		super();
		this.question = question;
		this.answers = answers;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public ArrayList<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(ArrayList<Answer> answers) {
		this.answers = answers;
	}
	
	
}
