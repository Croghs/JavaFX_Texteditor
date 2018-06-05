import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.io.*;

public class main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        try {
            primaryStage.setTitle("Dies ist ein Fenster lul");

            MenuBar menuBar = new MenuBar();
            Menu menuOpen = new Menu("Open");
            Menu menuSave = new Menu("Save");
            Menu menuExit = new Menu("Exit");

            BorderPane root = new BorderPane();
            menuBar.getMenus().addAll(menuOpen, menuSave, menuExit);
            root.setTop(menuBar);

            Button button = new Button("Open dis");
            root.setCenter(button);

            menuExit.setOnAction(e -> Platform.exit()); //funktioniert nicht

            button.setOnAction(new EventHandler<ActionEvent>(){ //funktioniert nur bei Button, nicht mit menuOpen
                @Override
                public void handle(ActionEvent open){
                    FileChooser fileChooser = new FileChooser();
                    FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
                    fileChooser.getExtensionFilters().add(extFilter);
                    File file = fileChooser.showOpenDialog(primaryStage);
                    if(file != null){
                        System.out.print(file);
                    }
                }
            });

            Scene scene = new Scene(root,600,400);
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }


    }
    /*private String readFile (File file){
        StringBuilder stringBuffer = new StringBuilder();
        BufferedReader bufferedReader = null;
        try{
            bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = bufferedReader.readLine()) != null)
                stringBuffer.append(line);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return stringBuffer.toString();
    }*/

}
