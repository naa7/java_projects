package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.application.Application;
import javafx.scene.layout.StackPane;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;
import javafx.scene.Scene;
import java.util.Scanner;
import java.util.Map;
import java.io.File;

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
        HistogramAlphabet histogram = new HistogramAlphabet();

        //Using readFile method to return text file contents
        String s = readFile("/home/naa/Desktop/Alice in Wonderland.txt");

        //stores the counted repetitions of each letter to Data
        Map<Character, Integer> data = histogram.count(s);

        //takes the counted repetition in data
        chart.makeProbability(data);

        // set number of highest probability to draw in chart
        chart.setN(0);

        // draw the chart to screen
        chart.draw(gc);
        pane.getChildren().add(canvas);
        primaryStage.setTitle("Najeeb's Project 3");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public String readFile(String filepath) {
        String result = null;
        try {
            File file = new File(filepath);
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    result += scanner.nextLine();
                }
            }
        } catch (Exception e) {
            System.out.println("Error in read file");
            System.exit(-1);
        }
        return result;
    }

    public static void main(String[] args) { launch(args); }
}