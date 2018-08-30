package Vaisseau;

import Objets.Objet;
import Planètes.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Vaisseau {
    private int qteCarburant, pointsDeVie;
    private List<Objet> inventaire = new ArrayList<>(5);
    private Stack<Planete> planetesVisitees = new Stack<>();

    public Vaisseau(Vaisseau unit) {
        planetesVisitees = (Stack<Planete>) unit.getPlanetesVisitees().clone();

        inventaire = new ArrayList<>(5);
        for (Objet objet : unit.getInventaire())
            inventaire.add(objet);


        this.qteCarburant = unit.getQteCarburant();
        this.pointsDeVie = unit.getPointsDeVie();
    }

    public Vaisseau(int qteCarburant, int pointsDeVie) {
        this.qteCarburant = qteCarburant;
        this.pointsDeVie = pointsDeVie;

        this.planetesVisitees.add(new Terre());
    }

    public int getQteCarburant() {
        return this.qteCarburant;
    }

    public void setQteCarburant(int qteCarburant) {
        this.qteCarburant = qteCarburant;
    }

    public int getPointsDeVie() {
        return this.pointsDeVie;
    }

    public void setPointsDeVie(int pointsDeVie) {
        this.pointsDeVie = pointsDeVie;
    }

    public List<Objet> getInventaire() {
        return this.inventaire;
    }

    public Stack<Planete> getPlanetesVisitees() {
        return this.planetesVisitees;
    }
}