package io.model.system;

public class Kontakt 
{
    private String email;
    private String nr_telefonu;
    
    public Kontakt(String email, String nr_telefonu)
    {
        this.email = email;
        this.nr_telefonu = nr_telefonu;
    }

    @Override
    public String toString() 
    {
        String result = "";
        
        result += "Kontakt:\n";
        result += "\t" + nr_telefonu + "\n";
        result += "\t" + email;
        
        return result;
    }
    
    public String getEmail() 
    {
        return email;
    }

    public String getNrTelefonu() 
    {
        return nr_telefonu;
    }

    public void setNrTelefonu(String nr_telefonu) 
    {
        this.nr_telefonu = nr_telefonu;
    }

    public void setEmail(String email) 
    {
        this.email = email;
    }
}
