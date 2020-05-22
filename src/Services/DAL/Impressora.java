package Services.DAL;

import java.io.IOException;

import Common.ProdutosDTO;
import Common.RecebePedidoDTO;

public class Impressora {
    public boolean Imprimir(RecebePedidoDTO entidade) throws IOException {
        TXT DAL = new TXT();
        return DAL.Imprimir("Etiqueta.txt", MontaEtiqueta(entidade));
    }

    private String MontaEtiqueta(RecebePedidoDTO entidade) {
        String retorno = "Funcionario: " + entidade.getFuncionario() + "\n" + "Cliente: " + entidade.getCliente()
                + "\n";
        retorno = "Produtos: " + "\n";
        for (ProdutosDTO item : entidade.getProd()) {
            retorno += "Codigo: " + item.getCodigo() + "\n";
            retorno += "Nome: " + item.getNome() + "\n";
            retorno += "Preco: " + String.valueOf(item.getQuantidade()) + "x" + item.getPreco() + "\n" + "\n";
        }

        return retorno;
    }
}