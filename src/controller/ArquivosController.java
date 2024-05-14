package controller;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ArquivosController implements IArquivosController {
    @Override
    public void readDir(String path) throws IOException {
        File dir = new File(path);
        if (dir.exists() && dir.isDirectory()) {
            File[] files = dir.listFiles();
            for (File f : files) {
                if (f.isFile()) {
                    System.out.println("     \t" + f.getName());
                } else {
                    System.out.println("<DIR>\t" + f.getName());
                }
            }
        } else {
            throw new IOException("Diretório inválido");
        }
    }

    @Override
    public void createFile(String path, String nome) throws IOException {
        File dir = new File(path);
        File arq = new File(path, nome );
        if (dir.exists() && dir.isDirectory()) {
            boolean exist = arq.exists();
            String conteudo = geraTxt();

            FileWriter fileWriter = new FileWriter(arq, exist);
            PrintWriter print = new PrintWriter(fileWriter);
            print.write(conteudo);
            print.flush();
            print.close();
            fileWriter.close();
        } else {
            throw new IOException("Diretório Inválido");
        }


    }

    private String geraTxt() {
        StringBuilder builder = new StringBuilder();
        String linha = "";
        while (!linha.equalsIgnoreCase("fim")) {
            linha = JOptionPane.showInputDialog(null, "Digite uma Frase",
                                        "Entrada de texto", JOptionPane.INFORMATION_MESSAGE);
            if (!linha.equalsIgnoreCase("fim")){
                builder.append(linha).append("\n");
            }

        }
        return builder.toString();
    }

    @Override
    public void readFile(String path, String nome) throws IOException {

    }

    @Override
    public void openFile(String path, String nome) throws IOException {

    }
}
