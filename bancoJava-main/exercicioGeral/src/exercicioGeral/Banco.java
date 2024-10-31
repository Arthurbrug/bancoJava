package exercicioGeral;

import java.util.Scanner;

public class Banco {

	static int cpf;
	static double saldo;
	static String nome;
	static int senha;
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
		System.out.println("Crie uma senha: ");
		senha = in.nextInt();
		System.out.println("COnfirme a senha: ");
		int confirirSenha = in.nextInt();
		if (confirirSenha == senha) {
			saldo = 0;
			contaAtiva = true;
			System.out.println("Conta criada com sucesso");
		} else {
			contaAtiva = false;
			System.out.println("Senha diferente");
		}

		return contaAtiva;
	}

	public static boolean conferirSenha() {
		if (contaAtiva == true) {
			System.out.println("Digite a senha para entrar: ");
			int conferir = in.nextInt();
			if (conferir == senha) {
				return true;
			} else {
				System.out.println("Senha invalida");
				return false;
			}
		} else {
			System.out.println("Nem uma conta ativa no momento");
			return false;
		}
	}

	public static void sacar() {
		boolean x = conferirSenha();
		if (x) {
			System.out.println("Ola " + nome + " Digite o quanto você gostaria de sacar: ");
			double sacarDinheiro = in.nextDouble();
			if (saldo <= sacarDinheiro) {
				System.out.println("Saldo invalido para sacar ");
			} else {
				saldo -= sacarDinheiro;
				System.out.println("Saque feito com sucesso");
			}
		}
	}

	public static void depositar() {
		boolean x = conferirSenha();
		if (x) {
			System.out.println("Ola " + nome + " Digite o quanto você gostaria de depositar: ");
			double depositar = in.nextDouble();
			saldo += depositar;
			System.out.println("Depositado com sucesso");
		}
	}

	public static void consultarSaldo() {
		boolean x = conferirSenha();
		if (x) {
			System.out.println("Ola " + nome + " Seu saldo e de " + saldo);
		} 
	}

	public static void fecharConta() {
		boolean x = conferirSenha();
		if (contaAtiva == true && x) {
			contaAtiva = false;
			cpf = 0;
			nome = "";
			System.out.println("Conta excluida com sucesso! ");
		} else {
			System.out.println("Nem uma conta ativa no momento");
		}
	}
}
