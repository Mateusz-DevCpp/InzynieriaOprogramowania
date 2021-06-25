package io.gui.controller;

import io.gui.Main;
import io.gui.Window;
import io.model.logowanie.Konto;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class LogowanieController 
{
    @FXML
    public void initialize()
    {
        lb_wiadomosc.setVisible(false);
    }
    
    @FXML 
    public void zaloguj() throws IOException
    {
        String wprowadzony_login = tf_login.getText();
        String wprowadzone_haslo = tf_haslo.getText();
        
        if(Main.manager_kont.probaLogowania(new Konto(wprowadzony_login, wprowadzone_haslo)) == 0)
        {
            Window.setRoot("MainWindow");
        }
        else
        {
            lb_wiadomosc.setVisible(true);
            lb_wiadomosc.setText("Cos jest zle...");
            lb_wiadomosc.setTextFill(Color.web("#FF0000"));
        }
        
    }
    
    
    @FXML Label lb_wiadomosc;
    @FXML TextField tf_login;
    @FXML TextField tf_haslo;
    @FXML Button bt_zaloguj;
}
