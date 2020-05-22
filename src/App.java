import java.util.Scanner;

import Common.Util.Login;

public class App {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        Login login = new Login();
        String resposta = "";
        boolean retorno = true;
        System.out.println("Bem-vindo!");

        while (retorno) {
            System.out.println("O que deseja fazer?");
            System.out.println("0 - Sair");
            System.out.println("1 - Login");
            resposta = scan.nextLine();

            if (resposta.equals("0")) {
                retorno = true;
                System.exit(0);
            } else if (resposta.equals("1")) {
                retorno = true;
                login.FazLogin();
            } else {
                System.out.println("Opção Inválida!");
            }
        }
    }
}
