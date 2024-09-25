# Linguagem de Programação - JAVA

* Interface grafica Javax Swing

## - Javax Swing

* Criar em interface gráfica Java Swing uma versão do programa feito durante a aula de hoje. 
* Como referencia, transcrevo aqui uma solução possivel do programa a ser adaptado.

    
    package exercicios;
    import java.util.*;
    public class compara {
    public static void main(String[] args) {
    double numero1=0;
    double numero2=0;
    boolean validado = false;
    boolean validado2 = false;

	    while(!validado) {
	      try {
	        Scanner s = new Scanner(System.in);
	        System.out.println("Digite um valor..: ");
	        numero1 = s.nextDouble();
	        System.out.println("Digite outro valor..: ");
	        numero2 = s.nextDouble();
	        validado = true;
	      } catch (InputMismatchException ex) {
	            System.out.println("O valor inserido nao e um numero inteiro!");
	      }
	    }

	    if (numero1 - numero2 > (numero1*0.2)) {
	    	System.out.println("A diferença entre valores é superior a 20%!");
	    }
	    else {
	        System.out.println("tudo bem com a diferença. ");
	    	validado2=true;
        }
    }
}

