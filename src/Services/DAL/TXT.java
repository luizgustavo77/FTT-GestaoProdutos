package Services.DAL;

import Services.Business.Business;
import java.io.*;
import java.util.*;

public class TXT {

    public List<String> Ler(String txt) throws IOException {
        List<String> retorno = new ArrayList<String>();
        File tempFile = new File(txt);
        boolean exists = tempFile.exists();

        if (!exists) {
            retorno = null;
        } else {
            FileReader file = null;
            try {
                file = new FileReader(txt);
                BufferedReader reader = new BufferedReader(file);
                String line = "";

                while ((line = reader.readLine()) != null) {
                    retorno.add(line);
                }
            } finally {
                file.close();
            }
        }
        return retorno;
    }

    public String GetId(String txt) throws IOException {
        String retorno = "1";
        FileReader file = null;
        try {
            file = new FileReader(txt);
            BufferedReader reader = new BufferedReader(file);
            String line = "";

            while ((line = reader.readLine()) != null) {
                String[] lista = line.split(";");
                retorno = lista[0];
            }

            if (retorno.equals("") || retorno.equals(null)) {
                retorno = "1";
            } else {
                retorno = String.valueOf(Integer.parseInt(retorno) + 1);
            }
        } finally {
            file.close();
        }

        return retorno;
    }

    public boolean Existe(String txt, String Id) throws IOException {
        boolean retorno = false;
        String linha = "";
        FileReader file = null;
        try {
            file = new FileReader(txt);
            BufferedReader reader = new BufferedReader(file);
            String line = "";

            while ((line = reader.readLine()) != null) {
                String[] lista = line.split(";");
                linha = lista[0];
                if (linha.equals(Id)) {
                    retorno = true;
                    break;
                }
            }
        } finally {
            file.close();
        }

        return retorno;
    }

    public boolean Gravar(String txt, String entidade) throws IOException {
        synchronized (this) {
            boolean retorno = false;
            PrintWriter file = null;
            String[] lista = entidade.split(";");
            String Id = lista[0];
            if (txt.contains("Auditoria") || !Existe(txt, Id)) {
                try {
                    if (entidade != null) {
                        file = new PrintWriter(new BufferedWriter(new FileWriter(txt, true)));
                        file.println(entidade);
                        file.flush();
                        retorno = true;
                    }
                } finally {
                    file.close();
                }
            }
            return retorno;
        }
    }

    public boolean Imprimir(String txt, String entidade) throws IOException {
        boolean retorno = false;
        FileWriter file = null;
        try {
            if (entidade != null) {
                file = new FileWriter(txt);
                file.write(entidade);
                retorno = true;
            }
        } finally {
            file.close();
        }

        return retorno;
    }

    public String Localiza(String txt, String Id) throws IOException {
        List<String> entidade = Ler(txt);
        String retorno = "";
        for (String item : entidade) {
            String[] ramificado = item.split(";");
            if (ramificado[0].equals(Id)) {
                retorno = item;
                break;
            }
        }
        return retorno;
    }

    public String ConsultaLogin(String cpf, String senha) throws IOException {
        String retorno = null;

        List<String> entidade = Ler("Funcionarios.txt");
        if (entidade != null) {
            String[] ramificado = new String[7];
            // String r = "";
            for (String item : entidade) {
                ramificado = item.split(";");

                if (ramificado[0].equals(cpf) && ramificado[6].equals(senha)) {
                    // System.out.println("UsuÃ¡rio Logado!");
                    retorno = ramificado[3];
                }
            }
        }
        return retorno;
    }

    public void Excluir(String txt, String cpf, String senha) throws FileNotFoundException, IOException {
        File inputFile = new File(txt);
        File tempFile = new File("myTemp" + txt);

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String perfil = ConsultaLogin(cpf, senha);

        if (perfil != null) {

            String lineToRemove = cpf + ";" + senha;
            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                // trim newline when comparing with lineToRemove
                String trimmedLine = currentLine.trim();
                if (trimmedLine.equals(lineToRemove)) {
                    continue;
                }
                writer.write(currentLine + System.getProperty("line.separator"));
            }
            writer.close();
            reader.close();
            inputFile.delete();
            boolean successful = tempFile.renameTo(inputFile);
        } else {

        }

    }

    public void modifyFile(String filePath, String oldString, String newString) {
        File fileToBeModified = new File(filePath);

        String oldContent = "";

        BufferedReader reader = null;

        FileWriter writer = null;

        try {
            reader = new BufferedReader(new FileReader(fileToBeModified));

            // Reading all the lines of input text file into oldContent
            String line = reader.readLine();

            while (line != null) {
                oldContent = oldContent + line + System.lineSeparator();

                line = reader.readLine();
            }

            // Replacing oldString with newString in the oldContent
            String newContent = oldContent.replaceAll(oldString, newString);

            // Rewriting the input text file with newContent
            writer = new FileWriter(fileToBeModified);

            writer.write(newContent);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // Closing the resources

                reader.close();

                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
