package testetarget;

/*
 * Dado a sequência de Fibonacci, onde se inicia por 0 e 1 e o próximo valor sempre será a soma dos 2 valores anteriores 
 * (exemplo: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34...), escreva um programa na linguagem que desejar onde, informado um número, ele calcule a sequência de Fibonacci
 * e retorne uma mensagem avisando se o número informado pertence ou não a sequência. 
 *  */
public class Questao1 {

	public static void resposta(Integer numero) {
		System.out.println("\nQuestão 1:");
		
		Integer valorFibonacci = 0;
		for(Integer indiceFibonacci = 0; valorFibonacci < numero; indiceFibonacci++) {
			valorFibonacci = fibonacci(indiceFibonacci);
		}
		
		System.out.println("O valor " + numero + " está na sequência de fibonacci? " + valorFibonacci.equals(numero));
	}
	
	public static Integer fibonacci(Integer numero) {
		if(numero.equals(0) || numero.equals(1))
			return numero;
		
		return fibonacci(numero - 1) + fibonacci(numero - 2);
	}
}
