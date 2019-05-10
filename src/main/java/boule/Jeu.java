package boule;

import java.util.Scanner;

public class Jeu {
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		CroupierBoule tao = new CroupierBoule();
		Joueur olivier = new Joueur();

		olivier.vaAuCasino(tao);

		initJetons(olivier);

		boolean jouer = true;
		String input;
		while ((jouer) && (olivier.getTotalJetons() > 0)) {
			
			boolean miser = true;
			while(miser) {
				System.out.println();
				System.out.println("Voulez-vous miser ? (O/N)");
				input = sc.nextLine();
				
				switch (input.charAt(0)) {
				case 'o':
				case 'O':
					System.out.println("Mise Simple ou Numéro ? (S/N)");
					input = sc.nextLine();
					switch (input.charAt(0)) {
					case 's':
					case 'S':
						demanderMiseSimple(olivier);
						break;
					case 'n':
					case 'N':
						demanderMiseNumero(olivier);
						break;
					default:
						System.out.println("Réponse invalide !");
						break;
					}
					break;
				case 'n':
				case 'N':
					miser = false;
					break;
				default :
					System.out.println("Réponse invalide !");
					break;
				}
			}

			System.out.println();
			lancerBoule(tao, olivier);
			
			System.out.println();
			System.out.println("Il vous reste " + olivier.getTotalJetons() + " jetons");
			System.out.println("Voulez-vous continuer ? (O/N)");
			input = sc.nextLine();
			switch (input.charAt(0)) {
			case 'o':
			case 'O':
				jouer = true;
				break;
			case 'n':
			case 'N':
				jouer = false;
				break;
			default :
				System.out.println("Réponse invalide !");
				break;
			}

		}
		System.out.println();
		System.out.println("Merci d'avoir joué !");
		System.out.println("Vous avez " + olivier.getTotalJetons() + " jetons.");
	}

	
	private static void initJetons(Joueur joueur) {
		System.out.println("Combien de jetons avez-vous ?");
		joueur.setTotalJetons(sc.nextInt());
		sc.nextLine();
	}
	
	private static void demanderMiseSimple(Joueur joueur) {
		System.out.println("Sur quelle mise misez-vous ?");
		String nomMise = sc.nextLine();
		System.out.println("Combien de jetons misez-vous ?");
		int quantite = sc.nextInt();
		sc.nextLine();
		joueur.depotMiseSimple(nomMise, quantite);
	}
	
	private static void demanderMiseNumero(Joueur joueur) {
		System.out.println("Sur quel numéro misez-vous ?  (de 1 à 8)");
		int numero = sc.nextInt();
		sc.nextLine();
		System.out.println("Combien de jetons misez-vous ?");
		int quantite = sc.nextInt();
		sc.nextLine();
		joueur.depotMiseNumero(numero, quantite);
	}
	
	private static void lancerBoule(CroupierBoule croupier, Joueur joueur) {
		System.out.println("Les jeux sont faits !");
		croupier.indiqueNumeroSorti();
		System.out.println("num sorti : " + croupier.getNumSorti());
		System.out.println("gains : " + joueur.aGagneOuPerdu());
	}
}
