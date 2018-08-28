package Objets;

import Vaisseau.Vaisseau;

public class ReacteurNucleaire extends Objet {

    public ReacteurNucleaire() {
        nom = "Réacteur nucléaire";
        vieBoost = 15;
    }

    public void utiliser(Vaisseau unit) {
        System.out.println("Vous jetez le réacteur nucléaire par dessus bord\n" +
                "Le vaisseau gagne 15 points de vie");

        unit.setPointsDeVie(unit.getPointsDeVie() + vieBoost);
    }
}