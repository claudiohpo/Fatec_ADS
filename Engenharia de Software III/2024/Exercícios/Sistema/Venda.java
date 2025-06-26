package Sistema;

import java.util.ArrayList;
import java.util.List;

public class Venda {
    private int id;
    private Cliente cliente;
    private Endereco enderecoEntrega;
    private List<ItemVenda> itens;
    private Pagamento pagamento;
    private double valorTotal;
    private Frete frete;
    private Comissao comissao;
    private Auditoria auditoria;
    private List<Imposto> impostos;

    public Venda(int id, Cliente cliente, Endereco enderecoEntrega, Pagamento pagamento, Frete frete, Comissao comissao, Auditoria auditoria) {
        this.id = id;
        this.cliente = cliente;
        this.enderecoEntrega = enderecoEntrega;
        this.pagamento = pagamento;
        this.frete = frete;
        this.comissao = comissao;
        this.auditoria = auditoria;
        this.itens = new ArrayList<>();
        this.impostos = new ArrayList<>();
    }

    public void adicionarItem(ItemVenda item) {
        if (item != null) {
            itens.add(item);
            valorTotal += item.getValorTotalItem();
        }
    }

    public double calcularImpostos() {
        double totalImpostos = 0;
        for (Imposto imposto : impostos) {
            totalImpostos += imposto.calcularImposto(valorTotal);
        }
        return totalImpostos;
    }

    public void calcularComissao() {
        double valorComissao = 0;
        for (ItemVenda item : itens) {
            valorComissao += comissao.calcularComissao(item.getValorTotalItem(), item.getProduto());
        }
        comissao.setValorComissao(valorComissao);
    }

    public double calcularFrete() {
        return frete.calcularFrete(enderecoEntrega);
    }

    public void finalizarVenda() {
        if (cliente.ehClienteClassificado()) {
            valorTotal += calcularImpostos() + calcularFrete();
            calcularComissao();
            pagamento.processarPagamento();
            
        } else {
            System.out.println("Venda não pode ser finalizada. Cliente mal classificado.");
        }
    }

    
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public Endereco getEnderecoEntrega() { return enderecoEntrega; }
    public void setEnderecoEntrega(Endereco enderecoEntrega) { this.enderecoEntrega = enderecoEntrega; }

    public List<ItemVenda> getItens() { return itens; }
    public void setItens(List<ItemVenda> itens) { this.itens = itens; }

    public Pagamento getPagamento() { return pagamento; }
    public void setPagamento(Pagamento pagamento) { this.pagamento = pagamento; }

    public double getValorTotal() { return valorTotal; }

    public Frete getFrete() { return frete; }
    public void setFrete(Frete frete) { this.frete = frete; }

    public Comissao getComissao() { return comissao; }
    public void setComissao(Comissao comissao) { this.comissao = comissao; }

    public Auditoria getAuditoria() { return auditoria; }
    public void setAuditoria(Auditoria auditoria) { this.auditoria = auditoria; }

    public List<Imposto> getImpostos() { return impostos; }
    public void setImpostos(List<Imposto> impostos) { this.impostos = impostos; }
}
