package Planètes;

import Objets.ReacteurNucleaire;
import Vaisseau.Vaisseau;

public class Tartario extends Planete {

    public Tartario() {
        nom = "Tartario";
        carburantPourArriver = 200;
        vieAPerdre = 10;
    }

    public void explorer(Vaisseau unit) {
        unit.setQteCarburant(unit.getQteCarburant() - carburantPourArriver);

        System.out.println("Vous visitez la planète Tartario\n" +
                "Vous dépensez " + carburantPourArriver + " litres d'essence");

        if ((int) (Math.random() * 101) < 25) {
            System.out.println("Une mouche atterrit sur votre pare-brise\n" +
                    "Votre vaisseau perd " + vieAPerdre + " points de vie");

            ennemiAttaque = true;
            unit.setPointsDeVie(unit.getPointsDeVie() - vieAPerdre);
        }

        if ((int) (Math.random() * 101) < 30) {
            System.out.println("Vous trouvez un réacteur nucléaire");

            objetTrouve = true;
            unit.getInventaire().add(new ReacteurNucleaire());
        }
    }
}
