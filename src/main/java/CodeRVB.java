package main.java;

public class CodeRVB {

	private int rouge;
	private int vert;
	private int bleu;
	
	
	public CodeRVB(int rouge, int vert, int bleu) {
		super();
		this.rouge = rouge;
		this.vert = vert;
		this.bleu = bleu;
	}
	
	public int getRouge() {
		return rouge;
	}
	public void setRouge(int rouge) {
		this.rouge = rouge;
	}
	public int getVert() {
		return vert;
	}
	public void setVert(int vert) {
		this.vert = vert;
	}
	public int getBleu() {
		return bleu;
	}
	public void setBleu(int bleu) {
		this.bleu = bleu;
	}
	
	public boolean equals(Object obj) {
	      return (obj instanceof CodeRVB) && 
		  ((CodeRVB)obj).getRouge() == rouge && 
		  ((CodeRVB)obj).getVert() == vert && 
		  ((CodeRVB)obj).getBleu() == bleu;
	    }

	
}

