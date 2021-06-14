package io.gui.controller;

import io.gui.Main;
import io.gui.Window;
import io.model.manager.ManagerKart;
import io.model.manager.ManagerLokali;
import io.model.manager.ManagerPracownikow;
import io.model.system.Karta;
import io.model.system.Pracownik;
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
    
    @FXML
    public void menuWyswietlLokale() throws IOException
    {
        Window.setRoot("WyswietlLokaleWindow");
    }
    
    @FXML
    public void wyloguj() throws IOException
    {
        Main.manager_kart = new ManagerKart();
        Main.manager_lokali = new ManagerLokali();
        Main.manager_pracownikow = new ManagerPracownikow();
        
        Window.setRoot("LogowanieWindow");
    }
    
}
