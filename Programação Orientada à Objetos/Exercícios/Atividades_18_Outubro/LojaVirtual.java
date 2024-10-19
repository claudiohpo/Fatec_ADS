package Atividades_18_Outubro;

import java.util.ArrayList;
import java.util.List;



class Produto {
    private String descricao;
    private double preco;
    private int quantidade;


    public Produto(String descricao, double preco, int quantidade) {
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

    public void cadastrarProdutos(){
        System.out.println("Informe o nome do Produtos: ");

    }
}

class Carrinho{
    private List<Produtos> produtos;

    public Carrinho(){
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produtos produtos, int quantidade){
        for (Produtos p : this.produtos) {
            if (p.getDescricao().equalsIgnoreCase(produtos.getDescricao())) {
                p.setQuantidade(p.getQuantidade() + quantidade);
                return;
            }
        }
        this.produtos.add(new Produtos(produtos.getDescricao(), produtos.getPreco(), quantidade));
    }

    public double calcularTotal() {
        double total = 0.0;
        for (Produtos p : produtos) {
            total += p.getPreco() * p.getQuantidade();
        }
        return total;
    }

    public void exibirCarrinho() {
        System.out.println("Produtos no Carrinho:");
        for (Produtos p : produtos) {
            System.out.printf("Nome: %s, Quantidade: %d, Preço unitário: R$ %.2f%n", p.getDescricao(), p.getQuantidade(), p.getPreco());
        }
        System.out.printf("Total: R$ %.2f%n", calcularTotal());
    }

    public void aplicarDesconto(double percentualDesconto) {
        for (Produtos p : produtos) {
            double precoComDesconto = p.getPreco() - (p.getPreco() * percentualDesconto / 100);
            p.setPreco(precoComDesconto); // Atualiza o preço com o valor descontado
        }
        System.out.printf("Desconto de %.2f%% aplicado com sucesso!%n", percentualDesconto);
    }
}

public class LojaVirtual {
    private List<Produtos> catalogo;
    private Carrinho carrinho;

    public LojaVirtual() {
        this.catalogo = new ArrayList<>();
        this.carrinho = new Carrinho();
    }

    public void cadastrarProduto(String nome, double preco, int quantidade) {
        Produtos produtos = new Produtos(nome, preco, quantidade);
        catalogo.add(produtos);
        System.out.println("Produtos cadastrado com sucesso!");
    }

    public void adicionarAoCarrinho(String nomeProduto, int quantidade) {
        for (Produtos p : catalogo) {
            if (p.getDescricao().equalsIgnoreCase(nomeProduto)) {
                carrinho.adicionarProduto(p, quantidade);
                System.out.println("Produtos adicionado ao carrinho!");
                return;
            }
        }
        System.out.println("Produtos não encontrado no catálogo.");
    }

    public void exibirCatalogo() {
        System.out.println("Catálogo de Produtos:");
        for (Produtos p : catalogo) {
            System.out.printf("Nome: %s, Preço: R$ %.2f, Quantidade: %d%n", p.getDescricao(), p.getPreco(), p.getQuantidade());
        }
    }

    public void exibirCarrinho() {
        carrinho.exibirCarrinho();
    }

    public void aplicarDescontoAoCarrinho(double percentualDesconto) {
        carrinho.aplicarDesconto(percentualDesconto);
    }

    public void calcularTotalCompra() {
        double total = carrinho.calcularTotal();
        System.out.printf("Valor total da compra: R$ %.2f%n", total);
    }

    public static void main(String[] args) {
        LojaVirtual loja = new LojaVirtual();

        // Cadastro de produtos
        loja.cadastrarProduto("Notebook", 3500.00, 10);
        loja.cadastrarProduto("Mouse", 50.00, 100);
        loja.cadastrarProduto("Teclado", 150.00, 50);

        // Exibição do catálogo
        loja.exibirCatalogo();

        // Adição ao carrinho
        loja.adicionarAoCarrinho("Notebook", 1);
        loja.adicionarAoCarrinho("Mouse", 2);

        // Exibição do carrinho
        loja.exibirCarrinho();

        // Aplicação de desconto
        loja.aplicarDescontoAoCarrinho(10);

        // Cálculo do valor total
        loja.calcularTotalCompra();
    }
}