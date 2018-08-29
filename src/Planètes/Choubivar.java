package Planètes;

import Objets.BidonEssence;
import Vaisseau.Vaisseau;

public class Choubivar extends Planete {

    public Choubivar() {
        nom = "Choubivar";
        carburantPourArriver = 150;
        vieAPerdre = 10;
    }

    public void explorer(Vaisseau unit) {
        unit.setQteCarburant(unit.getQteCarburant() - carburantPourArriver);

        System.out.println("Vous visitez la planète Choubivar\n" +
                "Vous dépensez " + carburantPourArriver + " litres d'essence");

        if ((int) (Math.random() * 101) < 15) {
            System.out.println("Vous heurtez une roche en atterrissant\n" +
                    "Votre vaisseau perd " + vieAPerdre + " points de vie");

            ennemiAttaque = true;
            unit.setPointsDeVie(unit.getPointsDeVie() - vieAPerdre);
        }

        if ((int) (Math.random() * 101) < 45) {
            System.out.println("Vous trouvez un bidon d'essence");

            objetTrouve = true;
            unit.getInventaire().add(new BidonEssence());
        }
    }
}
