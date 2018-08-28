package Planètes;

import Objets.ReacteurNucleaire;
import Vaisseau.Vaisseau;

public class Tartario extends Planete {

    public Tartario() {
        nom = "Tartario";
        carburantPourArriver = 200;
    }

    public void explorer(Vaisseau unit) {
        unit.setQteCarburant(unit.getQteCarburant() - carburantPourArriver);

        System.out.println("Vous visitez la planète Tartario\n" +
                "Vous dépensez " + carburantPourArriver + " litres d'essence");

        if ((int) (Math.random() * 101) < 25) {
            System.out.println("Une mouche atterrit sur votre pare-brise\n" +
                    "Votre vaisseau perd 10 points de vie");

            unit.setPointsDeVie(unit.getPointsDeVie() - 10);
        }

        if ((int) (Math.random() * 101) < 30) {
            System.out.println("Vous trouvez un réacteur nucléaire");

            unit.getInventaire().add(new ReacteurNucleaire());
        }
    }
}
