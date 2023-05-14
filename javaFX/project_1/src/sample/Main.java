fpackage sample;
import java.awt.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {
    @Override

    public void start(Stage primaryStage) {

        StackPane pane = new StackPane();
        Scene scene = new Scene(pane, 800, 500); //setting the size of the scene
        Canvas canvas = new Canvas(800,500);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        MyShape shape1 = new MyShape(840, 600, Color.white);
        shape1.draw(gc);
        MyPolygon polygon1 = new MyPolygon(400,250, 6, 235, Color.gray);
        polygon1.draw(gc);
        MyCircle circle2 = new MyCircle(200, 50, 400, Color.yellow);
        circle2.draw(gc);
        MyPolygon polygon2 = new MyPolygon(400,250, 6, 200, Color.green);
        polygon2.draw(gc);
        MyCircle circle3 = new MyCircle(230, 80, 340, Color.pink);
        circle3.draw(gc);
        MyPolygon polygon3 = new MyPolygon(400,250, 6, 170, Color.cyan);
        polygon3.draw(gc);
        MyLine line1 = new MyLine(0, 800, 0, 500, Color.black);
        line1.draw(gc);
        MyLine line2 = new MyLine(800, 0, 0, 500, Color.black);
        line2.draw(gc);
        MyLine line3 = new MyLine(0, 0, 0, 500, Color.black);
        line3.draw(gc);
        MyLine line4 = new MyLine(800, 0, 0, 0, Color.black);
        line4.draw(gc);
        MyLine line5 = new MyLine(0, 800, 500, 500, Color.black);
        line5.draw(gc);
        MyLine line6 = new MyLine(800, 800, 500, 0, Color.black);
        line6.draw(gc);
        pane.getChildren().add(canvas);
        primaryStage.setTitle("MyShape");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}



