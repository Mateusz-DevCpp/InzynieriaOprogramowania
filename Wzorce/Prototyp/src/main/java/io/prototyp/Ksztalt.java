package io.prototyp;

public abstract class Ksztalt 
{
    public int x;
    public int y;
    public String kolor;
    
     public Ksztalt() {
    }

    public Ksztalt(Ksztalt target) {
        if (target != null) {
            this.x = target.x;
            this.y = target.y;
            this.kolor = target.kolor;
        }
    }
    
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Ksztalt)) 
            return false;
        
        Ksztalt k = (Ksztalt) o;
        
        return k.x == x && k.y == y && k.kolor.equals(kolor);
    }
}
