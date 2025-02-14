package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        CalculatorView myCalculator = new CalculatorView(new CalculatorViewModel(), primaryStage);
        primaryStage.setTitle("Калькулятор");
        primaryStage.setScene(new Scene(myCalculator, 500, 500));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
