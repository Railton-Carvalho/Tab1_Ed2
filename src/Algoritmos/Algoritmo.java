package src.Algoritmos;

import src.Structure.Generic;
import src.Structure.Logs;

public abstract class Algoritmo implements Logs {//classe que define atributos e modulo comum a todos os algoritmos implementados.
    public long numTrocas = 0;// numero de trocas do algoritmo
    public long numComp = 0;// numero de comparações do algoritmo
    public long tempoDeExecucao = 0;// guarda o tempo de execução de cada algoritmo

    public abstract  void sort(Generic<?, ?>[] vetor, int tipoOrdenacao);// metodo comum e que todo alg vai precisar implementar da sua forma
}
