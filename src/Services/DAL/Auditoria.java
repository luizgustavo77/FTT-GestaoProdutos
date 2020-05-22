package Services.DAL;

import java.io.IOException;
import java.lang.Thread;

import Services.Entity.Clientes;
import Services.Entity.Funcionarios;
import Services.Entity.Pedidos;
import Services.Entity.Produtos;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
public void calculaTotalRecebido(){
  new Thread() {     
    @Override
    public void run() {
      //Code here       
    }
  }.start(); 
}*/
public class Auditoria {
    public static void Send(Clientes entidade) throws IOException {
        new Thread() {
            @Override
            public void run() {
                TXT DAL = new TXT();
                try {
                    DAL.Gravar("AuditoriaClientes.txt", entidade.MontaCliente());
                } catch (IOException ex) {
                    Logger.getLogger(Auditoria.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }.start();
    }

    public static void Send(Funcionarios entidade) throws IOException {
        new Thread() {
            @Override
            public void run() {
                TXT DAL = new TXT();
                try {
                    DAL.Gravar("AuditoriaFuncionarios.txt", entidade.MontaFuncionario());
                } catch (IOException ex) {
                    Logger.getLogger(Auditoria.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }.start();
    }

    public static void Send(Produtos entidade) throws IOException {
        new Thread() {
            @Override
            public void run() {
                TXT DAL = new TXT();
                try {
                    DAL.Gravar("AuditoriaProdutos.txt", entidade.MontaProduto());
                } catch (IOException ex) {
                    Logger.getLogger(Auditoria.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }.start();
    }

    public static void Send(Pedidos entidade) throws IOException {
        new Thread() {
            @Override
            public void run() {
                TXT DAL = new TXT();
                try {
                    DAL.Gravar("AuditoriaPedidos.txt", entidade.MontaPedido());
                } catch (IOException ex) {
                    Logger.getLogger(Auditoria.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }.start();
    }
}