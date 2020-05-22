package Services.Entity;

public class Funcionarios extends Pessoa {

    /**
     * @return the Senha
     */
    public String getSenha() {
        return Senha;
    }

    /**
     * @param Senha the Senha to set
     */
    public void setSenha(String Senha) {
        this.Senha = Senha;
    }

    /**
     * @return the perf
     */
    public EnumPerfil getPerf() {
        return perf;
    }

    /**
     * @param perf the perf to set
     */
    public void setPerf(EnumPerfil perf) {
        this.perf = perf;
    }

    /**
     * @return the Contratacao
     */
    public String getContratacao() {
        return Contratacao;
    }

    /**
     * @param Contratacao the Contratacao to set
     */
    public void setContratacao(String Contratacao) {
        this.Contratacao = Contratacao;
    }

    /**
     * @return the Demissao
     */
    public String getDemissao() {
        return Demissao;
    }

    /**
     * @param Demissao the Demissao to set
     */
    public void setDemissao(String Demissao) {
        this.Demissao = Demissao;
    }

    private EnumPerfil perf;
    private String Contratacao;
    private String Demissao;
    private String Senha;

    public String MontaFuncionario() {

        if (getDemissao().equals(null)) {
            setDemissao("0");
        }

        return getCPF() + ";" + getNome() + ";" + getTelefone() + ";" + getPerf() + ";" + getContratacao() + ";"
                + getDemissao() + ";" + getSenha();
    }
}
