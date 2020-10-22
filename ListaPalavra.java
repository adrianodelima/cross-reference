public class ListaPalavra
{
	private String palavra;
	private ListaPalavra prox, ant;
	private int numeroDeRepeticoes=1;

	public ListaPalavra(String palavra, ListaPalavra ant, ListaPalavra prox) {
		super();
		this.palavra = palavra;
		this.prox = prox;
		this.ant = ant;

	}
	
	public ListaPalavra() {
		super();
	}

	public String getPalavra() {
		return palavra;
	}

	public void setPalavra(String palavra) {
		this.palavra = palavra;
	}


	public ListaPalavra getProx() {
		return prox;
	}
	public void setProx(ListaPalavra prox) {
		this.prox = prox;
	}
	public ListaPalavra getAnt() {
		return ant;
	}
	public void setAnt(ListaPalavra ant) {
		this.ant = ant;
	}

	public int getNumeroDeRepeticoes() {
		return numeroDeRepeticoes;
	}

	public void setNumeroDeRepeticoes(int numeroDeRepeticoes) {
		this.numeroDeRepeticoes = numeroDeRepeticoes;
	}
	
	public void aumentarNumeroDeRepeticoes() {
		numeroDeRepeticoes++;
	}

	public void diminuirNumeroDeRepeticoes() {
		numeroDeRepeticoes--;
	}
}