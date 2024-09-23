package Sistema;
	
import java.util.Date;
import java.util.List;

public class Auditoria {
    private int id;
    private String usuarioResponsavel;
    private Date dataHoraTransacao;
    private int idCliente;
    private String meioPagamento;
    private List<Produto> produtos;

    public Auditoria(int id, String usuarioResponsavel, Date dataHoraTransacao, int idCliente, String meioPagamento, List<Produto> produtos) {
        this.id = id;
        this.usuarioResponsavel = usuarioResponsavel;
        this.dataHoraTransacao = dataHoraTransacao;
        this.idCliente = idCliente;
        this.meioPagamento = meioPagamento;
        this.produtos = produtos;
    }

    
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getUsuarioResponsavel() { return usuarioResponsavel; }
    public void setUsuarioResponsavel(String usuarioResponsavel) { this.usuarioResponsavel = usuarioResponsavel; }

    public Date getDataHoraTransacao() { return dataHoraTransacao; }
    public void setDataHoraTransacao(Date dataHoraTransacao) { this.dataHoraTransacao = dataHoraTransacao; }

    public int getIdCliente() { return idCliente; }
    public void setIdCliente(int idCliente) { this.idCliente = idCliente; }

    public String getMeioPagamento() { return meioPagamento; }
    public void setMeioPagamento(String meioPagamento) { this.meioPagamento = meioPagamento; }

    public List<Produto> getProdutos() { return produtos; }
    public void setProdutos(List<Produto> produtos) { this.produtos = produtos; }
}

