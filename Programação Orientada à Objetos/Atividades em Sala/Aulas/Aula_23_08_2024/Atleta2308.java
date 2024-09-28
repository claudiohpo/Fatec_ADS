//23 de Agosto de 2024
package Aula_23_08_2024;
public class Atleta2308{
	
	//definindo as propriedades
			String nome;
			String modalidade;
			int medalhista;
	
	public static void main(String[] args) {
		
		//Criando um objeto ou instância
		Atleta2308 a1 = new Atleta2308(); //criando objeto de Atleta
		a1.nome = "Vania";
		a1.modalidade = "Ciclismo";
		a1.medalhista=0;
		
		
		Atleta2308 a2 = new Atleta2308(); //criando objeto de Atleta
		a2.nome = "Telmo";
		a2.modalidade = "Judo";
		a2.medalhista=1;
		
		Atleta2308 campeao = new Atleta2308();
		campeao.nome = "Tiburcio";
		campeao.modalidade = "Peteca";
		campeao.medalhista = 0;
		
		System.out.println(a1.nome); //acessando membro através da variavel de referencia
		System.out.println(a2.modalidade);
		
		System.out.println(a2.nome); //acessando membro através da variavel de referencia
		System.out.println(a1.modalidade);
		
		System.out.println(campeao.nome); //acessando membro através da variavel de referencia
		System.out.println(campeao.modalidade);
		System.out.println(campeao.medalhista);
		
		a2.nome = "Patricia";
		System.out.println(a2.nome);
}
}