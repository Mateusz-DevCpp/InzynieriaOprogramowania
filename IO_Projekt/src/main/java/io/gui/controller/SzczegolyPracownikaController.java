package io.gui.controller;

import io.gui.Main;
import io.gui.Window;
import io.model.system.Karta;
import io.model.system.Lokal;
import io.model.system.Lokalizacja;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class SzczegolyPracownikaController 
{
    private Karta karta_pracownika;
    
    @FXML
    public void initialize()
    {
        tf_id.setText(Integer.toString(WyswietlPracownikowController.wybrany_pracownik.getId()));
        tf_imie.setText(WyswietlPracownikowController.wybrany_pracownik.getImie());
        tf_nazwisko.setText(WyswietlPracownikowController.wybrany_pracownik.getNazwisko());
        tf_ulica.setText(WyswietlPracownikowController.wybrany_pracownik.getAdres().getUlica());
        tf_mieszkanie.setText(WyswietlPracownikowController.wybrany_pracownik.getAdres().getMieszkanie());
        tf_kod_pocztowy.setText(WyswietlPracownikowController.wybrany_pracownik.getAdres().getKodPocztowy());
        tf_miasto.setText(WyswietlPracownikowController.wybrany_pracownik.getAdres().getMiasto());
        tf_email_pri.setText(WyswietlPracownikowController.wybrany_pracownik.getKontaktPrywatny().getEmail());
        tf_nr_tel_pri.setText(WyswietlPracownikowController.wybrany_pracownik.getKontaktPrywatny().getNrTelefonu());
        tf_email_pub.setText(WyswietlPracownikowController.wybrany_pracownik.getKontaktSluzbowy().getEmail());
        tf_nr_tel_pub.setText(WyswietlPracownikowController.wybrany_pracownik.getKontaktSluzbowy().getNrTelefonu());
    
        karta_pracownika = Main.manager_kart.getByCardID(WyswietlPracownikowController.wybrany_pracownik.getKarta());
        
        if(WyswietlPracownikowController.wybrany_pracownik.getKarta() == -1)
        {
            lv_his_lokalizacji.getItems().add(
                new Lokalizacja(
                    new Lokal("ERROR - Brak przypisanej karty", 0, 0, ""), 
                    false)
            );
        }
        else
        {
            for(int i=0; i<karta_pracownika.getHistoria().size(); i++)
            {
                lv_his_lokalizacji.getItems().add(karta_pracownika.getHistoria().get(i));
            }
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
    
    @FXML private TextField tf_id;
    @FXML private TextField tf_imie;
    @FXML private TextField tf_nazwisko;
    @FXML private TextField tf_miasto;
    @FXML private TextField tf_ulica;
    @FXML private TextField tf_mieszkanie;
    @FXML private TextField tf_kod_pocztowy;
    @FXML private TextField tf_email_pri;
    @FXML private TextField tf_nr_tel_pri;
    @FXML private TextField tf_email_pub;
    @FXML private TextField tf_nr_tel_pub;
    
    @FXML private ListView<Lokalizacja> lv_his_lokalizacji;
}
