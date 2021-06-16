package io.gui.controller;

import io.gui.Window;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SzczegolyLokaluController 
{
    @FXML
    public void initialize()
    {
        // to sie wykona podczas wlaczania onka, ktory ma ustawiony ten controller
        
        tf_nazwa.setText(WyswietlLokaleController.wybrany_lokal.getNazwa());
        tf_wym_uprawnienia.setText(WyswietlLokaleController.wybrany_lokal.getWymaganeUprawnienia());
        tf_poz_x.setText(Integer.toString(WyswietlLokaleController.wybrany_lokal.getPosX()));
        tf_poz_y.setText(Integer.toString(WyswietlLokaleController.wybrany_lokal.getPosY()));
        ta_opis.setText(WyswietlLokaleController.wybrany_lokal.getOpis());
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
    public void menuDodajLokal() throws IOException
    {
        Window.setRoot("DodajLokalWindow");
    }
    
    @FXML
    public void menuWyswietlKarty() throws IOException
    {
        Window.setRoot("WsywietlKartyWindow");
    }
    
    @FXML private TextField tf_nazwa;
    @FXML private TextField tf_wym_uprawnienia;
    @FXML private TextField tf_poz_x;
    @FXML private TextField tf_poz_y;
    @FXML private TextArea ta_opis;
}
