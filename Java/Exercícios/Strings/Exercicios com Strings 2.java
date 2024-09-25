class Java{

public static void main(String[] args) {
	
	var nome = "Ana Marcela Marmorá";
	var idade = 31;
	var ValorConsulta = 280.00;
	var DataConsulta = "21/08/2024";
	
	System.out.print("O Sexto Caractere do Nome: ");
	System.out.println(nome.charAt(5)); //O Sexto Caractere do Nome
	
	System.out.print("\nExiste a sequencia 'ela' no nome?(True ou False): ");
	System.out.println(nome.contains("ela")); //Verificar se existe a sequencia ela no nome
	
	String ValorData = String.format("\nValor da Consulta: R$%.2f.\n\nData da Consulta: %s.", ValorConsulta, DataConsulta);
	System.out.println(ValorData); // Exibir o valor da consulta e a data em formato legivel 
	
	System.out.println("\nSra. " + nome); //Concatenar o prefixo Sra, com o Nome da Paciente.
	}
}