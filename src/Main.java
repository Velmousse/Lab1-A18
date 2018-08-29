import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;

import Vaisseau.*;
import Objets.*;
import Planètes.*;

public class Main {
    static int entree;
    static Scanner sc = new Scanner(System.in);
    static Planete[] listePlanetes = {new Carrokin(), new Choubivar(), new Potagre(), new Tartario(), new Terre()};
    static Stack<Vaisseau> listeVaisseaux = new Stack<>();

    public static void main(String[] args) {
        listeVaisseaux.add(new Vaisseau(1000, 100));

        System.out.println("Bienvenue dans Space Explorer.");
        while (menu());
        sc.close();
    }

    public static boolean menu() {
        System.out.print("\nQue désirez-vous faire?\n" +
                "   1- Examiner le vaisseau;\n" +
                "   2- Explorer une planète;\n" +
                "   3- Utiliser un objet;\n" +
                "   4- Revenir en arrière.\n" +
                "Choix: ");

        getEntree();
        System.out.println();

        switch (entree) {
            case 1: examiner(); break;
            case 2: return explorer();
            case 3: return utiliserObjet();
            default: retourArriere();
        }

        return true;
    }

    public static void examiner() {
        System.out.println("Planète courante: " + listeVaisseaux.peek().getPlanetesVisitees().peek().getNom() +
                "\nQuantité de carburant: " + listeVaisseaux.peek().getQteCarburant() + " litres" +
                "\nPoints de vie: " + listeVaisseaux.peek().getPointsDeVie() +
                "\nInventaire: ");

        if (!listeVaisseaux.peek().getInventaire().isEmpty()) {
            for (Objet objet : listeVaisseaux.peek().getInventaire())
                System.out.println(" - " + objet.getNom());
        }
    }

    public static boolean explorer() {
        Planete rndPlanete = listePlanetes[(int) (Math.random()*5)];

        while (listeVaisseaux.peek().getPlanetesVisitees().peek().getClass().equals(rndPlanete.getClass()))
            rndPlanete = listePlanetes[(int) (Math.random()*5)];

        if (listeVaisseaux.peek().getQteCarburant() - rndPlanete.getCarburantPourArriver() < 0) {
            System.out.println("Vous vous dirigez vers " + rndPlanete.getNom() + "\n" +
                    "Votre vaisseau manque d'essence");
            return finPartie();
        }

        rndPlanete.explorer(listeVaisseaux.peek());
        listeVaisseaux.peek().getPlanetesVisitees().add(rndPlanete);
        listeVaisseaux.add(new Vaisseau(listeVaisseaux.peek()));

        if (listeVaisseaux.peek().getPointsDeVie() <= 0) {
            System.out.println("Vous n'avez plus de vie");
            return finPartie();
        }

        return true;
    }

    public static boolean utiliserObjet() {
        if (listeVaisseaux.peek().getInventaire().isEmpty()) System.out.println("Votre inventaire est vide");
        else {
            int i = 1;

            System.out.println("Quel objet voulez-vous utiliser?");
            for (Objet objet : listeVaisseaux.peek().getInventaire()) {
                System.out.println(" " + i + "- " + objet.getNom());
            }

            System.out.print("Choix: ");
            getEntree();
            entree--;
            System.out.println();
            listeVaisseaux.peek().getInventaire().get(entree).utiliser(listeVaisseaux.peek());
            listeVaisseaux.peek().getInventaire().remove(entree);
        }

        if (listeVaisseaux.peek().getPointsDeVie() <= 0) {
            System.out.println("Le vaisseau n'a plus de vie");
            return finPartie();
        }
        else return true;
    }

    public static void retourArriere() {
        if (listeVaisseaux.peek().getPlanetesVisitees().size() == 1)
            System.out.println("Vous ne pouvez pas revenir en arrière");
        else {
            listeVaisseaux.pop();

            System.out.println("Dernier voyage annulé");
            System.out.println("Retour sur " + listeVaisseaux.peek().getPlanetesVisitees().peek().getNom() +
                    "\n\n [...]\n");
        }
    }

    public static boolean finPartie() {
        System.out.println("Fin de la partie");

        ArrayList<Planete> planetesParcourues = new ArrayList<>();

        while (!listeVaisseaux.peek().getPlanetesVisitees().isEmpty()) {
            planetesParcourues.add(listeVaisseaux.peek().getPlanetesVisitees().pop());
        }

        System.out.println("Trajet parcouru: ");

        for (int i = planetesParcourues.size() - 1; i >= 0; i--) {
            System.out.print(planetesParcourues.get(i).getNom());
            if (!(i == 0))
                System.out.print(" => ");
        }

        return false;
    }

    public static void getEntree() {
        try {
            entree = sc.nextInt();
        }
        catch (InputMismatchException e) {
            System.out.print("Réessayez: ");
            sc = new Scanner(System.in);
            getEntree();
        }
    }
}
