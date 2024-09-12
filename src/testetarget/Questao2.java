package testetarget;

/*
 * Escreva um programa que verifique, em uma string, a existência da letra ‘a’,
 * seja maiúscula ou minúscula, além de informar a quantidade de vezes em que ela ocorre. 
 */
public class Questao2 {

	public static void resposta(String texto) {
		System.out.println("\nQuestão 2:");
		char[] caracteres = texto.toUpperCase().toCharArray();
		Integer quantidade = 0;
		for(char caractere : caracteres) {
			if(caractere == 'A')
				quantidade++;
		}
		
		System.out.println("O caractere 'A' aparece " + quantidade + " vezes na string: " + texto);
	}
}
