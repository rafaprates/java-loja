package Telas;

import javax.swing.*;

public abstract class TelaGerenciamento {
    public static int telaGerenciarProdutos() {
        try {
            return Integer.parseInt(
                    JOptionPane.showInputDialog("O que gostaria de fazer?\n" +
                            "1 - Cadastrar novo produto\n" +
                            "2 - Selecionar produto já existente\n" +
                            "3 - Alterar produto já existente\n" +
                            "4 - Remover produto\n" +
                            "0 - Retornar ao menu anterior")
            );
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "Opção inválida");
            return 0;
        }
    }

    public static int telaGerenciarMarcas() {
        try {
            return Integer.parseInt(
                    JOptionPane.showInputDialog("O que gostaria de fazer?\n" +
                            "1 - Cadastrar nova marca\n" +
                            "2 - Selecionar marca já existente\n" +
                            "3 - Alterar marca já existente\n" +
                            "4 - Remover marcas\n" +
                            "0 - Retornar ao menu anterior")
            );
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "Opção inválida");
            return 0;
        }
    }
}
