import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.Timer;
import Models.Student;
import javafx.application.Application;

public class Test extends JFrame implements ActionListener {
	public static final int WIDTH = 1000;
	public static final int HEIGHT = 1000;
	JLabel lblStudentName, lblTimer, lblQuestion, lblImage1, lblImage2, lblImage3;
	JPanel controlPanel;
	Student objStudent = new Student();
	Question testQuestion;
	public final ButtonGroup rdoGroup;
	private DataAccess objDataAccess;
	JRadioButton rdOption1, rdOption2, rdOption3, rdOption4;
	JButton btnMaths, btnIMGReco, btnSpelling, btnListening, btnWriting, btnNext, btnDone, btnHint,btnViewChart;
	int mathsTestQuestionCounter = 0;
	int imageTestQuestionCounter = 0;
	int listeningTestQuestionCounter = 0;
	int spellingTestQuestionCounter = 0;
	int writingTestQuestionCounter = 0;
	JTextField txtSpelling, txtWriting;
	JLabel lblImageQuestion1, lblImageQuestion2, lblImageQuestion3, lblImageQuestion4, lblImageQuestion5,
			lblImageQuestion6, lblImageQuestion7, lblImageQuestion8, lblImageQuestion9, lblImageQuestion10,
			lblImageQuestion11, lblImageQuestion12, lblImageQuestion13, lblImageQuestion14, lblImageQuestion15;
	
	JLabel lblExamPaerQuestion1, lblExamPaerQuestion2, lblExamPaerQuestion3, lblExamPaerQuestion4, lblExamPaerQuestion5;
	public String subject;
	boolean isAnswered = true;
	String strHint = "";
	
	public Timer timer;
	public JLabel timerLabel;
	public final int DELAY = 1000;
	//public static final int TOTAL_TIME = 2 * 60 * 1000;
	public static final int TOTAL_TIME =  10000;
	public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("mm:ss");

	public static int mathsObtainedMarks = 0;
	public static int mathsTotalMarks = 0;
	public static int imageObtainedMarks = 0;
	public static int imageTotalMarks = 0;
	public static int spellingObtainedMarks = 0;
	public static int spellingTotalMarks = 0;
	public static int listeningObtainedMarks = 0;
	public static int listeningTotalMarks = 0;
	public static int writingObtainedMarks = 0;
	public static int writingTotalMarks = 0;
	
	
	public Test(Student student) {
		controlPanel = new JPanel();
		controlPanel.setLayout(new FlowLayout());
		objStudent = student;

		setVisible(true);
		setSize(WIDTH, HEIGHT);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Test");

		objDataAccess = new DataAccess();
		rdoGroup = new ButtonGroup();
		lblStudentName = new JLabel("Hello, " + objStudent.getName());
		
		lblStudentName.setFont(new Font("Serif", Font.BOLD, 20));

		lblQuestion = new JLabel("");

		btnMaths = new JButton("Maths");
		btnMaths.addActionListener(this);

		btnIMGReco = new JButton("Image");
		btnIMGReco.addActionListener(this);

		btnSpelling = new JButton("Spelling");
		btnSpelling.addActionListener(this);

		btnListening = new JButton("Listening");
		btnListening.addActionListener(this);

		btnWriting = new JButton("Writing");
		btnWriting.addActionListener(this);
		
		btnViewChart = new JButton("View Chart");
		btnViewChart.addActionListener(this);

		lblStudentName.setBounds(50, 30, 400, 30);

		btnMaths.setBounds(50, 100, 150, 30);
		btnIMGReco.setBounds(200, 100, 200, 30);
		btnSpelling.setBounds(400, 100, 150, 30);
		btnListening.setBounds(550, 100, 150, 30);
		btnWriting.setBounds(700, 100, 150, 30);
		btnViewChart.setBounds(850, 100, 150, 30);
		
		lblQuestion.setBounds(50, 150, 700, 250);
		lblQuestion.setVerticalAlignment(JLabel.TOP);
		lblQuestion.setVerticalTextPosition(JLabel.TOP);

		add(lblStudentName);
		add(lblQuestion);
		add(btnMaths);
		add(btnIMGReco);
		add(btnSpelling);
		add(btnListening);
		add(btnWriting);
	}

	
	public void actionPerformed(ActionEvent e) {
		RemoveControls();
		btnNext = new JButton("Next");

		btnNext.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (objDataAccess.isExamOver(subject)) {
					JOptionPane.showMessageDialog(btnNext, subject + " test is over.");
				} else {

					int givenAnswerIndex = 0;

					if (subject.equalsIgnoreCase("Spelling")) {
						if (txtSpelling.getText().isEmpty()) {
							isAnswered = false;
							JOptionPane.showMessageDialog(btnNext, "Please answer this question.");
						}
						else
						{
							isAnswered = true;
						}
						if (isAnswered) {
							givenAnswerIndex = objDataAccess.checkSpellingAnswer(testQuestion, txtSpelling.getText());
						}

					} else if (subject.equalsIgnoreCase("Writing")) {

						if (txtWriting.getText().isEmpty()) {
							isAnswered = false;
							JOptionPane.showMessageDialog(btnNext, "Please answer this question.");
						}
						else
						{
							isAnswered = true;
						}
						if (isAnswered) {
							givenAnswerIndex = objDataAccess.checkWritingAnswer(testQuestion, txtWriting.getText());
						}
					} else {
						if (rdOption1.isSelected()) {
							givenAnswerIndex = 0;
						} else if (rdOption2.isSelected()) {
							givenAnswerIndex = 1;
						} else if (rdOption3.isSelected()) {
							givenAnswerIndex = 2;
						} else if (rdOption4.isSelected()) {
							givenAnswerIndex = 3;
						}
					}
					if (isAnswered) {
						if (subject.equalsIgnoreCase("Spelling"))
						{
							testQuestion.setGivenTextAnswer(txtSpelling.getText());
							objDataAccess.saveCurrentQuestion(subject, testQuestion,0,txtSpelling.getText());
						}
						else if(subject.equalsIgnoreCase("Writing"))
						{
							testQuestion.setGivenTextAnswer(txtWriting.getText());
							objDataAccess.saveCurrentQuestion(subject, testQuestion,0,txtWriting.getText());
						}
						else {
						//	testQuestion.setAnswerIndex(givenAnswerIndex);
							objDataAccess.saveCurrentQuestion(subject, testQuestion,givenAnswerIndex,"");
						}
						
						
						if(btnNext.getText() != "Done") {
							testQuestion = objDataAccess.getNextQuestion(subject, testQuestion, givenAnswerIndex);
							RemoveControls();
							BindQuestion(testQuestion, subject);
							SetControlsVisibility(true);
						}
						else
						{
							ResetTestButtons();
							SetControlsVisibility(false);
							RemoveControls();
						}
						
						if (objDataAccess.isLastQuestionOfExam(subject)) {
							btnNext.setText("Done");
						}
					}
					
				}
			}
		});
		
		if (e.getSource() == btnMaths) {
			timerLabel = new JLabel(DATE_FORMAT.format(new Date(TOTAL_TIME)));
			timerLabel.setBounds(50, 600, 700, 250);
			timerLabel.setVisible(true);
			setCountDown();

			
			if(btnMaths.getText()=="Maths") {
				//timer.start();
			DisableTestButtons();
			subject = "Maths";
			testQuestion = objDataAccess.getQuestion(e.getActionCommand());
			lblQuestion.setBounds(50, 150, 700, 250);
			BindQuestion(testQuestion, subject);
			
			}
			else
			{
				SetExamMarks();
				MathsResult mathsResult = new MathsResult(objDataAccess);
				this.dispose();
				mathsResult.setVisible(true);
				}
			//add(timerLabel);
		} else if (e.getSource() == btnIMGReco) {
			if(btnIMGReco.getText() == "Image") {
			DisableTestButtons();
			subject = "Image";
			testQuestion = objDataAccess.getQuestion(e.getActionCommand());
			BindQuestion(testQuestion, subject);
			}
			else
			{
				SetExamMarks();
				ImageResult imageResult = new ImageResult(objDataAccess);
				this.dispose();
				imageResult.setVisible(true);
			}

		} else if (e.getSource() == btnSpelling) {
			if(btnSpelling.getText() =="Spelling") {
			DisableTestButtons();
			subject = "Spelling";
			testQuestion = objDataAccess.getQuestion(e.getActionCommand());
			BindQuestion(testQuestion, subject);
			}
			else
			{
				SetExamMarks();
				SpellingResult spellingResult = new SpellingResult(objDataAccess);
				this.dispose();
				spellingResult.setVisible(true);
			}
		} else if (e.getSource() == btnListening) {
		if(btnListening.getText() == "Listening") {
			DisableTestButtons();
			subject = "Listening";
			testQuestion = objDataAccess.getQuestion(e.getActionCommand());
			BindQuestion(testQuestion, subject);
		}
		else
		{
			SetExamMarks();
			ListeningResult listeningResult = new ListeningResult(objDataAccess);
			this.dispose();
			listeningResult.setVisible(true);
		}
		} else if (e.getSource() == btnWriting) {
			if(btnWriting.getText() == "Writing") {
			DisableTestButtons();
			subject = "Writing";
			testQuestion = objDataAccess.getQuestion(e.getActionCommand());
			BindQuestion(testQuestion, subject);
			}
			else
			{
				SetExamMarks();
				WritingResult writingResult = new WritingResult(objDataAccess);
				this.dispose();
				writingResult.setVisible(true);
			}
		}
		 else if (e.getSource() == btnViewChart) {
			}
		btnNext.setVisible(true);
		add(btnNext);
		
		
		btnViewChart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				SetExamMarks();
				Application.launch(ResultBarChart.class);
				btnViewChart.setVisible(false);
			}
		}
		);
	}
	
	public void SetExamMarks() {
		int[] mathsMarks = objDataAccess.getExamMarks("Maths");
		mathsObtainedMarks = mathsMarks[0];
		mathsTotalMarks = mathsMarks[1];
		
		int[] imageMarks = objDataAccess.getExamMarks("Image");
		imageObtainedMarks = imageMarks[0];
		imageTotalMarks = imageMarks[1];
		
		int[] spellingMarks = objDataAccess.getExamMarks("Spelling");
		spellingObtainedMarks = spellingMarks[0];
		spellingTotalMarks = spellingMarks[1];
		
		int[] listeingMarks = objDataAccess.getExamMarks("Listening");
		listeningObtainedMarks = listeingMarks[0];
		listeningTotalMarks = listeingMarks[1];
		
		int[] writingMarks = objDataAccess.getExamMarks("Writing");
	    writingObtainedMarks = writingMarks[0];
        writingTotalMarks = writingMarks[1];
	}

	public void BindQuestion(Question testQuestion, String subject) {
		lblQuestion.setText(testQuestion.getQuestion());
		lblQuestion.setVisible(true);
		if (subject.equalsIgnoreCase("Maths")) {
			rdOption1 = new JRadioButton(testQuestion.getLstOptions()[0], true);
			rdOption2 = new JRadioButton(testQuestion.getLstOptions()[1]);
			rdOption3 = new JRadioButton(testQuestion.getLstOptions()[2]);
			rdOption4 = new JRadioButton(testQuestion.getLstOptions()[3]);
			mathsTestQuestionCounter++;
			lblQuestion.setText(mathsTestQuestionCounter + ") " + testQuestion.getQuestion());
		} else if (subject.equalsIgnoreCase("Image")) {
			try {
				
				lblQuestion.setText((imageTestQuestionCounter + 1) +") "+ testQuestion.getQuestion());
				
				String[] imageNames = testQuestion.getFilePath().split("//");
				if (imageTestQuestionCounter == 0) {
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

					lblImageQuestion1.setBounds(50, 150, 200, 200);
					lblImageQuestion2.setBounds(350, 150, 200, 200);
					lblImageQuestion3.setBounds(650, 150, 200, 200);

					 add(lblImageQuestion1);
					 add(lblImageQuestion2);
					 add(lblImageQuestion3);

					imageTestQuestionCounter++;
				} else if (imageTestQuestionCounter == 1) {
					BufferedImage myPicture = null;
					BufferedImage myPicture1 = null;
					BufferedImage myPicture2 = null;

					myPicture = ImageIO.read(new File("src/Images/" + imageNames[0]));
					myPicture1 = ImageIO.read(new File("src/Images/" + imageNames[1]));
					myPicture2 = ImageIO.read(new File("src/Images/" + imageNames[2]));

					ImageIcon icon1 = new ImageIcon(myPicture);
					ImageIcon icon2 = new ImageIcon(myPicture1);
					ImageIcon icon3 = new ImageIcon(myPicture2);

					lblImageQuestion1.setVisible(false);
					lblImageQuestion2.setVisible(false);
					lblImageQuestion3.setVisible(false);

					lblImageQuestion4 = new JLabel(icon1);
					lblImageQuestion5 = new JLabel(icon2);
					lblImageQuestion6 = new JLabel(icon3);

					lblImageQuestion4.setBounds(50, 150, 200, 200);
					lblImageQuestion5.setBounds(350, 150, 200, 200);
					lblImageQuestion6.setBounds(650, 150, 200, 200);

					 add(lblImageQuestion4);
					 add(lblImageQuestion5);
					 add(lblImageQuestion6);

					imageTestQuestionCounter++;
				} else if (imageTestQuestionCounter == 2) {
					BufferedImage myPicture = null;
					BufferedImage myPicture1 = null;
					BufferedImage myPicture2 = null;

					myPicture = ImageIO.read(new File("src/Images/" + imageNames[0]));
					myPicture1 = ImageIO.read(new File("src/Images/" + imageNames[1]));
					myPicture2 = ImageIO.read(new File("src/Images/" + imageNames[2]));

					ImageIcon icon1 = new ImageIcon(myPicture);
					ImageIcon icon2 = new ImageIcon(myPicture1);
					ImageIcon icon3 = new ImageIcon(myPicture2);

					lblImageQuestion4.setVisible(false);
					lblImageQuestion5.setVisible(false);
					lblImageQuestion6.setVisible(false);

					lblImageQuestion7 = new JLabel(icon1);
					lblImageQuestion8 = new JLabel(icon2);
					lblImageQuestion9 = new JLabel(icon3);

					lblImageQuestion7.setBounds(50, 150, 200, 200);
					lblImageQuestion8.setBounds(350, 150, 200, 200);
					lblImageQuestion9.setBounds(650, 150, 200, 200);

					 add(lblImageQuestion7);
					 add(lblImageQuestion8);
					 add(lblImageQuestion9);

					imageTestQuestionCounter++;
				} else if (imageTestQuestionCounter == 3) {
					BufferedImage myPicture = null;
					BufferedImage myPicture1 = null;
					BufferedImage myPicture2 = null;

					myPicture = ImageIO.read(new File("src/Images/" + imageNames[0]));
					myPicture1 = ImageIO.read(new File("src/Images/" + imageNames[1]));
					myPicture2 = ImageIO.read(new File("src/Images/" + imageNames[2]));

					ImageIcon icon1 = new ImageIcon(myPicture);
					ImageIcon icon2 = new ImageIcon(myPicture1);
					ImageIcon icon3 = new ImageIcon(myPicture2);

					lblImageQuestion7.setVisible(false);
					lblImageQuestion8.setVisible(false);
					lblImageQuestion9.setVisible(false);

					lblImageQuestion10 = new JLabel(icon1);
					lblImageQuestion11 = new JLabel(icon2);
					lblImageQuestion12 = new JLabel(icon3);

					lblImageQuestion10.setBounds(50, 150, 200, 200);
					lblImageQuestion11.setBounds(350, 150, 200, 200);
					lblImageQuestion12.setBounds(650, 150, 200, 200);

					 add(lblImageQuestion10);
					 add(lblImageQuestion11);
					 add(lblImageQuestion12);

					imageTestQuestionCounter++;
				}else if (imageTestQuestionCounter == 4) {
					BufferedImage myPicture = null;
					BufferedImage myPicture1 = null;
					BufferedImage myPicture2 = null;

					myPicture = ImageIO.read(new File("src/Images/" + imageNames[0]));
					myPicture1 = ImageIO.read(new File("src/Images/" + imageNames[1]));
					myPicture2 = ImageIO.read(new File("src/Images/" + imageNames[2]));

					ImageIcon icon1 = new ImageIcon(myPicture);
					ImageIcon icon2 = new ImageIcon(myPicture1);
					ImageIcon icon3 = new ImageIcon(myPicture2);

					lblImageQuestion10.setVisible(false);
					lblImageQuestion11.setVisible(false);
					lblImageQuestion12.setVisible(false);

					lblImageQuestion13 = new JLabel(icon1);
					lblImageQuestion14 = new JLabel(icon2);
					lblImageQuestion15 = new JLabel(icon3);

					lblImageQuestion13.setBounds(50, 150, 200, 200);
					lblImageQuestion14.setBounds(350, 150, 200, 200);
					lblImageQuestion15.setBounds(650, 150, 200, 200);

					 add(lblImageQuestion13);
					 add(lblImageQuestion14);
					 add(lblImageQuestion15);

					imageTestQuestionCounter++;
				}
			} catch (FileNotFoundException ex) {
				JOptionPane.showMessageDialog(btnIMGReco, ex.getMessage());
			} catch (IOException ex) {
				JOptionPane.showMessageDialog(btnIMGReco, ex.getMessage());
			}
			rdOption1 = new JRadioButton(testQuestion.getLstOptions()[0], true);
			rdOption2 = new JRadioButton(testQuestion.getLstOptions()[1], true);
			rdOption3 = new JRadioButton(testQuestion.getLstOptions()[2], true);
			rdOption4 = new JRadioButton(testQuestion.getLstOptions()[3], true);
		} else if (subject.equalsIgnoreCase("Listening")) {
			playAudiofile(testQuestion.getFilePath());
			rdOption1 = new JRadioButton(testQuestion.getLstOptions()[0], true);
			rdOption2 = new JRadioButton(testQuestion.getLstOptions()[1]);
			rdOption3 = new JRadioButton(testQuestion.getLstOptions()[2]);
			rdOption4 = new JRadioButton(testQuestion.getLstOptions()[3]);
			listeningTestQuestionCounter++;
			lblQuestion.setText(listeningTestQuestionCounter + ") " + testQuestion.getQuestion());
		} else if (subject.equalsIgnoreCase("Spelling")) {
			txtSpelling = new JTextField();
			btnHint = new JButton("Hint");
			btnHint.setVisible(true);
			btnHint.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String txtAnswer = txtSpelling.getText();
					testQuestion.setHintUsed(true);
					for (String strOption : testQuestion.getLstOptions()) {
						if (strOption.startsWith(txtAnswer)) {
							strHint = strOption.substring(0, 3);
						}
					}

					if (strHint.isEmpty()) {
						strHint = testQuestion.getLstOptions()[0].substring(0, 3);
					}

					JOptionPane.showMessageDialog(btnIMGReco, strHint);
				}
			});
			spellingTestQuestionCounter++;
			lblQuestion.setText(spellingTestQuestionCounter + ") " + testQuestion.getQuestion());
		} else if (subject.equalsIgnoreCase("Writing")) {
			txtWriting = new JTextField();
			writingTestQuestionCounter++;
			lblQuestion.setText(writingTestQuestionCounter + ") " + testQuestion.getQuestion());
		}

		AddControls();
		if (objDataAccess.isExamOver(subject)) {
			btnNext.setVisible(false);
		}
		repaint();
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

	public void RemoveControls() {
		if (rdOption1 != null) {
			rdOption1.setText("");
			rdoGroup.remove(rdOption1);
			remove(rdOption1);
		}

		if (rdOption2 != null) {
			rdOption2.setText("");
			rdoGroup.remove(rdOption2);
			remove(rdOption2);
		}

		if (rdOption3 != null) {
			rdOption3.setText("");
			rdoGroup.remove(rdOption3);
			remove(rdOption3);
		}

		if (rdOption4 != null) {
			rdOption4.setText("");
			rdoGroup.remove(rdOption4);
			remove(rdOption4);
		}

		if (lblQuestion != null) {
			lblQuestion.setText("");
			remove(lblQuestion);
		}

		if (btnNext != null) {
			remove(btnNext);
		}
		
		if(btnDone != null)
		{
			remove(btnDone);
		}
		
		if (lblImageQuestion1 != null) {
			remove(lblImageQuestion1);
		}

		if (lblImageQuestion2 != null) {
			remove(lblImageQuestion2);
		}

		if (lblImageQuestion3 != null) {
			remove(lblImageQuestion3);
		}

		if (lblImageQuestion4 != null) {
			remove(lblImageQuestion4);
		}

		if (lblImageQuestion5 != null) {
			remove(lblImageQuestion5);
		}

		if (lblImageQuestion6 != null) {
			remove(lblImageQuestion6);
		}

		if (lblImageQuestion7 != null) {
			remove(lblImageQuestion7);
		}

		if (lblImageQuestion8 != null) {
			remove(lblImageQuestion8);
		}

		if (lblImageQuestion9 != null) {
			remove(lblImageQuestion9);
		}

		if (lblImageQuestion10 != null) {
			remove(lblImageQuestion10);
		}

		if (lblImageQuestion11 != null) {
			remove(lblImageQuestion11);
		}

		if (lblImageQuestion12 != null) {
			remove(lblImageQuestion12);
		}

		if (lblImageQuestion13 != null) {
			remove(lblImageQuestion13);
		}

		if (lblImageQuestion14 != null) {
			remove(lblImageQuestion14);
		}

		if (lblImageQuestion15 != null) {
			remove(lblImageQuestion15);
		}

		if (txtSpelling != null) {
			txtSpelling.setText("");
			remove(txtSpelling);
		}

		if (txtWriting != null) {
			txtWriting.setText("");
			remove(txtWriting);
		}

		if (btnHint != null) {
			remove(btnHint);
		}
		
	}

	public void AddControls() {
		if (subject == "Maths") {
			rdoGroup.add(rdOption1);
			rdoGroup.add(rdOption2);
			rdoGroup.add(rdOption3);
			rdoGroup.add(rdOption4);

			rdOption1.setBounds(60, 180, 800, 40);
			rdOption2.setBounds(60, 210, 800, 40);
			rdOption3.setBounds(60, 240, 800, 40);
			rdOption4.setBounds(60, 270, 800, 40);

			add(rdOption1);
			add(rdOption2);
			add(rdOption3);
			add(rdOption4);

			lblQuestion.setBounds(50, 150, 700, 250);
			btnNext.setBounds(800, 350, 100, 40);
		} else if (subject == "Image") {
			rdoGroup.add(rdOption1);
			rdoGroup.add(rdOption2);
			rdoGroup.add(rdOption3);
			rdoGroup.add(rdOption4);

			rdOption1.setBounds(50, 380, 800, 40);
			rdOption2.setBounds(50, 410, 800, 40);
			rdOption3.setBounds(50, 440, 800, 40);
			rdOption4.setBounds(50, 470, 800, 40);

			add(rdOption1);
			add(rdOption2);
			add(rdOption3);
			add(rdOption4);

			lblQuestion.setBounds(50, 350, 700, 250);
			btnNext.setBounds(800, 550, 100, 40);

			if(imageTestQuestionCounter == 0) {
			if (lblImageQuestion1 != null) {
				add(lblImageQuestion1);
			}
			if (lblImageQuestion2 != null) {
				add(lblImageQuestion2);
			}
			if (lblImageQuestion3 != null) {
				add(lblImageQuestion3);
			}
			}
			
			if(imageTestQuestionCounter == 1) {
			if (lblImageQuestion4 != null) {
				add(lblImageQuestion4);
			}
			if (lblImageQuestion5 != null) {
				add(lblImageQuestion5);
			}
			if (lblImageQuestion6 != null) {
				add(lblImageQuestion6);
			}
			}
			
			if(imageTestQuestionCounter == 2) {
			if (lblImageQuestion7 != null) {
				add(lblImageQuestion7);
			}
			if (lblImageQuestion8 != null) {
				add(lblImageQuestion8);
			}
			if (lblImageQuestion9 != null) {
				add(lblImageQuestion9);
			}
			}
			
			if(imageTestQuestionCounter == 3) {
			if (lblImageQuestion10 != null) {
				add(lblImageQuestion10);
			}
			if (lblImageQuestion11 != null) {
				add(lblImageQuestion11);
			}
			if (lblImageQuestion12 != null) {
				add(lblImageQuestion12);
			}
			}
			
			if(imageTestQuestionCounter == 4) {
			if (lblImageQuestion13 != null) {
				add(lblImageQuestion13);
			}
			if (lblImageQuestion14 != null) {
				add(lblImageQuestion14);
			}
			if (lblImageQuestion15 != null) {
				add(lblImageQuestion15);
			}
			}
		} else if (subject == "Spelling") {
			txtSpelling.setBounds(60, 180, 200, 40);
			btnHint.setBounds(60, 240, 80, 40);

			add(txtSpelling);
			add(btnHint);

			lblQuestion.setBounds(50, 150, 700, 250);
			btnNext.setBounds(800, 350, 100, 40);
		} else if (subject == "Listening") {
			rdoGroup.add(rdOption1);
			rdoGroup.add(rdOption2);
			rdoGroup.add(rdOption3);
			rdoGroup.add(rdOption4);

			rdOption1.setBounds(60, 180, 800, 40);
			rdOption2.setBounds(60, 210, 800, 40);
			rdOption3.setBounds(60, 240, 800, 40);
			rdOption4.setBounds(60, 270, 800, 40);

			add(rdOption1);
			add(rdOption2);
			add(rdOption3);
			add(rdOption4);

			lblQuestion.setBounds(50, 150, 700, 250);
			btnNext.setBounds(800, 350, 100, 40);
		} else if (subject == "Writing") {
			txtWriting.setBounds(60, 180, 800, 50);
			add(txtWriting);

			lblQuestion.setBounds(50, 150, 700, 250);
			btnNext.setBounds(800, 250, 100, 40);
		}

		add(lblQuestion);
		add(btnNext);
	}
	
	public void DisableTestButtons() {
		btnMaths.setEnabled(false);
		btnIMGReco.setEnabled(false);
		btnSpelling.setEnabled(false);
		btnListening.setEnabled(false);
		btnWriting.setEnabled(false);
	}
	
	public void ResetTestButtons() {
		int isAllTestDone = 0;
		if (objDataAccess.isExamOver("Maths")) {
			btnMaths.setEnabled(false);
			isAllTestDone++;
		}
		else
		{
			btnMaths.setEnabled(true);
		}
		
		if (objDataAccess.isExamOver("Image")) {
			btnIMGReco.setEnabled(false);
			isAllTestDone++;
		}
		else
		{
			btnIMGReco.setEnabled(true);
		}
		
		if (objDataAccess.isExamOver("Spelling")) {
			btnSpelling.setEnabled(false);
			isAllTestDone++;
		}
		else
		{
			btnSpelling.setEnabled(true);
		}
		
		if (objDataAccess.isExamOver("Listening")) {
			btnListening.setEnabled(false);
			isAllTestDone++;
		}
		else
		{
			btnListening.setEnabled(true);
		}
		
		if (objDataAccess.isExamOver("Writing")) {
			btnWriting.setEnabled(false);
			isAllTestDone++;
		}
		else
		{
			btnWriting.setEnabled(true);
		}			
		
		if(isAllTestDone == 5)
		{
			JOptionPane.showMessageDialog(btnIMGReco, "Wohooo! You have completed your test.");
			btnMaths.setEnabled(true);
			btnMaths.setText("View Maths Result");
			btnIMGReco.setEnabled(true);
			btnIMGReco.setText("View Image Result");
			btnSpelling.setEnabled(true);
			btnSpelling.setText("View Spelling Result");
			btnListening.setEnabled(true);
			btnListening.setText("View Listening Result");
			btnWriting.setEnabled(true);
			btnWriting.setText("View Writing Result");
			
			btnViewChart.setEnabled(true);
			add(btnViewChart);
		}
	}

	public void SetControlsVisibility(Boolean isVisible)
	{
		
		if(subject.equalsIgnoreCase("Maths") || subject.equalsIgnoreCase("Listening") || subject.equalsIgnoreCase("Image")) {
			btnNext.setVisible(isVisible);
			rdOption1.setVisible(isVisible);
			rdOption2.setVisible(isVisible);
			rdOption3.setVisible(isVisible);
			rdOption4.setVisible(isVisible);
			lblQuestion.setVisible(isVisible);
			if(subject.equalsIgnoreCase("Image")) {
				if (lblImageQuestion1 != null) {
					lblImageQuestion1.setVisible(isVisible);
				}
				if (lblImageQuestion2 != null) {
					lblImageQuestion2.setVisible(isVisible);
				}
				if (lblImageQuestion3 != null) {
					lblImageQuestion3.setVisible(isVisible);
				}
				}
				
				if (lblImageQuestion4 != null) {
					lblImageQuestion4.setVisible(isVisible);
				}
				if (lblImageQuestion5 != null) {
					lblImageQuestion5.setVisible(isVisible);
				}
				if (lblImageQuestion6 != null) {
					lblImageQuestion6.setVisible(isVisible);
				}
				
				if (lblImageQuestion7 != null) {
					lblImageQuestion7.setVisible(isVisible);
				}
				if (lblImageQuestion8 != null) {
					lblImageQuestion8.setVisible(isVisible);
				}
				if (lblImageQuestion9 != null) {
					lblImageQuestion9.setVisible(isVisible);
				}
				
				if (lblImageQuestion10 != null) {
					lblImageQuestion10.setVisible(isVisible);
				}
				if (lblImageQuestion11 != null) {
					lblImageQuestion11.setVisible(isVisible);
				}
				if (lblImageQuestion12 != null) {
					lblImageQuestion12.setVisible(isVisible);
				}
				
				if (lblImageQuestion13 != null) {
					lblImageQuestion13.setVisible(isVisible);
				}
				if (lblImageQuestion14 != null) {
					lblImageQuestion14.setVisible(isVisible);
				}
				if (lblImageQuestion15 != null) {
					lblImageQuestion15.setVisible(isVisible);
				}
		}else if(subject.equalsIgnoreCase("Spelling")) {
			btnHint.setVisible(isVisible);
			btnNext.setVisible(isVisible);
			txtSpelling.setVisible(isVisible);
		}else if(subject.equalsIgnoreCase("Writing")) {
			btnNext.setVisible(isVisible);
			txtWriting.setVisible(isVisible);
		}
	}

	public void setCountDown() {
		timer = new Timer(DELAY, new ActionListener() {
			long time = TOTAL_TIME;

			@Override
			public void actionPerformed(ActionEvent e) {
				do {
					timerLabel.setForeground(Color.BLACK);
					timerLabel.setText(DATE_FORMAT.format(new Date(time)));
					repaint();
					
					
					if (time == 3000) {
							timerLabel.setForeground(Color.RED);
							//time -= 1000;
							repaint();
							
							// playSound(new File("/Users/palaktank/Downloads/beep.m4r.m4a"));
							// Toolkit.getDefaultToolkit().beep();
						}
					
					//time -= 1000;
					if(time == 0) {
						timer.stop();
						ResetTestButtons();
						SetControlsVisibility(false);
						RemoveControls();
						timerLabel.setText("");
						
					}
					time -= 1000;
					
				}
				while (time < -1000);
				//TODOTIMER while (time <= 1000);
				
//				do {
//					try {
//						// Open an audio input stream.
//						File url = new File("/Users/palaktank/Downloads/beep-09.wav");
//						// URL url = new
//						// URL("https://notificationsounds.com/notification-sounds/beep-472");
//						// lb.setText(url.toString());
//						AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
//						// Get a sound clip resource.
//						Clip clip = AudioSystem.getClip();
//						// Open audio clip and load samples from the audio input stream.
//						clip.open(audioIn);
//						clip.start();
//					} catch (UnsupportedAudioFileException ee) {
//						ee.printStackTrace();
//					} catch (IOException e1) {
//						e1.printStackTrace();
//					} catch (LineUnavailableException e2) {
//						e2.printStackTrace();
//					}
//				} while (time <= 58 * 1000);

//					timerLabel.repaint();

			}
		});
	}

}