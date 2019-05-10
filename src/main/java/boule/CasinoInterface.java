package boule;

public interface CasinoInterface {
	
	/**
	 * Permet au joueur de récupérer le numéro sorti
	 * @return le numéro sorti
	 */
	public int getNumSorti();
	
	/**
	 * Permet au joueur de savoir combien de jetons il a gagné ou perdu
	 * @return le nombre de jetons gagnés (<0 si les jetons sont perdus)
	 */
	public int gainOuPerte();
	
	/**
	 * Permet au joueur d'ajouter une mise simple
	 * @param st : le type de mise
	 * @param i  : la quantité de jetons misés
	 * @return un booléen qui indique si tout s'est bien passé
	 */
	public boolean addMiseSimple(String st, Integer i);
	
	/**
	 * Permet au joueur d'ajouter une mise sur un numéro
	 * @param numero   : le numéro misé
	 * @param quantite : la quantité de jetons misés
	 * @return un booléen qui indique si tout s'est bien passé
	 */
	public boolean addMiseNumero(Integer numero, Integer quantite);
	
	/**
	 * Génère le numéro sorti et le renseigne dans le résultat
	 */
	public void indiqueNumeroSorti();
	
}
