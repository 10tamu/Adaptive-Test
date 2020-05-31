import java.util.ArrayList;
import java.util.HashMap;

public class QuestionBank {
    private HashMap<String, Subject> lstSubjects;
    private ArrayList<Question> lstMathsQuestions;
    private ArrayList<Question> lstImageQuestions;
    private ArrayList<Question> lstSpellingQuestions;
    private ArrayList<Question> lstListeningQuestions;
    private ArrayList<Question> lstWritingQuestions;
    

	public HashMap<String, Subject> getLstSubjects() {
		return lstSubjects;
	}

	public void setLstSubjects(HashMap<String, Subject> lstSubjects) {
		this.lstSubjects = lstSubjects;
	}

	public HashMap<String, Subject> GetQuestions(){
		Subject objMaths = new Subject();
		Subject objImage = new Subject(); 
		Subject objListening = new Subject();
		Subject objSpelling = new Subject();
		Subject objWriting = new Subject();
		
		lstSubjects = new HashMap<>();
		lstMathsQuestions = new ArrayList<Question>();
		lstImageQuestions = new ArrayList<Question>();
		lstSpellingQuestions =new ArrayList<Question>();
		lstListeningQuestions = new ArrayList<Question>();
		lstWritingQuestions =new ArrayList<Question>();

		//Start of Maths Questions
		String[] lstoptions1 = { "100", "300", "2" ,"5"};
		Question objQuestion1 = new Question(1,"1 + 1 = This is tough question ", lstoptions1, 2, 2, "tough", 0, "");
		lstMathsQuestions.add(objQuestion1);
	
		String[] lstoptions2 = { "10", "30", "2" ,"5"};
		Question objQuestion2 = new Question(2,"1 + 2 = This is tougher question", lstoptions2, 1, 5, "tougher", 0, "");
		lstMathsQuestions.add(objQuestion2);
		
		String[] lstoptions3 = { "1", "30", "2" ,"5"};
		Question objQuestion3 = new Question(3,"1 + 4 = This is toughest question", lstoptions3, 3, 10, "toughest", 0, "");
		lstMathsQuestions.add(objQuestion3);
		
		String[] lstoptions4 = { "1", "3", "4" ,"50"};
		Question objQuestion4 = new Question(4,"5 - 1 = This is tough question", lstoptions4, 2, 2, "tough", 0, "");
		lstMathsQuestions.add(objQuestion4);
		
		String[] lstoptions5 = { "1", "3", "20" ,"5"};
		Question objQuestion5 = new Question(5," 5 - 2 = This is tougher question", lstoptions5, 1, 5, "tougher", 0, "");
		lstMathsQuestions.add(objQuestion5);
		
		String[] lstoptions6 = { "1", "300", "2" ,"5"};
		Question objQuestion6 = new Question(6," 5 - 4 = This is toughest question 6", lstoptions6, 0, 10, "toughest", 0, "");
		lstMathsQuestions.add(objQuestion6);
		
		String[] lstoptions7 = { "1", "3", "2" ,"549"};
		Question objQuestion7 = new Question(7,"1 + 1 = This is tough question 7", lstoptions7, 2, 2, "tough", 0, "");
		lstMathsQuestions.add(objQuestion7);
	
		String[] lstoptions8 = { "1", "3", "2324" ,"5"};
		Question objQuestion8 = new Question(8,"1 + 2 = This is tougher question 8", lstoptions8, 1, 5, "tougher", 0, "");
		lstMathsQuestions.add(objQuestion8);
		
		String[] lstoptions9 = { "1", "32342", "2" ,"5"};
		Question objQuestion9 = new Question(9,"1 + 4 = This is toughest question 9", lstoptions9, 3, 10, "toughest", 0, "");
		lstMathsQuestions.add(objQuestion9);
		
		String[] lstoptions10 = { "1", "3", "4" ,"522"};
		Question objQuestion10 = new Question(10,"5 - 1 = This is tough question 10", lstoptions10, 2, 2, "tough", 0, "");
		lstMathsQuestions.add(objQuestion10);
		
		String[] lstoptions11 = { "1", "3", "200" ,"5"};
		Question objQuestion11 = new Question(11," 5 - 2 = This is tougher question 111", lstoptions11, 1, 5, "tougher", 0, "");
		lstMathsQuestions.add(objQuestion11);
		
		String[] lstoptions12 = { "1", "301", "2" ,"5"};
		Question objQuestion12 = new Question(12," 5 - 4 = This is toughest question 12", lstoptions12, 0, 10, "toughest", 0, "");
		lstMathsQuestions.add(objQuestion12);
		
		String[] lstoptions13 = { "1", "3", "4" ,"500"};
		Question objQuestion13 = new Question(13,"5 - 1 = This is tough question 13", lstoptions13, 2, 2, "tough", 0, "");
		lstMathsQuestions.add(objQuestion13);
		
		String[] lstoptions14 = { "1", "3", "2" ,"5345"};
		Question objQuestion14 = new Question(14," 5 - 2 = This is tougher question 14", lstoptions14, 1, 5, "tougher", 0, "");
		lstMathsQuestions.add(objQuestion14);
		
		String[] lstoptions15 = { "1", "310", "2" ,"5"};
		Question objQuestion15 = new Question(15," 5 - 4 = This is toughest question 15", lstoptions15, 0, 10, "toughest", 0, "");
		lstMathsQuestions.add(objQuestion15);
		
		objMaths.setSubjectName("Maths");
		objMaths.setLstQuestion(lstMathsQuestions);
		
		lstSubjects.put(objMaths.getSubjectName(), objMaths);
		
		//End of Maths Questions
		
		//Start of Image Questions
		
		String[] lstoptions101 = { "1,2", "1,3", "2,3" ,"None"};
	    Question objQuestion101 = new Question(1,"Click on similar looking image 111", lstoptions101, 1, 2, "tough", 0, "fog.jpg//90.jpg//fog.jpg");
	    lstImageQuestions.add(objQuestion101);
	
		String[] lstoptions102 = { "1", "2", "3" ,"None"};
		Question objQuestion102 = new Question(1,"Click on hazier image 21", lstoptions102, 1, 5, "tougher", 0, "forest.jpg//conifers.jpg//seth-macey.jpg");
		lstImageQuestions.add(objQuestion102);
		
		String[] lstoptions103 = { "1", "3", "2" ,"None"};
		Question objQuestion103 = new Question(1,"Click on haziest image 31", lstoptions103, 2, 10, "toughest", 0, "fog.jpg//forest.jpg//seth-macey.jpg");
		lstImageQuestions.add(objQuestion103);
		
		String[] lstoptions104 = { "1,3", "2,3", "1,2" ,"None"};
		Question objQuestion104 = new Question(1,"Click on similar looking image 41", lstoptions104, 0, 2, "tough", 0, "forest.jpg//conifers.jpg//forest.jpg");
		lstImageQuestions.add(objQuestion104);
		
		String[] lstoptions105 = { "1", "3", "2" ,"None"};
		Question objQuestion105 = new Question(1,"Click on hazier image 51", lstoptions105, 1, 5, "tougher", 0, "simon-matzinger.jpg//conifers.jpg//seth-macey.jpg");
		lstImageQuestions.add(objQuestion105);
		
		String[] lstoptions106 = { "1", "2", "3" ,"None"};
		Question objQuestion106 = new Question(1,"Click on haziest image 61", lstoptions106, 0, 10, "toughest", 0, "forest.jpg//fog.jpg//seth-macey.jpg");
		lstImageQuestions.add(objQuestion106);
		
		String[] lstoptions107 = { "1,2", "1,3", "2,3" ,"None"};
	    Question objQuestion107 = new Question(1,"Click on similar looking image 1107", lstoptions107, 0, 2, "tough", 0, "90.jpg//90.jpg//fog.jpg");
	    lstImageQuestions.add(objQuestion107);
	
		String[] lstoptions108 = { "1", "2", "3" ,"None"};
		Question objQuestion108 = new Question(1,"Click on hazier image 21", lstoptions108, 0, 5, "tougher", 0, "forest.jpg//seth-macey.jpg//conifers.jpg");
		lstImageQuestions.add(objQuestion108);
		
		String[] lstoptions109 = { "1", "3", "2" ,"None"};
		Question objQuestion109 = new Question(1,"Click on haziest image 31", lstoptions109, 1, 10, "toughest", 0, "fog.jpg//seth-macey.jpg//forest.jpg");
		lstImageQuestions.add(objQuestion109);
		
		String[] lstoptions110 = { "1,3", "2,3", "1,2" ,"None"};
		Question objQuestion110 = new Question(1,"Click on similar looking image 41", lstoptions110, 3, 2, "tough", 0, "conifers.jpg//seth-macey.jpg//forest.jpg");
		lstImageQuestions.add(objQuestion110);
		
		String[] lstoptions111 = { "1", "3", "2" ,"None"};
		Question objQuestion111 = new Question(1,"Click on hazier image 51", lstoptions111, 0, 5, "tougher", 0, "seth-macey.jpg//simon-matzinger.jpg//conifers.jpg");
		lstImageQuestions.add(objQuestion111);
		
		String[] lstoptions112 = { "1", "2", "3" ,"None"};
		Question objQuestion112 = new Question(1,"Click on haziest image 61", lstoptions112, 1, 10, "toughest", 0, "fog.jpg//forest.jpg//seth-macey.jpg");
		lstImageQuestions.add(objQuestion112);
		
		String[] lstoptions113 = { "1,3", "2,3", "1,2" ,"None"};
		Question objQuestion113 = new Question(1,"Click on similar looking image 41", lstoptions113, 3, 2, "tough", 0, "fog.jpg//seth-macey.jpg//simon-matzinger.jpg");
		lstImageQuestions.add(objQuestion113);
		
		String[] lstoptions114 = { "1", "3", "2" ,"None"};
		Question objQuestion114 = new Question(1,"Click on hazier image 51", lstoptions114, 2, 5, "tougher", 0, "simon-matzinger.jpg//seth-macey.jpg//conifers.jpg");
		lstImageQuestions.add(objQuestion114);
		
		String[] lstoptions115 = { "1", "2", "3" ,"None"};
		Question objQuestion115 = new Question(1,"Click on haziest image 61", lstoptions115, 2, 10, "toughest", 0, "fog.jpg//seth-macey.jpg//forest.jpg");
		lstImageQuestions.add(objQuestion115);
		
		objImage.setSubjectName("Image");
		objImage.setLstQuestion(lstImageQuestions);
		
		lstSubjects.put(objImage.getSubjectName(), objImage);
		
		//End of Image Questions
		
		//Start of Spelling Questions
		
		String[] lstspellingoptions1 = { "Gorgeous", "Glowing", "Greeting" ,"Genuine"};
	    Question objSpellingQuestion1 = new Question(1,"Write down positive word starting with G.", lstspellingoptions1, 1, 2, "tough", 0, "");
	    lstSpellingQuestions.add(objSpellingQuestion1);
	
		String[] lstspellingoptions2 = { "Zealously", "Zestfully", "Zibeline" ,"Zeniness"};
		Question objSpellingQuestion2 = new Question(2,"Write down positive word starting with Z.", lstspellingoptions2, 1, 5, "tougher", 0, "");
		lstSpellingQuestions.add(objSpellingQuestion2);
		
		String[] lstspellingoptions3 = { "Genuine", "Gamesome", "Gentle" ,"Godlike"};
		Question objSpellingQuestion3 = new Question(3,"Write down positive word starting with G and ending with E.", lstspellingoptions3, 1, 10, "toughest", 0, "");
		lstSpellingQuestions.add(objSpellingQuestion3);
		
		String[] lstspellingoptions4 = { "Jocularly", "Judiciously", "Jawdropping" ,"Justified"};
		Question objSpellingQuestion4 = new Question(4,"Write down positive word starting with J.", lstspellingoptions4, 1, 2, "tough", 0, "");
		lstSpellingQuestions.add(objSpellingQuestion4);
		
		String[] lstspellingoptions5 = { "Justice", "Joysome", "Jubiliate" ,"Jocose"};
		Question objSpellingQuestion5 = new Question(5,"Write down positive word starting with J and ending with E.", lstspellingoptions5, 1, 5, "tougher", 0, "");
		lstSpellingQuestions.add(objSpellingQuestion5);
		
		String[] lstspellingoptions6 = { "Zibeline", "Zegedine", "Zowie" ,"Zestforlife"};
		Question objSpellingQuestion6 = new Question(6,"Write down positive word starting with Z and ending with E.", lstspellingoptions6, 1, 10, "toughest", 0, "");
		lstSpellingQuestions.add(objSpellingQuestion6);
		
		String[] lstspellingoptions7 = { "Gorgeous", "Glowing", "Greeting" ,"Genuine"};
	    Question objSpellingQuestion7 = new Question(7,"Write down positive word starting with G.", lstspellingoptions7, 1, 2, "tough", 0, "");
	    lstSpellingQuestions.add(objSpellingQuestion7);
	
		String[] lstspellingoptions8 = { "Zealously", "Zestfully", "Zibeline" ,"Zeniness"};
		Question objSpellingQuestion8 = new Question(8,"Write down positive word starting with Z.", lstspellingoptions8, 1, 5, "tougher", 0, "");
		lstSpellingQuestions.add(objSpellingQuestion8);
		
		String[] lstspellingoptions9 = { "Genuine", "Gamesome", "Gentle" ,"Godlike"};
		Question objSpellingQuestion9 = new Question(9,"Write down positive word starting with G and ending with E.", lstspellingoptions9, 1, 10, "toughest", 0, "");
		lstSpellingQuestions.add(objSpellingQuestion9);
		
		String[] lstspellingoptions10 = { "Jocularly", "Judiciously", "Jawdropping" ,"Justified"};
		Question objSpellingQuestion10 = new Question(10,"Write down positive word starting with J.", lstspellingoptions10, 1, 2, "tough", 0, "");
		lstSpellingQuestions.add(objSpellingQuestion10);
		
		String[] lstspellingoptions11 = { "Justice", "Joysome", "Jubiliate" ,"Jocose"};
		Question objSpellingQuestion11 = new Question(11,"Write down positive word starting with J and ending with E.", lstspellingoptions11, 1, 5, "tougher", 0, "");
		lstSpellingQuestions.add(objSpellingQuestion11);
		
		String[] lstspellingoptions12 = { "Zibeline", "Zegedine", "Zowie" ,"Zestforlife"};
		Question objSpellingQuestion12 = new Question(12,"Write down positive word starting with Z and ending with E.", lstspellingoptions12, 1, 10, "toughest", 0, "");
		lstSpellingQuestions.add(objSpellingQuestion12);
		
		String[] lstspellingoptions13 = { "Genuine", "Gamesome", "Gentle" ,"Godlike"};
		Question objSpellingQuestion13 = new Question(13,"Write down positive word starting with G and ending with E.", lstspellingoptions13, 1, 10, "toughest", 0, "");
		lstSpellingQuestions.add(objSpellingQuestion13);
		
		String[] lstspellingoptions14 = { "Jocularly", "Judiciously", "Jawdropping" ,"Justified"};
		Question objSpellingQuestion14 = new Question(14,"Write down positive word starting with J.", lstspellingoptions14, 1, 2, "tough", 0, "");
		lstSpellingQuestions.add(objSpellingQuestion14);
		
		String[] lstspellingoptions15 = { "Justice", "Joysome", "Jubiliate" ,"Jocose"};
		Question objSpellingQuestion15 = new Question(15,"Write down positive word starting with J and ending with E.", lstspellingoptions15, 1, 5, "tougher", 0, "");
		lstSpellingQuestions.add(objSpellingQuestion15);
		
		objSpelling.setSubjectName("Spelling");
		objSpelling.setLstQuestion(lstSpellingQuestions);
		
		lstSubjects.put(objSpelling.getSubjectName(), objSpelling);
		
		//End of Spelling Questions
		
		//Start of Listening Questions
		
		String[] lstListeningoptions1 = {"Morning", "Afternoon", "Evening", "Night"};
	    Question objListeningQuestion1 = new Question(1,"Select the correct option after listening the question.", lstListeningoptions1, 1, 2, "tough", 0, "1.wav");
	    lstListeningQuestions.add(objListeningQuestion1);
	
		String[] lstListeningoptions2 = {"The giraffe", "The lion", "The Tiger", "The Kangaroo"};
		Question objListeningQuestion2 = new Question(1,"Select the correct option after listening the question.", lstListeningoptions2, 0, 5, "tougher", 0, "2.wav");
		lstListeningQuestions.add(objListeningQuestion2);
		
		String[] lstListeningoptions3 = {"H2SO5", "H2SO3", "H2O", "H2SO4"};
		Question objListeningQuestion3 = new Question(1,"Select the correct option after listening the question.", lstListeningoptions3, 2, 10, "toughest", 0, "3.wav");
		lstListeningQuestions.add(objListeningQuestion3);
		
		String[] lstListeningoptions4 = {"Mother", "Father", "Daughter", "Aunt" };
		Question objListeningQuestion4 = new Question(1,"Select the correct option after listening the question.", lstListeningoptions4, 3, 2, "tough", 0, "4.wav");
		lstListeningQuestions.add(objListeningQuestion4);
		
		String[] lstListeningoptions5 = { "Green", "Red", "Yellow", "Gray"};
		Question objListeningQuestion5 = new Question(1,"Select the correct option after listening the question.", lstListeningoptions5, 1, 5, "tougher", 0, "5.wav");
		lstListeningQuestions.add(objListeningQuestion5);
		
		String[] lstListeningoptions6 = {"Kidney", "Heart", "Nose", "Lungs"};
		Question objListeningQuestion6 = new Question(1,"Select the correct option after listening the question.", lstListeningoptions6, 3, 10, "toughest", 0, "6.wav");
		lstListeningQuestions.add(objListeningQuestion6);
		
		String[] lstListeningoptions7 = {"USA", "Australia", "Canada", "Russia" };
	    Question objListeningQuestion7 = new Question(1,"Select the correct option after listening the question.", lstListeningoptions7, 3, 2, "tough", 0, "7.wav");
	    lstListeningQuestions.add(objListeningQuestion7);
	
		String[] lstListeningoptions8 = {"India", "China", "USA", "Canada"};
		Question objListeningQuestion8 = new Question(1,"Select the correct option after listening the question.", lstListeningoptions8, 1, 5, "tougher", 0, "8.wav");
		lstListeningQuestions.add(objListeningQuestion8);
		
		String[] lstListeningoptions9 = {"Oxygen", "Nitrogen", "Carbon Dioxide", "Argon"};
		Question objListeningQuestion9 = new Question(1,"Select the correct option after listening the question.", lstListeningoptions9, 0, 10, "toughest", 0, "9.wav");
		lstListeningQuestions.add(objListeningQuestion9);
		
		String[] lstListeningoptions10 = {"Oxygen", "Nitrogen", "Carbon Dioxide", "Argon"};
		Question objListeningQuestion10 = new Question(1,"Select the correct option after listening the question.", lstListeningoptions10, 0, 2, "tough", 0, "10.wav");
		lstListeningQuestions.add(objListeningQuestion10);
		
		String[] lstListeningoptions11 = {"Oxygen", "Nitrogen", "Carbon Dioxide", "Argon"};
		Question objListeningQuestion11 = new Question(1,"Select the correct option after listening the question.", lstListeningoptions11, 2, 5, "tougher", 0, "11.wav");
		lstListeningQuestions.add(objListeningQuestion11);
		
		String[] lstListeningoptions12 = {"Restaurant", "Hotel", "PlayGround", "Theatre"};
		Question objListeningQuestion12 = new Question(1,"Select the correct option after listening the question.", lstListeningoptions12, 3, 10, "toughest", 0, "12.wav");
		lstListeningQuestions.add(objListeningQuestion12);
		
		String[] lstListeningoptions13 = {"Headphone", "Microscope", "Compass", "Microphone"};
	    Question objListeningQuestion13 = new Question(1,"Select the correct option after listening the question.", lstListeningoptions13, 2, 2, "tough", 0, "13.wav");
	    lstListeningQuestions.add(objListeningQuestion13);
	
		String[] lstListeningoptions14 = {"Storybook", "Biographical Book", "Magazine", "Newspaper"};
		Question objListeningQuestion14 = new Question(1,"Select the correct option after listening the question.", lstListeningoptions14, 3, 5, "tougher", 0, "14.wav");
		lstListeningQuestions.add(objListeningQuestion14);
		
		String[] lstListeningoptions15 = {"Democracy", "Monarchy", "Oligarchy", "Aristocracy"};
		Question objListeningQuestion15 = new Question(1,"Select the correct option after listening the question.", lstListeningoptions15, 0, 10, "toughest", 0, "15.wav");
		lstListeningQuestions.add(objListeningQuestion15);
		
		objListening.setSubjectName("Listening");
		objListening.setLstQuestion(lstListeningQuestions);
		
		lstSubjects.put(objListening.getSubjectName(), objListening);	
		
		//End of Listening Questions
		
		//Start of Writing Questions
		
		String[] lstWritingoptions1 = { ".", ",", "a" ,"an"};
	    Question objWritingQuestion1 = new Question(1,"Please write down a simple sentence.", lstWritingoptions1, 1, 2, "tough", 0, "");
	    lstWritingQuestions.add(objWritingQuestion1);
	
		String[] lstWritingoptions2 = { "and", "the", "because" ,"so"};
		Question objWritingQuestion2 = new Question(1,"Please write down a compound sentence.", lstWritingoptions2, 1, 5, "tougher", 0, "");
		lstWritingQuestions.add(objWritingQuestion2);
		
		String[] lstWritingoptions3 = { "However", "Moreover", "Futhermore" ,"Eventually"};
		Question objWritingQuestion3 = new Question(1,"Please write down a complex sentence.", lstWritingoptions3, 1, 10, "toughest", 0, "");
		lstWritingQuestions.add(objWritingQuestion3);
		
		String[] lstWritingoptions4 = { ".", ",", "a" ,"an"};
		Question objWritingQuestion4 = new Question(1,"Please write down a simple sentence.", lstWritingoptions4, 1, 2, "tough", 0, "");
		lstWritingQuestions.add(objWritingQuestion4);
		
		String[] lstWritingoptions5 = { "and", "the", "because" ,"so"};
		Question objWritingQuestion5 = new Question(1,"Please write down a compound sentence.", lstWritingoptions5, 1, 5, "tougher", 0, "");
		lstWritingQuestions.add(objWritingQuestion5);
		
		String[] lstWritingoptions6 = { "However", "Moreover", "Futhermore" ,"Eventually"};
		Question objWritingQuestion6 = new Question(1,"Please write down a complex sentence.", lstWritingoptions6, 1, 10, "toughest", 0, "");
		lstWritingQuestions.add(objWritingQuestion6);
		
		String[] lstWritingoptions7 = { ".", ",", "a" ,"an"};
	    Question objWritingQuestion7 = new Question(1,"Please write down a simple sentence.", lstWritingoptions7, 1, 2, "tough", 0, "");
	    lstWritingQuestions.add(objWritingQuestion7);
	
		String[] lstWritingoptions8 = { "and", "the", "because" ,"so"};
		Question objWritingQuestion8 = new Question(1,"Please write down a compound sentence.", lstWritingoptions8, 1, 5, "tougher", 0, "");
		lstWritingQuestions.add(objWritingQuestion8);
		
		String[] lstWritingoptions9 = { "However", "Moreover", "Futhermore" ,"Eventually"};
		Question objWritingQuestion9 = new Question(1,"Please write down a complex sentence.", lstWritingoptions9, 1, 10, "toughest", 0, "");
		lstWritingQuestions.add(objWritingQuestion9);
		
		String[] lstWritingoptions10 = { ".", ",", "a" ,"an"};
		Question objWritingQuestion10 = new Question(1,"Please write down a simple sentence.", lstWritingoptions10, 1, 2, "tough", 0, "");
		lstWritingQuestions.add(objWritingQuestion10);
		
		String[] lstWritingoptions11 = { "and", "the", "because" ,"so"};
		Question objWritingQuestion11 = new Question(1,"Please write down a compound sentence.", lstWritingoptions11, 1, 5, "tougher", 0, "");
		lstWritingQuestions.add(objWritingQuestion11);
		
		String[] lstWritingoptions12 = { "However", "Moreover", "Futhermore" ,"Eventually"};
		Question objWritingQuestion12 = new Question(1,"Please write down a complex sentence.", lstWritingoptions12, 1, 10, "toughest", 0, "");
		lstWritingQuestions.add(objWritingQuestion12);
		
		String[] lstWritingoptions13 = { ".", ",", "a" ,"an"};
		Question objWritingQuestion13 = new Question(1,"Please write down a simple sentence.", lstWritingoptions13, 1, 2, "tough", 0, "");
		lstWritingQuestions.add(objWritingQuestion13);
		
		String[] lstWritingoptions14 = { "and", "the", "because" ,"so"};
		Question objWritingQuestion14 = new Question(1,"Please write down a compound sentence.", lstWritingoptions14, 1, 5, "tougher", 0, "");
		lstWritingQuestions.add(objWritingQuestion14);
		
		String[] lstWritingoptions15 = { "However", "Moreover", "Futhermore" ,"Eventually"};
		Question objWritingQuestion15 = new Question(1,"Please write down a complex sentence.", lstWritingoptions15, 1, 10, "toughest", 0, "");
		lstWritingQuestions.add(objWritingQuestion15);
		objWriting.setSubjectName("Writing");
		objWriting.setLstQuestion(lstWritingQuestions);
		
		lstSubjects.put(objWriting.getSubjectName(), objWriting);
		
		//End of Writing Questions
		
		
		return lstSubjects;
	}
}
