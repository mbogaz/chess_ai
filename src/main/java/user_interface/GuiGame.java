package user_interface;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class GuiGame extends Application {

    private Stage primaryStage;
    GridPane board;

    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Chess");

        board = loadView("fxml/main.fxml");
        Scene scene = new Scene(board);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private <T> T loadView(String fxmlPath) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource(fxmlPath));
        try {
            return (T) loader.load();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("ERROR ON LOADING : " + fxmlPath);
        }
    }
}
