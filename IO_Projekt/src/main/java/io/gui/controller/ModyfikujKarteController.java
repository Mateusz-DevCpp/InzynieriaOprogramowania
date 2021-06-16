package io.gui.controller;

import io.gui.Main;
import io.gui.Window;
import io.model.system.Lokal;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class ModyfikujKarteController 
{
    @FXML
    public void initialize()
    {
        lb_wiadomosc.setVisible(false);
        
        cb_posiadane.setSelected(true);
        cb_nieposiadane.setSelected(true);
        
        if(WsywietlKartyController.wybrana_karta.isPrzypisana())
        {
            cb_przpyisana.setSelected(true);
            bt_przypisz.setDisable(true);
        }
        
        tf_id.setText(Integer.toString(WsywietlKartyController.wybrana_karta.getId()));
        ta_pos_uprawnienia.setText(WsywietlKartyController.wybrana_karta.getPosiadaneUprawiniena().toString());
        
        for(int i=0; i<Main.manager_lokali.count(); i++)
        {
            lv_uprawnienial.getItems().add(Main.manager_lokali.get(i));
        }
        
        if(Main.manager_lokali.count() > 0)
        {
            lv_uprawnienial.getSelectionModel().select(0);
        }
        else
        {
            bt_usun.setDisable(true);
            bt_dodaj.setDisable(true);
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
    public void dodaj()
    {
        String tmp_upr = lv_uprawnienial.getSelectionModel().getSelectedItem().getWymaganeUprawnienia();
        if(WsywietlKartyController.wybrana_karta.getPosiadaneUprawiniena().getPoziomDostepu().contains(tmp_upr))
        {
            lb_wiadomosc.setVisible(true);
            lb_wiadomosc.setTextFill(Color.web("#FF0000"));
            lb_wiadomosc.setText("Karta juz pozwala na dostep do tego lokalu");
        }
        else
        {
            WsywietlKartyController.wybrana_karta.getPosiadaneUprawiniena().addDostep(tmp_upr);
            lb_wiadomosc.setVisible(true);
            lb_wiadomosc.setTextFill(Color.web("#00FF00"));
            lb_wiadomosc.setText("Dodano nowe uprawnienia");
        }
        ta_pos_uprawnienia.setText(WsywietlKartyController.wybrana_karta.getPosiadaneUprawiniena().toString());
    }
    
    @FXML
    public void usun()
    {
        String tmp_upr = lv_uprawnienial.getSelectionModel().getSelectedItem().getWymaganeUprawnienia();
        if(WsywietlKartyController.wybrana_karta.getPosiadaneUprawiniena().getPoziomDostepu().contains(tmp_upr))
        {
            WsywietlKartyController.wybrana_karta.getPosiadaneUprawiniena().rmDostep(tmp_upr);
            lb_wiadomosc.setVisible(true);
            lb_wiadomosc.setTextFill(Color.web("#00FF00"));
            lb_wiadomosc.setText("Usunieto uprawnienia");
        }
        else
        {
            lb_wiadomosc.setVisible(true);
            lb_wiadomosc.setTextFill(Color.web("#FF0000"));
            lb_wiadomosc.setText("Karta nie pozwala na dostep do tego lokalu");
        }
        ta_pos_uprawnienia.setText(WsywietlKartyController.wybrana_karta.getPosiadaneUprawiniena().toString());
    }
    
    @FXML
    public void filtruj()
    {
        lv_uprawnienial.getItems().clear();
        
        String filtr = tf_filtr.getText();
        int ilosc_danych_do_wyswietlenia = 0;
        
        bt_usun.setDisable(false);
        bt_dodaj.setDisable(false);
        
        if(filtr.length() == 0)
        {
            for(int i=0; i<Main.manager_lokali.count(); i++)
            {
                boolean p = WsywietlKartyController.wybrana_karta.getPosiadaneUprawiniena().getPoziomDostepu().contains(Main.manager_lokali.get(i).getWymaganeUprawnienia());
                
                if(p && cb_posiadane.isSelected())
                {
                    ilosc_danych_do_wyswietlenia++;
                    lv_uprawnienial.getItems().add(Main.manager_lokali.get(i));
                }
                if(!p && cb_nieposiadane.isSelected())
                {
                    ilosc_danych_do_wyswietlenia++;
                    lv_uprawnienial.getItems().add(Main.manager_lokali.get(i));
                }
            }
        }
        else
        {
            for(int i=0; i<Main.manager_lokali.count(); i++)
            {
                if(Main.manager_lokali.get(i).getNazwa().contains(filtr))
                {
                    boolean p = WsywietlKartyController.wybrana_karta.getPosiadaneUprawiniena().getPoziomDostepu().contains(Main.manager_lokali.get(i).getWymaganeUprawnienia());

                    if(p && cb_posiadane.isSelected())
                    {
                        ilosc_danych_do_wyswietlenia++;
                        lv_uprawnienial.getItems().add(Main.manager_lokali.get(i));
                    }
                    if(!p && cb_nieposiadane.isSelected())
                    {
                        ilosc_danych_do_wyswietlenia++;
                        lv_uprawnienial.getItems().add(Main.manager_lokali.get(i));
                    }
                }
            }
        }

        if(ilosc_danych_do_wyswietlenia > 0)
        {
            lv_uprawnienial.getSelectionModel().select(0);
        }
        else
        {
            bt_usun.setDisable(true);
            bt_dodaj.setDisable(true);
        }
    }
    
    @FXML
    public void przypisz() throws IOException
    {
        Window.setRoot("PrzypiszKarteWindow_karta");
    }
    
    @FXML private TextArea ta_pos_uprawnienia;
    @FXML private TextField tf_id;
    @FXML private CheckBox cb_przpyisana;
    @FXML private TextField tf_filtr;
    @FXML private CheckBox cb_posiadane;
    @FXML private CheckBox cb_nieposiadane;
    @FXML private ListView<Lokal> lv_uprawnienial;
    @FXML private Button bt_dodaj;
    @FXML private Button bt_usun;
    @FXML private Button bt_przypisz;
    @FXML private Label lb_wiadomosc;
}
