package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.application.Application;
import javafx.scene.layout.StackPane;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;
import javafx.scene.Scene;
import java.util.Map;
public class Main extends Application {

    // setting final values for width and height of the chart, and x&y for chart position
    public static final int w = 800, h = 800;
    @Override
    public void start(Stage primaryStage) {

        StackPane pane = new StackPane();

        //setting the size of the scene
        Scene scene = new Scene(pane, w, h);
        Canvas canvas = new Canvas(w, h);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        MyPieChart chart = new MyPieChart(w / 2, h / 2, w / 2, h / 2, MyColor.GREEN);
        HistogramGrade histogram = new HistogramGrade();
        DatabaseConnector.main(null);

        //stores the counted repetitions of each letter to Data
        Map<String, Integer> data = histogram.getData();

        //takes the counted repetition in data
        chart.makeProbability(data);

        // set number of highest probability to draw in chart
        chart.setN(5);

        // draw the chart to screen
        chart.draw(gc);
        pane.getChildren().add(canvas);
        primaryStage.setTitle("Najeeb's Project 4");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) { launch(args); }
}