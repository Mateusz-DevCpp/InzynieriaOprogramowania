package io.gui.controller;

import io.gui.Main;
import io.gui.Window;
import io.model.system.Pracownik;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class PrzypiszKarte_KController 
{
    
    @FXML
    public void initialize()
    {
        int ilosc_wyswietlonych_pracownikow = 0;
        
        for(int i=0; i<Main.manager_pracownikow.count(); i++)
        {
            if(Main.manager_pracownikow.get(i).getKarta() == -1)
            {
                lv_pracownicy.getItems().add(Main.manager_pracownikow.get(i));
                ilosc_wyswietlonych_pracownikow++;
            }
        }
        
        if(ilosc_wyswietlonych_pracownikow > 0)
        {
            lv_pracownicy.getSelectionModel().select(0);
        }
        else
        {
            bt_przypisz.setDisable(true);
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
    
    @FXML
    public void filtruj()
    {
        lv_pracownicy.getItems().clear();
        
        String filtr = tf_filtr.getText();
        
        if(filtr.length() == 0)
            initialize();
        else
        {
            int ilosc_wyswietlonych_pracownikow = 0;

            for(int i=0; i<Main.manager_pracownikow.count(); i++)
            {
                if(Main.manager_pracownikow.get(i).getKarta() == -1 &&
                        (Main.manager_pracownikow.get(i).getImie().contains(filtr) ||
                        Main.manager_pracownikow.get(i).getNazwisko().contains(filtr)))
                {
                    lv_pracownicy.getItems().add(Main.manager_pracownikow.get(i));
                    ilosc_wyswietlonych_pracownikow++;
                }
            }

            if(ilosc_wyswietlonych_pracownikow > 0)
            {
                lv_pracownicy.getSelectionModel().select(0);
            }
            else
            {
                bt_przypisz.setDisable(true);
            }
        }
    }
    
    @FXML
    public void anuluj() throws IOException
    {
        Window.setRoot("ModyfikujKarteWindow");
    }
    
    @FXML
    public void przypisz() throws IOException
    {
        WsywietlKartyController.wybrana_karta.setPrzypisana(true);
        lv_pracownicy.getSelectionModel().getSelectedItem().setKarta(WsywietlKartyController.wybrana_karta.getId());
        
        Window.setRoot("ModyfikujKarteWindow");
    }
    
    @FXML private ListView<Pracownik> lv_pracownicy;
    @FXML private Button bt_przypisz;
    @FXML private TextField tf_filtr;
}
