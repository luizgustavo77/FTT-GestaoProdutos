package Common;

public class RecebeFuncionarioDTO {

    /**
     * @return the perf
     */
    public int getPerf() {
        return perf;
    }

    /**
     * @param perf the perf to set
     */
    public void setPerf(int perf) {
        this.perf = perf;
    }

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
     * @return the CPF
     */
    public String getCPF() {
        return CPF;
    }

    /**
     * @param CPF the CPF to set
     */
    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    private int perf;
    private String Nome;
    private String CPF;
}