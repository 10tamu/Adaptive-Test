package Models;


public class Student {
	private String StudentID;
	private String Name;
	private String SchoolName;
	private boolean isTermsAgreed;
	private int tempPIN;
	
	public String getStudentID() {
		return StudentID;
	}
	public void setStudentID(String studentID) {
		StudentID = studentID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getSchoolName() {
		return SchoolName;
	}
	public void setSchoolName(String schoolName) {
		SchoolName = schoolName;
	}
	public boolean isTermsAgreed() {
		return isTermsAgreed;
	}
	public void setTermsAgreed(boolean isTermsAgreed) {
		this.isTermsAgreed = isTermsAgreed;
	}
	public int getTempPIN() {
		return tempPIN;
	}
	public void setTempPIN(int tempPIN) {
		this.tempPIN = tempPIN;
	}
	
}
