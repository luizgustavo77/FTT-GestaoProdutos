package Common;

public class LoginDTO {

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

    /**
     * @return the SENHA
     */
    public String getSENHA() {
        return SENHA;
    }

    /**
     * @param SENHA the SENHA to set
     */
    public void setSENHA(String SENHA) {
        this.SENHA = SENHA;
    }

    private String CPF;
    private String SENHA;
}
