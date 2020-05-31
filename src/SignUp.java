import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Models.Student;

public class SignUp extends JFrame implements ActionListener {
	public static final int WIDTH = 1000;
	public static final int HEIGHT = 1000;
	JLabel lblFormName, lblStudentID, lblName, lblSchoolName;
	JTextField txtStudentID, txtName, txtSchoolName;
	JCheckBox isAgreed;
	JButton btnSignUp;
	Student objStudent = new Student();
	
	Random rd = new Random();

	public SignUp() {
		// super("Student Sign Up");
		setVisible(true);
		setSize(WIDTH, HEIGHT);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Signup");

		lblFormName = new JLabel("SignUp");
		lblFormName.setBackground(Color.blue);
		lblFormName.setFont(new Font("Serif", Font.BOLD, 20));

		lblStudentID = new JLabel("StudentID");
		lblName = new JLabel("Name");
		lblSchoolName = new JLabel("School Name");

		txtStudentID = new JTextField("1");
		txtName = new JTextField("hjhjhjhj");
		txtSchoolName = new JTextField("dfsd");

		isAgreed = new JCheckBox("Terms and condition");
		isAgreed.setBounds(200, 190, 300, 60);

		btnSignUp = new JButton("SignUp");
		btnSignUp.addActionListener(this);

		lblFormName.setBounds(100, 30, 400, 30);
		lblStudentID.setBounds(80, 70, 200, 30);
		lblName.setBounds(80, 110, 200, 30);
		lblSchoolName.setBounds(80, 150, 200, 30);

		txtStudentID.setBounds(200, 70, 200, 30);
		txtName.setBounds(200, 110, 200, 30);
		txtSchoolName.setBounds(200, 150, 200, 30);

		btnSignUp.setBounds(200, 250, 200, 30);

		add(lblFormName);
		add(lblStudentID);
		add(lblName);
		add(lblSchoolName);
		add(txtStudentID);
		add(txtName);
		add(txtSchoolName);
		add(btnSignUp);
		add(isAgreed);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSignUp) {
			if (isAgreed.isSelected()) {
				if (validation()) {
					int pin = rd.nextInt(100);
					objStudent.setName(txtName.getText());
					objStudent.setSchoolName(txtSchoolName.getText());
					objStudent.setStudentID(txtStudentID.getText());
					objStudent.setTermsAgreed(isAgreed.isSelected());
					JOptionPane.showMessageDialog(btnSignUp, "Your temporary pin is " + pin);
					objStudent.setTempPIN(pin);
					this.dispose();
					LogIn login = new LogIn(objStudent);
					login.setVisible(true);
				//	 objChart = new ResultChart();
					
				}
			} else {
				JOptionPane.showMessageDialog(btnSignUp, "Please agree terms and condition.");
			}
		}
	}

	public boolean validation() {
		boolean flag = true;

		if ((txtStudentID.getText()).isEmpty()) {
			JOptionPane.showMessageDialog(btnSignUp, "Please enter your Student ID.");
			flag = false;
		} else if ((txtName.getText()).isEmpty()) {
			JOptionPane.showMessageDialog(btnSignUp, "Please enter your Name.");
			flag = false;
		} else if ((txtSchoolName.getText()).isEmpty()) {
			JOptionPane.showMessageDialog(btnSignUp, "Please enter your School Name.");
			flag = false;
		}
		return flag;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//First fr = new First();
		 SignUp fr = new SignUp();
		//ResultBarChart fr = new ResultBarChart();
		
		//LogIn fr = new LogIn();
		fr.setVisible(true);

	}
}
