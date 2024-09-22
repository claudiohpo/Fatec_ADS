public class Auladia20{

public static void main(String[] args) {
	System.out.println("Olá Pessoal".charAt(2)); //Mostra o terceiro caracter, java começa a contagem em ZERO
	
	String s = "Boa Tarde";
	System.out.println(s.concat("!!!")); //faz a concatenação de variaveis
	System.out.println(s + "!!!"); //concatenacao de informaçoes
	System.out.println(s.startsWith("BOA")); //tipo string pode retornar um boolean, não apenas String
	System.out.println(s.toUpperCase().startsWith("BOA")); //transforma o conteudo da variavel para upper case, o retorno é CASE SENSITIVE
	System.out.println(s.length()); //comprimento da variavel (9 caracteres incluindo espaços), pode retornar um numero inteiro tambem
	System.out.println(s.toLowerCase().equals("BOA TADE")); //transforma o conteudo da variavel para lower case,faz comparações e é CASE SENSITIVE como opcional
	System.out.println(s.equalsIgnoreCase("BOA TARDE")); //faz comparações e ignora CASE SENSITIVE

	//Usos de String retornando valores e frases
	
	var nome = "Pedro";
	var sobrenome = "Santos";
	var idade = 33;
	var salario = 12345.987;
	
	//Concatenação simples e manual
	
	String maisUmaFrase = "Nome: " + nome + "\nSobrenome: " + sobrenome + "\nIdade: " + idade + "\nSalario: " + salario + "\n\n";
	System.out.println(maisUmaFrase);
	
	//uso de printf. Lembrar que os % indicam o tipo de variavel a ser exibida
	System.out.printf("O senhor %s %s tem %d anos e ganha R$%.2f.", nome, sobrenome, idade, salario);

	//uso de stringformat armazenado em uma variavel
	String frase = String.format("\nO Senhor %s %s tem %d anos e ganha R$%.2f.", nome, sobrenome, idade, salario);
	System.out.println(frase);
	
	// Propriedade de contagem, index e substring
	System.out.println("Frase qualquer".contains("qual"));
	System.out.println("Frase qualquer".indexOf("qual"));
	System.out.println("Frase qualquer".substring(6));
	System.out.println("Frase qualquer".substring(6, 10));



}
}