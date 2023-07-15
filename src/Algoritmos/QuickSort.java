package src.Algoritmos;

import src.Structure.*;

public class QuickSort extends Algoritmo {
    
    @Override
    public void sort(Generic<?, ?>[] vetor, int tipoOrdenacao) {
        long tempoinicial = System.currentTimeMillis();
        quickSort(vetor, 0, vetor.length - 1, tipoOrdenacao);
        long tempofinal = System.currentTimeMillis();
        tempoDeExecucao = tempofinal - tempoinicial;
    }
    public void quickSort(Generic<?, ?>[] vetor, int esquerda, int direita, int tipoOrdenacao) {
        if (esquerda < direita) {
            int sentinela = particionar(vetor, esquerda, direita, tipoOrdenacao);
            quickSort(vetor, esquerda, sentinela - 1, tipoOrdenacao);
            quickSort(vetor, sentinela + 1, direita, tipoOrdenacao);
        }
    }

    public int particionar(Generic<?, ?>[] vetor, int esquerda, int direita, int tipoOrdenacao) {
        Generic<?, ?> pivor = vetor[direita];
        int i = esquerda - 1;
        numComp++;
        for (int j = esquerda; j < direita; j++) {
            if ((tipoOrdenacao == 1 && vetor[j].compareTo(pivor) <= 0) ||
            tipoOrdenacao == 0 && vetor[j].compareTo(pivor) >= 0) {numComp+=4;
            i++;
            Generic<?, ?> temp = vetor[i];
            vetor[i] = vetor[j];numTrocas++;
            vetor[j] = temp;numTrocas++;
            }
        }

        Generic<?, ?> temp = vetor[i + 1];
        vetor[i+1]=vetor[direita];numTrocas++;
        vetor[direita]=temp;numTrocas++;
        return i+1;
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
