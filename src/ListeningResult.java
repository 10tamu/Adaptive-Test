import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javafx.application.Application;

public class ListeningResult extends JFrame implements ActionListener {
	public static final int WIDTH = 1000;
	public static final int HEIGHT = 1000;
	JLabel lblFormName;
	JButton btnMaths, btnIMGReco, btnSpelling, btnListening, btnWriting;//,btnViewChart;
	private DataAccess objDataAccess;
	 int ListeningTotalMarks =0;
	 int ListeningObtainedMarks =0;
		
//	public ListeningResult(ArrayList<Question> ExamResult) {
	public ListeningResult(DataAccess objDataAcessLayer) {
		setVisible(true);
		setSize(WIDTH, HEIGHT);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Listening Result");
		
		//objDataAccess = new DataAccess();
		objDataAccess = objDataAcessLayer;

		lblFormName = new JLabel("SignIn");
		lblFormName.setBackground(Color.blue);
		lblFormName.setFont(new Font("Serif", Font.BOLD, 20));
		
		btnMaths = new JButton("View Maths Result");
		btnMaths.addActionListener(this);

		btnIMGReco = new JButton("View Image Result");
		btnIMGReco.addActionListener(this);

		btnSpelling = new JButton("View Spelling Result");
		btnSpelling.addActionListener(this);

		btnListening = new JButton("View Listening Result");
		btnListening.addActionListener(this);

		btnWriting = new JButton("View Writing Result");
		btnWriting.addActionListener(this);
		
		btnMaths.setBounds(50, 20, 150, 30);
		btnIMGReco.setBounds(200, 20, 200, 30);
		btnSpelling.setBounds(400, 20, 150, 30);
		btnListening.setBounds(550, 20, 150, 30);
		btnWriting.setBounds(700, 20, 150, 30);

		add(btnMaths);
		add(btnIMGReco);
		add(btnSpelling);
		add(btnListening);
		add(btnWriting);
		//add(btnViewChart);
		
		SetTestResultButtonAccessibility("Listening");
		
		ArrayList<Question> ExamResult = objDataAccess.GetExamResult("Listening");
		BindExamResult(ExamResult);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnMaths) {
			this.dispose();
			MathsResult Result = new MathsResult(objDataAccess);
			Result.setVisible(true);
		}
		else if (e.getSource() == btnIMGReco) {
				this.dispose();
				ImageResult Result = new ImageResult(objDataAccess);
				Result.setVisible(true);
		}
		else if (e.getSource() == btnSpelling) {
			this.dispose();
			SpellingResult Result = new SpellingResult(objDataAccess);
			Result.setVisible(true);
		}
		else if (e.getSource() == btnListening) {
			this.dispose();
			ListeningResult Result = new ListeningResult(objDataAccess);
			Result.setVisible(true);
		}
		else if (e.getSource() == btnWriting) {
			this.dispose();
			WritingResult Result = new WritingResult(objDataAccess);
			Result.setVisible(true);
		}
	}
	
	
	public void BindExamResult(ArrayList<Question> ExamResult) {
		int questionCounter =0;
		JLabel	lblExamPaerQuestion,lblQuestionNo, lblOption1,lblOption2,lblOption3,lblOption4,lblCorrectAnswer, lblGivenAnswer, lblListeningTotalMarks ,lblListeningObtainedMarks;
		for(Question objExamQuestion : ExamResult) {
			
			ListeningTotalMarks = ListeningTotalMarks + objExamQuestion.getMarks();
			ListeningObtainedMarks = ListeningObtainedMarks + objExamQuestion.getObtainedMarks();
			
			lblExamPaerQuestion= new JLabel(objExamQuestion.getQuestion());
			
			lblOption1 = new JLabel(" 1. " + objExamQuestion.getLstOptions()[0]);
			lblOption2 = new JLabel(" 2. " + objExamQuestion.getLstOptions()[1]);
			lblOption3 = new JLabel(" 3. "+ objExamQuestion.getLstOptions()[2]);
			lblOption4 = new JLabel(" 4. " + objExamQuestion.getLstOptions()[3]);
			
			lblCorrectAnswer = new JLabel("Correct Option : " + (objExamQuestion.getAnswerIndex()+1));
			lblGivenAnswer = new JLabel("User Selected Option : " + (objExamQuestion.getGivenAnswer()+ 1));
			
			if(questionCounter == 0) {
				lblExamPaerQuestion.setBounds(50, 50, 1000, 50);
				lblQuestionNo= new JLabel("1) ");
				lblQuestionNo.setBounds(30, 50, 100, 50);
				add(lblQuestionNo);
				
				lblOption1.setBounds(70, 70, 1000, 50);
				lblOption2.setBounds(70, 90, 1000, 50);
				lblOption3.setBounds(70, 110, 1000, 50);
				lblOption4.setBounds(70, 130, 1000, 50);
				
				lblCorrectAnswer.setBounds(70, 150, 1000, 50);
				lblGivenAnswer.setBounds(70, 170, 1000, 50);
			}
			else if(questionCounter == 1) {
				lblExamPaerQuestion.setBounds(50, 200, 1000, 50);
				lblQuestionNo= new JLabel("2) ");
				lblQuestionNo.setBounds(30, 200, 100, 50);
				add(lblQuestionNo);
				
				lblOption1.setBounds(70, 220, 1000, 50);
				lblOption2.setBounds(70, 240, 1000, 50);
				lblOption3.setBounds(70, 260, 1000, 50);
				lblOption4.setBounds(70, 280, 1000, 50);
				
				lblCorrectAnswer.setBounds(70, 300, 1000, 50);
				lblGivenAnswer.setBounds(70, 320, 1000, 50);
			}
			else if(questionCounter == 2) {
				lblExamPaerQuestion.setBounds(50, 350, 1000, 50);
				lblQuestionNo= new JLabel("3) ");
				lblQuestionNo.setBounds(30, 350, 100, 50);
				add(lblQuestionNo);
				
				lblOption1.setBounds(70, 370, 1000, 50);
				lblOption2.setBounds(70, 390, 1000, 50);
				lblOption3.setBounds(70, 410, 1000, 50);
				lblOption4.setBounds(70, 430, 1000, 50);
				
				lblCorrectAnswer.setBounds(70, 450, 1000, 50);
				lblGivenAnswer.setBounds(70, 470, 1000, 50);
			}
			else if(questionCounter == 3) {
				lblExamPaerQuestion.setBounds(50, 500, 1000, 50);
				lblQuestionNo= new JLabel("4) ");
				lblQuestionNo.setBounds(30, 500, 100, 50);
				add(lblQuestionNo);
				
				lblOption1.setBounds(70, 520, 1000, 50);
				lblOption2.setBounds(70, 540, 1000, 50);
				lblOption3.setBounds(70, 560, 1000, 50);
				lblOption4.setBounds(70, 580, 1000, 50);
				
				lblCorrectAnswer.setBounds(70, 600, 1000, 50);
				lblGivenAnswer.setBounds(70, 620, 1000, 50);
			}
			else if(questionCounter == 4)
			{
				lblExamPaerQuestion.setBounds(50, 650, 1000, 50);
				lblQuestionNo= new JLabel("5) ");
				lblQuestionNo.setBounds(30, 650, 100, 50);
				add(lblQuestionNo);
				
				lblOption1.setBounds(70, 670, 1000, 50);
				lblOption2.setBounds(70, 690, 1000, 50);
				lblOption3.setBounds(70, 710, 1000, 50);
				lblOption4.setBounds(70, 730, 1000, 50);
				
				lblCorrectAnswer.setBounds(70, 750, 1000, 50);
				lblGivenAnswer.setBounds(70, 770, 1000, 50);
			}
			add(lblExamPaerQuestion);
			
			add(lblOption1);
			add(lblOption2);
			add(lblOption3);
			add(lblOption4);
			
			add(lblCorrectAnswer);
			add(lblGivenAnswer);
			questionCounter++;
		}
		
		lblListeningObtainedMarks= new JLabel("Marks : " + ListeningObtainedMarks);
		lblListeningTotalMarks= new JLabel(" / " + ListeningTotalMarks);
		
		lblListeningObtainedMarks.setBounds(700, 50, 100, 50);
		lblListeningTotalMarks.setBounds(800, 50, 100, 50);
		
		lblListeningObtainedMarks.setFont(new Font("Serif", Font.BOLD, 20));
		lblListeningTotalMarks.setFont(new Font("Serif", Font.BOLD, 20));
		
		add(lblListeningObtainedMarks);
		add(lblListeningTotalMarks);
		
	}
	
	public void SetTestResultButtonAccessibility(String subject) {
		btnMaths.setEnabled(true);
		btnIMGReco.setEnabled(true);
		btnSpelling.setEnabled(true);
		btnListening.setEnabled(true);
		btnWriting.setEnabled(true);
		
		if (subject == "Maths") {
			btnMaths.setEnabled(false);
		} else if (subject == "Image") {
			btnIMGReco.setEnabled(false);
		} else if (subject == "Spelling") {
			btnSpelling.setEnabled(false);
		} else if (subject == "Listening") {
			btnListening.setEnabled(false);
		} else if (subject == "Writing") {
			btnWriting.setEnabled(false);
		}
	}
	
	public void playAudiofile(String fileName) {
		try {
			// Open an audio input stream.
			File url = new File("src/AudioFiles/" + fileName);

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
}
