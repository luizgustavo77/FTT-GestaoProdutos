package Services.Entity;

public class Produtos {

    /**
     * @return the Nome
     */
    public String getNome() {
        return Nome;
    }

    /**
     * @param Nome the Nome to set
     */
    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    /**
     * @return the Detalhe
     */
    public String getDetalhe() {
        return Detalhe;
    }

    /**
     * @param Detalhe the Detalhe to set
     */
    public void setDetalhe(String Detalhe) {
        this.Detalhe = Detalhe;
    }

    /**
     * @return the Codigo
     */
    public String getCodigo() {
        return Codigo;
    }

    /**
     * @param Codigo the Codigo to set
     */
    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    /**
     * @return the Preco
     */
    public String getPreco() {
        return Preco;
    }

    /**
     * @param Preco the Preco to set
     */
    public void setPreco(String Preco) {
        this.Preco = Preco;
    }

    /**
     * @return the Quantidade
     */
    public int getQuantidade() {
        return Quantidade;
    }

    /**
     * @param Quantidade the Quantidade to set
     */
    public void setQuantidade(int Quantidade) {
        this.Quantidade = Quantidade;
    }

    private String Nome;
    private String Detalhe;
    private String Codigo;
    private String Preco;
    private int Quantidade;

    public String MontaProduto() {
        return getCodigo() + ";" + getNome() + ";" + getDetalhe() + ";" + getPreco() + ";" + getQuantidade();
    }
}
