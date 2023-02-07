package quarto;

import java.util.Objects;

public class Pi�ce {

	private boolean claireOUfonc�e;
	private boolean hauteOuBasse;
	private boolean rondeOUcarr�;
	private boolean pleineOUcreuse;
	
	public Pi�ce(boolean claireOUfonc�e, boolean hauteOuBasse, boolean rondeOUcarr�, boolean pleineOUcreuse) {
		this.claireOUfonc�e = claireOUfonc�e;
		this.hauteOuBasse = hauteOuBasse;
		this.rondeOUcarr� = rondeOUcarr�;
		this.pleineOUcreuse = pleineOUcreuse;
	}

	public boolean estClaire() {
		return this.claireOUfonc�e;
	}
	
	public boolean estFonc�e() {
		return !this.estClaire();
	}

	public boolean estHaute() {
		return this.hauteOuBasse;
	}
	
	public boolean estBasse() {
		return !this.estHaute();
	}

	public boolean estRonde() {
		return this.rondeOUcarr�;
	}

	public boolean estCarr�() {
		return !this.estRonde();
	}

	public boolean estPleine() {
		return this.pleineOUcreuse;
	}

	public boolean estCreuse() {
		return !this.estPleine();
	}

	@Override
	public int hashCode() {
		return Objects.hash(claireOUfonc�e, hauteOuBasse, pleineOUcreuse, rondeOUcarr�);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pi�ce other = (Pi�ce) obj;
		return claireOUfonc�e == other.claireOUfonc�e && hauteOuBasse == other.hauteOuBasse
				&& pleineOUcreuse == other.pleineOUcreuse && rondeOUcarr� == other.rondeOUcarr�;
	}
	
}
