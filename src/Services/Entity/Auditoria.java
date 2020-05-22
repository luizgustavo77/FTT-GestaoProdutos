package Services.Entity;

public class Auditoria {

    /**
     * @return the Id
     */
    public int getId() {
        return Id;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(int Id) {
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
     * @return the ped
     */
    public Pedidos getPed() {
        return ped;
    }

    /**
     * @param ped the ped to set
     */
    public void setPed(Pedidos ped) {
        this.ped = ped;
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

    private int Id;
    private Funcionarios func;
    private Pedidos ped;
    private Clientes cli;
}
