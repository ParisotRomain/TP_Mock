package boule;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class CroupierBoule implements CasinoInterface {
	// les mises simples possibles :
	List<String>  mises   = Arrays.asList( "Pairs", "Impairs",
										  "Rouges", "Noirs",
										  "Manque", "Passe");
	List<Integer> pairs   = Arrays.asList( 2, 4, 6, 8);
	List<Integer> impairs = Arrays.asList( 1, 3, 7, 9);
	List<Integer> rouges  = Arrays.asList( 2, 4, 7, 9);
	List<Integer> noirs   = Arrays.asList( 1, 3, 6, 8);
	List<Integer> manque  = Arrays.asList( 1, 2, 3, 4);
	List<Integer> passe   = Arrays.asList( 6, 7, 8, 9);

	// les mises réalisées par le joueur :
	private HashMap<String, Integer> lesMisesSimples = new HashMap<String, Integer>();
	private HashMap<Integer, Integer> lesNumeros = new HashMap<Integer, Integer>();
	
	// le numéro sorti :
	private int resultat;

	
	@Override
	public int getNumSorti() {
		return resultat;
	}

	
	@Override
	public int gainOuPerte() {
		// Mises simples :
		int jetonsGagnantsSimple = 0;
		
		// on parcours les mises simples
		for(Entry<String, Integer> entry : lesMisesSimples.entrySet()) {
		    String mise = entry.getKey();
		    int jetons = entry.getValue();
		    
		    // en fonction de la mise on défini le nombre de jetons gagnants
		    switch (mise) {
			case "Pairs":
				// on vérifie si le résultat est pair :
				if (pairs.contains(resultat))
					// si oui, on ajoute le nombre de jetons misés aux jetons gagnants
					jetonsGagnantsSimple += jetons;
				break;
			case "Impairs":
				if (impairs.contains(resultat))
					jetonsGagnantsSimple += jetons;
				break;
			case "Rouges":
				if (rouges.contains(resultat))
					jetonsGagnantsSimple += jetons;
				break;
			case "Noirs":
				if (noirs.contains(resultat))
					jetonsGagnantsSimple += jetons;
				break;
			case "Manque":
				if (manque.contains(resultat))
					jetonsGagnantsSimple += jetons;
				break;
			case "Passe":
				if (passe.contains(resultat))
					jetonsGagnantsSimple += jetons;
				break;
			}
		}

		
		// Mises numéros :
		int jetonsGagnantsNumero = 0;
		// on vérifie si une mise a été faite sur le numéro sorti
		if (lesNumeros.containsKey(resultat)) {
			// si oui, on note combien de jetons ont gagné
			jetonsGagnantsNumero = lesNumeros.get(resultat);
		}
		
		
		// les mises ont été distribuées, on nettoie la table :
		lesMisesSimples.clear();
		lesNumeros.clear();
		
		// Les mises simples comptent x1, les mises numéros comptent x7
		return jetonsGagnantsSimple + (jetonsGagnantsNumero*7);
	}

	
	@Override
	public boolean addMiseSimple(String st, Integer i) {
		// On vérifie que la mise est valide
		if (mises.contains(st)) {

			// On vérifie s'il y a déja des jetons sur cette mise
			if (lesMisesSimples.containsKey(st)) {
				// si oui, on met a jour les jetons sur cette mise
				lesMisesSimples.put(st, lesMisesSimples.get(st) + i);
			} else {
				// sinon on l'ajoute
				lesMisesSimples.put(st, i);
			}
			return true;
			
		} else {

			// si la mise n'est pas valide on informe l'utilisateur
			System.out.println("Mise incorrecte !   " + mises);
			return false;
		}
	}


	@Override
	public boolean addMiseNumero(Integer numero, Integer quantite) {
		// On vérifie que le numéro est valide
		if ((numero > 0) && (numero < 10)) {

			// On vérifie s'il y a déja des jetons sur ce numéro
			if (lesNumeros.containsKey(numero)) {
				// si oui, on met a jour les jetons sur cette mise
				lesNumeros.put(numero, lesNumeros.get(numero) + quantite);
			} else {
				// sinon on l'ajoute
				lesNumeros.put(numero, quantite);
			}
			return true;
			
		} else {

			// si le numéro n'est pas valide on informe l'utilisateur
			System.out.println("Numéro incorrect !    (numéro de 1 à 8)");
			return false;
		}
	}

	
	@Override
	public void indiqueNumeroSorti() {
		resultat = Boule.lancer(1, 9);
	}

}
