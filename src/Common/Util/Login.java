package Common.Util;

import java.io.IOException;
import java.util.Scanner;

import Common.LoginDTO;
import Services.Business.Business;
import Services.DAL.TXT;

public class Login {

    public static boolean FazLogin() throws IOException {
        boolean sair = false;
        LoginDTO user = new LoginDTO();
        TXT DAL = new TXT();
        Business bll = new Business();
        String perfil = null;
        Scanner scan = new Scanner(System.in);
        System.out.println("**** LOGIN ****");
        System.out.println("Digite seu CPF");
        user.setCPF(scan.nextLine());
        System.out.println("Digite sua senha");
        user.setSENHA(scan.nextLine());

        perfil = DAL.ConsultaLogin(user.getCPF(), user.getSENHA());

        if (perfil != null) {
            if (perfil.equals("Vendedor")) {
                bll.Vendedor();
            } else if (perfil.equals("Gerente")) {
                bll.Gerente();
            } else if (perfil.equals("Funcionario")) {
                bll.Funcionario();
            }
        } else {
            System.out.println("Usuário e/ou senha incorretos!");
        }

        return sair;
    }
}
