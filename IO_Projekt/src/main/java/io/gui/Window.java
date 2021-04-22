package io.gui;

import java.io.IOException;
import javafx.application.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;

public class Window extends Application implements EventHandler<ActionEvent> 
{

    private Button button[];
    
    public static void main(String[] args) 
    {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) throws Exception 
    {
        stage.setTitle("Test");
        
        Scene scene = new Scene(loadControls(), 800, 600);
        
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void handle(ActionEvent event) 
    {
        if(event.getSource() == button[0]) 
        {
            System.err.println("press button 1");
        }
        else if(event.getSource() == button[1]) 
        {
            System.err.println("press button 2");
        }
    }
    
    public Pane loadControls()
    {
        Pane layout = new Pane();
        
        button = new Button[2];
        
        button[0] = new Button();
        button[0].setText("click-I");
        button[0].setLayoutX(10);
        button[0].setLayoutY(10);
        button[0].setOnAction(this);
        
        button[1] = new Button();
        button[1].setText("click-II");
        button[1].setLayoutX(10);
        button[1].setLayoutY(40);
        button[1].setOnAction(this);

        layout.getChildren().add(button[0]);
        layout.getChildren().add(button[1]);
        
        return layout;
    }
}