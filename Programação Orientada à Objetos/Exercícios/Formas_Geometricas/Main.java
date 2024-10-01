package Formas_Geometricas;//package Formas_Geométricas; //Usar essa linha para rodar no Eclipse

import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Cálculos Geométricos!\n\n");
		while (true) {
			
			System.out.println("Escolha uma figura geométrica:");
			System.out.println("1 - Quadrado ");
			System.out.println("2 - Retângulo");
			System.out.println("3 - Triângulo");
			System.out.println("4 - Círculo");
			System.out.println("5 - Sair");
			
			int opcao = entrada.nextInt();

			switch (opcao) {
			case 1:
				System.out.println("Digite a medida do lado do Quadrado: ");
				double lado = entrada.nextDouble();
				Quadrado quadrado = new Quadrado(lado);
				System.out.println("Área do Quadrado: " + quadrado.calcularArea());
                System.out.println("Perímetro do Quadrado: " + quadrado.calcularPerimetro());
				break;
			
			case 2:
				System.out.println("Digite a medida da base do Retângulo: ");
				double base = entrada.nextDouble();
				System.out.println("Digite a medida da altura do Retângulo: ");
				double altura = entrada.nextDouble();
				Retangulo retangulo = new Retangulo(base, altura);
				System.out.println("Área do Retângulo: " + retangulo.calcularArea());
                System.out.println("Perímetro do Retângulo: " + retangulo.calcularPerimetro());
				break;
				
			case 3:
				System.out.println("Digite a medida do lado 'A' do Triângulo: ");
                double ladoA = entrada.nextDouble();
                System.out.println("Digite a medida do lado 'B' do Triângulo: ");
                double ladoB = entrada.nextDouble();
                System.out.println("Digite a medida do lado 'C' do Triângulo: ");
                double ladoC = entrada.nextDouble();
                Triangulo triangulo = new Triangulo(ladoA, ladoB, ladoC);
                System.out.println(String.format("Área do Triângulo: %.2f", triangulo.calcularArea()));
                System.out.println("Perímetro do Triângulo: " + triangulo.calcularPerimetro());
                break;
                 
			case 4:
				System.out.println("Digite a medida do raio do Círculo: ");
                double raio = entrada.nextDouble();
                Circulo circulo = new Circulo(raio);
                System.out.println(String.format("Área do Círculo: %.2f", circulo.calcularArea()));
                System.out.println(String.format("Perímetro do Círculo: %.2f", circulo.calcularPerimetro()));
                break;
				
			case 5:
				System.out.println("Saindo...");
				entrada.close();
				System.exit(0);
				break;
				
			default:
				System.out.println("Opção Inválida. Tente novamente.");
			}
			
			System.out.println("\n\nPressione Enter para voltar ao Menu!");
		    esperarTecla(); 
		}
	}
	
	public static void esperarTecla() {
		Scanner tecla = new Scanner(System.in);
		tecla.nextLine();
	}
}

class Quadrado {
    private double lado;

    public Quadrado(double lado) {
        this.lado = lado;
    }

    public double calcularArea() {
        return lado * lado;
    }

    public double calcularPerimetro() {
        return 4 * lado;
    }
}

class Retangulo{
	private double base, altura;
	
	public Retangulo(double lado, double altura) {
		this.base = lado;
		this.altura = altura;
	}
	
	public double calcularArea() {
		return base * altura;
	}
	
	public double calcularPerimetro() {
		return 2 * (base + altura);
	}
}

class Triangulo{
	private double ladoA, ladoB, ladoC;
	
	public Triangulo(double ladoA, double ladoB, double ladoC) {
		this.ladoA = ladoA;
		this.ladoB = ladoB;
		this.ladoC = ladoC;
	}
	
	public double calcularArea() {
		double semiPerimetro = (ladoA + ladoB + ladoC)/2;
		double resultado = Math.sqrt(semiPerimetro * (semiPerimetro - ladoA) * (semiPerimetro - ladoB) * (semiPerimetro - ladoC));
		return resultado;
	}
	
	public double calcularPerimetro() {
		return ladoA + ladoB + ladoC;
	}
}

class Circulo{
	private double raio;
	
	public Circulo(double raio) {
		this.raio = raio;
	}
	
	public double calcularArea() {
		return Math.PI * Math.pow(raio, 2);
	}
	
	public double calcularPerimetro() {
		return 2 * Math.PI * raio;
	}
}