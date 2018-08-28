package Planètes;

import Vaisseau.Vaisseau;

public class Carrokin extends Planete{

    public Carrokin() {
        nom = "Carrokin";
        carburantPourArriver = 250;
    }

    public void explorer(Vaisseau unit) {
        unit.setQteCarburant(unit.getQteCarburant() - carburantPourArriver);


    }
}
