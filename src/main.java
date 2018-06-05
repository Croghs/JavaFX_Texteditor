import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

import static javafx.application.Application.launch;

public class main extends Application {

    Button button;

    @Override
    public void start(Stage primaryStage) {
        try {
            // 1. STAGE
            // Damit setzen wir den Titel unseres Fensters
            primaryStage.setTitle("Dies ist ein Fenster lul");

            // Wir verwenden einen StackPane, dabei handelt es sich um eine Layoutklasse,
            // welche die Eigenschaften
            // und Funktionalität des Layouts bestimmen
            StackPane root = new StackPane();

            // 2.SCENE
            // Wir legen unsere Scene an, welche innerhalb des StackPanes root ist
            // und eine Größe von 400 * 400 Pixel hat
            Scene scene = new Scene(root,600,400);



            MenuBar menuBar = new MenuBar();

            // --- Menu File
            Menu menuOpen = new Menu("Open");

            // --- Menu Edit
            Menu menuSave = new Menu("Save");

            // --- Menu View
            Menu menuExit = new Menu("Exit");

            menuBar.getMenus().addAll(menuOpen, menuSave, menuExit);

            menuBar.setTranslateY(-190);

            root.getChildren().addAll(menuBar);

            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open Resource File");
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Text Files", "*.txt"));
            File selectedFile = fileChooser.showOpenDialog(primaryStage);
            if (selectedFile != null) {
                System.out.println("Erfolgreich");
            }


            // nun Setzen wir die Scene zu unserem Stage und zeigen ihn an
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        // In der Main Methode rufen wir launch auf, welches unser Fenster startet
        launch(args);
    }
}
