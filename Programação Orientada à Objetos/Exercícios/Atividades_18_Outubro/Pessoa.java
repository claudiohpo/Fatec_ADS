package Atividades_18_Outubro;

import java.util.Scanner;

public class Pessoa {
    private String nome;
    private int idade;
    private String profissao;
    private int anoAtual;

    public Pessoa(String nome, int idade, String profissao, int anoAtual) {
        this.nome = nome;
        this.idade = idade;
        this.profissao = profissao;
        this.anoAtual = anoAtual;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public String getProfissao() {
        return profissao;
    }
    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public int getAnoAtual() {
        return anoAtual;
    }

    public void setAnoAtual(int anoAtual) {
        this.anoAtual = anoAtual;
    }

    public int calcularIdade(){
        int anoNascimento = anoAtual - idade;
        int totalAnosBissextos = 0;

        for (int i = anoNascimento; i <= anoAtual; i++){
            if (i % 4 == 0){
                totalAnosBissextos += 1;
            }
        }
        return totalAnosBissextos;
    }

    public void exibirInformacoes() {
        System.out.println("---------------------------------");
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Profissão: " + profissao);
        System.out.println("Anos bissextos vividos: " + calcularIdade());
        System.out.println("---------------------------------");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();

        System.out.print("Digite sua idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Digite sua profissão: ");
        String profissao = scanner.nextLine();

        System.out.print("Informe o ano atual: ");
        int anoAtual = scanner.nextInt();
        scanner.nextLine();

        Pessoa pessoa = new Pessoa(nome, idade, profissao, anoAtual);
        pessoa.exibirInformacoes();

        scanner.close();
    }
}