package Telas;

import javax.swing.*;

public class TelaInicio {
    public static int TelaInicio() {
        try {
            return Integer.parseInt(JOptionPane.showInputDialog("Escolha uma opção\n" +
                    "1 - Gerenciar marcas\n" +
                    "2 - Gerenciar produtos\n" +
                    "3 - Pesquisar produtos\n" +
                    "9 - Sair do programa"));
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "Opção inválida");
            return 0;
        }
    }
}