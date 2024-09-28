package Aula27092024.Exercico1;

public class Main {
    public static void  main(String[] args){
        PessoaF pf = new PessoaF("Cláudio", 411, 12984, 8547.48,"347.154.125-85", "25/10/1988","Solteiro", "14/07/2012");
        PessoaF pf1 = new PessoaF("Oliveira", 231, 1254, 98745.25,"075.658.479-88", "09/06/1955","Casado", "02/12/1999");
        pf.exibir();
        pf1.exibir();

        PessoaJ pj = new PessoaJ("Julius Mecanica ltda", 1261, 2514, 105478.85,"00.458.789/0001-85", "Julio Cesar Silva", "Média", "02/08/2005");
        PessoaJ pj1 = new PessoaJ("Diane Modas DiVestiti SA", 411, 1425, 14521.14, "02.021.258/0001-69", "Diane Driely", "Pequeuna", "01/02/2010");
        pj.exibir();
        pj1.exibir();
    }
}
