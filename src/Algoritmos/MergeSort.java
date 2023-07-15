package src.Algoritmos;
import src.Structure.Generic;

public class MergeSort extends Algoritmo {

    @Override
    public void sort(Generic<?, ?>[] vetor, int tipoOrdenacao) {
        long tempoinicial = System.currentTimeMillis();
        mergeSort(vetor, 0, vetor.length - 1, tipoOrdenacao);  
        long tempofinal = System.currentTimeMillis();
        tempoDeExecucao = tempofinal - tempoinicial;
    }
    
    private void mergeSort(Generic[] vetor, int inicio, int fim, int ordem) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            mergeSort(vetor, inicio, meio, ordem);
            mergeSort(vetor, meio + 1, fim, ordem);
            merge(vetor, inicio, meio, fim, ordem);
            
        }
    }

    public void merge(Generic[] vetor, int inicio, int meio, int fim, int ordem) {
        int tamanhoEsquerda = meio - inicio + 1;
        int tamanhoDireita = fim - meio;

        Generic[] esquerda = new Generic[tamanhoEsquerda];
        Generic[] direita = new Generic[tamanhoDireita];

        for (int i = 0; i < tamanhoEsquerda; i++) {numComp++;
            esquerda[i] = vetor[inicio + i];numTrocas++;
        }
        for (int j = 0; j < tamanhoDireita; j++) {numComp++;
            direita[j] = vetor[meio + 1 + j];numTrocas++;
        }

        int i = 0, j = 0;
        int k = inicio;
        while (i < tamanhoEsquerda && j < tamanhoDireita) {numComp+=2;
            if ((ordem == 1 && esquerda[i].getKey().compareTo(direita[j].getKey()) <= 0) ||
                    (ordem == 0 && esquerda[i].getKey().compareTo(direita[j].getKey()) >= 0)) {numComp++;
                vetor[k] = esquerda[i];numTrocas++;
                i++;
            } else {
                numComp++;
                vetor[k] = direita[j];numTrocas++;
                j++;
            }
            k++;
        }
        numComp++;
        while (i < tamanhoEsquerda) {
            vetor[k] = esquerda[i];numTrocas++;
            i++;
            k++;
        }
        numComp++;
        while (j < tamanhoDireita) {
            vetor[k] = direita[j];numTrocas++;
            numComp++;
            j++;
            k++;
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