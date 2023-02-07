package quarto;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TestPièce {

	@Test
	void testUnePièceDevraitEtreClaireOuFoncée() {
		Pièce pièceClaire = new Pièce(true,true,true,true);
		assertTrue(pièceClaire.estClaire());
		assertFalse(pièceClaire.estFoncée());
		
		Pièce pièceFoncée = new Pièce(false,true,true,true);
		assertFalse(pièceFoncée.estClaire());
		assertTrue(pièceFoncée.estFoncée());
	}
	
	@Test
	void testUnePièceDevraitEtreHauteOuBasse() {
		Pièce pièceHaute = new Pièce(true,true,true,true);
		assertTrue(pièceHaute.estHaute());
		assertFalse(pièceHaute.estBasse());
		
		Pièce pièceBasse = new Pièce(true,false,true,true);
		assertFalse(pièceBasse.estHaute());
		assertTrue(pièceBasse.estBasse());
	}
	
	@Test
	void testUnePièceDevraitEtreRondeOuCarré() {
		Pièce pièceRonde = new Pièce(true,true,true,true);
		assertTrue(pièceRonde.estRonde());
		assertFalse(pièceRonde.estCarré());
		
		Pièce pièceCarré = new Pièce(true,true,false,true);
		assertFalse(pièceCarré.estRonde());
		assertTrue(pièceCarré.estCarré());
	}
	
	@Test
	void testUnePièceDevraitEtrePleineOuCreuse() {
		Pièce piècePleine = new Pièce(true,true,true,true);
		assertTrue(piècePleine.estPleine());
		assertFalse(piècePleine.estCreuse());
		
		Pièce pièceCreuse = new Pièce(true,true,true,false);
		assertFalse(pièceCreuse.estPleine());
		assertTrue(pièceCreuse.estCreuse());
	}

}
