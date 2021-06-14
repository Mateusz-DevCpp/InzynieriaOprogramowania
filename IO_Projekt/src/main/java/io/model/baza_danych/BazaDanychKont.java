package io.model.baza_danych;

import io.model.logowanie.Konto;

public class BazaDanychKont extends BazaDanych<Konto>
{
    public BazaDanychKont()
    {
        super();
        
        connect(/* ... */);
    }
    
    public int tryLogin(Konto konto)
    {
        return 0;// 0 - logowanie powiodlo sie
    }
}
