package io.gui.controller;

import io.gui.Main;
import io.gui.Window;
import io.model.system.Karta;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class WsywietlKartyController 
{
    static public Karta wybrana_karta = null;
    
    @FXML
    public void initialize()
    {
        cb_przypisane.setSelected(true);
        cb_wolne.setSelected(true);
        
        for(int i=0; i<Main.manager_kart.count(); i++)
        {
            lv_karty.getItems().add(Main.manager_kart.get(i));
        }
        
        if(Main.manager_kart.count() > 0)
        {
            lv_karty.getSelectionModel().select(0);
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
        lv_karty.getItems().clear();
        
        String filtr = tf_filtr.getText();
        int ilosc_danych_do_wyswietlenia = 0;
        
        bt_usun.setDisable(false);
        bt_modyfikuj.setDisable(false);
        bt_szczegoly.setDisable(false);
        
        if(filtr.length() == 0)
        {
            for(int i=0; i<Main.manager_kart.count(); i++)
            {
                boolean p = Main.manager_kart.get(i).isPrzypisana();
                
                if(!p && cb_wolne.isSelected())
                {
                    ilosc_danych_do_wyswietlenia++;
                    lv_karty.getItems().add(Main.manager_kart.get(i));
                }
                if(p && cb_przypisane.isSelected())
                {
                    ilosc_danych_do_wyswietlenia++;
                    lv_karty.getItems().add(Main.manager_kart.get(i));
                }
            }
        }
        else
        {
            for(int i=0; i<Main.manager_kart.count(); i++)
            {
                if(Integer.toString(Main.manager_kart.get(i).getId()).contains(filtr))
                {
                    boolean p = Main.manager_kart.get(i).isPrzypisana();

                    if(!p && cb_wolne.isSelected())
                    {
                        ilosc_danych_do_wyswietlenia++;
                        lv_karty.getItems().add(Main.manager_kart.get(i));
                    }
                    if(p && cb_przypisane.isSelected())
                    {
                        ilosc_danych_do_wyswietlenia++;
                        lv_karty.getItems().add(Main.manager_kart.get(i));
                    }
                }
            }
        }

        if(ilosc_danych_do_wyswietlenia > 0)
        {
            lv_karty.getSelectionModel().select(0);
        }
        else
        {
            bt_usun.setDisable(true);
            bt_modyfikuj.setDisable(true);
            bt_szczegoly.setDisable(true);
        }
    }
    
    @FXML
    public void usun()
    {
        wybrana_karta = lv_karty.getSelectionModel().getSelectedItem();
        Main.manager_kart.unregister(wybrana_karta);
        wybrana_karta = null;
        lv_karty.getItems().clear();
        initialize();
    }
    
    @FXML
    public void modyfikuj() throws IOException
    {
        wybrana_karta = lv_karty.getSelectionModel().getSelectedItem();
        Window.setRoot("ModyfikujKarteWindow");
    }
    
    @FXML
    public void szczegoly()
    {
        wybrana_karta = lv_karty.getSelectionModel().getSelectedItem();
        
    }
    
    
    @FXML private ListView<Karta> lv_karty;
    @FXML private TextField tf_filtr;
    @FXML private Button bt_usun;
    @FXML private Button bt_modyfikuj;
    @FXML private Button bt_szczegoly;
    
    @FXML private CheckBox cb_wolne;
    @FXML private CheckBox cb_przypisane;
}
