import java.util.Scanner;

public class Main {

    public static boolean cpf(String cpfNum) {
        // Verificação do CPF com 11 dígitos
        if (cpfNum.length() != 11) {
            System.out.println("O CPF deve ter 11 dígitos somente.");
            return false;
        }

        // Utiliza somente os primeiros 9 dígitos do CPF para o cálculo
        int a1 = Integer.parseInt(cpfNum.substring(8, 9));
        int a2 = Integer.parseInt(cpfNum.substring(7, 8));
        int a3 = Integer.parseInt(cpfNum.substring(6, 7));
        int a4 = Integer.parseInt(cpfNum.substring(5, 6));
        int a5 = Integer.parseInt(cpfNum.substring(4, 5));
        int a6 = Integer.parseInt(cpfNum.substring(3, 4));
        int a7 = Integer.parseInt(cpfNum.substring(2, 3));
        int a8 = Integer.parseInt(cpfNum.substring(1, 2));
        int a9 = Integer.parseInt(cpfNum.substring(0, 1));

        // Cálculo do primeiro dígito verificador
        int cpfPriDig = (a1 * 9 + a2 * 8 + a3 * 7 + a4 * 6 + a5 * 5 + a6 * 4 + a7 * 3 + a8 * 2 + a9) % 11;
        if (cpfPriDig == 10) {
            cpfPriDig = 0;
        }

        // Cálculo do segundo dígito verificador
        int cpfSegDig = (cpfPriDig * 9 + a1 * 8 + a2 * 7 + a3 * 6 + a4 * 5 + a5 * 4 + a6 * 3 + a7 * 2 + a8) % 11;
        if (cpfSegDig == 10) {
            cpfSegDig = 0;
        }

        // Extrai os dígitos verificadores digitados
        int userPriDig = Integer.parseInt(cpfNum.substring(9, 10));  // 10º dígito
        int userSegDig = Integer.parseInt(cpfNum.substring(10, 11)); // 11º dígito

        // Verifica se os dígitos verificadores calculados são iguais com os digitados pelo usuário
        if (cpfPriDig == userPriDig && cpfSegDig == userSegDig) {
            return true; // CPF válido
        } else {
            return false; // CPF inválido
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite os 11 dígitos do seu CPF: ");
        String cpfNum = scanner.nextLine();

        if (cpf(cpfNum)) {
            System.out.println("O CPF é válido.");
        } else {
            System.out.println("O CPF é inválido.");
        }

        scanner.close();
    }
}

//Outros código abaixo:

/*public class Main{
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.printf("Insira um número de CPF com 9 digitos para verificar se é válido: ");
		String cpf = teclado.next();
		
		int validador=0;
		
		if (validador == 1) {
			
		}
		
	}
	
	public static void CalcularCPF(int cpf){
		if (cpf.lenght != 11) {
			
		}
		
	}
}


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicita o CPF ao usuário
        System.out.print("Digite o CPF (apenas números, 11 dígitos): ");
        
        String cpf = scanner.next();

        // Verifica se o CPF tem exatamente 11 dígitos
        if (cpf.length() != 11) {
            System.out.println("CPF inválido. Deve conter 11 dígitos.");
            return;
        }

        // Converte o CPF em um array de inteiros
        int[] cpfNumeros = new int[11];
        for (int i = 0; i < 11; i++) {
            cpfNumeros[i] = Integer.parseInt(String.valueOf(cpf.charAt(i)));
        }

        // Cálculo do primeiro dígito verificador
        int soma1 = 0;
        for (int i = 0; i < 9; i++) {
            soma1 += cpfNumeros[i] * (10 - i);
        }
        int primeiroDigito = 11 - (soma1 % 11);
        if (primeiroDigito >= 10) {
            primeiroDigito = 0;
        }

        // Cálculo do segundo dígito verificador
        int soma2 = 0;
        for (int i = 0; i < 10; i++) {
            soma2 += cpfNumeros[i] * (11 - i);
        }
        int segundoDigito = 11 - (soma2 % 11);
        if (segundoDigito >= 10) {
            segundoDigito = 0;
        }

        // Verifica se os dígitos verificadores estão corretos
        if (primeiroDigito == cpfNumeros[9] && segundoDigito == cpfNumeros[10]) {
            System.out.println("CPF válido.");
        } else {
            System.out.println("CPF inválido.");
        }

        scanner.close();
    }
}
*/


//Código entregue, porém comentado:

/*public class Main {

    public static boolean cpf(String cpfNum) {
        // Verifica se o CPF tem 11 dígitos
        if (cpfNum.length() != 11) {
            System.out.println("O CPF deve ter 11 dígitos.");
            return false;
        }

        // Extrai os primeiros 9 dígitos do CPF
        int a1 = Integer.parseInt(cpfNum.substring(8, 9));
        int a2 = Integer.parseInt(cpfNum.substring(7, 8));
        int a3 = Integer.parseInt(cpfNum.substring(6, 7));
        int a4 = Integer.parseInt(cpfNum.substring(5, 6));
        int a5 = Integer.parseInt(cpfNum.substring(4, 5));
        int a6 = Integer.parseInt(cpfNum.substring(3, 4));
        int a7 = Integer.parseInt(cpfNum.substring(2, 3));
        int a8 = Integer.parseInt(cpfNum.substring(1, 2));
        int a9 = Integer.parseInt(cpfNum.substring(0, 1));

        // Calcula o primeiro dígito verificador
        int cpfPriDig = (a1 * 9 + a2 * 8 + a3 * 7 + a4 * 6 + a5 * 5 + a6 * 4 + a7 * 3 + a8 * 2 + a9) % 11;
        if (cpfPriDig == 10) {
            cpfPriDig = 0;
        }

        // Calcula o segundo dígito verificador
        int cpfSegDig = (cpfPriDig * 9 + a1 * 8 + a2 * 7 + a3 * 6 + a4 * 5 + a5 * 4 + a6 * 3 + a7 * 2 + a8) % 11;
        if (cpfSegDig == 10) {
            cpfSegDig = 0;
        }

        // Extrai os dígitos verificadores inseridos pelo usuário
        int userPriDig = Integer.parseInt(cpfNum.substring(9, 10));  // 10º dígito
        int userSegDig = Integer.parseInt(cpfNum.substring(10, 11)); // 11º dígito

        // Verifica se os dígitos verificadores calculados coincidem com os inseridos
        if (cpfPriDig == userPriDig && cpfSegDig == userSegDig) {
            return true; // CPF válido
        } else {
            return false; // CPF inválido
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite os 11 dígitos do CPF: ");
        String cpfNum = scanner.nextLine();

        // Verifica se o CPF é válido
        if (cpf(cpfNum)) {
            System.out.println("O CPF é válido.");
        } else {
            System.out.println("O CPF é inválido.");
        }

        scanner.close();
    }
}*/