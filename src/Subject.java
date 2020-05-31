import java.util.ArrayList;

public class Subject {
	private String subjectName;
	private ArrayList<Question> lstQuestion;
	
	public Subject() {
		
	}
	
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public ArrayList<Question> getLstQuestion() {
		return lstQuestion;
	}
	public void setLstQuestion(ArrayList<Question> lstQuestion) {
		this.lstQuestion = lstQuestion;
	}
	
}
