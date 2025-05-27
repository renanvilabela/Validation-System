package candidatura;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;

public class ProcessoSeletivo {
	public static void main(String[] args) {
		String [] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO", "MONICA", "FABRICIO", "MIRELLA", "DANIELA", "JORGE"};
		for(String candidato: candidatos) {
			entrandoEmContato(candidato);
		}
		
		//imprimirSelecionados();
		//selecaoCandidatos();
		//analisarCandidato(1900.0);
		//analisarCandidato(2200.0);
		//analisarCandidato(200.0);
	}
	
	static void entrandoEmContato(String candidato) {
		int tentativasRealizadas = 1;
		boolean continuarTentando = true;
		boolean atendeu=false;
		do {
			atendeu= atender();
			continuarTentando = !atendeu;
			if(continuarTentando)
				tentativasRealizadas++;
			else
				System.out.println("Contato Realizado com Sucesso");
		}while(continuarTentando && tentativasRealizadas<3);
		
		if(atendeu)
			System.out.println("Conseguimos contato com " + " Na " + tentativasRealizadas + " Tentativa");
		else
			System.out.println("Não Conseguimos contato com " + candidato + ", número máximo de tentativas " + tentativasRealizadas + " Realizadas");
	}
	//método auxiliar
	static boolean atender() {
		return new Random().nextInt(3)==1;
	}
	
	static void imprimirSelecionados() {
		String [] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO", "MONICA", "FABRICIO", "MIRELLA", "DANIELA", "JORGE"};
		System.out.println("Imprimindo a lista de candidatos informando o índice do elemento");
		for(int indice=0; indice < candidatos.length;indice++) {
			System.out.println("O candidato de nº " + (indice+1) + " é " + candidatos[indice]);
		}
		
		System.out.println("Forma abreviada da interação for each");
		
		for(String candidato: candidatos) {
			System.out.println("o candidato selecionado foi: " + candidato);
		}
	}
	
	static void selecaoCandidatos() {
		String [] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO", "MONICA", "FABRICIO", "MIRELLA", "DANIELA", "JORGE"};
	
		int candidatosSelecionados = 0;
		int candidatosAtual=0;
		double salarioBase=2000.0;
		while(candidatosSelecionados < 5 && candidatosAtual < candidatos.length) {
			String candidato = candidatos[candidatosAtual];
			double salarioPretendido = valorPretendido();
			
			System.out.println("O candidato" + candidato + " solicitou este valor de salário " + salarioPretendido);
			if(salarioBase >= salarioPretendido) {
				System.out.println("O candidato " + candidato + " foi selecionado para a vaga");
				candidatosSelecionados++;
			}
			candidatosAtual++;
		}
	}
	static double valorPretendido() {
		return ThreadLocalRandom.current().nextDouble(1800, 2200);
	}
	static void analisarCandidato(double salarioPretendido) {
		double salarioBase = 2000.0;
		if(salarioBase > salarioPretendido) {
			System.out.println("Ligar para o candidato");
		}else if(salarioBase==salarioPretendido)
			System.out.println("Ligar para o candidato com contra proposta.");
		else {
			System.out.println("Aguardando demais Candidatos");
		}
	}
}
