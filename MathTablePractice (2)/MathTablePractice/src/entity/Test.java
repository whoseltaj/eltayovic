package entity;

public class Test {
	
	
	private int student_id;
	
	private String question;
	
	private boolean answerCheck;

	public Test( int student_id, String question, boolean answerCheck) {
		super();
		this.student_id = student_id;
		this.question = question;
		this.answerCheck = answerCheck;
	}

	public Test() {
		super();
	}

	
	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public boolean isAnswerCheck() {
		return answerCheck;
	}

	public void setAnswerCheck(boolean answerCheck) {
		this.answerCheck = answerCheck;
	}
	
	

}
