//import javafx.application.Application;
//import javafx.scene.Scene;
//import javafx.scene.chart.BarChart;
//import javafx.scene.chart.CategoryAxis;
//import javafx.scene.chart.NumberAxis;
//import javafx.scene.chart.XYChart;
//import javafx.stage.Stage;
//
//public class ResultChart extends Application{
//
//	final static String MATHS = "Maths";
//	final static String IMAGE = "Image";
//	final static String SPELLING = "Spelling";
//	final static String LISTENING = "Listening";
//	final static String WRITING = "Writing";
//	
//	public ResultChart() {
//		final CategoryAxis xAxis = new CategoryAxis();
//		final NumberAxis yAxis = new NumberAxis();
//		final BarChart<String,Number> bc = new BarChart<>(xAxis,yAxis);
//		
//		bc.setTitle("Test result");
//		xAxis.setLabel("Subjects");
//		yAxis.setLabel("Marks");
//		
//		XYChart.Series s1 = new XYChart.Series();
//		s1.setName("Adaptive Test");
//		s1.getData().add(new XYChart.Data("Maths",25));	
//		s1.getData().add(new XYChart.Data("Image",70));
//		s1.getData().add(new XYChart.Data("Spelling",5));
//		s1.getData().add(new XYChart.Data("Listenining",15));
//		s1.getData().add(new XYChart.Data("Writing",50));
//		Scene scene = new Scene(bc,800,600);
//		bc.getData().addAll(s1);
//	}
//	@Override
//	public void start(Stage stage) throws Exception {
//		// TODO Auto-generated method stub
//		stage.setTitle("Result chart");
//		final CategoryAxis xAxis = new CategoryAxis();
//		final NumberAxis yAxis = new NumberAxis();
//		final BarChart<String,Number> bc = new BarChart<>(xAxis,yAxis);
//		
//		bc.setTitle("Test result");
//		xAxis.setLabel("Subjects");
//		yAxis.setLabel("Marks");
//		
//		XYChart.Series s1 = new XYChart.Series();
//		s1.setName("Adaptive Test");
//		s1.getData().add(new XYChart.Data("Maths",25));	
//		s1.getData().add(new XYChart.Data("Image",70));
//		s1.getData().add(new XYChart.Data("Spelling",5));
//		s1.getData().add(new XYChart.Data("Listenining",15));
//		s1.getData().add(new XYChart.Data("Writing",50));
//		Scene scene = new Scene(bc,800,600);
//		bc.getData().addAll(s1);
//		stage.setScene(scene);
//		stage.show();
//	}
//
//}






import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Models.Student;

public class ResultChart123 extends JFrame implements ActionListener {
	public static final int WIDTH = 1000;
	public static final int HEIGHT = 1000;
	JLabel lblFormName, lblStudentID, lblPIN;
	JTextField txtStudentID, txtPIN;
	Student objStudent = new Student();

	JButton btnSignIn;

	public ResultChart123(Student student) {

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
		txtPIN = new JTextField();

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

	


}

