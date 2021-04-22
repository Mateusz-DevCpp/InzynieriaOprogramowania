package io.gui;

import io.model.system.*;

public class Main 
{
    static public void main(String[] args)
    {
        /// konfiguracja poczatkowa
        Pracownik.init();
        Karta.init();
        
        /// przejscie do programu glownego
        Window.main(args);
    }
}
