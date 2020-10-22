# cross-reference
Trabalho de listas encadeadas duplas realizado para a disciplina de Algoritmos e Estrutura de Dados, com o objetivo de implementar uma função que transforma um texto recebido em uma referência cruzada.

Um programa de referência cruzada (cross-reference) lê todas as palavras de um texto e estabelece relações entre elas. Uma referência que pode ser estabelecida e identificar quantas vezes cada palavra aparece em um texto.

O objetivo é implementar uma Referência Cruzada de um texto através de uma lista de listas de palavras. Com o texto informado, o programa deve separar as palavras e colocá-las em listas, cada lista associada a uma letra do alfabeto. Cada elemento (nodo) de uma lista associada a uma letra contém uma palavra do texto lido junto com a quantidade de vezes que a palavra aparece no texto, sendo que em cada lista as palavras de uma mesma letra são mantidas em ordem alfabética das palavras.

As operações que foram implementadas estão descritas no TAD a seguir, e fazem parte de um menu que irá executá-las. A linguagem de programação utilizada foi Java.

TAD crossreference {

Dados: listas de palavras (sepadas por um espaço);

Operações:

criaReferenciaCruzada(E: texto): insere as palavras de um texto da referência cruzada
inserePalavra(E: palavra): insere uma palavra na referência cruzada. Se ela não estiver na referência cruzada, inserir na lista adequada. Se já existir em uma lista, incrementar seu contador
removePalavra(E: palavra): remove uma palavra de uma referência cruzada
existePalavra(E: palavra): verifica se uma palavra faz parte da referência cruzada. Se fizer, exibe a quantidade de ocorrências
exibeReferenciaCruzada ( ): exibe todas as palavras armazenadas e seus contadores
exibePalavrasLetra (E: letra): exibe as palavras que iniciam por uma determinada letra, com seus contadores
contaPalavrasDiferentesTotal(S: total): exibe o total de palavras (total de nodos das listas)
contaPalavrasTotal(S: total): exibe o total de palavras (soma total dos contadores das palavras das listas)
contaPalavrasPorLetra(E: letra; S: total): exibe o total de palavras (total de nodos da lista de palavras de uma letra)
}
