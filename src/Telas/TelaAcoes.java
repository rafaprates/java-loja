package Telas;

import Entidades.Marca;
import Entidades.MarcaDAO;
import Entidades.Produto;
import Entidades.ProdutoDAO;
import Servicos.Pesquisa;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class TelaAcoes {

    public static void cadastrarMarca(MarcaDAO marcas) {
        String nomeMarca = JOptionPane.showInputDialog("Informe o nome da marca");

        if (marcas.existe(nomeMarca)) {
            JOptionPane.showMessageDialog(null, nomeMarca + " já está cadastrada");
        } else {
            marcas.cadastrar(nomeMarca);
            JOptionPane.showMessageDialog(null, nomeMarca + " foi cadastrada com sucesso");
        }
    }

    public static void selecionarMarca(MarcaDAO marcas) {
        String nomeMarca = JOptionPane.showInputDialog("Informe o nome da marca");

        if (marcas.existe(nomeMarca)) {
            Marca m = (Marca) marcas.selecionar(nomeMarca);
            JOptionPane.showMessageDialog(null, m.toString());
        } else {
            JOptionPane.showMessageDialog(null, nomeMarca + " não está cadastrada");
        }
    }

    public static void alterarMarca(MarcaDAO marcas) {
        String nomeMarca = JOptionPane.showInputDialog("Informe o nome da marca");
        if (marcas.existe(nomeMarca)) {
            String novoNome = JOptionPane.showInputDialog("Informe o novo nome da marca");
            if (marcas.existe(novoNome)) {
                JOptionPane.showMessageDialog(null, novoNome + " já está cadastrado");
            } else {
                marcas.alterar(nomeMarca, novoNome);
                JOptionPane.showMessageDialog(null, "alteração realizada com sucesso");
            }
        } else {
            JOptionPane.showMessageDialog(null, nomeMarca + " não está cadastrada");
        }
    }

    public static void excluirMarca(MarcaDAO marcas, ProdutoDAO produtos) {
        String nomeMarca = JOptionPane.showInputDialog("Informe o nome da marca");

        if (!marcas.existe(nomeMarca)) {
            JOptionPane.showMessageDialog(null, nomeMarca + " não está cadastrada");
            return;
        }

        Marca m = (Marca) marcas.selecionar(nomeMarca);
        if (produtos.existeProdutoComMarca(m)) {
            JOptionPane.showMessageDialog(null, "não é possível excluir marca " + m.getNome() +
                    ", pois ela está associada a algum produto.");
            return;
        }
        marcas.remover(nomeMarca);
        JOptionPane.showMessageDialog(null, nomeMarca + " foi removida com sucesso");
    }

    public static void cadastrarProduto(MarcaDAO marcas, ProdutoDAO produtos) {
        String nomeProduto = JOptionPane.showInputDialog("Informe o nome do produto");

        String nomeMarca = JOptionPane.showInputDialog("Informe o nome da marca");
        Marca m = (Marca) marcas.selecionar(nomeMarca);

        if (m == null) {
            JOptionPane.showMessageDialog(null, nomeMarca + " não está cadastrada");
            return;
        }

        if (produtos.existe(nomeProduto, m)) {
            JOptionPane.showMessageDialog(null, nomeProduto + " " + nomeMarca + " já está cadastrado");
            return;
        }

        try {
            double precoProduto = Double.parseDouble(JOptionPane.showInputDialog("Informe o preço do produto"));
            produtos.cadastrar(nomeProduto, m, precoProduto);
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "Preço com formato inválido");
        }
    }

    public static void alterarProduto(MarcaDAO marcas, ProdutoDAO produtos) {
        String nomeProduto = JOptionPane.showInputDialog("Informe o nome do produto");
        Produto p = (Produto) produtos.selecionar(nomeProduto);

        String nomeMarca = JOptionPane.showInputDialog("Informe o nome da marca");
        Marca m = (Marca) marcas.selecionar(nomeMarca);

        if (produtos.existe(nomeProduto, m)) {
            try {
                double novoValorProduto = Double.parseDouble(JOptionPane.showInputDialog("Informe o novo preço do produto"));
                p.setPreco(novoValorProduto);
                JOptionPane.showMessageDialog(null, nomeProduto + " " + nomeMarca + " alterado");
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "Preço com formato inválido");
            }
        } else {
            JOptionPane.showMessageDialog(null, nomeProduto + " " + nomeMarca + " não está cadastrado");
        }
    }

    public static void selecionarProduto(MarcaDAO marcas, ProdutoDAO produtos) {
        String nomeProduto = JOptionPane.showInputDialog("Informe o nome do produto");
        Produto p = (Produto) produtos.selecionar(nomeProduto);

        String nomeMarca = JOptionPane.showInputDialog("Informe o nome da marca");
        Marca m = (Marca) marcas.selecionar(nomeMarca);

        if (produtos.existe(nomeProduto, m)) {
            JOptionPane.showMessageDialog(null, p.toString());
        } else {
            JOptionPane.showMessageDialog(null, nomeProduto + " " + nomeMarca + " não está cadastrado");
        }
    }

    public static void excluirProduto(MarcaDAO marcas, ProdutoDAO produtos) {
        String nomeProduto = JOptionPane.showInputDialog("Informe o nome do produto");
        String nomeMarca = JOptionPane.showInputDialog("Informe o nome da marca");
        Marca m = (Marca) marcas.selecionar(nomeMarca);

        if (produtos.existe(nomeProduto, m)) {
            produtos.remover(nomeProduto);
            JOptionPane.showMessageDialog(null, nomeProduto + " " + nomeMarca + " foi removido com sucesso");
        } else {
            JOptionPane.showMessageDialog(null, nomeProduto + " " + nomeMarca + " não está cadastrado");
        }
    }

    public static void procurarProdutos(ProdutoDAO produtos) {
        String termo = JOptionPane.showInputDialog("Informe o termo para procurar");
        HashSet<Produto> todosProdutos = produtos.selecionarTodos();
        List<String> todosNomesProdutos = new ArrayList<String>();

        for (Produto p : todosProdutos) {
            todosNomesProdutos.add(p.getNome());
        }

        List<String> nomesProduto = Pesquisa.pesquisar(termo, todosNomesProdutos);
        String textoResultado = "";
        for (String nome : nomesProduto) {
            textoResultado = textoResultado + produtos.selecionar(nome).toString() + "\n";
        }
        JOptionPane.showMessageDialog(null, textoResultado);
    }
}