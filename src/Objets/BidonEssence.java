package Objets;

import Vaisseau.Vaisseau;

public class BidonEssence extends Objet {

    public BidonEssence() {
        nom = "Bidon d'essence";
        essenceBoost = 50;
    }

    public void utiliser(Vaisseau unit) {
        System.out.println("Vous videz votre bidon d'essence dans le contenant du vaisseau\n" +
                "Votre vaisseau gagne 50 litres d'essence");

        unit.setQteCarburant(unit.getQteCarburant() + essenceBoost);
    }
}
