package sample; 			               //Main file
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
        Scene scene = new Scene(pane, 800, 500);

        Canvas canvas = new Canvas(800,500);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        MyRectangle rec1 = new MyRectangle(400, 250, 400,250, MyColor.BIEGE);
        rec1.draw(gc);
        MyOval oval1 = new MyOval(400, 250, 400,250, MyColor.LIGHTLIME);
        oval1.draw(gc);

        MyRectangle rec2 = new MyRectangle(400, 250, 290,180, MyColor.LIGHTBROWN);
        rec2.draw(gc);
        MyOval oval2 = new MyOval(400, 250, 290,180, MyColor.SKYBLUE);
        oval2.draw(gc);

        MyRectangle rec3 = new MyRectangle(400, 250, 210,130, MyColor.SUNGLOW);
        rec3.draw(gc);
        MyOval oval3 = new MyOval(400, 250, 210,130, MyColor.WISTERIA);
        oval3.draw(gc);

        MyLine line1 = new MyLine(0, 800, 0, 500, MyColor.BLACK);
        line1.draw(gc);
        MyLine line2 = new MyLine(0, 0, 0, 500, MyColor.BLACK);
        line2.draw(gc);
        MyLine line3 = new MyLine(800, 0, 0, 0, MyColor.BLACK);
        line3.draw(gc);
        MyLine line4 = new MyLine(0, 800, 500, 500, MyColor.BLACK);
        line4.draw(gc);
        MyLine line5 = new MyLine(800, 800, 500, 0, MyColor.BLACK);
        line5.draw(gc);


        pane.getChildren().add(canvas);
        primaryStage.setTitle("Najeeb's Project #2");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}