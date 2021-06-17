package io.gui.controller;

import io.gui.Main;
import io.gui.Window;
import io.model.system.Wynagrodzenie;
import java.io.IOException;
import java.time.LocalDate;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;

public class WyswietlHistorieWynagrodzenController 
{
    @FXML
    public void initialize()
    {
        int liczba_dodanych_wartosci = 0;
        for(int i=0; i<Main.manager_wynagrodzen.count(); i++)
        {
            if(Main.manager_wynagrodzen.get(i).getPracownik() == WyswietlPracownikowController.wybrany_pracownik)
            {
                lv_wynagrodzenia.getItems().add(Main.manager_wynagrodzen.get(i));
                liczba_dodanych_wartosci++;
            }
        }
        
        if(liczba_dodanych_wartosci > 0)
        {
            lv_wynagrodzenia.getSelectionModel().select(0);
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
    public void filtruj()
    {
        lv_wynagrodzenia.getItems().clear();
        
        LocalDate dod = dp_od_daty.getValue();
        LocalDate ddd = dp_do_daty.getValue();
        
        int liczba_dodanych_wartosci = 0;
        for(int i=0; i<Main.manager_wynagrodzen.count(); i++)
        {
            if(Main.manager_wynagrodzen.get(i).getPracownik() == WyswietlPracownikowController.wybrany_pracownik)
            {
                LocalDate tmp = LocalDate.now();//Main.manager_wynagrodzen.get(i).getDataOtrzymania();
                System.err.println(tmp.compareTo(dod) + " " + tmp.compareTo(ddd));
                if(tmp.compareTo(dod) >= 1 && tmp.compareTo(ddd) <= -1)
                {
                    lv_wynagrodzenia.getItems().add(Main.manager_wynagrodzen.get(i));
                    liczba_dodanych_wartosci++;
                }
            }
        }
        
        if(liczba_dodanych_wartosci > 0)
        {
            lv_wynagrodzenia.getSelectionModel().select(0);
        }
    }
    
    @FXML private ListView<Wynagrodzenie> lv_wynagrodzenia;
    @FXML private DatePicker dp_od_daty;
    @FXML private DatePicker dp_do_daty;
}
