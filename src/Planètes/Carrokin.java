package Planètes;

import Objets.Bandage;
import Vaisseau.Vaisseau;

public class Carrokin extends Planete{

    public Carrokin() {
        nom = "Carrokin";
        carburantPourArriver = 250;
    }

    public void explorer(Vaisseau unit) {
        unit.setQteCarburant(unit.getQteCarburant() - carburantPourArriver);

        System.out.println("Vous visitez la planète Carrokin\n" +
                "Vous dépensez " + carburantPourArriver + " litres d'essence");

        if ((int) (Math.random() * 101) < 25) {
            System.out.println("Des fourmis géantes mangent des morceaux de votre vaisseau\n" +
                    "Votre vaisseau perd 15 points de vie");

            ennemiAttaque = true;
            unit.setPointsDeVie(unit.getPointsDeVie() - 15);
        }

        if ((int) (Math.random() * 101) < 25) {
            System.out.println("Vous découvrez un bandage");

            objetTrouve = true;
            unit.getInventaire().add(new Bandage());
        }
    }
}
