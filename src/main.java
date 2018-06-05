import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.io.*;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;

public class main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        try {
            primaryStage.setTitle("Dies ist ein Fenster lul");

            MenuBar menuBar = new MenuBar();
            Menu menu = new Menu("Menü");
            MenuItem menuOpen = new MenuItem("Open");
            MenuItem menuSave = new MenuItem("Save");
            MenuItem menuExit = new MenuItem("Exit");
            menu.getItems().addAll(menuOpen,menuSave,menuExit);


            BorderPane root = new BorderPane();
            menuBar.getMenus().addAll(menu);
            root.setTop(menuBar);

            menuOpen.setOnAction(new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent open){
                    FileChooser fileChooser = new FileChooser();
                    FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
                    fileChooser.getExtensionFilters().add(extFilter);
                    File file = fileChooser.showOpenDialog(null);
                    if(file != null){
                        try{
                            Files.lines(file.toPath()).forEach(System.out::println);
                        } catch (IOException ex){
                            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            });

            menuSave.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent save) {
                    FileChooser fileChooser = new FileChooser();
                    FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
                    fileChooser.getExtensionFilters().add(extFilter);
                    File file = fileChooser.showSaveDialog(primaryStage);
                    if(file != null){
                        SaveFile("blabla", file);
                    }
                }
            });

            menuExit.setOnAction(e -> Platform.exit());

            Scene scene = new Scene(root,400,400);
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void SaveFile(String content, File file){
        try {
            FileWriter fileWriter = null;

            fileWriter = new FileWriter(file);
            fileWriter.write(content);
            fileWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

     /*private String readFile (File file){
        StringBuilder stringBuffer = new StringBuilder();

        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String text;
            while ((text = bufferedReader.readLine()) != null) {
                stringBuffer.append(text);
            }
            bufferedReader.close();
        }

        catch (IOException e) {
            e.printStackTrace();
        }

        return stringBuffer.toString();
    }*/

}
