package ImpostoDeRenda;

import java.util.Scanner;


public class Calculo {
		
    
    public static void MostrarDados(){
    	Scanner scanner = new Scanner(System.in);
	    	
		System.out.printf("Informe seu nome: ");
		String nome = scanner.nextLine();
		
		System.out.printf("Informe seu Salário: ");
		float salario = scanner.nextFloat();
		
		float imposto = calcularIR(salario);
		String faixa = calcularFaixaIR(salario);
	
		System.out.printf("\n\nResultado do Cálculo:\n");
		System.out.printf("Nome: %s\n",nome);
		System.out.printf("Salário: R$%.2f\n",salario);
		System.out.printf("Faixa do Imposto: %s\n",faixa);
		System.out.printf("Imposto à pagar: R$%.2f",imposto);
		System.out.printf("\n\nSalário Líquido: R$%.2f",(salario-imposto));
		
		System.out.println("\n\nPressione Enter para voltar ao Menu!");
	    esperarTecla(); 
    }
	
    public static float calcularIR(float salario) {
    	float imposto =0;
    	
    	if(salario <= Tabela.faixa1Ate) {
    		imposto = 0;
    	}
    	else if(salario <= Tabela.faixa2Ate) {
    		imposto = salario * Tabela.faixa2Aliq - Tabela.faixa2Ded;
    	}
    	else if(salario <= Tabela.faixa3Ate) {
    		imposto = salario * Tabela.faixa3Aliq - Tabela.faixa3Ded;
    	}
    	else if(salario <= Tabela.faixa4Ate) {
    		imposto = salario * Tabela.faixa4Aliq - Tabela.faixa4Ded;
    	}
    	else{
    		imposto = salario * Tabela.faixa5Aliq - Tabela.faixa5Ded;
        }
    	return imposto;
    }
    
    public static String calcularFaixaIR(float salario) {
    	
    	if(salario <= Tabela.faixa1Ate) {
    		return "Faixa 1 | Isento";
    	}
    	else if(salario <= Tabela.faixa2Ate) {
    		return "Faixa 2 | 7.5%"; 
    	}
    	else if(salario <= Tabela.faixa3Ate) {
    		return "Faixa 3 | 15%";
    	}
    	else if(salario <= Tabela.faixa4Ate) {
    		return "Faixa 4 | 22.5%";
    	}
    	else {
    		return "Faixa 5 | 27.5%";
    	}
    }
    
    public static void esperarTecla() {
		Scanner tecla = new Scanner(System.in);
		tecla.nextLine();
	}

}
    