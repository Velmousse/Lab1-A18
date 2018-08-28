package Planètes;

import Objets.BidonEssence;
import Vaisseau.Vaisseau;

public class Choubivar extends Planete {

    public Choubivar() {
        nom = "Choubivar";
        carburantPourArriver = 150;
    }

    public void explorer(Vaisseau unit) {
        unit.setQteCarburant(unit.getQteCarburant() - carburantPourArriver);

        System.out.println("Vous visitez la planète Choubivar\n" +
                "Vous dépensez " + carburantPourArriver + " litres d'essence");

        if ((int) (Math.random() * 101) < 15) {
            System.out.println("Vous heurtez une roche en atterrissant\n" +
                    "Votre vaisseau perd 10 points de vie");

            ennemiAttaque = true;
            unit.setPointsDeVie(unit.getPointsDeVie() - 10);
        }

        if ((int) (Math.random() * 101) < 45) {
            System.out.println("Vous trouvez un bidon d'essence");

            objetTrouve = true;
            unit.getInventaire().add(new BidonEssence());
        }
    }
}
