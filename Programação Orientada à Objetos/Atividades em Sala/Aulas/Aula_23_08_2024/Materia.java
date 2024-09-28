//23 de Agosto de 2024
package Aula_23_08_2024;
public class Materia{
	
	//definindo as propriedades
			int codigo;
			String titulo;
			String periodo;
			String ementa;
	
	public static void main(String[] args) {
		
		//Criando um objeto ou instância
		Materia a1 = new Materia(); //criando objeto de Atleta
		a1.codigo = 6969;
		a1.titulo = "POO";
		a1.periodo="noturno";
		a1.ementa="Aprender sobre programação orientada a Objetos";
		
		Materia a2 = new Materia(); //criando objeto de Atleta
		a2.codigo = 2454;
		a2.titulo = "ES3";
		a2.periodo="noturno";
		a2.ementa="Aprender sobre Engenharia de Sofware (Nível 3)";
		
		Materia a3 = new Materia(); //criando objeto de Atleta
		a3.codigo = 1245;
		a3.titulo = "BD";
		a3.periodo="noturno";
		a3.ementa="Aprender sobre banco de Dados";
		
				
		System.out.println(a1.codigo); //acessando membro através da variavel de referencia
		System.out.println(a1.titulo);
		System.out.println(a1.periodo);
		System.out.println(a1.ementa);
		System.out.println("\n");
		
		System.out.println(a2.codigo); //acessando membro através da variavel de referencia
		System.out.println(a2.titulo);
		System.out.println(a2.periodo);
		System.out.println(a2.ementa);
		System.out.println("\n");
		
		System.out.println(a3.codigo); //acessando membro através da variavel de referencia
		System.out.println(a3.titulo);
		System.out.println(a3.periodo);
		System.out.println(a3.ementa);
		System.out.println("\n");
}
}