package io.prototyp.Ksztalty;

public class Kolo extends Ksztalt
{
    public int promien;

    public Kolo() {
    }

    public Kolo(Kolo target) 
    {
        super(target);
        if (target != null) 
        {
            this.promien = target.promien;
        }
    }

    @Override
    public Ksztalt clone() 
    {
        return new Kolo(this);
    }

    @Override
    public boolean equals(Object o) 
    {
        if (!(o instanceof Kolo) || !super.equals(o)) 
            return false;
        
        Kolo k = (Kolo) o;
        return k.promien == promien;
    }
}
