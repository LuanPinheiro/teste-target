package testetarget;

/*
 * Descubra a lógica e complete o próximo elemento: 
	a) 1, 3, 5, 7, ___ 
	b) 2, 4, 8, 16, 32, 64, ____ 
	c) 0, 1, 4, 9, 16, 25, 36, ____ 
	d) 4, 16, 36, 64, ____ 
	e) 1, 1, 2, 3, 5, 8, ____ 
	f) 2,10, 12, 16, 17, 18, 19, ____
 * */
public class Questao4 {
	
	// 2 + 8 + 2 + 4 + 1 + 1 + 1

	public static void resposta() {
		System.out.println("\nQuestão 4:");
		System.out.println("A lógica A possui como " + 5 + " elemento: " + logicaA(5));
		System.out.println("A lógica B possui como " + 7 + " elemento: " + logicaB(7));
		System.out.println("A lógica C possui como " + 8 + " elemento: " + logicaC(8));
		System.out.println("A lógica D possui como " + 5 + " elemento: " + logicaD(5));
		System.out.println("A lógica E possui como " + 7 + " elemento: " + Questao1.fibonacci(7));
		System.out.println("Não encontrei padrão na F");
	}
	
	private static Integer logicaA(Integer indice) {
		Integer numero = 1;
		while(indice > 1) {
			numero +=2;
			indice--;
		}
		return numero;
	}
	
	private static Integer logicaB(Integer indice) {
		Integer numero = 2;
		for(;indice > 1; numero*=2, indice--);
		return numero;
	}
	
	private static Integer logicaC(Integer indice) {
		Integer numero = 0;
		Integer imparAtual = 0;
		for(;indice > 1; indice--) {
			imparAtual = proximoImpar(imparAtual+1);
			numero += imparAtual;
		}
		
		return numero;
	}
	
	private static Integer logicaD(Integer indice) {
		Integer numero = 4;
		Integer somador = 12;
		for(;indice > 1; indice--, somador+=8)
			numero += somador;
		
		return numero;
	}
	
	private static Integer proximoImpar(Integer numero) {
		if(numero % 2 == 0)
			return proximoImpar(numero+1);
		
		return numero;
	}
}
