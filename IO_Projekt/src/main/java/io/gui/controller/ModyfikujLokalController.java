package io.gui.controller;

import io.gui.Window;
import io.gui.Main;
import io.model.system.Lokal;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class ModyfikujLokalController 
{
    @FXML
    public void initialize()
    {
        lb_wiadomosc.setVisible(false);
        
        tf_nazwa.setText(WyswietlLokaleController.wybrany_lokal.getNazwa());
        tf_wym_uprawnienia.setText(WyswietlLokaleController.wybrany_lokal.getWymaganeUprawnienia());
        ta_opis.setText(WyswietlLokaleController.wybrany_lokal.getOpis());
        tf_poz_x.setText(Integer.toString(WyswietlLokaleController.wybrany_lokal.getPosX()));
        tf_poz_y.setText(Integer.toString(WyswietlLokaleController.wybrany_lokal.getPosY()));
    }
    
    
    @FXML
    public void zapisz() throws IOException
    {
        String nazwa = tf_nazwa.getText();
        String wym_uprawnienia = tf_wym_uprawnienia.getText();
        String opis = ta_opis.getText();
        
        String px = tf_poz_x.getText();
        String py = tf_poz_y.getText();
        
        boolean poprawne_dane = true;
        
        if(nazwa.length() == 0)
            poprawne_dane = false;
        if(wym_uprawnienia.length() == 0)
            poprawne_dane = false;
        if(opis.length() == 0)
            poprawne_dane = false;
        
        if(px.length() <= 0)
            poprawne_dane = false;
        if(py.length() <= 0)
            poprawne_dane = false;
        
        for(int i=0; i<px.length(); i++)
            if(px.charAt(i) < '0' || px.charAt(i) > '9')
                poprawne_dane = false;
        for(int i=0; i<py.length(); i++)
            if(py.charAt(i) < '0' || py.charAt(i) > '9')
                poprawne_dane = false;
        
        if(poprawne_dane == true)
        {
            Main.manager_lokali.update(WyswietlLokaleController.wybrany_lokal,
                    new Lokal(
                            nazwa, 
                            Integer.parseInt(px),
                            Integer.parseInt(py),
                            wym_uprawnienia, 
                            opis)
                    );
            
            mainMenu();
        }
        else
        {
            lb_wiadomosc.setVisible(true);
            lb_wiadomosc.setTextFill(Color.web("#FF0000"));
            lb_wiadomosc.setText("Wprowadzono bledne dane");
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
    
    @FXML private TextField tf_nazwa;
    @FXML private TextField tf_wym_uprawnienia;
    @FXML private TextField tf_poz_x;
    @FXML private TextField tf_poz_y;
    @FXML private TextArea ta_opis;
    @FXML private Label lb_wiadomosc;
}
