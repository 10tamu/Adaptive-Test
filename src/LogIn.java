import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Models.Student;

public class LogIn extends JFrame implements ActionListener {
	public static final int WIDTH = 1000;
	public static final int HEIGHT = 1000;
	JLabel lblFormName, lblStudentID, lblPIN;
	JTextField txtStudentID;//, txtPIN;
	JPasswordField txtPIN;
	Student objStudent = new Student();

	JButton btnSignIn;

	public LogIn(Student student) {

		objStudent = student;

		setVisible(true);
		setSize(WIDTH, HEIGHT);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Sign In");

		lblFormName = new JLabel("SignIn");
		lblFormName.setBackground(Color.blue);
		lblFormName.setFont(new Font("Serif", Font.BOLD, 20));

		lblStudentID = new JLabel("Student ID");
		lblPIN = new JLabel("PIN");

		txtStudentID = new JTextField("1");
		//txtPIN = new JTextField();
		txtPIN = new JPasswordField();
		
		btnSignIn = new JButton("SignIn");
		btnSignIn.addActionListener(this);

		lblFormName.setBounds(100, 30, 400, 30);
		lblStudentID.setBounds(80, 70, 200, 30);
		lblPIN.setBounds(80, 110, 200, 30);

		txtStudentID.setBounds(200, 70, 200, 30);
		txtPIN.setBounds(200, 110, 200, 30);

		btnSignIn.setBounds(200, 160, 200, 30);

		add(lblFormName);
		add(lblStudentID);
		add(lblPIN);

		add(txtStudentID);
		add(txtPIN);

		add(btnSignIn);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSignIn) {
			if (validation()) {
				this.dispose();
				Test objTest = new Test(objStudent);
				objTest.setVisible(true);
			}
		}
	}

	public boolean validation() {
		boolean flag = true;

		if ((txtStudentID.getText()).isEmpty()) {
			JOptionPane.showMessageDialog(btnSignIn, "Please enter your Student ID.");
			flag = false;
		} else if ((txtPIN.getText()).isEmpty()) {
			JOptionPane.showMessageDialog(btnSignIn, "Please enter PIN.");
			flag = false;
		} else if (!(objStudent.getStudentID()).isEmpty()) {
			if (!(objStudent.getStudentID()).equalsIgnoreCase(txtStudentID.getText())) {
				JOptionPane.showMessageDialog(btnSignIn, "Invalid Student ID");
				flag = false;
			} else if ((objStudent.getTempPIN()) != 0) {
				if (!(Integer.toString(objStudent.getTempPIN()).equals(txtPIN.getText()))) {
					JOptionPane.showMessageDialog(btnSignIn, "Invalid PIN");
					flag = false;
				}
			}
		}
		return flag;
	}
}
