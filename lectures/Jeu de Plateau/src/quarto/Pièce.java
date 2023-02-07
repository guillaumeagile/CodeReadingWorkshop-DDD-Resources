package quarto;

import java.util.Objects;

public class Pièce {

	private boolean claireOUfoncée;
	private boolean hauteOuBasse;
	private boolean rondeOUcarré;
	private boolean pleineOUcreuse;
	
	public Pièce(boolean claireOUfoncée, boolean hauteOuBasse, boolean rondeOUcarré, boolean pleineOUcreuse) {
		this.claireOUfoncée = claireOUfoncée;
		this.hauteOuBasse = hauteOuBasse;
		this.rondeOUcarré = rondeOUcarré;
		this.pleineOUcreuse = pleineOUcreuse;
	}

	public boolean estClaire() {
		return this.claireOUfoncée;
	}
	
	public boolean estFoncée() {
		return !this.estClaire();
	}

	public boolean estHaute() {
		return this.hauteOuBasse;
	}
	
	public boolean estBasse() {
		return !this.estHaute();
	}

	public boolean estRonde() {
		return this.rondeOUcarré;
	}

	public boolean estCarré() {
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
		return Objects.hash(claireOUfoncée, hauteOuBasse, pleineOUcreuse, rondeOUcarré);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pièce other = (Pièce) obj;
		return claireOUfoncée == other.claireOUfoncée && hauteOuBasse == other.hauteOuBasse
				&& pleineOUcreuse == other.pleineOUcreuse && rondeOUcarré == other.rondeOUcarré;
	}
	
}
