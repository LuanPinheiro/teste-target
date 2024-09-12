package testetarget;

/*
 * Observe o trecho de código abaixo: int INDICE = 12, SOMA = 0, K = 1;
 * enquanto K < INDICE faça { K = K + 1; SOMA = SOMA + K; } imprimir(SOMA);
 *  */
public class Questao3 {
	
	public static void resposta(Integer indice) {
		System.out.println("\nQuestão 3:");
		Integer soma = 0;
		for(Integer k = 1; k < indice; k++)
			soma += k;
		
		System.out.println("Com o índice " + indice + " temos a soma: " + soma);
	}
}
