package unb.cs3035.individualproject;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
    public static final Model model = new Model();
    public static final View view = new View();
    public static final Controller controller = new Controller();

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane borderPane = view.getBorderPane();

        Scene scene = new Scene(borderPane, 1504,1010);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
