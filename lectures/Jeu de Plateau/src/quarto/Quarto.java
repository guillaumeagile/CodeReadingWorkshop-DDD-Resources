package quarto;

import java.util.HashSet;
import java.util.Set;

public class Quarto {
	
	private Plateau plateau;
	private Set<Pièce> piècesRestantesAJouer;
	
	public Quarto() {
		this.plateau = new Plateau();
		this.piècesRestantesAJouer = new HashSet<>();
		this.piècesRestantesAJouer.add(new Pièce(false,false,false,false));
		this.piècesRestantesAJouer.add(new Pièce(false,false,false,true));
		this.piècesRestantesAJouer.add(new Pièce(false,false,true,false));
		this.piècesRestantesAJouer.add(new Pièce(false,false,true,true));
		this.piècesRestantesAJouer.add(new Pièce(false,true,false,false));
		this.piècesRestantesAJouer.add(new Pièce(false,true,false,true));
		this.piècesRestantesAJouer.add(new Pièce(false,true,true,false));
		this.piècesRestantesAJouer.add(new Pièce(false,true,true,true));
		this.piècesRestantesAJouer.add(new Pièce(true,false,false,false));
		this.piècesRestantesAJouer.add(new Pièce(true,false,false,true));
		this.piècesRestantesAJouer.add(new Pièce(true,false,true,false));
		this.piècesRestantesAJouer.add(new Pièce(true,false,true,true));
		this.piècesRestantesAJouer.add(new Pièce(true,true,false,false));
		this.piècesRestantesAJouer.add(new Pièce(true,true,false,true));
		this.piècesRestantesAJouer.add(new Pièce(true,true,true,false));
		this.piècesRestantesAJouer.add(new Pièce(true,true,true,true));
	}

	public boolean estVide() {
		return this.plateau.estVide();
	}

	public int nombreDePiècesRestantAJouer() {
		return this.piècesRestantesAJouer.size();
	}

	public boolean choisirUnePieceNonJouée(Pièce pièce) {
		if (this.piècesRestantesAJouer.contains(pièce)) {
			this.piècesRestantesAJouer.remove(pièce);
			return true;
		}
		return false;
	}

	public boolean emplacementLibre(int ligne, int colonne) {
		return this.plateau.getCases()[ligne][colonne].estVide();
	}

	public void poserPièce(Pièce pièce, int ligne, int colonne) {
		if (!this.emplacementLibre(ligne, colonne)) {
			throw new RuntimeException("Emplacement non Libre !");
		}
		this.plateau.getCases()[ligne][colonne].poserPièce(pièce);
		
	}

	public boolean coupVictorieux(int ligne, int colonne) {
		return 	this.plateau.ligneComplèteEtVictorieuse(ligne) ||
				this.plateau.colonneComplèteEtVictorieuse(colonne) ||
				(ligne == colonne && this.plateau.premièreDiagonaleComplèteEtVictorieuse()) ||
				(ligne + colonne == 3 && this.plateau.deuxièmeDiagonaleComplèteEtVictorieuse());
	}

}
