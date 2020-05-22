package Services.Entity;

public class Clientes extends Pessoa {
    public String MontaCliente() {
        return getCPF() + ";" + getNome() + ";" + getTelefone();
    }
}