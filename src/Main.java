import java.util.ArrayList;
import java.util.Scanner;
import Vaisseau.*;
import Objets.*;
import Planètes.*;

public class Main {
    static int entree;
    static Scanner sc = new Scanner(System.in);
    static Planete[] listePlanetes = {new Carrokin(), new Choubivar(), new Potagre(), new Tartario(), new Terre()};

    public static void main(String[] args) {
        Vaisseau joueur = new Vaisseau(1000, 100);

        System.out.println("Bienvenue dans Space Explorer.");
        while (menu(joueur));
    }

    public static boolean menu(Vaisseau unit) {
        System.out.print("\nQue désirez-vous faire?\n" +
                "   1- Examiner le vaisseau;\n" +
                "   2- Explorer une planète;\n" +
                "   3- Utiliser un objet;\n" +
                "   4- Revenir en arrière.\n" +
                "Choix: ");

        entree = sc.nextInt();
        System.out.println();

        switch (entree) {
            case 1: examiner(unit); break;
            case 2: return explorer(unit);
            case 3: return utiliserObjet(unit);
            default: retourArriere(unit);
        }

        return true;
    }

    public static void examiner(Vaisseau unit) {
        System.out.println("Planète courante: " + unit.getPlanetesVisitees().peek().getNom() +
                "\nQuantité de carburant: " + unit.getQteCarburant() + " litres" +
                "\nPoints de vie: " + unit.getPointsDeVie() +
                "\nInventaire: ");

        if (!unit.getInventaire().isEmpty()) {
            for (Objet objet : unit.getInventaire())
                System.out.println(" - " + objet.getNom());
        }
    }

    public static boolean explorer(Vaisseau unit) {
        Planete rndPlanete = listePlanetes[(int) (Math.random()*5)];

        while (unit.getPlanetesVisitees().peek().getClass().equals(rndPlanete.getClass()))
            rndPlanete = listePlanetes[(int) (Math.random()*5)];

        if (unit.getQteCarburant() - rndPlanete.getCarburantPourArriver() < 0) {
            System.out.println("Vous vous dirigez vers " + rndPlanete.getNom() + "\n" +
                    "Votre vaisseau manque d'essence");
            return finPartie(unit);
        }

        rndPlanete.explorer(unit);
        unit.getPlanetesVisitees().add(rndPlanete);

        if (unit.getPointsDeVie() <= 0) {
            System.out.println("Vous n'avez plus de vie");
            return finPartie(unit);
        }

        return true;
    }

    public static boolean utiliserObjet(Vaisseau unit) {
        if (unit.getInventaire().isEmpty()) System.out.println("Votre inventaire est vide");
        else {
            int i = 1;

            System.out.println("Quel objet voulez-vous utiliser?");
            for (Objet objet : unit.getInventaire()) {
                System.out.println(" " + i + "- " + objet.getNom());
            }

            System.out.print("Choix: ");
            entree = sc.nextInt() - 1;
            System.out.println();
            unit.getInventaire().get(entree).utiliser(unit);
            unit.getInventaire().remove(entree);
        }

        if (unit.getPointsDeVie() <= 0) {
            System.out.println("Le vaisseau n'a plus de vie");
            return finPartie(unit);
        }
        else return true;
    }

    public static void retourArriere(Vaisseau unit) {

    }

    public static boolean finPartie(Vaisseau unit) {
        System.out.println("Fin de la partie");

        ArrayList<Planete> planetesParcourues = new ArrayList<>();

        while (!unit.getPlanetesVisitees().isEmpty())
            planetesParcourues.add(unit.getPlanetesVisitees().pop());

        System.out.println("Trajet parcouru: ");

        for (int i = 0; i < planetesParcourues.size(); i++) {
            System.out.print(planetesParcourues.get(i).getNom());
            if (!(i == planetesParcourues.size() - 1))
                System.out.print(" => ");
        }

        return false;
    }
}
