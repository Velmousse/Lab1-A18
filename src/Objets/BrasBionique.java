package Objets;

import Vaisseau.Vaisseau;

public class BrasBionique extends Objet {

    public BrasBionique() {
        nom = "Bras bionique";
        essenceBoost = 100;
        vieBoost = 25;
    }

    public void utiliser(Vaisseau unit) {
        System.out.println("Vous utilisez le bras bionique d'une certaine façon...\n" +
                "Le vaisseau gagne 100 litres d'essence et 25 points de vie");

        unit.setQteCarburant(unit.getQteCarburant() + essenceBoost);
        unit.setPointsDeVie(unit.getPointsDeVie() + vieBoost);
    }
}
