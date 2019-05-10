package test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import boule.CasinoInterface;
import boule.Joueur;

public class JoueurTest {
	private Joueur leJoueur;
	private CasinoInterface laDoublure;
	
	@Before
	public void setup() {
		leJoueur = new Joueur();
		laDoublure = mock(CasinoInterface.class);
		leJoueur.setCasino(laDoublure);
	}
	
	@Test
	public void testGagne() {
		System.out.println("Le joueur n'a joué que sur le 8 avec 3 jetons et le 8 est sorti");
		when(laDoublure.getNumSorti()).thenReturn(8);
		when(laDoublure.gainOuPerte()).thenReturn(21);
		int gagneOuPerdu = leJoueur.aGagneOuPerdu();
		System.out.println("Le joueur a gagné : " + gagneOuPerdu + " parce que le numéro sorti est : " + leJoueur.getNumeroSorti());
		assertEquals(21, gagneOuPerdu);
		
		System.out.println("Fin de testGagne");
	}
	
	@Test
	public void testPerdu() {
		System.out.println("Le joueur n'a joué que sur le 8 avec 3 jetons et le 9 est sorti");
		when(laDoublure.getNumSorti()).thenReturn(9);
		when(laDoublure.gainOuPerte()).thenReturn(-3);
		int gagneOuPerdu = leJoueur.aGagneOuPerdu();
		System.out.println("Le joueur a gagné : " + gagneOuPerdu + " parce que le numéro sorti est : " + leJoueur.getNumeroSorti());
		assertEquals(-3, gagneOuPerdu);
		
		System.out.println("Fin de testPerdu");
	}

}
