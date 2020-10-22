public class HeaderListas {
	private ListaAlfabeto primeiraLetra, ultimaLetra;
	
	public ListaAlfabeto getPrimeiraLetra() {
		return primeiraLetra;
	}
	
	public void setPrimeiraLetra(ListaAlfabeto primeiraLetra) {
		this.primeiraLetra = primeiraLetra;
	}
	
	public ListaAlfabeto getUltimaLetra() {
		return ultimaLetra;
	}
	
	public void setUltimaLetra(ListaAlfabeto ultimaLetra) {
		this.ultimaLetra = ultimaLetra;
	}

	
	public HeaderListas(ListaAlfabeto primeiraLetra, ListaAlfabeto ultimaLetra, ListaPalavra primeiraPalavra,
			ListaPalavra ultimaPalavra) {
		super();
		this.primeiraLetra = primeiraLetra;
		this.ultimaLetra = ultimaLetra;

	}
	
	public HeaderListas() {
		super();
	}
	
}
