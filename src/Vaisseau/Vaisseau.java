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
        planetesVisitees = unit.getPlanetesVisitees();

        qteCarburant = unit.getQteCarburant();
        pointsDeVie = unit.getPointsDeVie();
    }

    public Vaisseau(int qteCarburant, int pointsDeVie) {
        this.qteCarburant = qteCarburant;
        this.pointsDeVie = pointsDeVie;

        planetesVisitees.add(new Terre());
    }

    public int getQteCarburant() {
        return qteCarburant;
    }

    public void setQteCarburant(int qteCarburant) {
        this.qteCarburant = qteCarburant;
    }

    public int getPointsDeVie() {
        return pointsDeVie;
    }

    public void setPointsDeVie(int pointsDeVie) {
        this.pointsDeVie = pointsDeVie;
    }

    public List<Objet> getInventaire() {
        return inventaire;
    }

    public Stack<Planete> getPlanetesVisitees() {
        return planetesVisitees;
    }
}