package Entidades;

import Interfaces.DAO;

import java.util.HashSet;

public class ProdutoDAO implements DAO {

    HashSet<Produto> produtos;
    private int contadorId = 0;

    public ProdutoDAO() {
        produtos = new HashSet<>();
    }

    @Override
    public boolean cadastrar(String nome) {
        return false;
    }

    public boolean cadastrar(String nome, Marca marca, double preco) {
        Produto p = new Produto(++contadorId, nome, marca, preco);
        return produtos.add(p);
    }

    @Override
    public Object selecionar(String nome) {
        for (Produto p : produtos) {
            if (p.getNome().equalsIgnoreCase(nome)) {
                return p;
            }
        }
        return null;
    }

    public HashSet<Produto> selecionarTodos() {
        return (HashSet<Produto>) produtos.clone();
    }

    @Override
    public boolean alterar(String antigoNome, String novoNome) {
        Produto p = (Produto) selecionar(antigoNome);
        if (p != null) {
            p.setNome(novoNome);
            return true;
        }
        return false;
    }

    @Override
    public boolean remover(String nome) {
        Produto p = (Produto) selecionar(nome);
        if (p != null) {
            return produtos.remove(p);
        }
        return false;
    }

    public boolean existeProdutoComMarca(Marca m) {
        for (Produto p : produtos) {
            if (p.getMarca() == m) {
                return true;
            }
        }
        return false;
    }

    public boolean existe(String nome, Marca m) {
        for (Produto p : produtos) {
            if (p.getNome().equalsIgnoreCase(nome) && p.getMarca() == m) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "ProdutoDAO{" +
                "produtos=" + produtos +
                '}';
    }
}