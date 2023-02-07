package quarto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestQuarto {

	private Quarto quarto;
	
	@BeforeEach
	void setUp() throws Exception {
		this.quarto = new Quarto();
	}

	@AfterEach
	void tearDown() throws Exception {
		this.quarto = quarto;
	}

	@Test
	void testLePlateauDevraitEtreVideEnDebutDePartie() {
		assertTrue(this.quarto.estVide());
	}
	
	@Test
	void testLesPiècesRestantesAJouerSontAuNombreDe16() {
		assertEquals(16,this.quarto.nombreDePiècesRestantAJouer());
	}
	
	@Test
	void testJeNePeuxChoisirQunePieceQuiNaPasEtéJoué() {
		assertTrue(this.quarto.choisirUnePieceNonJouée(new Pièce(false,false,false,false)));
		assertFalse(this.quarto.choisirUnePieceNonJouée(new Pièce(false,false,false,false)));
	}

	@Test
	void testEmplacementLibre() {
		assertTrue(this.quarto.emplacementLibre(0,0));
		this.quarto.poserPièce(new Pièce(false,false,false,false),0,0);
		assertFalse(this.quarto.emplacementLibre(0, 0));
	}
	
	@Test
	void testPoserPièceSurEmplacementNonLibre() {
		this.quarto.poserPièce(new Pièce(false,false,false,false),0,0);
		assertThrows(RuntimeException.class, () -> {
			this.quarto.poserPièce(new Pièce(false,false,false,false),0,0);
		});
	}
	
	@Test
	void testVictoireLigneComplèteEtUneCaractéristiqueCommune() {
		this.quarto.poserPièce(new Pièce(false,false,false,false),0,0);
		assertFalse(this.quarto.coupVictorieux(0,0));
		this.quarto.poserPièce(new Pièce(false,true,false,false),0,1);
		assertFalse(this.quarto.coupVictorieux(0,1));
		this.quarto.poserPièce(new Pièce(false,false,true,false),0,2);
		assertFalse(this.quarto.coupVictorieux(0,2));
		this.quarto.poserPièce(new Pièce(false,false,false,true),0,3);
		assertTrue(this.quarto.coupVictorieux(0,3));
	}
	
	@Test
	void testVictoireColonneComplèteEtUneCaractéristiqueCommune() {
		this.quarto.poserPièce(new Pièce(false,false,false,false),0,0);
		assertFalse(this.quarto.coupVictorieux(0,0));
		this.quarto.poserPièce(new Pièce(false,true,false,false),1,0);
		assertFalse(this.quarto.coupVictorieux(1,0));
		this.quarto.poserPièce(new Pièce(false,false,true,false),2,0);
		assertFalse(this.quarto.coupVictorieux(2,0));
		this.quarto.poserPièce(new Pièce(false,false,false,true),3,0);
		assertTrue(this.quarto.coupVictorieux(3,0));
	}
	
	@Test
	void testVictoirePremiereDiagonaleUneCaractéristiqueCommune() {
		this.quarto.poserPièce(new Pièce(false,false,false,false),0,0);
		assertFalse(this.quarto.coupVictorieux(0,0));
		this.quarto.poserPièce(new Pièce(false,true,false,false),1,1);
		assertFalse(this.quarto.coupVictorieux(1,1));
		this.quarto.poserPièce(new Pièce(false,false,true,false),2,2);
		assertFalse(this.quarto.coupVictorieux(2,2));
		this.quarto.poserPièce(new Pièce(false,false,false,true),3,3);
		assertTrue(this.quarto.coupVictorieux(3,3));
	}
	
	@Test
	void testVictoireDeuxiemeDiagonaleUneCaractéristiqueCommune() {
		this.quarto.poserPièce(new Pièce(false,false,false,false),0,3);
		assertFalse(this.quarto.coupVictorieux(0,3));
		this.quarto.poserPièce(new Pièce(false,true,false,false),1,2);
		assertFalse(this.quarto.coupVictorieux(1,2));
		this.quarto.poserPièce(new Pièce(false,false,true,false),2,1);
		assertFalse(this.quarto.coupVictorieux(2,1));
		this.quarto.poserPièce(new Pièce(false,false,false,true),3,0);
		assertTrue(this.quarto.coupVictorieux(3,0));
	}
}
