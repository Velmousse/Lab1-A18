package Objets;

import Vaisseau.Vaisseau;

public class Bandage extends Objet {

    public Bandage() {
        nom = "Bandage";
        vieBoost = 100;
    }

    public void utiliser(Vaisseau unit) {
        System.out.println("Vous appliquez le bandage sur la console du vaisseau\n" +
                "Le vaisseau gagne 100 points de vie");

        unit.setPointsDeVie(unit.getPointsDeVie() + vieBoost);
    }
}
