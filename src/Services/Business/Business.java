package Services.Business;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.xml.crypto.Data;

import Services.DAL.Auditoria;
import Services.DAL.TXT;
import Services.Entity.Clientes;
import Services.Entity.EnumPerfil;
import Services.Entity.Funcionarios;
import Services.Entity.Produtos;
import Services.Entity.Pedidos;

public class Business {
    List<Produtos> ListaProdutos;

    // public static void Clear() {
    // try {
    // new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    // } catch (Exception e) {
    // System.out.println(e);
    // }
    // }

    public Funcionarios CarregaFuncionario(String cpf) throws IOException {
        Funcionarios func = new Funcionarios();
        TXT DAL = new TXT();
        List<String> entidade = DAL.Ler("Funcionarios.txt");
        String[] ramificado = new String[7];
        for (String item : entidade) {
            ramificado = item.split(";");

            if (ramificado[0].equals(cpf)) {
                func.setCPF(ramificado[0]);
                func.setNome(ramificado[1]);
                func.setTelefone(ramificado[2]);
                switch (ramificado[3]) {
                case "Vendedor":
                    func.setPerf(EnumPerfil.Vendedor);
                    break;
                case "Gerente":
                    func.setPerf(EnumPerfil.Gerente);
                    break;
                case "Funcionario":
                    func.setPerf(EnumPerfil.Funcionario);
                    break;
                }

                func.setContratacao(ramificado[4]);
                func.setDemissao(ramificado[5]);
                func.setSenha(ramificado[6]);
            }
        }
        return func;
    }

    public Clientes CarregaCliente(String cpf) throws IOException {
        Clientes cli = new Clientes();
        TXT DAL = new TXT();
        List<String> entidade = DAL.Ler("Clientes.txt");
        String[] ramificado = new String[3];
        for (String item : entidade) {
            ramificado = item.split(";");

            if (ramificado[0].equals(cpf)) {

                cli.setCPF(ramificado[0]);
                cli.setNome(ramificado[1]);
                cli.setTelefone(ramificado[2]);
            }
        }
        return cli;
    }

    public Produtos CarregaProdutos(String Id) throws IOException {
        Produtos retorno = new Produtos();
        String entidade = "";
        TXT DAL = new TXT();
        entidade = DAL.Localiza("Produtos.txt", Id);
        String[] ramificado = entidade.split(";");
        retorno.setCodigo(ramificado[0]);
        retorno.setNome(ramificado[1]);
        retorno.setDetalhe(ramificado[2]);
        retorno.setPreco(ramificado[3]);
        retorno.setQuantidade(Integer.parseInt(ramificado[4]));
        return retorno;
    }

    public void CadastraFuncionario() throws IOException {
        Scanner scan = new Scanner(System.in);
        TXT DAL = new TXT();
        Funcionarios func = new Funcionarios();

        try {
            System.out.println("**** CADASTRO DE FUNCIONARIO ****");
            System.out.println("Digite o nome: ");
            String nome = scan.nextLine();

            System.out.println("Digite a CPF: ");
            String cpf = scan.nextLine();

            System.out.println("Digite o telefone: ");
            String telefone = scan.nextLine();

            boolean resposta = false;
            String perf = "";
            while (!resposta) {
                System.out.println("Digite o perfil (VENDEDOR, GERENTE & FUNCIONARIO):  ");
                perf = (scan.nextLine()).toUpperCase();
                switch (perf) {
                case "VENDEDOR":
                    resposta = true;
                    func.setPerf(EnumPerfil.Vendedor);
                    break;
                case "GERENTE":
                    resposta = true;
                    func.setPerf(EnumPerfil.Gerente);
                    break;
                case "FUNCIONARIO":
                    resposta = true;
                    func.setPerf(EnumPerfil.Funcionario);
                    break;
                }
            }

            System.out.println("Digite a senha: ");
            String Senha = scan.nextLine();

            func.setNome(nome);
            func.setCPF(cpf);
            func.setTelefone(telefone);
            Date data = new Date();
            SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
            func.setContratacao(String.valueOf(formatador.format(data)));
            func.setDemissao("0");
            func.setSenha(Senha);

            if (DAL.Gravar("Funcionarios.txt", func.MontaFuncionario())) {
                System.out.println("Funcionário Cadastrado.");
                Auditoria.Send(func);
            } else
                System.out.println("Funcionário não Cadastrado.");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void CadastraCliente() throws IOException {
        Scanner scan = new Scanner(System.in);
        TXT DAL = new TXT();
        Clientes cli = new Clientes();

        try {
            System.out.println("**** CADASTRO DE CLIENTE ****");
            System.out.println("Digite o nome: ");
            String nome = scan.nextLine();

            System.out.println("Digite a CPF: ");
            String cpf = scan.nextLine();

            System.out.println("Digite o telefone: ");
            String telefone = scan.nextLine();

            cli.setNome(nome);
            cli.setCPF(cpf);
            cli.setTelefone(telefone);

            if (DAL.Gravar("Clientes.txt", cli.MontaCliente())) {
                System.out.println("Cliente Cadastrado.");
                Auditoria.Send(cli);
            } else
                System.out.println("Cliente não Cadastrado.");
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void CadastraProdutos() throws IOException {
        Scanner scan = new Scanner(System.in);
        TXT DAL = new TXT();
        Produtos prod = new Produtos();

        try {
            System.out.println("**** CADASTRO DE PRODUTOS ****");
            System.out.println("Digite o nome:");
            String nome = scan.nextLine();

            System.out.println("Digite o detalhe:");
            String detalhe = scan.nextLine();

            String codigo = DAL.GetId("Produtos.txt");

            System.out.println("Digite o preço: ");
            String preco = scan.nextLine();

            System.out.println("Digite a quantidade: ");
            int qtd = Integer.parseInt(scan.nextLine());

            prod.setNome(nome);
            prod.setDetalhe(detalhe);
            prod.setCodigo(codigo);
            prod.setPreco(preco);
            prod.setQuantidade(qtd);

            if (DAL.Gravar("Produtos.txt", prod.MontaProduto())) {
                System.out.println("Produto Cadastrado.");
                Auditoria.Send(prod);
            } else
                System.out.println("Produto não Cadastrado.");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void CadastraPedidos() throws IOException {
        TXT DAL = new TXT();
        Pedidos ped = new Pedidos();
        Scanner scan = new Scanner(System.in);
        Funcionarios func = new Funcionarios();
        Clientes cli = new Clientes();
        Produtos prod = new Produtos();
        boolean validacao = true;

        System.out.println("**** CADASTRO DE PEDIDOS ****");
        String id = DAL.GetId("Pedidos.txt");

        while (validacao) {
            System.out.println("Digite o CPF do cliente: ");
            String cliente = (scan.nextLine());
            cli = CarregaCliente(cliente);
            if (DAL.Existe("Clientes.txt", cli.getCPF())) {
                validacao = false;
            } else {
                System.out.println("Cliente não existe!");
            }
        }

        validacao = true;

        while (validacao) {
            System.out.println("Digite o CPF do Funcionário: ");
            String funcionario = scan.nextLine();
            func = CarregaFuncionario(funcionario);
            if (DAL.Existe("Funcionarios.txt", func.getCPF())) {
                validacao = false;
            } else {
                System.out.println("Funcionario não existe!");
            }
        }
        validacao = true;
        ListaProdutos = new ArrayList();
        while (validacao) {
            System.out.println("Digite o codigo do produto: ");
            String produto = scan.nextLine();
            if (DAL.Existe("Produtos.txt", produto)) {
                prod = CarregaProdutos(produto);
                ListaProdutos.add(prod);
                System.out.println("Cadastrar outro produto? (S/N)");
                String read = scan.nextLine().toUpperCase();
                if (read.equals("N")) {
                    validacao = false;
                } else if (!read.equals("S")) {
                    System.out.println("Opção Inválida");
                }
            } else {
                System.out.println("Produto não existe!");
            }
        }

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        ped.setId(id);
        ped.setFunc(func);
        ped.setCli(cli);
        ped.setProd(ListaProdutos);
        ped.setData(dateFormat.format(date));

        if (DAL.Gravar("Pedidos.txt", ped.MontaPedido())) {
            System.out.println("Pedido Cadastrado.");
            Auditoria.Send(ped);
        } else
            System.out.println("Pedido não Cadastrado.");
    }

    public void Gerente() throws IOException {
        Scanner scan = new Scanner(System.in);
        try {
            do {
                // Clear();
                System.out.println("Menu do Gerente!");
                System.out.println("O que deseja fazer?");
                System.out.println("0 - Sair");
                System.out.println("1 - Cadastrar Clientes");
                System.out.println("2 - Cadastrar Funcionarios");
                System.out.println("3 - Cadastrar Produtos");
                System.out.println("4 - Cadastrar Pedidos ");
                String resposta = scan.nextLine();

                if (resposta.equals("0")) {
                    System.exit(0);
                } else if (resposta.equals("1")) {
                    CadastraCliente();
                } else if (resposta.equals("2")) {
                    CadastraFuncionario();
                } else if (resposta.equals("3")) {
                    CadastraProdutos();
                } else if (resposta.equals("4")) {
                    CadastraPedidos();
                } else {
                    System.out.println("Opção inválida!");
                }
            } while (true);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void Vendedor() throws IOException {
        Scanner scan = new Scanner(System.in);
        try {

            do {
                System.out.flush();
                // Clear();
                System.out.println("Menu do Vendedor!");
                System.out.println("O que deseja fazer?");
                System.out.println("0 - Sair");
                System.out.println("1 - Cadastrar Clientes");
                System.out.println("2 - Cadastrar Produtos");
                System.out.println("3 - Cadastrar Pedidos ");
                String resposta = scan.nextLine();

                if (resposta.equals("0")) {
                    System.exit(0);
                } else if (resposta.equals("1")) {
                    CadastraCliente();
                } else if (resposta.equals("2")) {
                    CadastraProdutos();
                } else if (resposta.equals("3")) {
                    CadastraPedidos();
                } else {
                    System.out.println("Opção inválida!");
                }
            } while (true);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void Funcionario() throws IOException {
        Scanner scan = new Scanner(System.in);
        try {

            do {
                System.out.flush();
                // Clear();
                System.out.println("Menu do Funcionario!");
                System.out.println("O que deseja fazer?");
                System.out.println("0 - Sair");
                String resposta = scan.nextLine();

                if (resposta.equals("0")) {
                    System.exit(0);
                } else {
                    System.out.println("Opção inválida!");
                }
            } while (true);
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
