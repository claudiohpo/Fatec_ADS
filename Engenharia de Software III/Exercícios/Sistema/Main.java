package Sistema;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Criar produtos
        Produto produto1 = new Produto(1, "Smartphone", 1500.0, "Eletrônicos", true);
        Produto produto2 = new Produto(2, "Notebook", 3000.0, "Eletrônicos", false);
        Produto produto3 = new Produto(3, "Geladeira", 2000.0, "Eletrodomésticos", true);

        // Criar estoque
        Estoque estoque1 = new Estoque(1, produto1, 10);
        Estoque estoque2 = new Estoque(2, produto2, 5);
        Estoque estoque3 = new Estoque(3, produto3, 3);

        // Criar cliente
        Cliente cliente = new Cliente(1, "João da Silva", "Bom", 100.0);

        // Criar endereço de entrega
        Endereco endereco = new Endereco("São Paulo", "SP", "01000-000");

        // Selecionar forma de pagamento
        Pagamento pagamento = new Pagamento(1, "Cartão de Crédito");

        // Criar frete
        Frete frete = new Frete(1, "Normal");

        // Criar comissão
        Comissao comissao = new Comissao(1, 101);

        // Criar auditoria
        List<Produto> produtosAuditados = new ArrayList<>();
        Auditoria auditoria = new Auditoria(1, "admin", new Date(), cliente.getId(), pagamento.getMeioDePagamento(), produtosAuditados);

        // Criar venda
        Venda venda = new Venda(1, cliente, endereco, pagamento, frete, comissao, auditoria);

        // Adicionar produtos à venda
        System.out.println("Selecione os produtos para a venda:");
        System.out.println("1 - Smartphone (R$ 1500.00)");
        System.out.println("2 - Notebook (R$ 3000.00)");
        System.out.println("3 - Geladeira (R$ 2000.00)");

        System.out.print("Digite o ID do produto (0 para finalizar): ");
        int produtoId = scanner.nextInt();

        while (produtoId != 0) {
            switch (produtoId) {
                case 1:
                    if (estoque1.validarDisponibilidade(1)) {
                        ItemVenda item1 = new ItemVenda(1, produto1, 1);
                        venda.adicionarItem(item1);
                        produtosAuditados.add(produto1);
                        estoque1.darBaixa(1);
                        System.out.println("Produto adicionado: Smartphone");
                    } else {
                        System.out.println("Produto indisponível no estoque.");
                    }
                    break;
                case 2:
                    if (estoque2.validarDisponibilidade(1)) {
                        ItemVenda item2 = new ItemVenda(2, produto2, 1);
                        venda.adicionarItem(item2);
                        produtosAuditados.add(produto2);
                        estoque2.darBaixa(1);
                        System.out.println("Produto adicionado: Notebook");
                    } else {
                        System.out.println("Produto indisponível no estoque.");
                    }
                    break;
                case 3:
                    if (estoque3.validarDisponibilidade(1)) {
                        ItemVenda item3 = new ItemVenda(3, produto3, 1);
                        venda.adicionarItem(item3);
                        produtosAuditados.add(produto3);
                        estoque3.darBaixa(1);
                        System.out.println("Produto adicionado: Geladeira");
                    } else {
                        System.out.println("Produto indisponível no estoque.");
                    }
                    break;
                default:
                    System.out.println("ID do produto inválido.");
            }

            System.out.print("Digite o ID do próximo produto (0 para finalizar): ");
            produtoId = scanner.nextInt();
        }

        // Adicionar impostos à venda
        Imposto icms = new Imposto(1, "ICMS", 18.0);
        Imposto cofins = new Imposto(2, "COFINS", 7.6);
        venda.getImpostos().add(icms);
        venda.getImpostos().add(cofins);

        // Calcular frete
        double valorFrete = venda.calcularFrete();
        System.out.println("Valor do frete: R$ " + valorFrete);

        // Finalizar venda
        venda.finalizarVenda();
        System.out.println("Valor total da venda: R$ " + venda.getValorTotal());

        // Exibir informações da venda
        System.out.println("\nDetalhes da Venda:");
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Classificação do Cliente: " + cliente.getClassificacao());
        System.out.println("Produtos Vendidos:");
        for (ItemVenda item : venda.getItens()) {
            System.out.println("- " + item.getProduto().getNome() + " x" + item.getQuantidade() + " = R$ " + item.getValorTotalItem());
        }
        System.out.println("Total dos Produtos: R$ " + (venda.getValorTotal() - valorFrete - venda.calcularImpostos()));
        System.out.println("Total de Impostos: R$ " + venda.calcularImpostos());
        System.out.println("Valor da Comissão: R$ " + venda.getComissao().getValorComissao());
        System.out.println("Valor Total da Venda (com frete e impostos): R$ " + venda.getValorTotal());

        scanner.close();
    }
}
