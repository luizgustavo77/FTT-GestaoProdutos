package Services.Entity;

import java.io.IOException;
import java.util.List;

import Services.DAL.TXT;

public class Pedidos {

    /**
     * @return the Id
     */
    public String getId() {
        return Id;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(String Id) {
        this.Id = Id;
    }

    /**
     * @return the func
     */
    public Funcionarios getFunc() {
        return func;
    }

    /**
     * @param func the func to set
     */
    public void setFunc(Funcionarios func) {
        this.func = func;
    }

    /**
     * @return the prod
     */
    public List<Produtos> getProd() {
        return prod;
    }

    /**
     * @param prod the prod to set
     */
    public void setProd(List<Produtos> prod) {
        this.prod = prod;
    }

    /**
     * @return the cli
     */
    public Clientes getCli() {
        return cli;
    }

    /**
     * @param cli the cli to set
     */
    public void setCli(Clientes cli) {
        this.cli = cli;
    }

    /**
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }

    private String Id;
    private Funcionarios func;
    private List<Produtos> prod;
    private Clientes cli;
    private String data;

    public String MontaClientePedido(Clientes entidade) {
        return entidade.getCPF();
    }

    public String MontaFuncionarioPedido(Funcionarios entidade) {
        return entidade.getCPF();
    }

    public String MontaItems(List<Produtos> entidade) {
        String retorno = "";

        for (Produtos item : entidade) {
            retorno += item.getCodigo() + ",";
        }
        if (retorno.length() > 1) {
            retorno = retorno.substring(0, retorno.length() - 1);
        }
        return retorno;
    }

    public String MontaPedido() throws IOException {
        String retorno = "";
        TXT DAL = new TXT();

        retorno = DAL.GetId("Pedidos.txt") + ";" + MontaFuncionarioPedido(getFunc()) + ";" + MontaItems(getProd()) + ";"
                + MontaClientePedido(getCli()) + ";" + getData();

        return retorno;
    }
}