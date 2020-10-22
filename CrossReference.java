        import java.util.Scanner;
        
        public class CrossReference
        {
            
            private HeaderListas header = new HeaderListas();
            private ListaAlfabeto letraAux;

            
            private Scanner entrada = new Scanner(System.in);
        
        void menuPrincipal()
        {
            System.out.println("0.Sair");
            System.out.println("1.Inserir texto");
            System.out.println("2.Inserir palavra");
            System.out.println("3.Remover palavra");
            System.out.println("4.Verificar se palavra existe");
            System.out.println("5.Exibir referência cruzada");
            System.out.println("6.Exibir palavras iniciadas com determinada letra"); 
            System.out.println("7.Exibir total de palavras diferentes"); 
            System.out.println("8.Exibir número total de palavras"); 
            System.out.println("9.Exibir número total de palavras iniciadas por determinada letra"); 
            int opcao = entrada.nextInt();

            while(opcao != 0)
            {
                switch(opcao)
                {
                    case 1:
                    this.criarAlfabeto();
                    this.criarReferenciaCruzada();
                    break;
    
                    case 2:
                    this.inserePalavra();
                    break;
    
                    case 3:
                    this.removePalavra();
                    break;
    
                    case 4:
                    this.existePalavra();
                    break;
    
                    case 5:
                    this.exibeReferenciaCruzada();
                    break;
    
                    case 6:
                    this.exibePalavrasLetra();
                    break;
                    
                    case 7:
                    this.contaPalavrasDiferentesTotal();
                    break;
                    
                    case 8:
                    this.contaPalavrasTotal();
                    break;
                    
                    case 9:
                    this.ContaPalavrasPorLetra();
                    break;
            }

            System.out.println("0.Sair");
            System.out.println("1.Inserir texto");
            System.out.println("2.Inserir palavra");
            System.out.println("3.Remover palavra");
            System.out.println("4.Verificar se palavra existe");
            System.out.println("5.Exibir referência cruzada");
            System.out.println("6.Exibir palavras iniciadas com determinada letra"); 
            System.out.println("7.Exibir total de palavras diferentes"); 
            System.out.println("8.Exibir número total de palavras"); 
            System.out.println("9.Exibir número total de palavras iniciadas por determinada letra"); 
            opcao = entrada.nextInt();
        }
    }

        private void criarReferenciaCruzada() {

        	System.out.println("Insira o texto para criar a referencia cruzada:");
            entrada.nextLine();
        	String texto = entrada.nextLine();

            
            String[] textoSeparado = texto.split(" ");
        	
            for (String palavra: textoSeparado) {  
            	
            		palavra = palavra.toUpperCase();
            		String letraInicial = palavra.substring(0,1);
              	
            		ListaAlfabeto percorreAlfabeto = header.getPrimeiraLetra();
            		String buscaLetra = percorreAlfabeto.getLetra();
            		
            			while(letraInicial != null && !letraInicial.equals(buscaLetra)) {
            				percorreAlfabeto = percorreAlfabeto.getProx();
            				buscaLetra = percorreAlfabeto.getLetra();
            			}


            		this.insercaoOrdenada(palavra, percorreAlfabeto);
                	System.out.println("Concluido: seu texto se tornou uma referencia cruzada!");
            }
        }
        
        private void inserePalavra() {
        	System.out.println("Insira a palavra que deseja inserir na referencia cruzada:");
            entrada.nextLine();
            String palavra = entrada.nextLine();
            palavra = palavra.toUpperCase();
    		ListaAlfabeto percorreAlfabeto = header.getPrimeiraLetra();
    		String buscaLetra = percorreAlfabeto.getLetra();
    		
            		String letraInicial = palavra.substring(0,1);
            		
            			while(letraInicial != null && !letraInicial.equals(buscaLetra)) {
            				percorreAlfabeto = percorreAlfabeto.getProx();
            				buscaLetra = percorreAlfabeto.getLetra();
            			}
    		
    		this.insercaoOrdenada(palavra, percorreAlfabeto);
        	System.out.println("Concluido: palavra adicionada a referencia cruzada!");
        }
        
        private void removePalavra() {
        	System.out.println("Insira a palavra que deseja remover da referencia cruzada:");
            entrada.nextLine();
            String palavra = entrada.nextLine();

            
            ListaAlfabeto percorrerAlfabeto = header.getPrimeiraLetra();
            ListaAlfabeto ultimaLetra = header.getUltimaLetra();
            int exclusaoRealizada = 0;
            palavra = palavra.toUpperCase();
            
            while(percorrerAlfabeto.getProx() != null || percorrerAlfabeto.getLetra().contentEquals(ultimaLetra.getLetra())) {
                ListaPalavra percorrerPalavras = percorrerAlfabeto.getPrimeiraPalavra();
                ListaPalavra ultimaPalavra = percorrerAlfabeto.getFinalListaPalavra();
                
                while(percorrerPalavras.getProx() != null || percorrerPalavras.getPalavra().contentEquals(ultimaPalavra.getPalavra())) {
                    
                	if(percorrerPalavras.getPalavra().contentEquals(palavra)) {
                    	
                		if(percorrerPalavras.getAnt() == null && percorrerPalavras.getProx() == null) {
                    		percorrerAlfabeto.setPrimeiraPalavra(null);
                        	exclusaoRealizada = 1;
                        	break;
                    	}
                		
                    	else {
                    	ListaPalavra aux = percorrerPalavras.getAnt();
                    	if(aux == null) {
                    		percorrerAlfabeto.setPrimeiraPalavra(percorrerPalavras.getProx());
                        	exclusaoRealizada = 1;
                        	break;
                    	}
                    	if(percorrerPalavras.getProx() == null) {
                    		percorrerAlfabeto.setFinalListaPalavra(percorrerPalavras.getAnt());
                        	exclusaoRealizada = 1;
                        	break;
                    	}
                    	else {
                    	aux.setProx(percorrerPalavras.getProx());	
                    	}
                    	}
                		
                    }
                	
                    if(percorrerPalavras.getProx()==null) {
                    	break;
                    }
                    
                    percorrerPalavras = percorrerPalavras.getProx();
                }
                if(exclusaoRealizada == 1 ) {
                	break;
                }
                if(percorrerAlfabeto.getProx()==null) {
                	break;
                }
                
                percorrerAlfabeto = percorrerAlfabeto.getProx();
                percorrerPalavras = percorrerAlfabeto.getPrimeiraPalavra();
            } 
        	System.out.println("Exclusão realizada com sucesso!");

        }
        
        private void existePalavra(){
        	System.out.println("Insira a palavra que deseja buscar na referencia cruzada:");
            entrada.nextLine();
            String palavra = entrada.nextLine();

            
            ListaAlfabeto percorrerAlfabeto = header.getPrimeiraLetra();
            ListaAlfabeto ultimaLetra = header.getUltimaLetra();
            int jaExiste = 0, fimDaBusca = 0;
            palavra = palavra.toUpperCase();
            
            while(percorrerAlfabeto.getProx() != null || percorrerAlfabeto.getLetra().contentEquals(ultimaLetra.getLetra())) {
            	ListaPalavra percorrerPalavras = percorrerAlfabeto.getPrimeiraPalavra();
            	ListaPalavra ultimaPalavra = percorrerAlfabeto.getFinalListaPalavra();
            	
            	while(percorrerAlfabeto.getPrimeiraPalavra() == null && fimDaBusca==0) {
            		if(percorrerAlfabeto.getProx() == null) {
            			fimDaBusca=1;
            			break;
            		}
            		percorrerAlfabeto = percorrerAlfabeto.getProx();
            		percorrerPalavras = percorrerAlfabeto.getPrimeiraPalavra();
                	ultimaPalavra = percorrerAlfabeto.getFinalListaPalavra();
            	}
            	
            	if(fimDaBusca ==1) {
            		break;
            	}
            	if(percorrerPalavras.getProx() != null || percorrerPalavras.getPalavra().contentEquals(ultimaPalavra.getPalavra())) {

            		if(percorrerPalavras.getPalavra().contentEquals(palavra)) {
            				jaExiste=1;
            	        	System.out.println("A palavra " + palavra + " esta presente na referência cruzada!");
            				break;
            		}

                    if(percorrerPalavras.getProx() != null) {
                    percorrerPalavras = percorrerPalavras.getProx();
                    }
                    else {
                		if(percorrerPalavras.getPalavra().contentEquals(palavra)) {
            				jaExiste=1;
            	        	System.out.println("A palavra " + palavra + " esta presente na referência cruzada!");
            				break;
                    }
                }
                if(jaExiste == 1 ) {
                	break;
                }
                
                if(percorrerAlfabeto.getProx() == null) {
                	break;
                }
                percorrerAlfabeto = percorrerAlfabeto.getProx();

            }
           }
            if(jaExiste==0) {
        	System.out.println("A palavra " + palavra + " nao foi encontrada na referência cruzada!");
            }
        }
        
        private void exibePalavrasLetra() {
        	System.out.println("Insira a letra que deseja buscar na referencia cruzada:");
            entrada.nextLine();
            int encontrou = 0;
            String letra = entrada.nextLine();
            letra = letra.toUpperCase();
            
            ListaAlfabeto percorrerAlfabeto = header.getPrimeiraLetra();
            ListaAlfabeto ultimaLetra = header.getUltimaLetra();
            

            while(percorrerAlfabeto.getProx() != null || percorrerAlfabeto.getLetra().contentEquals(ultimaLetra.getLetra())) {
                ListaPalavra percorrerPalavras = percorrerAlfabeto.getPrimeiraPalavra();
                ListaPalavra ultimaPalavra = percorrerAlfabeto.getFinalListaPalavra();


                if(percorrerPalavras != null) {

                while(percorrerPalavras.getProx() != null || percorrerPalavras.getPalavra().contentEquals(ultimaPalavra.getPalavra())) {
                    if(percorrerAlfabeto.getLetra().contentEquals(letra)) {            
                    System.out.println("Palavra:" + percorrerPalavras.getPalavra());
                    System.out.println("Número de Repeticoes:" + percorrerPalavras.getNumeroDeRepeticoes() + "\n");
                    encontrou = 1;
                    }
                    if(percorrerPalavras.getProx()==null) {
                    	break;
                    }
                    percorrerPalavras = percorrerPalavras.getProx();
                }

                }
                if(percorrerAlfabeto.getProx()==null) {
                	break;
                }
                percorrerAlfabeto = percorrerAlfabeto.getProx();
                percorrerPalavras = percorrerAlfabeto.getPrimeiraPalavra();

            }
            if(encontrou == 0) {
                System.out.println("Nenhuma palavra vinculada a letra " + letra );
            }
        }
        
        private void insercaoOrdenada(String palavra, ListaAlfabeto percorreAlfabeto) {
        	ListaPalavra compararPalavra = percorreAlfabeto.getPrimeiraPalavra();
        	
        	if(compararPalavra == null) {
				ListaPalavra temp = new ListaPalavra(palavra, null, null);
				percorreAlfabeto.setPrimeiraPalavra(temp);
				percorreAlfabeto.setFinalListaPalavra(temp);
        	} 
        	
        	
        	else {
        	
        		//Verificar se palavra é repetida
        		
        	while(compararPalavra.getProx() != null ){
        		if(palavra.equals(compararPalavra.getPalavra())) {
        		compararPalavra.aumentarNumeroDeRepeticoes();
        		return;
        	} 
        		else if(compararPalavra.getProx() == null) {
          		if(palavra.equals(compararPalavra.getPalavra())) {
            		compararPalavra.aumentarNumeroDeRepeticoes();
          		}
        		return;
        	}
        		
        		compararPalavra = compararPalavra.getProx();
        	}
	    		if(palavra.equals(compararPalavra.getPalavra())) {
	    		compararPalavra.aumentarNumeroDeRepeticoes();
	    		return;
	    		} 

        	
        	compararPalavra = percorreAlfabeto.getPrimeiraPalavra();
        		//Procurar palavra que seja menor 
        	while(compararPalavra != null && palavra.compareTo(compararPalavra.getPalavra()) > 0) {
            	if(compararPalavra.getProx() == null) {
            		break;       		
            	} else {
        		compararPalavra = compararPalavra.getProx();
            	}
        	}

        	if(palavra.compareTo(compararPalavra.getPalavra()) > 0) {
            	ListaPalavra temp2 = new ListaPalavra(palavra, compararPalavra, compararPalavra.getProx());
            	
            	compararPalavra.setProx(temp2);
            	
            	if(temp2.getProx() == null) {
                    percorreAlfabeto.setFinalListaPalavra(temp2); 
            	}
            	
        	} else {

        	ListaPalavra temp3 = new ListaPalavra(palavra, compararPalavra.getAnt(), compararPalavra);
        	if(compararPalavra.getAnt() == null) {
        		percorreAlfabeto.setPrimeiraPalavra(temp3);
        	}
        	
        	if(temp3.getProx() == null) {
                percorreAlfabeto.setFinalListaPalavra(temp3); 
        	}
    		return;
        	}

        	}
        }
        
        private void criarAlfabeto()
        {       
    	this.inserirNoFinal("A");
    	this.inserirNoFinal("B");
    	this.inserirNoFinal("C");
    	this.inserirNoFinal("D");
    	this.inserirNoFinal("E");
    	this.inserirNoFinal("F");
    	this.inserirNoFinal("G");
    	this.inserirNoFinal("H");
    	this.inserirNoFinal("I");
    	this.inserirNoFinal("J");
    	this.inserirNoFinal("K");
    	this.inserirNoFinal("L");
    	this.inserirNoFinal("M");
    	this.inserirNoFinal("N");
    	this.inserirNoFinal("O");
    	this.inserirNoFinal("P");
    	this.inserirNoFinal("Q");
    	this.inserirNoFinal("R");
    	this.inserirNoFinal("S");
    	this.inserirNoFinal("T");
    	this.inserirNoFinal("U");
    	this.inserirNoFinal("V");
    	this.inserirNoFinal("W");
    	this.inserirNoFinal("X");
    	this.inserirNoFinal("Y");
    	this.inserirNoFinal("Z");
    	header.setUltimaLetra(letraAux);
        }    
        
        private void inserirNoFinal(String letra) {
        	if(header.getPrimeiraLetra() == null) {
        		ListaAlfabeto temp = new ListaAlfabeto(letra, null, null);
        		header.setPrimeiraLetra(temp);
        		letraAux = temp;
        	} else {
        		ListaAlfabeto temp = new ListaAlfabeto(letra, letraAux, null);
        		letraAux.setProx(temp);
        		letraAux = temp;
        		temp.setProx(null);
        	}
        	
        }

        private void exibeReferenciaCruzada() {
        	System.out.println("Referência Cruzada:" + "\n");
            
            ListaAlfabeto percorrerAlfabeto = header.getPrimeiraLetra();
            ListaAlfabeto ultimaLetra = header.getUltimaLetra();

            while(percorrerAlfabeto.getProx() != null || percorrerAlfabeto.getLetra().contentEquals(ultimaLetra.getLetra())) {
                System.out.println("Letra:" + percorrerAlfabeto.getLetra());
                ListaPalavra percorrerPalavras = percorrerAlfabeto.getPrimeiraPalavra();
                ListaPalavra ultimaPalavra = percorrerAlfabeto.getFinalListaPalavra();
                

                if(percorrerPalavras == null) {
                	System.out.println("Nenhuma palavra com a letra:" + percorrerAlfabeto.getLetra() + "\n");
                }
                else {

                while(percorrerPalavras.getProx() != null || percorrerPalavras.getPalavra().contentEquals(ultimaPalavra.getPalavra())) {
                    System.out.println("Palavra:" + percorrerPalavras.getPalavra());
                    System.out.println("Número de Repeticoes:" + percorrerPalavras.getNumeroDeRepeticoes() + "\n");
                    if(percorrerPalavras.getProx()==null) {
                    	break;
                    }
                    percorrerPalavras = percorrerPalavras.getProx();
                }

                }
                if(percorrerAlfabeto.getProx()==null) {
                	break;
                }
                percorrerAlfabeto = percorrerAlfabeto.getProx();
                percorrerPalavras = percorrerAlfabeto.getPrimeiraPalavra();

            }
        }
        
        private void contaPalavrasDiferentesTotal() {
        	int counter = 0;
            
            ListaAlfabeto percorrerAlfabeto = header.getPrimeiraLetra();
            ListaAlfabeto ultimaLetra = header.getUltimaLetra();

            while(percorrerAlfabeto.getProx() != null || percorrerAlfabeto.getLetra().contentEquals(ultimaLetra.getLetra())) {
                ListaPalavra percorrerPalavras = percorrerAlfabeto.getPrimeiraPalavra();
                ListaPalavra ultimaPalavra = percorrerAlfabeto.getFinalListaPalavra();
                

                if(percorrerPalavras != null) {

                while(percorrerPalavras.getProx() != null || percorrerPalavras.getPalavra().contentEquals(ultimaPalavra.getPalavra())) {
                		counter++;
                    if(percorrerPalavras.getProx()==null) {
                    	break;
                    }
                    percorrerPalavras = percorrerPalavras.getProx();
                }

                }
                if(percorrerAlfabeto.getProx()==null) {
                	break;
                }
                percorrerAlfabeto = percorrerAlfabeto.getProx();
                percorrerPalavras = percorrerAlfabeto.getPrimeiraPalavra();

            }
            System.out.println("Numero de Palavras: " + counter + "\n");

        }
        
        private void contaPalavrasTotal() {
        	int counter = 0;
            
            ListaAlfabeto percorrerAlfabeto = header.getPrimeiraLetra();
            ListaAlfabeto ultimaLetra = header.getUltimaLetra();

            while(percorrerAlfabeto.getProx() != null || percorrerAlfabeto.getLetra().contentEquals(ultimaLetra.getLetra())) {
                ListaPalavra percorrerPalavras = percorrerAlfabeto.getPrimeiraPalavra();
                ListaPalavra ultimaPalavra = percorrerAlfabeto.getFinalListaPalavra();
                

                if(percorrerPalavras != null) {

                while(percorrerPalavras.getProx() != null || percorrerPalavras.getPalavra().contentEquals(ultimaPalavra.getPalavra())) {
                		counter = counter + percorrerPalavras.getNumeroDeRepeticoes();
                    if(percorrerPalavras.getProx()==null) {
                    	break;
                    }
                    percorrerPalavras = percorrerPalavras.getProx();
                }

                }
                if(percorrerAlfabeto.getProx()==null) {
                	break;
                }
                percorrerAlfabeto = percorrerAlfabeto.getProx();
                percorrerPalavras = percorrerAlfabeto.getPrimeiraPalavra();

            }
            System.out.println("Numero de Palavras: " + counter + "\n");

        }
        
        private void ContaPalavrasPorLetra() {
        	System.out.println("Insira a letra que deseja buscar na referencia cruzada:");
            entrada.nextLine();
            int counter = 0;
            String letra = entrada.nextLine();
            letra = letra.toUpperCase();
            
            ListaAlfabeto percorrerAlfabeto = header.getPrimeiraLetra();
            ListaAlfabeto ultimaLetra = header.getUltimaLetra();
            

            while(percorrerAlfabeto.getProx() != null || percorrerAlfabeto.getLetra().contentEquals(ultimaLetra.getLetra())) {
                ListaPalavra percorrerPalavras = percorrerAlfabeto.getPrimeiraPalavra();
                ListaPalavra ultimaPalavra = percorrerAlfabeto.getFinalListaPalavra();


                if(percorrerPalavras != null) {

                while(percorrerPalavras.getProx() != null || percorrerPalavras.getPalavra().contentEquals(ultimaPalavra.getPalavra())) {
                    if(percorrerAlfabeto.getLetra().contentEquals(letra)) {            
                    	counter++;
                    }
                    if(percorrerPalavras.getProx()==null) {
                    	break;
                    }
                    percorrerPalavras = percorrerPalavras.getProx();
                }

                }
                if(percorrerAlfabeto.getProx()==null) {
                	break;
                }
                percorrerAlfabeto = percorrerAlfabeto.getProx();
                percorrerPalavras = percorrerAlfabeto.getPrimeiraPalavra();

            }
        	System.out.println("Numero de palavras vinculadas a letra " + letra + ": " + counter);

        }

}
