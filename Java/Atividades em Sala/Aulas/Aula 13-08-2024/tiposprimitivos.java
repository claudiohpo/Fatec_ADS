public class tiposprimitivos {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Informações de funcionarios
		// Tipos Tipos Numericos inteiros
		byte anosdeEmpresa = 23;
		short numerodeVoos = 542;
		int id = 56789;
		long pontosAcumulados = 3_234_845_223L;
		
		//Tipos Numericos reais
		float salario = 11_445.44F;
		double vendasAcumuladas = 2_991_797_103.91;
		boolean ferias = false;
		char a='A'; //ativo
		
		//Dias de Empresa
		System.out.println(anosdeEmpresa*365);
		
		//Numero de viagens
		System.out.println(542 / 2);
		
		//Pontos Acumulados
		System.out.println(pontosAcumulados / vendasAcumuladas);
		
		//Quanto ganha
		System.out.println(id + ": ganha --> " + salario);
		System.out.println(id + "de Férias? " + ferias);
		System.out.println(id + "Qual Status? " + a);
	}
}