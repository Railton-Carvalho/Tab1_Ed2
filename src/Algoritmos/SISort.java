package src.Algoritmos;
import src.Structure.*;
import java.util.Arrays;

public class SISort extends Algoritmo {
    public void ordenar(Generic[] vetor, int tipoOrdenacao, double percentual) {
        int size = vetor.length;
        int limite = (int) (size * (percentual / 100));
        Algoritmo s1 = new SelectSort();
        Algoritmo s2 = new SelectSort();
        Algoritmo i1 = new InsertSort();
        long tempoinicial = System.currentTimeMillis();
        s1.sort(Arrays.copyOfRange(vetor, 0, limite),tipoOrdenacao);
    
        s2.sort(Arrays.copyOfRange(vetor, size - limite, size), tipoOrdenacao);
        
        i1.sort(Arrays.copyOfRange(vetor,0, size), tipoOrdenacao);

        numTrocas = s1.getTrocas()+s2.getTrocas()+i1.getTrocas();
        numComp = s1.getComp()+s2.getComp()+i1.getComp();
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

    @Override
    public void sort(Generic<?, ?>[] vetor, int tipoOrdenacao) {
        ordenar(vetor, tipoOrdenacao, 20);
    }
}

