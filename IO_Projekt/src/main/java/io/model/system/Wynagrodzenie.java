package io.model.system;

import java.time.LocalDate;
import java.util.Date;

public class Wynagrodzenie 
{
    private Pracownik pracownik;
    private double wartosc_wynagrodzenia;
    private double stawka_za_nadgodziny;
    private LocalDate data_otrzymania;
    private int ilosc_nadgodzin;

    public Wynagrodzenie(Pracownik pracownik, double wartosc_wynagrodzenia, double stawka_za_nadgodziny, int ilosc_nadgodzin) 
    {
        this.pracownik = pracownik;
        this.wartosc_wynagrodzenia = wartosc_wynagrodzenia;
        this.stawka_za_nadgodziny = stawka_za_nadgodziny;
        this.ilosc_nadgodzin = ilosc_nadgodzin;
        
        this.data_otrzymania = LocalDate.now();
    }

    public Pracownik getPracownik() 
    {
        return pracownik;
    }

    public double getWartoscWynagrodzenia() 
    {
        return wartosc_wynagrodzenia;
    }

    public double getStawkaZaNadgodziny() 
    {
        return stawka_za_nadgodziny;
    }

    public LocalDate getDataOtrzymania() 
    {
        return data_otrzymania;
    }

    public int getIloscNadgodzin() 
    {
        return ilosc_nadgodzin;
    }
    
    public String toString()
    {
        String result = "";
        
        result += pracownik.toString();
        result += " : ";
        result += Double.toString(wartosc_wynagrodzenia + ilosc_nadgodzin*stawka_za_nadgodziny);
        result += "PLN\n";
        result += " - Pensja bazowa: " +  Double.toString(wartosc_wynagrodzenia) + "\n";
        result += " - Kwota za nadgodziny: " +  Double.toString(stawka_za_nadgodziny) + "\n";
        result += " - Ilosc nadgodzin: " +  Integer.toString(ilosc_nadgodzin) + "\n";
        result += "Data: " + data_otrzymania.toString();
        
        
        return result;
    }
}
