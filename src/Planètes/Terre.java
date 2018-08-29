package Planètes;

import Objets.TasseDeThe;
import Vaisseau.Vaisseau;

public class Terre extends Planete {

    public Terre() {
        nom = "Terre";
        carburantPourArriver = 100;
        vieAPerdre = 0;
    }

    public void explorer(Vaisseau unit) {
        unit.setQteCarburant(unit.getQteCarburant() - carburantPourArriver);

        System.out.println("Vous visitez la planète Terre\n" +
                "Vous dépensez " + carburantPourArriver + " litres d'essence");

        if ((int) (Math.random() * 101) < 75) {
            System.out.println("Quelqu'un vous donne une tasse de thé");

            objetTrouve = true;
            unit.getInventaire().add(new TasseDeThe());
        }
    }
}