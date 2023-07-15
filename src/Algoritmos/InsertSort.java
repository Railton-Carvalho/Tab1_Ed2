package src.Algoritmos;

import src.Structure.Generic;

public class InsertSort extends Algoritmo{
    @Override
    public void sort(Generic<?, ?>[] vetor,int tipoOrdenacao) {
        long tempoinicial = System.currentTimeMillis();
        for (int i = 1; i < vetor.length; i++) { 
            Generic<?, ?> temp = vetor[i];
            int j;
            numComp++;
            for (j = i - 1; j >= 0 && ((tipoOrdenacao == 1)? vetor[j].compareTo(temp) > 0:vetor[j].compareTo(temp)<0); j--) { numComp+=2;
                vetor[j+1] = vetor[j]; numTrocas++;
            }
            vetor[j+1] = temp; numTrocas++;
        } long tempofinal = System.currentTimeMillis();
        tempoDeExecucao = tempofinal - tempoinicial;
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
