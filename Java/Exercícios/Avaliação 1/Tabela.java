package ImpostoDeRenda;

import java.util.Scanner;

public class Tabela{
	
	static float faixa1De=0;
	static float faixa1Ate=2259;
	static float faixa1Aliq=0;
	static float faixa1Ded=0;
	
	static float faixa2De = 2259.01f;
    static float faixa2Ate = 2826.66f;
    static float faixa2Aliq = 0.075f; 
    static float faixa2Ded = 169.44f;
    
    static float faixa3De = 2826.67f;
    static float faixa3Ate = 3751.06f;
    static float faixa3Aliq = 0.15f; 
    static float faixa3Ded = 381.44f;
    
    static float faixa4De = 3751.07f;
    static float faixa4Ate = 4664.68f;
    static float faixa4Aliq = 0.225f; 
    static float faixa4Ded = 662.77f;
    
    static float faixa5De = 4664.69f;
    static float faixa5Ate = 999999999;
    static float faixa5Aliq = 0.275f; 
    static float faixa5Ded = 896f;
	
	
	static String[] colunas = {"Faixas","De","Até","Aliq","Dedução"};
	
public static void MostrarTabela() {
	
	System.out.println("\n\nTabela de Imposto de Renda 2024\n");

    
    for (String coluna : colunas) {
        System.out.print(coluna + "\t");
    }
    System.out.println();

    System.out.printf("Faixa 1\t%.2f\t%.2f\t%.1f%%\t%.2f\n", faixa1De, faixa1Ate, faixa1Aliq * 100, faixa1Ded);
    System.out.printf("Faixa 2\t%.2f\t%.2f\t%.1f%%\t%.2f\n", faixa2De, faixa2Ate, faixa2Aliq * 100, faixa2Ded);
    System.out.printf("Faixa 3\t%.2f\t%.2f\t%.1f%%\t%.2f\n", faixa3De, faixa3Ate, faixa3Aliq * 100, faixa3Ded);
    System.out.printf("Faixa 4\t%.2f\t%.2f\t%.1f%%\t%.2f\n", faixa4De, faixa4Ate, faixa4Aliq * 100, faixa4Ded);
    System.out.printf("Faixa 5\t%.2f\t" + "   \u221E\t" + "%.2f\t%.2f\n", faixa5De, faixa5Aliq * 100, faixa5Ded);
    
    System.out.println("\n\nPressione Enter para voltar ao Menu!");
    esperarTecla();  
}

	public static void esperarTecla() {
		Scanner tecla = new Scanner(System.in);
		tecla.nextLine();
	}
	
}	
