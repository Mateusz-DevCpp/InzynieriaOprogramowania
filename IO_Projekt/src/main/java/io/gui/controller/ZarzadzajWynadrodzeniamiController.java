package io.gui.controller;

import io.gui.Main;
import io.gui.Window;
import io.model.system.Pracownik;
import io.model.system.Wynagrodzenie;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class ZarzadzajWynadrodzeniamiController 
{   
    @FXML
    public void initialize()
    {
        lb_wiadomosc.setVisible(false);
        
        bt_wyplac_wyn.setDisable(false);
        bt_wyswietl_wyn.setDisable(false);
        
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
            bt_wyplac_wyn.setDisable(true);
            bt_wyswietl_wyn.setDisable(true);
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
    public void filtruj()
    {
        lv_pracownicy.getItems().clear();
        
        bt_wyplac_wyn.setDisable(false);
        bt_wyswietl_wyn.setDisable(false);
        
        String filtr = tf_filtr.getText();
        if(filtr.length() == 0)
        {
            initialize();
        }
        else
        {
            int ilosc_dodanych_pozycji = 0;
            for(int i=0; i<Main.manager_pracownikow.count(); i++)
            {
                if(Main.manager_pracownikow.get(i).getImie().contains(filtr) ||
                        Main.manager_pracownikow.get(i).getNazwisko().contains(filtr))
                {
                    lv_pracownicy.getItems().add(Main.manager_pracownikow.get(i));
                    ilosc_dodanych_pozycji++;
                }
            }

            if(ilosc_dodanych_pozycji > 0)
            {
                lv_pracownicy.getSelectionModel().select(0);
            }
            else
            {
                bt_wyplac_wyn.setDisable(true);
                bt_wyswietl_wyn.setDisable(true);
            }
        }
    }
    
    @FXML
    public void wyplacWynagrodzenie()
    {
        Pracownik ptr = lv_pracownicy.getSelectionModel().getSelectedItem();
        
        String nadgodziny = if_ilosc_nadgodzin.getText();
        String nadgodziny_cena = tf_stawka_nadgodzin.getText();
        
        if(nadgodziny.length() == 0 || nadgodziny_cena.length() == 0)
        {
            lb_wiadomosc.setVisible(true);
            lb_wiadomosc.setTextFill(Color.web("#FF0000"));
            lb_wiadomosc.setText("Wprowadz dane");
            return;
        }
        
        Main.manager_wynagrodzen.register(
                new Wynagrodzenie(ptr, 
                    ptr.getStanowisko().getZarobki(),
                    Float.parseFloat(nadgodziny_cena),
                    Integer.parseInt(nadgodziny))
        );
        
        lb_wiadomosc.setVisible(true);
        lb_wiadomosc.setTextFill(Color.web("#00FF00"));
        lb_wiadomosc.setText("Dodano wynagrodzenie");
    }
    
    @FXML
    public void wyswietlWynagrodzenia() throws IOException
    {
        WyswietlPracownikowController.wybrany_pracownik = lv_pracownicy.getSelectionModel().getSelectedItem();
        Window.setRoot("WyswietlHistorieWynagrodzenWindow");
    }
    
    @FXML
    public void aktualizujWybranegoPracownika()
    {
        Pracownik ptr = lv_pracownicy.getSelectionModel().getSelectedItem();
        
        tf_imie.setText(ptr.getImie());
        tf_nazwisko.setText(ptr.getNazwisko());
        tf_stanowisko.setText(ptr.getStanowisko().getNazwa());
        tf_wyplata_bazowa.setText(Float.toString(ptr.getStanowisko().getZarobki()));
             
        ptr = null;
    }
    
    @FXML private ListView<Pracownik> lv_pracownicy;
    @FXML private Button bt_wyplac_wyn;
    @FXML private Button bt_wyswietl_wyn;
    @FXML private TextField tf_filtr;
    @FXML private Label lb_wiadomosc;
    @FXML private TextField tf_imie;
    @FXML private TextField tf_nazwisko;
    @FXML private TextField tf_stanowisko;
    @FXML private TextField tf_wyplata_bazowa;
    @FXML private TextField tf_stawka_nadgodzin;
    @FXML private TextField if_ilosc_nadgodzin;
}
