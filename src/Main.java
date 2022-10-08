import Entidades.MarcaDAO;
import Entidades.ProdutoDAO;
import Telas.TelaAcoes;

import javax.swing.*;

import static Telas.TelaGerenciamento.telaGerenciarMarcas;
import static Telas.TelaGerenciamento.telaGerenciarProdutos;
import static Telas.TelaInicio.TelaInicio;

public class Main {
    public static void main(String[] args) {

        MarcaDAO marcas = new MarcaDAO();
        ProdutoDAO produtos = new ProdutoDAO();

        int telaEscolhida = 0;
        int funcaoEscolhida;
        boolean continuar = true;
        while (continuar) {
            switch (telaEscolhida) {
                case 0: {
                    telaEscolhida = TelaInicio();
                    break;
                }
                case 1: {
                    funcaoEscolhida = telaGerenciarMarcas();
                    if (funcaoEscolhida == 1) {
                        TelaAcoes.cadastrarMarca(marcas);
                    } else if (funcaoEscolhida == 2) {
                        TelaAcoes.selecionarMarca(marcas);
                    } else if (funcaoEscolhida == 3) {
                        TelaAcoes.alterarMarca(marcas);
                    } else if (funcaoEscolhida == 4) {
                        TelaAcoes.excluirMarca(marcas, produtos);
                    } else if (funcaoEscolhida == 0) {
                        telaEscolhida = 0;
                    } else {
                        JOptionPane.showMessageDialog(null, "Opção inválida");
                    }
                    break;
                }
                case 2: {
                    funcaoEscolhida = telaGerenciarProdutos();
                    if (funcaoEscolhida == 1) {
                        TelaAcoes.cadastrarProduto(marcas, produtos);
                    } else if (funcaoEscolhida == 2) {
                        TelaAcoes.selecionarProduto(marcas, produtos);
                    } else if (funcaoEscolhida == 3) {
                        TelaAcoes.alterarProduto(marcas, produtos);
                    } else if (funcaoEscolhida == 4) {
                        TelaAcoes.excluirProduto(marcas, produtos);
                    } else if (funcaoEscolhida == 0) {
                        telaEscolhida = 0;
                    } else {
                        JOptionPane.showMessageDialog(null, "Opção inválida");
                    }
                    break;
                }
                case 3: {
                    TelaAcoes.procurarProdutos(produtos);
                    telaEscolhida = 0;
                    break;
                }
                case 9: {
                    continuar = false;
                    break;
                }
                default: {
                    JOptionPane.showMessageDialog(null, "Opção inválida");
                    telaEscolhida = 0;
                }
            }
        }

    }
}