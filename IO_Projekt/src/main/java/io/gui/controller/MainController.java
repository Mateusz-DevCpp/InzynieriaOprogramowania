package io.gui.controller;

import io.gui.Main;
import io.gui.Window;
import io.model.manager.ManagerKart;
import io.model.manager.ManagerLokali;
import io.model.manager.ManagerPracownikow;
import java.io.IOException;
import javafx.fxml.FXML;

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
    public void menuDodajLokal() throws IOException
    {
        Window.setRoot("DodajLokalWindow");
    }
    
    @FXML
    public void menuWyswietlKarty() throws IOException
    {
        Window.setRoot("WsywietlKartyWindow");
    }
    
    @FXML
    public void menuDodajKarte() throws IOException
    {
        Window.setRoot("DodajKarteWindow");
    }
    
    @FXML
    public void menuZarzadzajWynagrodzeniami() throws IOException
    {
        Window.setRoot("ZarzadzajWynadrodzeniamiWindow");
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
