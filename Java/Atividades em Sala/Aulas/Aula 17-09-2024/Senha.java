package Aula1709;

import java.util.Scanner;

public class Senha {

	public static void main(String[] args) {
		String SENHASECRETA = "123456";
		try {
			Scanner s = new Scanner(System.in);
			System.out.print("Digite a senha: ");
			String senha = s.nextLine();
			if (!senha.equals(SENHASECRETA)) {
				throw new Exception("Senha invalida!!!");
			}
			System.out.println("Senha correta!!!\nBem vindo(a)!!!");
			System.out.print("Deseja mudar sua senha? (sim / nao)");
			String opcao = s.nextLine();

			if(opcao.equals("sim")) {
				System.out.print("Digite sua nova senha: ");
				String senhanova = s.nextLine();
				senha = senhanova;
				System.out.print("Senha Alterada! \n");
				System.out.print("Deseja visualizar sua nova senha?(sim / nao)");
				String opcao2 = s.nextLine();
				if(opcao2.equals("sim")) {
					System.out.print("Sua nova senha é: " + senha);
				}else {
					System.out.print("Até Logo! ");
				}
			}else {
				System.out.print("Até Logo! ");
			}

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}