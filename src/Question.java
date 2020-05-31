public class Question {
	private int questionID;
	private String question;
	private String[] lstOptions; // change this to enum 
	private int answerIndex;
	private int marks;
	private String difficultyLevel; // change this to enum 
	private int obtainedMarks;
	private String filePath;
	private boolean isHintUsed;
	private int givenAnswer;
	private String givenTextAnswer;

	public Question() {
		
	}

	public Question(int questionID, String question, String[] lstOptions, int answerIndex, int marks,
			String difficultyLevel, int obtainedMarks, String filePath) {
		super();
		this.questionID = questionID;
		this.question = question;
		this.lstOptions = lstOptions;
		this.answerIndex = answerIndex;
		this.marks = marks;
		this.difficultyLevel = difficultyLevel;
		this.obtainedMarks = obtainedMarks;
		this.filePath = filePath;
		//this.objDataAccess = dataAccess;
	}

	public int getQuestionID() {
		return questionID;
	}

	public void setQuestionID(int questionID) {
		this.questionID = questionID;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String[] getLstOptions() {
		return lstOptions;
	}

	public void setLstOptions(String[] lstOptions) {
		this.lstOptions = lstOptions;
	}

	public int getAnswerIndex() {
		return answerIndex;
	}

	public void setAnswerIndex(int answerIndex) {
		this.answerIndex = answerIndex;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public String getDifficultyLevel() {
		return difficultyLevel;
	}

	public void setDifficultyLevel(String difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}
	public int getObtainedMarks() {
		return obtainedMarks;
	}

	public void setObtainedMarks(int obtainedMarks) {
		this.obtainedMarks = obtainedMarks;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	public boolean isHintUsed() {
		return isHintUsed;
	}

	public void setHintUsed(boolean isHintUsed) {
		this.isHintUsed = isHintUsed;
	}
	
	public int getGivenAnswer() {
		return givenAnswer;
	}

	public void setGivenAnswer(int givenAnswer) {
		this.givenAnswer = givenAnswer;
	}

	public String getGivenTextAnswer() {
		return givenTextAnswer;
	}

	public void setGivenTextAnswer(String givenTextAnswer) {
		this.givenTextAnswer = givenTextAnswer;
	}
}
