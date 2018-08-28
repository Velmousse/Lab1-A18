package Planètes;

import Vaisseau.*;

public abstract class Planete {
    protected String nom;
    protected int carburantPourArriver;

    public abstract void explorer(Vaisseau vaisseau);

    public String getNom() {
        return nom;
    }

    public int getCarburantPourArriver() {
        return carburantPourArriver;
    }
}
