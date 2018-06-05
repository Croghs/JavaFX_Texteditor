import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

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

            // 3. NODE
            // Initialisieren des Buttons und setzen des Textes der auf dem Button auftaucht
            button = new Button();
            button.setText("Useless Button");

            // Fügen den Button zu unserem StackPane (Fenster) hinzu
            root.getChildren().add(button);



            MenuBar menuBar = new MenuBar();

            // --- Menu File
            Menu menuOpen = new Menu("Open");

            // --- Menu Edit
            Menu menuSave = new Menu("Save");

            // --- Menu View
            Menu menuExit = new Menu("Exit");

            menuBar.getMenus().addAll(menuOpen, menuSave, menuExit);

            root.getChildren().addAll(menuBar);

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
