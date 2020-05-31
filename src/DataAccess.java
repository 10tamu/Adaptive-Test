import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class DataAccess {

	private HashMap<String, Subject> lstSubject;
	public ArrayList<Question> lstMathsDefaultQuestion = new ArrayList<Question>();
	public ArrayList<Question> lstMathsQuestionPaper = new ArrayList<Question>();

	public ArrayList<Question> lstImageQuestionPaper = new ArrayList<Question>();
	public ArrayList<Question> lstSpellingQuestionPaper = new ArrayList<Question>();
	public ArrayList<Question> lstListeningQuestionPaper = new ArrayList<Question>();
	public ArrayList<Question> lstWritingQuestionPaper = new ArrayList<Question>();

	public ArrayList<Question> lstImageDafaultQuestion = new ArrayList<Question>();
	public ArrayList<Question> lstSpellingDafaultQuestion = new ArrayList<Question>();
	public ArrayList<Question> lstListeningDafaultQuestion = new ArrayList<Question>();
	public ArrayList<Question> lstWritingDafaultQuestion = new ArrayList<Question>();

	public DataAccess() {
		lstSubject = new QuestionBank().GetQuestions();
		if (lstMathsDefaultQuestion.size() == 0) {
			lstMathsDefaultQuestion = this.GetQuestionsSubjectWise("Maths");
		}
		if (lstImageDafaultQuestion.size() == 0) {
			lstImageDafaultQuestion = this.GetQuestionsSubjectWise("Image");
		}
		if (lstSpellingDafaultQuestion.size() == 0) {
			 lstSpellingDafaultQuestion = this.GetQuestionsSubjectWise("Spelling");
		}
		if (lstListeningDafaultQuestion.size() == 0) {
			lstListeningDafaultQuestion = this.GetQuestionsSubjectWise("Listening");
		}
		if (lstWritingDafaultQuestion.size() == 0) {
			 lstWritingDafaultQuestion = this.GetQuestionsSubjectWise("Writing");
		}
	}

	public HashMap<String, Subject> getLstSubject() {
		return lstSubject;
	}

	public void setLstSubject(HashMap<String, Subject> lstSubject) {
		this.lstSubject = lstSubject;
	}

	public ArrayList<Question> GetQuestionsSubjectWise(String subject) {
		return lstSubject.get(subject).getLstQuestion();
	}

	public ArrayList<Question> updateQuestionBank(Collection<Question> col1, Collection<Question> col2) {
		ArrayList<Question> lstUpdatedQuesionBank = new ArrayList<Question>();

		Iterator<Question> iteratior = col1.iterator();

		while (iteratior.hasNext()) {
			if (col2.contains(iteratior.hasNext())) {
				iteratior.remove();
			}
		}

		lstUpdatedQuesionBank = (ArrayList<Question>) iteratior;
		return lstUpdatedQuesionBank;
	}

	public Question getQuestion(String subject) {

		ArrayList<Question> lstQuestions = new ArrayList<Question>();
		lstQuestions = this.GetQuestionsSubjectWise(subject);

		return getRandomQuestion(lstQuestions);
	}

	public Question getRandomQuestion(ArrayList<Question> lstQuestion) {
		Random objRandom = new Random();

		int index = objRandom.nextInt(lstQuestion.size());

		Question objRandomQuestion = lstQuestion.get(index);

		return objRandomQuestion;

	}

	public boolean isExamOver(String subject) {
		boolean flag = false;
		if (subject.equalsIgnoreCase("Maths")) {
			flag = lstMathsQuestionPaper.size() < 5 ? false : true;
		} else if (subject.equalsIgnoreCase("Image")) {
			flag = lstImageQuestionPaper.size() < 5 ? false : true;
		} else if (subject.equalsIgnoreCase("Spelling")) {
			flag = lstSpellingQuestionPaper.size() < 5 ? false : true;
		} else if (subject.equalsIgnoreCase("Listening")) {
			flag = lstListeningQuestionPaper.size() < 5 ? false : true;
		} else if (subject.equalsIgnoreCase("Writing")) {
			flag = lstWritingQuestionPaper.size() < 5 ? false : true;
		}
		return flag;
	}
	
	public boolean isLastQuestionOfExam(String subject) {
		boolean flag = false;
		if(subject.equalsIgnoreCase("Maths")) {
			flag = lstMathsQuestionPaper.size() == 4 ? true :false;
		}else if(subject.equalsIgnoreCase("Image")) {
			flag = lstImageQuestionPaper.size() == 4 ? true :false;
		} else if(subject.equalsIgnoreCase("Spelling")) {
			flag = lstSpellingQuestionPaper.size() == 4 ? true :false;
		}else if(subject.equalsIgnoreCase("Listening")) {
			flag = lstListeningQuestionPaper.size() == 4 ? true :false;
		}else if(subject.equalsIgnoreCase("Writing")) {
			flag = lstWritingQuestionPaper.size() == 4 ? true :false;
		}
		return flag;
	}

	public Question getNextQuestion(String subject, Question currentQuestion, int givenAnswer) {

		ArrayList<Question> lstDefaultQuestion = new ArrayList<Question>();

		if (subject.equals("Maths")) {
			lstMathsDefaultQuestion.remove(currentQuestion); // Remove Current Question from the list
			lstDefaultQuestion = lstMathsDefaultQuestion;
		} else if (subject.equals("Image")) {
			lstImageDafaultQuestion.remove(currentQuestion); // Remove Current Question from the list
			lstDefaultQuestion = lstImageDafaultQuestion;
		} else if (subject.equals("Spelling")) {
			lstSpellingDafaultQuestion.remove(currentQuestion); // Remove Current Question from the list
			lstDefaultQuestion = lstSpellingDafaultQuestion;
		} else if (subject.equals("Listening")) {
			lstListeningDafaultQuestion.remove(currentQuestion); // Remove Current Question from the list
			lstDefaultQuestion = lstListeningDafaultQuestion;
		} else if (subject.equals("Writing")) {
			lstWritingDafaultQuestion.remove(currentQuestion); // Remove Current Question from the list
			lstDefaultQuestion = lstWritingDafaultQuestion;
		}

		String currentQuestionDifficulty = currentQuestion.getDifficultyLevel();
		int correctAnswerOfCurrentQuestion = currentQuestion.getAnswerIndex();

		ArrayList<Question> lstQuestionsByDifficultyLavel = new ArrayList<Question>();

		for (Question q : lstDefaultQuestion) {
			if (correctAnswerOfCurrentQuestion == givenAnswer) {
				if (currentQuestionDifficulty == "tough") {
					if (q.getDifficultyLevel() == "tougher") {
						lstQuestionsByDifficultyLavel.add(q);
					}
				} else if (currentQuestionDifficulty == "tougher" || currentQuestionDifficulty == "toughest") {
					if (q.getDifficultyLevel() == "toughest") {
						lstQuestionsByDifficultyLavel.add(q);
					}
				}
			} else {
				if (currentQuestionDifficulty == "tough") {
					if (q.getDifficultyLevel() == "tough") {
						lstQuestionsByDifficultyLavel.add(q);
					}
				} else if (currentQuestionDifficulty == "tougher") {
					if (q.getDifficultyLevel() == "tough") {
						lstQuestionsByDifficultyLavel.add(q);
					}
				} else if (currentQuestionDifficulty == "toughest") {
					if (q.getDifficultyLevel() == "tougher") {
						lstQuestionsByDifficultyLavel.add(q);
					}
				}
			}
		}

		// lstQuestions.

		return getRandomQuestion(lstQuestionsByDifficultyLavel);
	}

	public void saveCurrentQuestion(String subject, Question currentQuestion, int givenAnswer, String givenAnswerText) {
		
		String currentQuestionDifficulty = currentQuestion.getDifficultyLevel();
		int correctAnswerOfCurrentQuestion = currentQuestion.getAnswerIndex();
		
		if(subject.equalsIgnoreCase("Maths") || subject.equalsIgnoreCase("Image") || subject.equalsIgnoreCase("Listening")) {
		if (correctAnswerOfCurrentQuestion == givenAnswer) {
			if(currentQuestionDifficulty.equalsIgnoreCase("Tough"))
			{
				currentQuestion.setObtainedMarks(2);
			}
			else if(currentQuestionDifficulty.equalsIgnoreCase("Tougher"))
			{
				currentQuestion.setObtainedMarks(5);
			}
			else if(currentQuestionDifficulty.equalsIgnoreCase("Toughest"))
			{
				currentQuestion.setObtainedMarks(10);
			}
		}
		else
		{
			currentQuestion.setObtainedMarks(0);
		}
		}
		else if(subject.equalsIgnoreCase("Spelling")) {
			
		Boolean isCorrectAnswer = false;	
		for(String option:currentQuestion.getLstOptions()) {
			if(option.equalsIgnoreCase(givenAnswerText))
			{
				isCorrectAnswer = true;
			}
		}
		if(isCorrectAnswer) {
			if(currentQuestion.isHintUsed()) {
				currentQuestion.setObtainedMarks(currentQuestion.getMarks()/2);
			}
			else
			{
				currentQuestion.setObtainedMarks(currentQuestion.getMarks());
			}
		}
		else
		{
			currentQuestion.setObtainedMarks(0);
		}
		}
		else if(subject.equalsIgnoreCase("Writing")) {
		if(checkWritingAnswer(currentQuestion,givenAnswerText) == 1)
		{
			currentQuestion.setObtainedMarks(currentQuestion.getMarks());
		}
		else
		{
			currentQuestion.setObtainedMarks(0);
		}
		}
		
		if (subject.equals("Maths")) {
			currentQuestion.setGivenAnswer(givenAnswer);
			lstMathsQuestionPaper.add(currentQuestion); // Add answered question into result sheet
		} else if (subject.equals("Image")) {
			currentQuestion.setGivenAnswer(givenAnswer);
			lstImageQuestionPaper.add(currentQuestion); // Add answered question into result sheet
		} else if (subject.equals("Spelling")) {
			currentQuestion.setGivenTextAnswer(givenAnswerText);
			lstSpellingQuestionPaper.add(currentQuestion); // Add answered question into result sheet
		} else if (subject.equals("Listening")) {
			currentQuestion.setGivenAnswer(givenAnswer);
			lstListeningQuestionPaper.add(currentQuestion); // Add answered question into result sheet
		} else if (subject.equals("Writing")) {
			currentQuestion.setGivenTextAnswer(givenAnswerText);
			lstWritingQuestionPaper.add(currentQuestion); // Add answered question into result sheet
		}
	}
	
	public ArrayList<Question> GetExamResult(String subject) {

		if (subject.equals("Maths")) {
		return	lstMathsQuestionPaper;
		} else if (subject.equals("Image")) {
		return	lstImageQuestionPaper; 
		} else if (subject.equals("Spelling")) {
		return	lstSpellingQuestionPaper; 
		} else if (subject.equals("Listening")) {
		return	lstListeningQuestionPaper; 
		} else {
		return	lstWritingQuestionPaper;
		}

	}
	
	public int[] getExamMarks(String subject)
	{
		int TotalMarks = 0;
		int ObtainedMarks = 0;
		int[] Marks = new int[2];
		
		if(subject == "Maths") {
			for(Question objExamQuestion : lstMathsQuestionPaper) {
				TotalMarks = TotalMarks + objExamQuestion.getMarks();
				ObtainedMarks = ObtainedMarks + objExamQuestion.getObtainedMarks();
			}
		}
		else if(subject == "Image") {
			for(Question objExamQuestion : lstImageQuestionPaper) {
				TotalMarks = TotalMarks + objExamQuestion.getMarks();
				ObtainedMarks = ObtainedMarks + objExamQuestion.getObtainedMarks();
			}
		}
		else if(subject == "Listening") {
			for(Question objExamQuestion : lstListeningQuestionPaper) {
				TotalMarks = TotalMarks + objExamQuestion.getMarks();
				ObtainedMarks = ObtainedMarks + objExamQuestion.getObtainedMarks();
			}
		}
		else if(subject == "Spelling") {
			for(Question objExamQuestion : lstSpellingQuestionPaper) {
				TotalMarks = TotalMarks + objExamQuestion.getMarks();
				ObtainedMarks = ObtainedMarks + objExamQuestion.getObtainedMarks();
			}
		}
		else if(subject == "Writing") {
			for(Question objExamQuestion : lstWritingQuestionPaper) {
				TotalMarks = TotalMarks + objExamQuestion.getMarks();
				ObtainedMarks = ObtainedMarks + objExamQuestion.getObtainedMarks();
			}
		}
		
		Marks[0] = ObtainedMarks;
		Marks[1] = TotalMarks;
		return Marks;
	}
	
	public void playAudioFile() {
		try {
			// Open an audio input stream.
			File url = new File("/Users/palaktank/Downloads/pronunciation_en_bracelet.wav");

			AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
			// Get a sound clip resource.
			Clip clip = AudioSystem.getClip();
			// Open audio clip and load samples from the audio input stream.
			clip.open(audioIn);
			clip.start();
		} catch (UnsupportedAudioFileException ee) {
			ee.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (LineUnavailableException e2) {
			e2.printStackTrace();
		}
	}

	public int checkSpellingAnswer(Question currentQuestion, String answer) {
		int isCorrect = 0;
		for (String strCorrectAnswer : currentQuestion.getLstOptions()) {
			if (answer.equalsIgnoreCase(strCorrectAnswer)) {
				isCorrect = 1;
			}
		}
		return isCorrect;
	}

	public int checkWritingAnswer(Question currentQuestion, String answer) {
		int isCorrect = 0;
		String[] strAnswers = answer.split(" ");
		for (String givenAnswer : strAnswers) {
			for (String strCorrectAnswer : currentQuestion.getLstOptions()) {
				if (givenAnswer.equalsIgnoreCase(strCorrectAnswer)) {
					isCorrect = 1;
				}
			}
		}
		return isCorrect;
	}
}
