package quarto;

public class Case {
	
	private Pièce pièce;

	public boolean estVide() {
		return this.pièce == null;
	}

	public void poserPièce(Pièce pièce) {
		this.pièce = pièce;
	}
	
	public Pièce getPièce() {
		return this.pièce;
	}

}
