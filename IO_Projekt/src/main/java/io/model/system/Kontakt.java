package io.model.system;

public class Kontakt 
{
    private String email;
    private String numer_telefonu;

    public Kontakt(String email, String numer_telefonu) 
    {
        this.email = email;
        this.numer_telefonu = numer_telefonu;
    }

    public String getEmail() 
    {
        return email;
    }

    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getNumer_telefonu() 
    {
        return numer_telefonu;
    }

    public void setNumer_telefonu(String numer_telefonu) 
    {
        this.numer_telefonu = numer_telefonu;
    }
    
}
