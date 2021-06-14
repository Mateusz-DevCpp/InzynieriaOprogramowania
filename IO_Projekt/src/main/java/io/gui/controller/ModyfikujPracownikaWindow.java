package io.gui.controller;

import io.gui.Main;
import io.gui.Window;
import io.model.system.Adres;
import io.model.system.Kontakt;
import io.model.system.Pracownik;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class ModyfikujPracownikaWindow 
{
    @FXML
    public void initialize()
    {
        lb_wiadomosc.setVisible(false);
        
        tf_imie.setText(WyswietlPracownikowController.wybrany_pracownik.getImie());
        tf_nazwisko.setText(WyswietlPracownikowController.wybrany_pracownik.getNazwisko());
        
        tf_ulica.setText(WyswietlPracownikowController.wybrany_pracownik.getAdres().getUlica());
        tf_mieszkanie.setText(WyswietlPracownikowController.wybrany_pracownik.getAdres().getMieszkanie());
        tf_kod_pocztowy.setText(WyswietlPracownikowController.wybrany_pracownik.getAdres().getKodPocztowy());
        tf_miasto.setText(WyswietlPracownikowController.wybrany_pracownik.getAdres().getMiasto());
        
        tf_email_priv.setText(WyswietlPracownikowController.wybrany_pracownik.getKontaktPrywatny().getEmail());
        tf_nr_telefonu_priv.setText(WyswietlPracownikowController.wybrany_pracownik.getKontaktPrywatny().getNrTelefonu());
        
        tf_email_pub.setText(WyswietlPracownikowController.wybrany_pracownik.getKontaktSluzbowy().getEmail());
        tf_nr_telefonu_pub.setText(WyswietlPracownikowController.wybrany_pracownik.getKontaktSluzbowy().getNrTelefonu());
    }
    
    @FXML
    public void mainMenu() throws IOException
    {
        Window.setRoot("MainWindow");
    }
    
    @FXML
    public void zapiszPracowinka() throws IOException
    {
        String imie, nazwisko, ulica, mieszkanie, kod_pocztowy, miasto, email_pr, email_pu, nr_tel_pr, nr_tel_pu;
        
        boolean poprawne_dane = true;
        
        imie = tf_imie.getText();
        if(imie.length() == 0) poprawne_dane = false;
        nazwisko = tf_nazwisko.getText();
        if(nazwisko.length() == 0) poprawne_dane = false;
        
        ulica = tf_ulica.getText();
        if(ulica.length() == 0) poprawne_dane = false;
        mieszkanie = tf_mieszkanie.getText();
        if(mieszkanie.length() == 0) poprawne_dane = false;
        kod_pocztowy = tf_kod_pocztowy.getText();
        if(kod_pocztowy.length() == 0) poprawne_dane = false;
        miasto = tf_miasto.getText();
        if(miasto.length() == 0) poprawne_dane = false;
        
        email_pr = tf_email_priv.getText();
        if(email_pr.length() == 0) poprawne_dane = false;
        nr_tel_pr = tf_nr_telefonu_priv.getText();
        if(nr_tel_pr.length() == 0) poprawne_dane = false;
        
        email_pu = tf_email_pub.getText();
        if(email_pu.length() == 0) poprawne_dane = false;
        nr_tel_pu = tf_nr_telefonu_pub.getText();
        if(nr_tel_pu.length() == 0) poprawne_dane = false;
        
        if(poprawne_dane)
        {
            Pracownik tmp = new Pracownik(WyswietlPracownikowController.wybrany_pracownik.getId(), 
                            imie, nazwisko, 
                            new Adres(miasto, ulica, mieszkanie, kod_pocztowy), 
                            new Kontakt(email_pr, nr_tel_pr), 
                            new Kontakt(email_pu, nr_tel_pu),
                            WyswietlPracownikowController.wybrany_pracownik.getKarta());
            
            Main.manager_pracownikow.update(WyswietlPracownikowController.wybrany_pracownik.getId(), tmp);
            
            WyswietlPracownikowController.wybrany_pracownik.update(tmp);
            
            Window.setRoot("MainWindow");
        }
        else
        {
            lb_wiadomosc.setVisible(true);
            lb_wiadomosc.setTextFill(Color.web("#FF0000"));
            lb_wiadomosc.setText("Wprowadzono bledne dane");
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
    
    @FXML private TextField tf_imie;
    @FXML private TextField tf_nazwisko;
    
    @FXML private TextField tf_ulica;
    @FXML private TextField tf_mieszkanie;
    @FXML private TextField tf_kod_pocztowy;
    @FXML private TextField tf_miasto;
    
    @FXML private TextField tf_email_priv;
    @FXML private TextField tf_nr_telefonu_priv;
    
    @FXML private TextField tf_email_pub;
    @FXML private TextField tf_nr_telefonu_pub;
    
    @FXML private Label lb_wiadomosc;
}
