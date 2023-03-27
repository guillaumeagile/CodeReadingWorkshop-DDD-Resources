package quarto;

public class Plateau {

	public static final int NOMBRE_COLONNES = 4;
	public static final int NOMBRE_LIGNES = 4;
	private Case[][] cases;
	
	public Plateau() {
		this.cases = new Case[NOMBRE_LIGNES][NOMBRE_COLONNES];
		for (int i = 0; i < NOMBRE_LIGNES; i++) {
			for (int j = 0; j < NOMBRE_COLONNES; j++) {
				this.cases[i][j] = new Case();
			}
		}
	}

	public Case[][] getCases() {
		return this.cases;
	}

	public int nombreDeLignes() {
		return NOMBRE_LIGNES;
	}

	public int nombreDeColonnes() {
		return NOMBRE_COLONNES;
	}

	public boolean estVide() {
		for (int i = 0; i < NOMBRE_LIGNES; i++) {
			for (int j = 0; j < NOMBRE_COLONNES; j++) {
				if (!this.cases[i][j].estVide()) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean ontEnCommunUneCaract�riqtique(Pi�ce... pi�ces) {
		int somme[] = {0,0,0,0};
		for (int i = 0; i < pi�ces.length; i++) {
			if (pi�ces[i].estClaire()) 	somme[0] +=1;
			if (pi�ces[i].estHaute()) 	somme[1] +=1;
			if (pi�ces[i].estRonde())	somme[2] +=1;
			if (pi�ces[i].estPleine())	somme[3] +=1;
		}
		return (somme[0] == 0 || somme[0] == 4 ||
				somme[1] == 0 || somme[1] == 4 ||
				somme[2] == 0 || somme[2] == 4 ||
				somme[3] == 0 || somme[3] == 4);	
	}

	public boolean ligneCompl�teEtVictorieuse(int ligne) {
		for (int colonne = 0; colonne < NOMBRE_COLONNES; colonne++) {
			if (this.getCases()[ligne][colonne].estVide())
				return false;
		}
		return ontEnCommunUneCaract�riqtique(	this.getCases()[ligne][0].getPi�ce(),
												this.getCases()[ligne][1].getPi�ce(),
												this.getCases()[ligne][2].getPi�ce(),
												this.getCases()[ligne][3].getPi�ce());
	}

	public boolean colonneCompl�teEtVictorieuse(int colonne) {
		for (int ligne = 0; ligne < NOMBRE_LIGNES; ligne++) {
			if (this.getCases()[ligne][colonne].estVide())
				return false;
		}
		return ontEnCommunUneCaract�riqtique(	this.getCases()[0][colonne].getPi�ce(),
												this.getCases()[1][colonne].getPi�ce(),
												this.getCases()[2][colonne].getPi�ce(),
												this.getCases()[3][colonne].getPi�ce());
	}

	public boolean premi�reDiagonaleCompl�teEtVictorieuse() {
		for (int ligne = 0; ligne < NOMBRE_LIGNES; ligne++) {
			if (this.getCases()[ligne][ligne].estVide())
				return false;
		}
		return ontEnCommunUneCaract�riqtique(	this.getCases()[0][0].getPi�ce(),
												this.getCases()[1][1].getPi�ce(),
												this.getCases()[2][2].getPi�ce(),
												this.getCases()[3][3].getPi�ce());
	}

	public boolean deuxi�meDiagonaleCompl�teEtVictorieuse() {
		for (int ligne = 0; ligne < NOMBRE_LIGNES; ligne++) {
			if (this.getCases()[ligne][3-ligne].estVide())
				return false;
		}
		return ontEnCommunUneCaract�riqtique(	this.getCases()[0][3].getPi�ce(),
												this.getCases()[1][2].getPi�ce(),
												this.getCases()[2][1].getPi�ce(),
												this.getCases()[3][0].getPi�ce());
	}

}
package quarto;

import java.util.HashSet;
import java.util.Set;

public class Quarto {
	
	private Plateau plateau;
	private Set<Pi�ce> pi�cesRestantesAJouer;
	
	public Quarto() {
		this.plateau = new Plateau();
		this.pi�cesRestantesAJouer = new HashSet<>();
		this.pi�cesRestantesAJouer.add(new Pi�ce(false,false,false,false));
		this.pi�cesRestantesAJouer.add(new Pi�ce(false,false,false,true));
		this.pi�cesRestantesAJouer.add(new Pi�ce(false,false,true,false));
		this.pi�cesRestantesAJouer.add(new Pi�ce(false,false,true,true));
		this.pi�cesRestantesAJouer.add(new Pi�ce(false,true,false,false));
		this.pi�cesRestantesAJouer.add(new Pi�ce(false,true,false,true));
		this.pi�cesRestantesAJouer.add(new Pi�ce(false,true,true,false));
		this.pi�cesRestantesAJouer.add(new Pi�ce(false,true,true,true));
		this.pi�cesRestantesAJouer.add(new Pi�ce(true,false,false,false));
		this.pi�cesRestantesAJouer.add(new Pi�ce(true,false,false,true));
		this.pi�cesRestantesAJouer.add(new Pi�ce(true,false,true,false));
		this.pi�cesRestantesAJouer.add(new Pi�ce(true,false,true,true));
		this.pi�cesRestantesAJouer.add(new Pi�ce(true,true,false,false));
		this.pi�cesRestantesAJouer.add(new Pi�ce(true,true,false,true));
		this.pi�cesRestantesAJouer.add(new Pi�ce(true,true,true,false));
		this.pi�cesRestantesAJouer.add(new Pi�ce(true,true,true,true));
	}

	public boolean estVide() {
		return this.plateau.estVide();
	}

	public int nombreDePi�cesRestantAJouer() {
		return this.pi�cesRestantesAJouer.size();
	}

	public boolean choisirUnePieceNonJou�e(Pi�ce pi�ce) {
		if (this.pi�cesRestantesAJouer.contains(pi�ce)) {
			this.pi�cesRestantesAJouer.remove(pi�ce);
			return true;
		}
		return false;
	}

	public boolean emplacementLibre(int ligne, int colonne) {
		return this.plateau.getCases()[ligne][colonne].estVide();
	}

	public void poserPi�ce(Pi�ce pi�ce, int ligne, int colonne) {
		if (!this.emplacementLibre(ligne, colonne)) {
			throw new RuntimeException("Emplacement non Libre !");
		}
		this.plateau.getCases()[ligne][colonne].poserPi�ce(pi�ce);
		
	}

	public boolean coupVictorieux(int ligne, int colonne) {
		return 	this.plateau.ligneCompl�teEtVictorieuse(ligne) ||
				this.plateau.colonneCompl�teEtVictorieuse(colonne) ||
				(ligne == colonne && this.plateau.premi�reDiagonaleCompl�teEtVictorieuse()) ||
				(ligne + colonne == 3 && this.plateau.deuxi�meDiagonaleCompl�teEtVictorieuse());
	}

}
