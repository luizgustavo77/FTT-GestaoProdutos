package Services.Entity;

public enum EnumPerfil {

    Vendedor("Vendedor"), // Prod, Ped, Cli
    Gerente("Gerente"), // Prod, Ped, Cli, Func
    Funcionario("Funcionario");

    private String descricao;

    EnumPerfil(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}