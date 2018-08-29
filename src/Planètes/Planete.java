package Planètes;

import Vaisseau.*;

public abstract class Planete {
    protected String nom;
    protected int carburantPourArriver, vieAPerdre;
    protected boolean objetTrouve = false, ennemiAttaque = false;

    public abstract void explorer(Vaisseau vaisseau);

    public String getNom() {
        return nom;
    }

    public int getCarburantPourArriver() {
        return carburantPourArriver;
    }

    public boolean isObjetTrouve() {
        return objetTrouve;
    }

    public boolean isEnnemiAttaque() {
        return ennemiAttaque;
    }
}
