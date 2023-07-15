package src.Algoritmos;

import src.Structure.*;


public class HeapSort extends Algoritmo {    
    @Override
    public void sort(Generic<?, ?>[] vetor, int tipoOrdenacao) {
        int n = vetor.length;
        long tempoinicial = System.currentTimeMillis();
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(vetor, n, i, tipoOrdenacao);
        }
    
        for (int i = n - 1; i >= 0; i--) {numComp++;
            Generic temp = vetor[0];
            vetor[0] = vetor[i];numTrocas++;
            vetor[i] = temp;numTrocas++;
    
            heapify(vetor, i, 0, tipoOrdenacao);
        }
        long tempofinal = System.currentTimeMillis();
        tempoDeExecucao = tempofinal - tempoinicial;
    }
    private void heapify(Generic[] vetor, int n, int i, int ordem) {
        int maior = i;
        int esquerda = 2 * i + 1;
        int direita = 2 * i + 2;
        numComp+=4;
        if ((ordem == 1 && esquerda < n && vetor[esquerda].getKey().compareTo(vetor[maior].getKey()) > 0) ||
                (ordem == 0 && esquerda < n && vetor[esquerda].getKey().compareTo(vetor[maior].getKey()) < 0)) {;
            maior = esquerda;numTrocas++;
        }
        numComp+=4;
        if ((ordem == 1 && direita < n && vetor[direita].getKey().compareTo(vetor[maior].getKey()) > 0) ||
                (ordem == 0 && direita < n && vetor[direita].getKey().compareTo(vetor[maior].getKey()) < 0)) {
            maior = direita;numTrocas++;
        }
        numComp++;
        if (maior != i) {
            Generic temp = vetor[i];
            vetor[i] = vetor[maior];numTrocas++;
            vetor[maior] = temp;numTrocas++;

            heapify(vetor, n, maior, ordem);
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

