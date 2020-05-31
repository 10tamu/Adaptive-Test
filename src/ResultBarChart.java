import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
 
public class ResultBarChart extends Application implements ActionListener{
    final static String maths = "Maths";
    final static String image = "Image";
    final static String listening = "Listening";
    final static String spelling = "Spelling";
    final static String writing = "Writing";
    
    public int _mathsmarks = 0; 
 
    public ResultBarChart(int mathsMarks) {
    	_mathsmarks = mathsMarks;
    }
    
public ResultBarChart() {
    	
    }
    @Override public void start(Stage stage) {
        stage.setTitle("Result Chart");
        final NumberAxis xAxis = new NumberAxis();
        final CategoryAxis yAxis = new CategoryAxis();
        final BarChart<Number,String> bc = 
            new BarChart<Number,String>(xAxis,yAxis);
        bc.setTitle("Result Chart");
        xAxis.setLabel("Value");  
        xAxis.setTickLabelRotation(90);
        yAxis.setLabel("Subjects");        
 
        
        //Test oo = new Test(new Student());
        //oo.
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Obtained");       
        series1.getData().add(new XYChart.Data(Test.mathsObtainedMarks, maths));
        series1.getData().add(new XYChart.Data(Test.imageObtainedMarks, image));
        series1.getData().add(new XYChart.Data(Test.listeningObtainedMarks, listening));
        series1.getData().add(new XYChart.Data(Test.spellingObtainedMarks, spelling));
        series1.getData().add(new XYChart.Data(Test.writingObtainedMarks, writing));      
        
        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Total");
        series2.getData().add(new XYChart.Data(Test.mathsTotalMarks, maths));
        series2.getData().add(new XYChart.Data(Test.imageTotalMarks, image));
        series2.getData().add(new XYChart.Data(Test.listeningTotalMarks, listening));
        series2.getData().add(new XYChart.Data(Test.spellingTotalMarks, spelling));
        series2.getData().add(new XYChart.Data(Test.writingTotalMarks, writing));  
        
        Scene scene  = new Scene(bc,800,600);
        bc.getData().addAll(series1, series2);
        stage.setScene(scene);
        stage.show();
    }
 
    public static void main(String[] args) {
        launch(args);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
