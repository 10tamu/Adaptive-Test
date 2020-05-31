import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class ImageResult extends JFrame implements ActionListener {
	public static final int WIDTH = 1000;
	public static final int HEIGHT = 1000;
	JLabel lblFormName;
	JButton btnMaths, btnIMGReco, btnSpelling, btnListening, btnWriting;
	private DataAccess objDataAccess;
	int ImageTotalMarks =0;
    int ImageObtainedMarks =0;

	//public ImageResult(ArrayList<Question> ExamResult) {
	public ImageResult(DataAccess objDataAcessLayer) {
		setVisible(true);
		setSize(WIDTH, HEIGHT);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Image Result");
		
		objDataAccess =  objDataAcessLayer;

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
		
		SetTestResultButtonAccessibility("Image");
		
		ArrayList<Question> ExamResult = objDataAccess.GetExamResult("Image");
		
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
		
		try {
		int questionCounter =0;
		JLabel	lblExamPaerQuestion,lblQuestionNo, lblImageQuestion1,lblImageQuestion2,lblImageQuestion3,lblCorrectAnswer, lblGivenAnswer, lblImageTotalMarks ,lblImageObtainedMarks;
		for(Question objExamQuestion : ExamResult) {
			ImageTotalMarks = ImageTotalMarks + objExamQuestion.getMarks();
			ImageObtainedMarks = ImageObtainedMarks + objExamQuestion.getObtainedMarks();
			
			lblExamPaerQuestion= new JLabel(objExamQuestion.getQuestion());
			
			String[] imageNames = objExamQuestion.getFilePath().split("//");
			
			BufferedImage myPicture = null;
			BufferedImage myPicture1 = null;
			BufferedImage myPicture2 = null;

			myPicture = ImageIO.read(new File("src/Images/" + imageNames[0]));
			myPicture1 = ImageIO.read(new File("src/Images/" + imageNames[1]));
			myPicture2 = ImageIO.read(new File("src/Images/" + imageNames[2]));

			ImageIcon icon1 = new ImageIcon(myPicture);
			ImageIcon icon2 = new ImageIcon(myPicture1);
			ImageIcon icon3 = new ImageIcon(myPicture2);

			lblImageQuestion1 = new JLabel(icon1);
			lblImageQuestion2 = new JLabel(icon2);
			lblImageQuestion3 = new JLabel(icon3);

			
			
			lblCorrectAnswer = new JLabel("Correct Option : " + (objExamQuestion.getAnswerIndex()+1));
			lblGivenAnswer = new JLabel("User Selected Option : " + (objExamQuestion.getGivenAnswer()+ 1));
			
			if(questionCounter == 0) {
				lblExamPaerQuestion.setBounds(50, 50, 1000, 50);
				lblQuestionNo= new JLabel("1) ");
				lblQuestionNo.setBounds(30, 50, 100, 50);
				add(lblQuestionNo);
				
				lblImageQuestion1.setBounds(50, 90, 50, 50);
				lblImageQuestion2.setBounds(350, 90, 50, 50);
				lblImageQuestion3.setBounds(650, 90, 50, 50);
				
				lblCorrectAnswer.setBounds(70, 150, 1000, 50);
				lblGivenAnswer.setBounds(70, 170, 1000, 50);
			}
			else if(questionCounter == 1) {
				lblExamPaerQuestion.setBounds(50, 200, 1000, 50);
				lblQuestionNo= new JLabel("2) ");
				lblQuestionNo.setBounds(30, 200, 100, 50);
				add(lblQuestionNo);
				
				lblImageQuestion1.setBounds(50, 240, 50, 50);
				lblImageQuestion2.setBounds(350, 240, 50, 50);
				lblImageQuestion3.setBounds(650, 240, 50, 50);
				
				lblCorrectAnswer.setBounds(70, 300, 1000, 50);
				lblGivenAnswer.setBounds(70, 320, 1000, 50);
			}
			else if(questionCounter == 2) {
				lblExamPaerQuestion.setBounds(50, 350, 1000, 50);
				lblQuestionNo= new JLabel("3) ");
				lblQuestionNo.setBounds(30, 350, 100, 50);
				add(lblQuestionNo);
				
				lblImageQuestion1.setBounds(50, 390, 50, 50);
				lblImageQuestion2.setBounds(350, 390, 50, 50);
				lblImageQuestion3.setBounds(650, 390, 50, 50);
				
				lblCorrectAnswer.setBounds(70, 450, 1000, 50);
				lblGivenAnswer.setBounds(70, 470, 1000, 50);
			}
			else if(questionCounter == 3) {
				lblExamPaerQuestion.setBounds(50, 500, 1000, 50);
				lblQuestionNo= new JLabel("4) ");
				lblQuestionNo.setBounds(30, 500, 100, 50);
				add(lblQuestionNo);
				
				
				lblImageQuestion1.setBounds(50, 540, 50, 50);
				lblImageQuestion2.setBounds(350, 540, 50, 50);
				lblImageQuestion3.setBounds(650, 540, 50, 50);
				
				lblCorrectAnswer.setBounds(70, 600, 1000, 50);
				lblGivenAnswer.setBounds(70, 620, 1000, 50);
			}
			else if(questionCounter == 4)
			{
				lblExamPaerQuestion.setBounds(50, 650, 1000, 50);
				lblQuestionNo= new JLabel("5) ");
				lblQuestionNo.setBounds(30, 650, 100, 50);
				add(lblQuestionNo);
				
				lblImageQuestion1.setBounds(50, 690, 50, 50);
				lblImageQuestion2.setBounds(350, 690, 50, 50);
				lblImageQuestion3.setBounds(650, 690, 50, 50);
				
				lblCorrectAnswer.setBounds(70, 750, 1000, 50);
				lblGivenAnswer.setBounds(70, 770, 1000, 50);
			}
			add(lblExamPaerQuestion);
			
			add(lblImageQuestion1);
			add(lblImageQuestion2);
			add(lblImageQuestion3);
			
			add(lblCorrectAnswer);
			add(lblGivenAnswer);
			questionCounter++;
		}
		
		lblImageObtainedMarks= new JLabel("Marks : " + ImageObtainedMarks);
		lblImageTotalMarks= new JLabel(" / " + ImageTotalMarks);
		
		lblImageObtainedMarks.setBounds(700, 50, 100, 50);
		lblImageTotalMarks.setBounds(800, 50, 100, 50);
		
		lblImageObtainedMarks.setFont(new Font("Serif", Font.BOLD, 20));
		lblImageTotalMarks.setFont(new Font("Serif", Font.BOLD, 20));
		
		add(lblImageObtainedMarks);
		add(lblImageTotalMarks);
		
	} catch (FileNotFoundException ex) {
		JOptionPane.showMessageDialog(btnIMGReco, ex.getMessage());
	} catch (IOException ex) {
		JOptionPane.showMessageDialog(btnIMGReco, ex.getMessage());
	}
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
}
