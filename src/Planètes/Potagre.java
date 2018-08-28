package Planètes;

import Objets.BrasBionique;
import Vaisseau.Vaisseau;

public class Potagre extends Planete{

    public Potagre() {
        nom = "Potagre";
        carburantPourArriver = 300;
    }

    public void explorer(Vaisseau unit) {
        unit.setQteCarburant(unit.getQteCarburant() - carburantPourArriver);

        System.out.println("Vous visitez la planète Potagre\n" +
                "Vous dépensez " + carburantPourArriver + " litres d'essence");

        if ((int) (Math.random() * 101) < 2) {
            System.out.println("Une onde thermique endommage votre vaisseau\n" +
                    "Votre vaisseau perd 80 points de vie");

            unit.setPointsDeVie(unit.getPointsDeVie() - 80);
        }

        if ((int) (Math.random() * 101) < 15) {
            System.out.println("Vous recouvrez un bras bionique");

            unit.getInventaire().add(new BrasBionique());
        }
    }
}
