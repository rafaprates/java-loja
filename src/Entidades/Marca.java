package Entidades;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Marca {
    private int id;
    private String nome;
    private LocalDateTime dataCadastro;

    public Marca(String nome, int id) {
        this.id = id;
        setNome(nome);
        this.dataCadastro = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

//    public String setNome(String nome) {
//        // A informação é sempre armazenada em LowerCase.
//        return nome.toLowerCase();

    public void setNome(String nome) {
        this.nome = nome.toLowerCase();
    }
//    }

    public String getDataCadastro() {
        return dataCadastro.format(DateTimeFormatter.ofPattern("d/L/u"));
    }

    @Override
    public String toString() {
        return "Marca{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", dataCadastro=" + getDataCadastro() +
                '}';
    }
}