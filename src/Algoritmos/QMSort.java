package src.Algoritmos;

import src.Structure.Generic;
import java.util.Arrays;

public class QMSort extends Algoritmo {
    QuickSort quick = new QuickSort();
    MergeSort merge = new MergeSort();

    @Override
    public void sort(Generic<?, ?>[] vetor, int tipoOrdenacao) {
        int T = (int) (vetor.length * 0.25);
        long tempoinicial = System.currentTimeMillis();

        QMSort(vetor, 0, vetor.length - 1, tipoOrdenacao, T);
        numComp = quick.getComp() + merge.getComp();
        numTrocas = quick.getTrocas() + merge.getTrocas();
        long tempofinal = System.currentTimeMillis();
        tempoDeExecucao = tempofinal - tempoinicial;

    }

    public void QMSort(Generic<?, ?>[] vetor, int inicio, int fim, int tipoOrdenacao, int T) {
        if (inicio < fim) {
            if (inicio + fim + 1 <= T) {
                quick.sort(Arrays.copyOfRange(vetor, inicio, fim + 1), tipoOrdenacao);
            } else {
                int meio = (inicio + fim) / 2;
                QMSort(vetor, inicio, meio, tipoOrdenacao, T);
                QMSort(vetor, meio + 1, fim, tipoOrdenacao, T);
                merge.merge(vetor, inicio, meio, fim, tipoOrdenacao);
            }
        }

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
