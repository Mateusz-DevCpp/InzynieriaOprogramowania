package io.prototyp.Ksztalty;

public class Prostokat extends Ksztalt
{
    public int szerokosc;
    public int wysokosc;

    public Prostokat() {
    }

    public Prostokat(Prostokat target) 
    {
        super(target);
        if (target != null) 
        {
            this.szerokosc = target.szerokosc;
            this.wysokosc = target.wysokosc;
        }
    }

    @Override
    public Ksztalt clone() 
    {
        return new Prostokat(this);
    }

    @Override
    public boolean equals(Object o) 
    {
        if (!(o instanceof Prostokat) || !super.equals(o)) 
            return false;
        
        Prostokat k = (Prostokat) o;
        return k.szerokosc == szerokosc && k.wysokosc == wysokosc;
    }
}
