package Objets;

import Vaisseau.Vaisseau;

public class TasseDeThe extends Objet {

    public TasseDeThe() {
        nom = "Tasse de thé";
        essenceBoost = 25;
        vieBoost = -10;
    }

    public void utiliser(Vaisseau unit) {
        System.out.println("Vous videz la tasse de thé dans le contenant d'essence du vaisseau\n" +
                "Le vaisseau gagne 25 litres d'essence... mais perd 10 points de vie");

        unit.setQteCarburant(unit.getQteCarburant() + essenceBoost);
        unit.setPointsDeVie(unit.getPointsDeVie() + vieBoost);
    }
}
