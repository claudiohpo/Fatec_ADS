public class Estado {

    private String descricao;
    private String UF;

    public Estado(String descricao, String UF) {
        this.descricao = descricao;
        this.UF = UF;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUF() {
        return UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }
}
