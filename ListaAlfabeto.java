public class ListaAlfabeto
{
	private String letra;
	private ListaAlfabeto prox, ant;
	private ListaPalavra inicioListaPalavra, finalListaPalavra;
	

	public ListaAlfabeto() {
		super();
	}

	public ListaAlfabeto(String letra, ListaAlfabeto ant, ListaAlfabeto prox, ListaPalavra inicioListaPalavra) {
		super();
		this.letra = letra;
		this.prox = prox;
		this.ant = ant;
		this.inicioListaPalavra = inicioListaPalavra;
	}
	
	public ListaAlfabeto(String letra, ListaAlfabeto ant, ListaAlfabeto prox) {
		super();
		this.letra = letra;
		this.ant = ant;
		this.prox = prox;
	}
	
	public String getLetra() {
		return letra;
	}
	
	public void setLetra(String letra) {
		this.letra = letra;
	}
	
	public ListaAlfabeto getProx() {
		return prox;
	}
	
	public void setProx(ListaAlfabeto prox) {
		this.prox = prox;
	}
	
	public ListaAlfabeto getAnt() {
		return ant;
	}
	
	public void setAnt(ListaAlfabeto ant) {
		this.ant = ant;
	}
	
	public ListaPalavra getPrimeiraPalavra() {
		return inicioListaPalavra;
	}
	
	public void setPrimeiraPalavra(ListaPalavra primeiraPalavra) {
		this.inicioListaPalavra = primeiraPalavra;
	}
	
	public ListaPalavra getFinalListaPalavra() {
		return finalListaPalavra;
	}

	public void setFinalListaPalavra(ListaPalavra finalListaPalavra) {
		this.finalListaPalavra = finalListaPalavra;
	}

}