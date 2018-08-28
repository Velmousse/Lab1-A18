package Objets;

import Vaisseau.Vaisseau;

public abstract class Objet {
    protected String nom;
    protected int essenceBoost, vieBoost;

    public String getNom() {
        return nom;
    }

    public abstract void utiliser(Vaisseau unit);
}
