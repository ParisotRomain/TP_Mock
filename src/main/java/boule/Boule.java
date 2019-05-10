package boule;

import java.util.Random;

public class Boule {
	private static int resultat;
	
	/**
	 * Génère un nombre aléatoire entre deux valeurs donées
	 * @param min
	 * @param max
	 * @return un entier entre min et max compris
	 */
	public static int lancer(int min, int max) {
		Random rand = new Random();
		resultat = rand.nextInt(max) + min; //on génère un nombre aléatoire entre min et max compris
		return resultat;
	}

	public static int getResultat() {
		return resultat;
	}
}
