package Interfaces;

public interface DAO {
    public boolean cadastrar(String nome);
    public Object selecionar(String nome);
    public boolean alterar(String nomeObjeto, String novoNome);
    public boolean remover(String nome);
}