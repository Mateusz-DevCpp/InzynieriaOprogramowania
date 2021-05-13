package io.gui;

import java.io.IOException;
import javafx.application.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.stage.*;

public class Window extends Application
{
   private static Scene scene;
    
    public static void main(String[] args) 
    {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException 
    {
        scene = new Scene(loadFXML("main"), 640, 480);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("System zarzadzania pracownikami");
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException 
    {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException 
    {
        System.out.println(Main.class.getResource(fxml + ".fxml"));
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
}