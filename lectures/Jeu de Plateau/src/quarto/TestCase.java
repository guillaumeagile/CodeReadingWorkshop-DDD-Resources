package quarto;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TestPi�ce {

	@Test
	void testUnePi�ceDevraitEtreClaireOuFonc�e() {
		Pi�ce pi�ceClaire = new Pi�ce(true,true,true,true);
		assertTrue(pi�ceClaire.estClaire());
		assertFalse(pi�ceClaire.estFonc�e());
		
		Pi�ce pi�ceFonc�e = new Pi�ce(false,true,true,true);
		assertFalse(pi�ceFonc�e.estClaire());
		assertTrue(pi�ceFonc�e.estFonc�e());
	}
	
	@Test
	void testUnePi�ceDevraitEtreHauteOuBasse() {
		Pi�ce pi�ceHaute = new Pi�ce(true,true,true,true);
		assertTrue(pi�ceHaute.estHaute());
		assertFalse(pi�ceHaute.estBasse());
		
		Pi�ce pi�ceBasse = new Pi�ce(true,false,true,true);
		assertFalse(pi�ceBasse.estHaute());
		assertTrue(pi�ceBasse.estBasse());
	}
	
	@Test
	void testUnePi�ceDevraitEtreRondeOuCarr�() {
		Pi�ce pi�ceRonde = new Pi�ce(true,true,true,true);
		assertTrue(pi�ceRonde.estRonde());
		assertFalse(pi�ceRonde.estCarr�());
		
		Pi�ce pi�ceCarr� = new Pi�ce(true,true,false,true);
		assertFalse(pi�ceCarr�.estRonde());
		assertTrue(pi�ceCarr�.estCarr�());
	}
	
	@Test
	void testUnePi�ceDevraitEtrePleineOuCreuse() {
		Pi�ce pi�cePleine = new Pi�ce(true,true,true,true);
		assertTrue(pi�cePleine.estPleine());
		assertFalse(pi�cePleine.estCreuse());
		
		Pi�ce pi�ceCreuse = new Pi�ce(true,true,true,false);
		assertFalse(pi�ceCreuse.estPleine());
		assertTrue(pi�ceCreuse.estCreuse());
	}

}
