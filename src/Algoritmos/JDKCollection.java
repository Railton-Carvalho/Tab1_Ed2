package src.Algoritmos;

import src.IO.Produto;
import src.Structure.Generic;
import java.util.Collections;
import java.util.Comparator;
import java.util.Arrays;

public class JDKCollection extends Algoritmo{
    @Override
        public void sort(Generic<?, ?>[] vetor, int tipoOrdenacao) {
            Comparator<Generic> comparador = (p1, p2) -> p2.getKey().compareTo(p1.getKey());
            long tempoinicial = System.currentTimeMillis();
            Collections.sort(Arrays.asList(vetor),comparador);
            long tempofinal = System.currentTimeMillis();
            tempoDeExecucao = tempofinal-tempoinicial;
        }
    @Override
    public long getComp() {
        return numComp;
    }

    @Override
    public long getTrocas() {
        return numTrocas;
    }  
}
