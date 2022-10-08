package Entidades;

import Interfaces.DAO;

import java.util.HashSet;

public class MarcaDAO implements DAO {
    // HashSet permite apenas objetos diferentes.
    HashSet<Marca> marcas;
    private int contadorId = 0;

    public MarcaDAO() {
        marcas = new HashSet<>();
    }
    @Override
    public boolean cadastrar(String nome) {
        return marcas.add(new Marca(nome, ++contadorId));
    }

    @Override
    public Object selecionar(String nome) {
        for(Marca marca : marcas) {
            if (marca.getNome().equalsIgnoreCase(nome)) {
                return marca;
            }
        }
        return null;
    }

    @Override
    public boolean alterar(String antigoNome, String novoNome) {
        Marca m = (Marca) selecionar(antigoNome);
        if (m != null) {
            m.setNome(novoNome);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean remover(String nome) {
        Marca m = (Marca) selecionar(nome);
        if (m != null) {
            return marcas.remove(m);
        }
        return false;
    }

    public boolean existe(String nome) {
        for (Marca m : marcas) {
            if (m.getNome().equalsIgnoreCase(nome)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "MarcaDAO{" +
                "marcas=" + marcas.toString() +
                '}';
    }
}