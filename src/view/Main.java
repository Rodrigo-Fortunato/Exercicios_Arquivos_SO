package view;

import controller.ArquivosController;
import controller.IArquivosController;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        IArquivosController arqController = new ArquivosController();
        String dirWin = "C:\\Windows";
        String path ="C:\\Users\\rodri\\Desktop";
        String nome = "Teste.csv";

        try {
//            arqController.readDir(dirWin);
            arqController.createFile(path,nome);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
