package src.Algoritmos;

import src.Structure.Generic;

public class SelectSort extends Algoritmo {
    //se tipoOrdenacao igual a 1 a ordem é crescente se igual a 0 é decresente
    public void sort(Generic<?, ?>[] vetor, int tipoOrdenacao) {
        long tempoinicial = System.currentTimeMillis();
        for (int i = 0; i < vetor.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < vetor.length; j++) {
                if (tipoOrdenacao == 1){
                    if (vetor[j].compareTo(vetor[min])<0) {
                        numComp++;
                        min = j;
                    }
                }else{
                    if (vetor[j].compareTo(vetor[min])>0) {
                        numComp++;
                        min = j;
                    }
                }
                //fazer um comparador ternario short 
            }
            Generic<?, ?> temp = vetor[min];
            numTrocas++;
            vetor[min] = vetor[i];
            numTrocas++;
            vetor[i] = temp;
            numTrocas++;
        }
        long tempofinal = System.currentTimeMillis();
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
