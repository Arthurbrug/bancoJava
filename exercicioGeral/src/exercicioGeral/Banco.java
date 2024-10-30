package exercicioGeral;

import java.util.Scanner;

public class Banco {
	
	static int cpf;
	static double saldo;
	static String nome;
	static boolean contaAtiva;
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		boolean terminar = true;

		while (terminar) {
			System.out.println(
					"Digite a opcao: 1. Abrir conta, 2. Sacar, 3. Depositar, 4. Consultar Saldo, 5. Fechar conta  6. Finalizar.");
			int opcao = in.nextInt();
			switch (opcao) {
			case 1:
				abrirConta();
				break;

			case 2:
				sacar();
				break;

			case 3:
				depositar();
				break;

			case 4:
				consultarSaldo();
				break;

			case 5:
				fecharConta();
				break;

			case 6:
				System.out.println("Finalizando a sessao");
				terminar = false;
				break;

			default:
				System.out.println("Opçao invalida");
				break;
			}
		}

	}

	public static boolean abrirConta() {
		System.out.println("Digite o nome: ");
		nome = in.next();
		System.out.println("Digite o cpf: ");
		cpf = in.nextInt();
		
	    contaAtiva = true;
		return contaAtiva;
	}

	public static void sacar() {
		if (contaAtiva == true) {
		System.out.println("Ola " + nome + " Digite o quanto você gostaria de sacar: ");
		double sacarDinheiro = in.nextDouble();
		if (saldo <= sacarDinheiro) {
			System.out.println("Saldo invalido para sacar ");
		} else {
			saldo -= sacarDinheiro;
			System.out.println("Saque feito com sucesso");
		}
		} else {
			System.out.println("Nem uma conta ativa no momento");
		}
	}

	public static void depositar() {
		if (contaAtiva == true) {
		System.out.println("Ola " + nome + " Digite o quanto você gostaria de depositar: ");
		double depositar = in.nextDouble();
		saldo += depositar;
		System.out.println("Depositado com sucesso");
		} else {
			System.out.println("Nem uma conta ativa no momento");
		}
	}

	public static void consultarSaldo() {
		if (contaAtiva == true) {
          System.out.println("Ola " + nome + " Seu saldo e de " + saldo);
		} else {
			System.out.println("Nem uma conta ativa no momento");
		}
	}

	public static void fecharConta() {
         if (contaAtiva == true) {
        	 System.out.println("Tem certeza que gostaria de excluir essa conta do cpf " + cpf +  " (1 - sim / 2 - nao)");
        	 int confirmacao = in.nextInt();
        	 if (confirmacao == 1) {
        		 contaAtiva = false;
        		 cpf = 0;
        		 nome = "";
        		 System.out.println("Conta excluida com sucesso! ");
        	 } else if (confirmacao == 2) {
        		 System.out.println("Conta segue ativa");
        	 } else {
        		 System.out.println("opcao invalida");
        	 }
         } else {
 			System.out.println("Nem uma conta ativa no momento");
 		}
	}
}
