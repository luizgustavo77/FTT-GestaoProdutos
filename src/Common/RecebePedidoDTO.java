package Common;

import java.util.List;

/**
 *
 * @author 082170039
 */
public class RecebePedidoDTO {

    /**
     * @return the Imprimir
     */
    public boolean isImprimir() {
        return Imprimir;
    }

    /**
     * @param Imprimir the Imprimir to set
     */
    public void setImprimir(boolean Imprimir) {
        this.Imprimir = Imprimir;
    }

    /**
     * @return the Funcionario
     */
    public String getFuncionario() {
        return Funcionario;
    }

    /**
     * @param Funcionario the Funcionario to set
     */
    public void setFuncionario(String Funcionario) {
        this.Funcionario = Funcionario;
    }

    /**
     * @return the prod
     */
    public List<ProdutosDTO> getProd() {
        return prod;
    }

    /**
     * @param prod the prod to set
     */
    public void setProd(List<ProdutosDTO> prod) {
        this.prod = prod;
    }

    /**
     * @return the Cliente
     */
    public String getCliente() {
        return Cliente;
    }

    /**
     * @param Cliente the Cliente to set
     */
    public void setCliente(String Cliente) {
        this.Cliente = Cliente;
    }

    private String Funcionario;
    private List<ProdutosDTO> prod;
    private String Cliente;
    private boolean Imprimir;
}