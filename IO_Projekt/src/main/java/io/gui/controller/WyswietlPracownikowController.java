package io.gui.controller;

import io.gui.Main;
import io.gui.Window;
import io.model.system.Adres;
import io.model.system.Kontakt;
import io.model.system.Pracownik;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class WyswietlPracownikowController
{
    static public Pracownik wybrany_pracownik = null;
    
    @FXML
    public void initialize()
    {
        for(int i=0; i<Main.manager_pracownikow.count(); i++)
        {
            lv_pracownicy.getItems().add(Main.manager_pracownikow.get(i));
        }
        
        if(Main.manager_pracownikow.count() > 0)
        {
            lv_pracownicy.getSelectionModel().select(0);
        }
        else
        {
            bt_usun.setDisable(true);
            bt_modyfikuj.setDisable(true);
            bt_szczegoly.setDisable(true);
        }
    }

    @FXML
    public void mainMenu() throws IOException
    {
        Window.setRoot("MainWindow");
    }
    
    @FXML
    public void modyfikujPracownika() throws IOException
    {
        wybrany_pracownik = lv_pracownicy.getSelectionModel().getSelectedItem();
        Window.setRoot("ModyfikujPracownikaWindow");
    }
    
    @FXML 
    public void usunPracownika()
    {
        wybrany_pracownik = lv_pracownicy.getSelectionModel().getSelectedItem();
        Main.manager_pracownikow.unregister(wybrany_pracownik);
        wybrany_pracownik = null;
        lv_pracownicy.getItems().clear();
        initialize();
    }
    
    @FXML 
    public void szczegolyPracownika() throws IOException
    {
        wybrany_pracownik = lv_pracownicy.getSelectionModel().getSelectedItem();
        Window.setRoot("SzczegolyPracownikaWindow");
    }
    
    @FXML
    public void filtruj()
    {
        lv_pracownicy.getItems().clear();
        
        String filtr = tf_filtr.getText();
        int ilosc_danych_do_wyswietlenia = 0;
        
        bt_usun.setDisable(false);
        bt_modyfikuj.setDisable(false);
        bt_szczegoly.setDisable(false);
        
        if(filtr == "")
        {
            for(int i=0; i<Main.manager_pracownikow.count(); i++)
            {
                ilosc_danych_do_wyswietlenia++;
                lv_pracownicy.getItems().add(Main.manager_pracownikow.get(i));
            }
        }
        else
        {
            for(int i=0; i<Main.manager_pracownikow.count(); i++)
            {
                if(Main.manager_pracownikow.get(i).getNazwisko().contains(filtr))
                {
                    ilosc_danych_do_wyswietlenia++;
                    lv_pracownicy.getItems().add(Main.manager_pracownikow.get(i));
                }
            }
        }

        if(ilosc_danych_do_wyswietlenia > 0)
        {
            lv_pracownicy.getSelectionModel().select(0);
        }
        else
        {
            bt_usun.setDisable(true);
            bt_modyfikuj.setDisable(true);
            bt_szczegoly.setDisable(true);
        }
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
    
    @FXML private TextField tf_filtr;
    @FXML private ListView<Pracownik> lv_pracownicy;
    
    @FXML private Button bt_filtruj;
    
    @FXML private Button bt_usun;
    @FXML private Button bt_modyfikuj;
    @FXML private Button bt_szczegoly;
}
