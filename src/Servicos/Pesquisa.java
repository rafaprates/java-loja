package Servicos;

import java.util.ArrayList;
import java.util.List;

public class Pesquisa {
    public static List<String> pesquisar(String termo, List<String> dicionario) {
        List<String> palavrasEncontradas = new ArrayList<>();
        for (String palavra : dicionario) {
            if (palavra.contains(termo)) {
                palavrasEncontradas.add(palavra);
            }
        }
        return palavrasEncontradas;
    }
}