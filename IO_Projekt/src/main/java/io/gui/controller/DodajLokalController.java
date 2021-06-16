package io.gui.controller;

import io.gui.Main;
import io.gui.Window;
import io.model.system.Lokal;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class DodajLokalController 
{
    @FXML
    public void initialize()
    {
        lb_wiadomosc.setVisible(false);
    }
    
    @FXML
    public void dodaj() throws IOException
    {
        String nazwa = tf_nazwa.getText();
        String wym_uprawnienia = tf_wym_uprawnienia.getText();
        String opis = ta_opis.getText();
        
        boolean bledne_dane = false;
        
        if(nazwa == "")
            bledne_dane = true;
        if(wym_uprawnienia == "")
            bledne_dane = true;
        
        String spx = tf_poz_x.getText();
        String spy = tf_poz_y.getText();
        
        
        if(spx.length() == 0)
                bledne_dane = true;
        if(spy.length() == 0)
                bledne_dane = true;
        
        for(int i=0; i<spx.length(); i++)
            if(spx.charAt(i) < '0' || spx.charAt(i) > '9')
                bledne_dane = true;
        for(int i=0; i<spy.length(); i++)
            if(spy.charAt(i) < '0' || spy.charAt(i) > '9')
                bledne_dane = true;
                
        
        if(bledne_dane)
        {
            lb_wiadomosc.setVisible(true);
            lb_wiadomosc.setTextFill(Color.web("#FF0000"));
            lb_wiadomosc.setText("Wprowadzono bledne dane");
        }
        else
        {
            int px = Integer.valueOf(spx);
            int py = Integer.valueOf(spy);
        
            Main.manager_lokali.register(
                    new Lokal(nazwa, px, py, wym_uprawnienia, opis)
            );
            
            mainMenu();
        }
    }
    
    @FXML
    public void mainMenu() throws IOException
    {
        Window.setRoot("MainWindow");
    }
    
    @FXML
    public void menuDodajPracownika() throws IOException
    {
        Window.setRoot("DodajPracownikaWindow");
    }
    
    @FXML
    public void menuWyswietlPracownikow() throws IOException
    {
        Window.setRoot("WyswietlPracownikowWindow");
    }
    
    @FXML
    public void menuWyswietlLokale() throws IOException
    {
        Window.setRoot("WyswietlLokaleWindow");
    }
    
    @FXML
    public void menuDodajLokal() throws IOException
    {
        Window.setRoot("DodajLokalWindow");
    }
    
    @FXML
    public void menuWyswietlKarty() throws IOException
    {
        Window.setRoot("WsywietlKartyWindow");
    }
    
    @FXML private TextField tf_poz_x;
    @FXML private TextField tf_poz_y;
    @FXML private TextField tf_nazwa;
    @FXML private TextArea ta_opis;
    @FXML private TextField tf_wym_uprawnienia;
    @FXML private Label lb_wiadomosc;
}
