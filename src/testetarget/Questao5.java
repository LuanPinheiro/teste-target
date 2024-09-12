package testetarget;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/*
 * Você está em uma sala com três interruptores, cada um conectado a uma lâmpada em salas diferentes.
 * Você não pode ver as lâmpadas da sala em que está, mas pode ligar e desligar os interruptores quantas vezes quiser.
 * Seu objetivo é descobrir qual interruptor controla qual lâmpada. Como você faria para descobrir, usando apenas duas idas até uma das salas das lâmpadas,
 * qual interruptor controla cada lâmpada?   
 * */
public class Questao5 {

	private static Boolean[] salas = new Boolean[3];
	private static Interruptor[] interruptores = new Interruptor[3];
	
	private static class Interruptor {
		private Integer sala;
		private Boolean ativado;
		
		public Interruptor(Integer sala) {
			this.sala = sala;
			this.ativado = false;
		}
		
		public Integer getSala() {
			return this.sala;
		}
		
		public Boolean getAtivado() {
			return this.ativado;
		}
		
		public void usarInterruptor() {
			this.ativado = !this.ativado;
		}
	}
	
	public static void resposta() {
		System.out.println("\nQuestão 5:");
		geraInterruptores();
		encontraLigacao();
	}
	
	private static void geraInterruptores() {
		ArrayList<Integer> salasExistentes = new ArrayList<Integer>();
		Random random = new Random();
		
		for(int posicao = 0; posicao < 3; posicao++) {
			Integer sala;
			do {
				sala = random.nextInt(3)+1;				
			} while(salasExistentes.contains(sala));
			
			interruptores[posicao] = new Interruptor(sala);
			salasExistentes.add(sala);
		}
		
		System.out.println("Disposição das salas e interruptores");
		for(Integer indice = 0; indice < 3; indice++) {
			System.out.println( "Sala " + interruptores[indice].getSala() + " - Interruptor nº" + (indice+1));
		}
	}
	
	private static void encontraLigacao() {
		// Para cada sala(chave) tem interruptores potenciais(valores)
        HashMap<Integer, ArrayList<Integer>> potenciais = new HashMap<Integer, ArrayList<Integer>>();
        for(Integer indice=0; indice < 3; indice++)
        	potenciais.put(indice, new ArrayList<Integer>());
        
        // Liga os 2 primeiros interruptores
        interruptores[0].usarInterruptor();
        interruptores[1].usarInterruptor();
        alteraSalas();
        
        // Adiciona os potenciais interruptores de cada sala
        for(Integer indice=0; indice < 3; indice++) {
        	if(salas[indice]) {
        		potenciais.get(indice).add(0);
        		potenciais.get(indice).add(1);
        	}else {
        		potenciais.get(indice).add(2);
        	}
        }
        
        // Desliga um dos interruptores
        interruptores[0].usarInterruptor();
        alteraSalas();
        
        // Remove os potenciais interruptores, sobrando apenas 1 para cada sala
        for(Integer indice=0; indice < 3; indice++) {
        	if(!salas[indice])
        		potenciais.get(indice).remove((Integer) 1);
    		else
    			potenciais.get(indice).remove((Integer) 0);
        }
        
        System.out.println("Resposta:");
        potenciais.forEach((chave, valor) -> {
        	System.out.println("Sala " + (chave+1) + " - Interruptor nº" + (valor.getFirst()+1) );
        });
    }
	
	private static void alteraSalas() {
		for(Interruptor interruptor : interruptores) {
        	salas[interruptor.getSala()-1] = interruptor.getAtivado();
		}
	}
}
