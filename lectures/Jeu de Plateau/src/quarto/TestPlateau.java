package quarto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestPlateau {
	
	private Plateau plateau;

	@BeforeEach
	void setUp() throws Exception {
		this.plateau = new Plateau();
	}

	@AfterEach
	void tearDown() throws Exception {
		this.plateau = null;
	}
	
	@Test
	void unPlateauDevraitAvoir4Lignes() {
		assertEquals(4, this.plateau.nombreDeLignes());
	}
	
	@Test
	void unPlateauDevraitAvoir4Colonnes() {
		assertEquals(4, this.plateau.nombreDeColonnes());
	}
	
	@Test
	void unPlateauDevraitEtreCompos�De16Cases() {
		assertEquals(16, this.plateau.getCases().length * this.plateau.getCases()[0].length);
	}
	
	@Test
	void unPlateauDevraitEtreVideEnDebutDePartie() {
		assertTrue(this.plateau.estVide());
	}
	
	@Test
	void OntEnCommunAuMoinsUneCaract�ristique() {
		assertTrue(this.plateau.ontEnCommunUneCaract�riqtique(
				new Pi�ce(true, false, false, false),
				new Pi�ce(true, true, false, false),
				new Pi�ce(true, false, true, false),
				new Pi�ce(true, false, false, true)));
		
		assertFalse(this.plateau.ontEnCommunUneCaract�riqtique(
				new Pi�ce(false, false, false, false),
				new Pi�ce(true, true, false, false),
				new Pi�ce(true, false, true, false),
				new Pi�ce(true, false, false, true)));
	}

}
