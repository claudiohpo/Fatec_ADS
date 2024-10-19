package Atividades_18_Outubro;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Produtos {
    private String descricao;
    private double preco;
    private int quantidade;

    public Produtos(String descricao, double preco, int quantidade) {
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    // Método para vender o produto
    public boolean vender(int quantidade) {
        if (this.quantidade >= quantidade) {
            this.quantidade -= quantidade;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Nome: " + descricao + ", Preço: R$ " + String.format("%.2f", preco) + ", Quantidade: " + quantidade;
    }
}

public class MaquinaDeVendas {
    private List<Produtos> produtos;

    public MaquinaDeVendas() {
        this.produtos = new ArrayList<>();
    }

    public void cadastrarProduto(String descricao, double preco, int quantidade) {
        Produtos produto = new Produtos(descricao, preco, quantidade);
        produtos.add(produto);
        System.out.println("Produto cadastrado com sucesso!");
    }

    public void exibirEstoque() {
        if (produtos.isEmpty()) {
            System.out.println("Estoque vazio.");
        } else {
            System.out.println("Estoque disponível:");
            for (Produtos p : produtos) {
                System.out.println(p);
            }
        }
    }

    public Produtos selecionarProduto(String descricao) {
        for (Produtos p : produtos) {
            if (p.getDescricao().equalsIgnoreCase(descricao)) {
                return p;
            }
        }
        System.out.println("Produto não encontrado.");
        return null;
    }

    public void inserirDinheiro(Produtos produto, int quantidade, double valorInserido) {
        if (produto == null) {
            System.out.println("Produto inválido.");
            return;
        }

        double valorTotal = produto.getPreco() * quantidade;
        if (valorInserido < valorTotal) {
            System.out.println("Dinheiro insuficiente. Valor total: R$ " + String.format("%.2f", valorTotal));
            return;
        }

        if (!produto.vender(quantidade)) {
            System.out.println("Estoque insuficiente para a quantidade solicitada.");
            return;
        }

        double troco = valorInserido - valorTotal;
        System.out.println("Compra realizada com sucesso!");
        System.out.printf("Troco: R$ %.2f%n", troco);
    }

    public static void main(String[] args) {
        MaquinaDeVendas maquina = new MaquinaDeVendas();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMenu da Máquina de Vendas:");
            System.out.println("1. Cadastrar Produto");
            System.out.println("2. Exibir Estoque");
            System.out.println("3. Selecionar Produto para Compra");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do produto: ");
                    String descricao = scanner.nextLine();
                    System.out.print("Digite o preço do produto: ");
                    double preco = scanner.nextDouble();
                    System.out.print("Digite a quantidade no estoque: ");
                    int quantidade = scanner.nextInt();
                    maquina.cadastrarProduto(descricao, preco, quantidade);
                    break;
                case 2:
                    maquina.exibirEstoque();
                    break;
                case 3:
                    System.out.print("Digite o nome do produto que deseja comprar: ");
                    String produtoNome = scanner.nextLine();
                    Produtos produtoSelecionado = maquina.selecionarProduto(produtoNome);

                    if (produtoSelecionado != null) {
                        System.out.print("Digite a quantidade desejada: ");
                        int quantidadeDesejada = scanner.nextInt();
                        System.out.print("Insira o valor em dinheiro: ");
                        double valorInserido = scanner.nextDouble();
                        maquina.inserirDinheiro(produtoSelecionado, quantidadeDesejada, valorInserido);
                    }
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}