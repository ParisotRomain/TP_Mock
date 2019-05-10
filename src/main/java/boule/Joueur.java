package boule;

public class Joueur {
	private CasinoInterface representantCasino;
	private int totalJetons;

	/**
	 * Détermine combien de jetons ont été gagnés (ou perdu)
	 * et mets à jour le nombre de jetons du joueur
	 * @return les gains de cette partie
	 */
	public int aGagneOuPerdu() {
		int gains = representantCasino.gainOuPerte();
		totalJetons += gains;
		return gains;
	}

	/**
	 * Demande au casino le numéro sorti
	 * @return le numéro sorti
	 */
	public int getNumeroSorti() {
		return representantCasino.getNumSorti();
	}

	/**
	 * Informe le casino d'une nouvelle mise simple
	 * @param nomMise  : le type de mise
	 * @param quantite : la quantité de jetons misés
	 */
	public void depotMiseSimple(String nomMise, int quantite) {
		if (totalJetons >= quantite) {
		if (representantCasino.addMiseSimple(nomMise, quantite))
			totalJetons -= quantite;
		} else {
			System.out.println("Vous n'avez pas assez de jetons !");
		}
	}

	/**
	 * Informe le casino d'une nouvelle mise numéro
	 * @param numero   : le numéro misé
	 * @param quantite : la quantité de jetons misés
	 */
	public void depotMiseNumero(int numero, int quantite) {
		if (totalJetons >= quantite) {
			if (representantCasino.addMiseNumero(numero, quantite))
				totalJetons -= quantite;
		} else {
			System.out.println("Vous n'avez pas assez de jetons !");
		}
	}


	public Joueur() {
		super();
	}

	public CasinoInterface getCasino() {
		return representantCasino;
	}

	public void vaAuCasino(CasinoInterface representantCasino) {
		this.setCasino(representantCasino);
	}

	public void setCasino(CasinoInterface representantCasino) {
		this.representantCasino = representantCasino;
	}

	public int getTotalJetons() {
		return totalJetons;
	}

	public void setTotalJetons(int totalJetons) {
		this.totalJetons = totalJetons;
	}
}
