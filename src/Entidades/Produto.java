package Entidades;

public class Produto {
    private int produtoId;
    private String nome;
    private Marca marca;
    private double preco;

    public Produto(String nome, Marca marca) {
        this.nome = nome;
        this.marca = marca;
    }

    public Produto(int id, String nome, Marca marca, double preco) {
        this.produtoId = id;
        this.nome = nome;
        this.marca = marca;
        this.preco = preco;
    }

    public int getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(int produtoId) {
        this.produtoId = produtoId;
    }

    public String getNome() {
        return nome;
    }

    public String setNome(String nome) {
        // A informação é sempre armazenada em LowerCase.
        return nome.toLowerCase();
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "produtoId=" + produtoId +
                ", nome='" + nome + '\'' +
                ", marca=" + marca.getNome() +
                ", preco=" + preco +
                '}';
    }
}