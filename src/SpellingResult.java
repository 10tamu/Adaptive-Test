import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SpellingResult extends JFrame implements ActionListener {
	public static final int WIDTH = 1000;
	public static final int HEIGHT = 1000;
	JLabel lblFormName;
	JButton btnMaths, btnIMGReco, btnSpelling, btnListening, btnWriting;
	private DataAccess objDataAccess;
	int SpellingTotalMarks =0;
	int SpellingObtainedMarks =0;

	//public SpellingResult(ArrayList<Question> ExamResult) {
	public SpellingResult(DataAccess objDataAcessLayer) {
		setVisible(true);
		setSize(WIDTH, HEIGHT);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Spelling Result");
		
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
		
		SetTestResultButtonAccessibility("Spelling");
		ArrayList<Question> ExamResult = objDataAccess.GetExamResult("Spelling");
		
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
		JLabel	lblExamPaerQuestion,lblQuestionNo, lblOption1, lblGivenAnswer , lblSpellingTotalMarks ,lblSpellingObtainedMarks;
		for(Question objExamQuestion : ExamResult) {
			
			SpellingTotalMarks = SpellingTotalMarks + objExamQuestion.getMarks();
			SpellingObtainedMarks = SpellingObtainedMarks + objExamQuestion.getObtainedMarks();
			
			lblExamPaerQuestion= new JLabel(objExamQuestion.getQuestion());
			
			String HintUsed = "";
			if(objExamQuestion.isHintUsed()) {
				HintUsed ="Yes";
			}
			else
			{
				HintUsed = "No";
			}
			
			lblOption1 = new JLabel("Options : " + objExamQuestion.getLstOptions()[0] + "		" +  objExamQuestion.getLstOptions()[1] + "		" + objExamQuestion.getLstOptions()[2] + "		" + objExamQuestion.getLstOptions()[3]);
			lblGivenAnswer = new JLabel("User Written Word : " + objExamQuestion.getGivenTextAnswer() + "  (Hint Used by Used :)" + HintUsed);
			
			if(questionCounter == 0) {
				lblExamPaerQuestion.setBounds(50, 50, 1000, 50);
				lblQuestionNo= new JLabel("1) ");
				lblQuestionNo.setBounds(30, 50, 100, 50);
				add(lblQuestionNo);
				
				lblOption1.setBounds(70, 70, 1000, 50);
				lblGivenAnswer.setBounds(70, 90, 1000, 50);
			}
			else if(questionCounter == 1) {
				lblExamPaerQuestion.setBounds(50, 120, 1000, 50);
				lblQuestionNo= new JLabel("2) ");
				lblQuestionNo.setBounds(30, 120, 100, 50);
				add(lblQuestionNo);
				
				lblOption1.setBounds(70, 140, 1000, 50);
				lblGivenAnswer.setBounds(70, 160, 1000, 50);
			}
			else if(questionCounter == 2) {
				lblExamPaerQuestion.setBounds(50, 190, 1000, 50);
				lblQuestionNo= new JLabel("3) ");
				lblQuestionNo.setBounds(30, 190, 100, 50);
				add(lblQuestionNo);
				
				lblOption1.setBounds(70, 210, 1000, 50);
				lblGivenAnswer.setBounds(70, 230, 1000, 50);
			}
			else if(questionCounter == 3) {
				lblExamPaerQuestion.setBounds(50, 260, 1000, 50);
				lblQuestionNo= new JLabel("4) ");
				lblQuestionNo.setBounds(30, 260, 100, 50);
				add(lblQuestionNo);
				
				lblOption1.setBounds(70, 280, 1000, 50);
				lblGivenAnswer.setBounds(70, 300, 1000, 50);
			}
			else if(questionCounter == 4)
			{
				lblExamPaerQuestion.setBounds(50, 330, 1000, 50);
				lblQuestionNo= new JLabel("5) ");
				lblQuestionNo.setBounds(30, 330, 100, 50);
				add(lblQuestionNo);
				
				lblOption1.setBounds(70, 350, 1000, 50);
				lblGivenAnswer.setBounds(70, 370, 1000, 50);
			}
			add(lblExamPaerQuestion);
			add(lblOption1);
			add(lblGivenAnswer);
			questionCounter++;
		}

		lblSpellingObtainedMarks= new JLabel("Marks : " + SpellingObtainedMarks);
		lblSpellingTotalMarks= new JLabel(" / " + SpellingTotalMarks);
		
		lblSpellingObtainedMarks.setBounds(700, 50, 100, 50);
		lblSpellingTotalMarks.setBounds(800, 50, 100, 50);
		
		lblSpellingObtainedMarks.setFont(new Font("Serif", Font.BOLD, 20));
		lblSpellingTotalMarks.setFont(new Font("Serif", Font.BOLD, 20));
		
		add(lblSpellingObtainedMarks);
		add(lblSpellingTotalMarks);
		
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
