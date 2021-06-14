package io.gui.controller;

import io.gui.Window;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class MainController 
{
    @FXML
    public void initialize()
    {
        // to sie wykona podczas wlaczania onka, ktory ma ustawiony ten controller
        
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
    
    
    
    @FXML private MenuItem menu_start_sg;
    @FXML private MenuItem menu_start_wyloguj;
    
    @FXML private MenuItem menu_pracownicy_dodaj;
    @FXML private MenuItem menu_pracownicy_wyswietl;
    
    @FXML private MenuItem menu_karty_dodaj;
    @FXML private MenuItem menu_karty_wyswietl;
    
    @FXML private MenuItem menu_lokal_dodaj;
    @FXML private MenuItem menu_lokal_wyswietl;
}
