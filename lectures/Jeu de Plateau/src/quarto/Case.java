package quarto;

public class Case {
	
	private Pi�ce pi�ce;

	public boolean estVide() {
		return this.pi�ce == null;
	}

	public void poserPi�ce(Pi�ce pi�ce) {
		this.pi�ce = pi�ce;
	}
	
	public Pi�ce getPi�ce() {
		return this.pi�ce;
	}

}
