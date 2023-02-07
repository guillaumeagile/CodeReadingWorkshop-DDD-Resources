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

	public boolean ontEnCommunUneCaractériqtique(Pièce... pièces) {
		int somme[] = {0,0,0,0};
		for (int i = 0; i < pièces.length; i++) {
			if (pièces[i].estClaire()) 	somme[0] +=1;
			if (pièces[i].estHaute()) 	somme[1] +=1;
			if (pièces[i].estRonde())	somme[2] +=1;
			if (pièces[i].estPleine())	somme[3] +=1;
		}
		return (somme[0] == 0 || somme[0] == 4 ||
				somme[1] == 0 || somme[1] == 4 ||
				somme[2] == 0 || somme[2] == 4 ||
				somme[3] == 0 || somme[3] == 4);	
	}

	public boolean ligneComplèteEtVictorieuse(int ligne) {
		for (int colonne = 0; colonne < NOMBRE_COLONNES; colonne++) {
			if (this.getCases()[ligne][colonne].estVide())
				return false;
		}
		return ontEnCommunUneCaractériqtique(	this.getCases()[ligne][0].getPièce(),
												this.getCases()[ligne][1].getPièce(),
												this.getCases()[ligne][2].getPièce(),
												this.getCases()[ligne][3].getPièce());
	}

	public boolean colonneComplèteEtVictorieuse(int colonne) {
		for (int ligne = 0; ligne < NOMBRE_LIGNES; ligne++) {
			if (this.getCases()[ligne][colonne].estVide())
				return false;
		}
		return ontEnCommunUneCaractériqtique(	this.getCases()[0][colonne].getPièce(),
												this.getCases()[1][colonne].getPièce(),
												this.getCases()[2][colonne].getPièce(),
												this.getCases()[3][colonne].getPièce());
	}

	public boolean premièreDiagonaleComplèteEtVictorieuse() {
		for (int ligne = 0; ligne < NOMBRE_LIGNES; ligne++) {
			if (this.getCases()[ligne][ligne].estVide())
				return false;
		}
		return ontEnCommunUneCaractériqtique(	this.getCases()[0][0].getPièce(),
												this.getCases()[1][1].getPièce(),
												this.getCases()[2][2].getPièce(),
												this.getCases()[3][3].getPièce());
	}

	public boolean deuxièmeDiagonaleComplèteEtVictorieuse() {
		for (int ligne = 0; ligne < NOMBRE_LIGNES; ligne++) {
			if (this.getCases()[ligne][3-ligne].estVide())
				return false;
		}
		return ontEnCommunUneCaractériqtique(	this.getCases()[0][3].getPièce(),
												this.getCases()[1][2].getPièce(),
												this.getCases()[2][1].getPièce(),
												this.getCases()[3][0].getPièce());
	}

}
