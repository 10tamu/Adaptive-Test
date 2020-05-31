import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.Timer;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class First extends JFrame implements ActionListener {

	public static final int WIDTH = 900;
	public static final int HEIGHT = 900;
	public static final int TOTAL_TIME = 2 * 60 * 1000;
	public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("mm:ss");
	public JLabel lb;
	public Timer timer;
	public JLabel timerLabel;
	public final int DELAY = 1000;
	public JPanel btnPanel;
	public final ButtonGroup rdoGroup;
	private String answer;
	private DataAccess objDataAccess;
	
	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}


	public First() {
		super("BorderLayout Demonstration");
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLayout(new BorderLayout());

		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());

		lb = new JLabel("I HATE KUNAL");

		btnPanel = new JPanel();
		rdoGroup = new ButtonGroup();
		objDataAccess = new DataAccess();
		
		JButton btnMaths = new JButton("Maths");
		btnMaths.addActionListener(this);
		btnPanel.add(btnMaths);

		JButton btnIMGReco = new JButton("Critical reasoning");
		btnPanel.add(btnIMGReco);

		JButton btnSpelling = new JButton("Spelling");
		btnPanel.add(btnSpelling);

		JButton btnListening = new JButton("Listening");
		btnPanel.add(btnListening);

		JButton btnWriting = new JButton("Writing");
		btnPanel.add(btnWriting);
		
		
		add(btnPanel, BorderLayout.NORTH);

		btnPanel.add(lb);

		timerLabel = new JLabel(DATE_FORMAT.format(new Date(TOTAL_TIME)));

		setCountDown();

		btnPanel.add(timerLabel, BorderLayout.EAST);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		First fr = new First();
	//	SignUp fr = new SignUp();
		//LogIn fr = new LogIn();
		fr.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {

		// System.out.println("performed");
		JPanel pnlTest = new JPanel();
		JLabel lblQuestion;

		JRadioButton rdOption1;
		JRadioButton rdOption2;
		JRadioButton rdOption3;
		JRadioButton rdOption4;

		String btnTitle = e.getActionCommand();
		
		// Random question for test
		Question testQuestion = new Question();
		testQuestion = objDataAccess.getQuestion(btnTitle);
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getActionCommand().equalsIgnoreCase("Next")){
					lb.setText("You are next baby.");
				}
			}
		});
		

		
		lb.setText(btnTitle);
		if (btnTitle.equalsIgnoreCase("Maths")) {
			lblQuestion = new JLabel(testQuestion.getQuestion());
			pnlTest.add(lblQuestion);
			// lblQuestion = new JLabel("1 + 1 =");
			// pnlTest.add(lblQuestion);
			rdOption1 = new JRadioButton(testQuestion.getLstOptions()[0], true);
			rdOption1.addActionListener(new RadioButtonActionListener());
			
			rdoGroup.add(rdOption1);
			rdOption2 = new JRadioButton(testQuestion.getLstOptions()[1]);
			rdOption2.addActionListener(new RadioButtonActionListener());
			
			rdoGroup.add(rdOption2);
			rdOption3 = new JRadioButton(testQuestion.getLstOptions()[2]);
			rdOption3.addActionListener(new RadioButtonActionListener());
			
			rdoGroup.add(rdOption3);
			rdOption4 = new JRadioButton(testQuestion.getLstOptions()[3]);
			rdOption4.addActionListener(new RadioButtonActionListener());
			
			rdoGroup.add(rdOption4);
			
			pnlTest.add(rdOption1);
			pnlTest.add(rdOption2);
			pnlTest.add(rdOption3);
			pnlTest.add(rdOption4);
			
			timer.start();
			
		} else if (btnTitle.equals("Reasoing")) {
			lblQuestion = new JLabel("Reasoing Test");
			// lblQuestion = new JLabel("Reasoning Question");
			rdOption1 = new JRadioButton("R Q 1");
			rdOption2 = new JRadioButton("R Q 2");
			rdOption3 = new JRadioButton("R Q 3");
			rdOption4 = new JRadioButton("R Q 4");
		} 
		pnlTest.add(btnNext);
		add(pnlTest, BorderLayout.CENTER);
	}


	private class RadioButtonActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			lb.setText(e.getActionCommand());
		}
		
	}
	
	
	
	public void setCountDown() {
		timer = new Timer(DELAY, new ActionListener() {
			long time = TOTAL_TIME;

			@Override
			public void actionPerformed(ActionEvent e) {

				// TODO Auto-generated method stub
				// btnPanel.repaint();
				do {
					timerLabel.setText(DATE_FORMAT.format(new Date(time)));
					time -= 1000;
				

				if (time == 58 * 1000) {
					timerLabel.setForeground(Color.RED);
					// playSound(new File("/Users/palaktank/Downloads/beep.m4r.m4a"));
					// Toolkit.getDefaultToolkit().beep();
					btnPanel.repaint();
				}
				} while (time <= 1000);
				
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
