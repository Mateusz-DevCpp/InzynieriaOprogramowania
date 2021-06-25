package io.gui.controller;

import io.gui.Main;
import io.gui.Window;
import io.model.system.Karta;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class PrzypiszKarte_PController 
{
    @FXML
    public void initialize()
    {
        int ilosc_dodanych_pozycji = 0;
        for(int i=0; i<Main.manager_kart.count(); i++)
        {
            if(!Main.manager_kart.get(i).isPrzypisana())
            {
                lv_dostepne_karty.getItems().add(Main.manager_kart.get(i));
                ilosc_dodanych_pozycji++;
            }
        }
        
        if(ilosc_dodanych_pozycji > 0)
        {
            lv_dostepne_karty.getSelectionModel().select(0);
        }
        else
        {
            bt_przypisz.setDisable(true);
        }
    }
    
    @FXML
    public void filtruj()
    {
        lv_dostepne_karty.getItems().clear();
        
        String filtr = tf_filtr.getText();
        if(filtr.length() == 0)
        {
            initialize();
        }
        else
        {
            int ilosc_dodanych_pozycji = 0;
            for(int i=0; i<Main.manager_kart.count(); i++)
            {
                if(!Main.manager_kart.get(i).isPrzypisana())
                {
                    if(Integer.toString(Main.manager_kart.get(i).getId()).contains(filtr))
                    {
                        lv_dostepne_karty.getItems().add(Main.manager_kart.get(i));
                        ilosc_dodanych_pozycji++;
                    }
                }
            }

            if(ilosc_dodanych_pozycji > 0)
            {
                lv_dostepne_karty.getSelectionModel().select(0);
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
        Window.setRoot("ModyfikujPracownikaWindow");
    }
    
    @FXML
    public void przypisz() throws IOException
    {
        WyswietlPracownikowController.wybrany_pracownik.setKarta(lv_dostepne_karty.getSelectionModel().getSelectedItem().getId());
        lv_dostepne_karty.getSelectionModel().getSelectedItem().setPrzypisana(true);
        
        Window.setRoot("ModyfikujPracownikaWindow");
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
    public void menuDodajKarte() throws IOException
    {
        Window.setRoot("DodajKarteWindow");
    }
    
    @FXML
    public void menuZarzadzajWynagrodzeniami() throws IOException
    {
        Window.setRoot("ZarzadzajWynadrodzeniamiWindow");
    }
    
    @FXML private TextField tf_filtr;
    @FXML private Button bt_przypisz;
    @FXML private ListView<Karta> lv_dostepne_karty;
}
