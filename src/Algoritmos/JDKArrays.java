package src.Algoritmos;

import src.Structure.Generic;
import java.util.Arrays;
import java.util.Comparator;

public class JDKArrays extends Algoritmo{
    @Override
        public void sort(Generic<?, ?>[] vetor, int tipoOrdenacao) {
            Comparator<Generic> comparador = (p1, p2) -> p2.getKey().compareTo(p1.getKey());
            long tempoinicial = System.currentTimeMillis();
            Arrays.sort(vetor,comparador);
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
