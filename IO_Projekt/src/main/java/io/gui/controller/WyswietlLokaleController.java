package io.gui.controller;

import io.gui.Main;
import io.gui.Window;
import io.model.system.Lokal;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class WyswietlLokaleController 
{
    static public Lokal wybrany_lokal = null;
    
    @FXML
    public void initialize()
    {
        for(int i=0; i<Main.manager_lokali.count(); i++)
        {
            lv_lokale.getItems().add(Main.manager_lokali.get(i));
        }
        
        if(Main.manager_lokali.count() > 0)
        {
            lv_lokale.getSelectionModel().select(0);
        }
        else
        {
            bt_usun.setDisable(true);
            bt_modyfikuj.setDisable(true);
            bt_szczegoly.setDisable(true);
        }
    }
    
    @FXML
    public void filtruj()
    {
        lv_lokale.getItems().clear();
        
        String filtr = tf_filtr.getText();
        int ilosc_danych_do_wyswietlenia = 0;
        
        bt_usun.setDisable(false);
        bt_modyfikuj.setDisable(false);
        bt_szczegoly.setDisable(false);
        
        if(filtr == "")
        {
            for(int i=0; i<Main.manager_lokali.count(); i++)
            {
                ilosc_danych_do_wyswietlenia++;
                lv_lokale.getItems().add(Main.manager_lokali.get(i));
            }
        }
        else
        {
            for(int i=0; i<Main.manager_lokali.count(); i++)
            {
                if(Main.manager_lokali.get(i).getNazwa().contains(filtr))
                {
                    ilosc_danych_do_wyswietlenia++;
                    lv_lokale.getItems().add(Main.manager_lokali.get(i));
                }
            }
        }

        if(ilosc_danych_do_wyswietlenia > 0)
        {
            lv_lokale.getSelectionModel().select(0);
        }
        else
        {
            bt_usun.setDisable(true);
            bt_modyfikuj.setDisable(true);
            bt_szczegoly.setDisable(true);
        }
    }
    
    
    @FXML
    public void usun() throws IOException
    {
        wybrany_lokal = lv_lokale.getSelectionModel().getSelectedItem();
        Main.manager_lokali.unregister(wybrany_lokal);
        wybrany_lokal = null;
        lv_lokale.getItems().clear();
        initialize();
    }
    
    @FXML
    public void modyfikuj() throws IOException
    {
        wybrany_lokal = lv_lokale.getSelectionModel().getSelectedItem();
        Window.setRoot("ModyfikujLokalWindow");
    }
    
    @FXML
    public void szczegoly() throws IOException
    {
        wybrany_lokal = lv_lokale.getSelectionModel().getSelectedItem();
        Window.setRoot("SzczegolyLokaluWindow");
    }
    
    @FXML
    public void menuWyswietlKarty() throws IOException
    {
        Window.setRoot("WsywietlKartyWindow");
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
    public void menuDodajKarte() throws IOException
    {
        Window.setRoot("DodajKarteWindow");
    }
    
    @FXML
    public void menuZarzadzajWynagrodzeniami() throws IOException
    {
        Window.setRoot("ZarzadzajWynadrodzeniamiWindow");
    }
    
    @FXML private Button bt_usun;
    @FXML private Button bt_modyfikuj;     
    @FXML private Button bt_szczegoly;
    @FXML private TextField tf_filtr;
    @FXML private ListView<Lokal> lv_lokale;
}
