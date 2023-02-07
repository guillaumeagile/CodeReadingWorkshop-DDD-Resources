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
