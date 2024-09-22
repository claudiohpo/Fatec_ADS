/*Criar um programa Java que crie uma classe chamada apartamento.
Esta classe em geral, possui quantidade de quartos, área total, 
varanda gourmet, numero de banheiros, proprietário.
Voces devem construir 2 objetos desta classe e apresentar o conteúdo deles na tela.  */
package Apartamento;

public class Main {
    public static void main(String[] args) {

        Apartamento[] apartamentos = new Apartamento[3];

        apartamentos[0] = new Apartamento(3, 68.2, true, 3, "Milton Teixeira");
        apartamentos[1] = new Apartamento(2, 56, false, 2, "Cláudio Henrique");
        apartamentos[2] = new Apartamento(1, 39, false, 1, "Wilson Santos Martins");
        
        for (int i = 0; i < apartamentos.length; i++) {
                System.out.println("Apartamento " + (i+1));
                apartamentos[i].exibirInfo();
        }
        /*System.out.println("Apartamento 1:");
        ape1.exibirInfo();
        System.out.println("Apartamento 2:");
        ape2.exibirInfo();
        System.out.println("Apartamento 3:");
        ape3.exibirInfo();*/
    }
}

 class Apartamento {
    private int quantidadeQuartos;
    private double areaTotal;
    private boolean varandaGourmet;
    private int numBanheiros;
    private String proprietario;

    public Apartamento(int qtdQuartos, double area, boolean varandaGourmet, int numBanheiros, String proprietario) {
        this.quantidadeQuartos = qtdQuartos;
        this.areaTotal = area;
        this.varandaGourmet = varandaGourmet;
        this.numBanheiros = numBanheiros;
        this.proprietario = proprietario;
    }

    public void exibirInfo() {
        System.out.println("----------------------------------------------------------");
        System.out.printf("| %-54s |\n", "Nome do Proprietário: " + proprietario);
        System.out.printf("| %-54s |\n", "Quantidade de Quartos: " + quantidadeQuartos);
        System.out.printf("| %-54s |\n", "Área Total: " + areaTotal + " m²");
        System.out.printf("| %-54s |\n", "Há Varanda Gourmet: " + (varandaGourmet ? "Sim" : "Não"));
        System.out.printf("| %-54s |\n", "Número de Banheiros: " + numBanheiros);
        System.out.println("----------------------------------------------------------\n");
    }
}