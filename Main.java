import java.io.IOException;
import java.util.Scanner;

import src.Algoritmos.*;
import src.Structure.Generic;
import src.IO.*;

public class Main {
  //DISCIPLINA: ESTRUTURA DE DADOS II   PRIMEIRA ATIVIDADE PRATICA 
  // ALUNO: Railton Rosa de Carvalho
  //classe responvel pela interação com o usuario além de gerar um LOG de cada algoritmo para analise.
  public static void main(String[] args) throws IOException {
    int tamanho;
    String path = "C:/Users/railt/Documents/UFMA/ED2 - DALLYSON[/Tab01-ED2/src/IO/base.csv";
    Scanner input = new Scanner(System.in);

    System.out.print("Informe o tamanho da entrada: ");
    tamanho = input.nextInt();

    System.out.println("------------------------");
    Generic<?, ?>[] entrada = new Generic[tamanho];
    menu(entrada, tamanho, path);

  }

  public static void log(String name, Algoritmo alg, String Tipo, long size, int tipoOrdenacao) {
    // Metodo reponsavel por imprimir o resumo de execução de cada algoritmo
    String tiponame = "";
    switch (tipoOrdenacao) {
      case 0:
        tiponame = "DES";
        break;
      case 1:
        tiponame = "ASC";
        break;
      default:
        break;
    }
    System.out.println("=> " + name + " <=");
    System.out.print(" | CompS = " + alg.getComp());
    System.out.print(" | Trocas = " + alg.getTrocas());
    System.out.print(" | Entrada: " + size);
    System.out.print(" | Chave: " + Tipo);
    System.out.print(" | Tempo: " + alg.tempoDeExecucao + " ms");
    System.out.print(" | Ordem: " + tiponame);
    System.out.println("\n");
  }

  public static void menu(Generic[] vetor, int tamanho, String path) throws IOException {
    //classe responsavel pelo menu
    Algoritmo alg;
    int escolha;
    int tipoOrdenacao;
    String tipoChave = "";
    Scanner input = new Scanner(System.in);
    Produto[] produtos = LoaderObject.Load(tamanho);
    boolean flag = true;
    while (flag) {
      System.out.println("------------------------------------");
      System.out.println("Escolha um tipo de dado: ");
      System.out.println("1. STRING");
      System.out.println("2. DOUBLE");
      System.out.println("3. INTEGER");
      System.out.println("4. DEBUGGER");
      escolha = input.nextInt();
      switch (escolha) {
        case 1:
          for (int j = 0; j < tamanho; j++) {
            vetor[j] = new Generic<String, Produto>(produtos[j].getId(), produtos[j]);
          }
          tipoChave = "String";
          break;
        case 2:
          for (int j = 0; j < tamanho; j++) {
            vetor[j] = new Generic<Double, Produto>(produtos[j].getPreço(), produtos[j]);
          }
          tipoChave = "Double";
          break;
        case 3:
          for (int j = 0; j < tamanho; j++) {
            vetor[j] = new Generic<Integer, Produto>(produtos[j].getQuantidade(), produtos[j]);
          }
          tipoChave = "Integer";
          break;
        case 4:
          for (int i = 1; i < 10; i++) {
            Debugger(i, path);
          }
          break;
        default:
          flag = false;
          break;
      }
      System.out.println("Escolha o Algoritmo para ordenar: ");
      System.out.println("1. SelectSort");
      System.out.println("2. InsertSort");
      System.out.println("3. QuickSort");
      System.out.println("4. MergeSort");
      System.out.println("5. HeapSort");
      System.out.println("6. QMSort");
      System.out.println("7. SISort");
      System.out.println("8. JDKCollection");
      System.out.println("9. JDKArrays");
      escolha = input.nextInt();
      System.out.println("Escolha a ordem[1:asc | 0: desc] ");
      tipoOrdenacao = input.nextInt();
      if (tipoOrdenacao == 1) {
        tipoOrdenacao = 1;
      } else if (tipoOrdenacao == 0) {
        tipoOrdenacao = 0;
      } else {
        tipoOrdenacao = 1;// ordenação padrão caso o usuario informe um valor invalido
      }
      switch (escolha) {
        case 1:
          alg = new SelectSort();
          alg.sort(vetor, tipoOrdenacao);
          log("SelectSort", alg, tipoChave, tamanho, tipoOrdenacao);
          break;
        case 2:
          alg = new InsertSort();
          alg.sort(vetor, tipoOrdenacao);
          log("InsertSort", alg, tipoChave, tamanho, tipoOrdenacao);
          break;
        case 3:
          alg = new QuickSort();
          alg.sort(vetor, tipoOrdenacao);
          log("QuickSort", alg, tipoChave, tamanho, tipoOrdenacao);
          break;
        case 4:
          alg = new MergeSort();
          alg.sort(vetor, tipoOrdenacao);
          log("MergeSort", alg, tipoChave, tamanho, tipoOrdenacao);
          break;
        case 5:
          alg = new HeapSort();
          alg.sort(vetor, tipoOrdenacao);
          log("HeapSort", alg, tipoChave, tamanho, tipoOrdenacao);
          break;
        case 6:
          alg = new QMSort();
          alg.sort(vetor, tipoOrdenacao);
          log("QMSort", alg, tipoChave, tamanho, tipoOrdenacao);
          break;
        case 7:
          SISort alg1 = new SISort();
          alg1.ordenar(vetor, tipoOrdenacao, tipoOrdenacao);
          log("SISort", alg1, tipoChave, tamanho, tipoOrdenacao);
          break;
        case 8:
          alg = new JDKCollection();
          alg.sort(vetor, tipoOrdenacao);
          log("JDKCollection", alg, tipoChave, tamanho, tipoOrdenacao);
          break;
        case 9:
          alg = new JDKArrays();
          alg.sort(vetor, tipoOrdenacao);
          log("JDKArrays", alg, tipoChave, tamanho, tipoOrdenacao);
          break;
        default:
          break;
      }
    }
  }

  public static void Debugger(int algoritmo, String path) throws IOException {
    // metodo responsavel por gerar os casos de teste para cada algoritmo implementado no 3 tipos de chaves e ordens 
    String nomeAlg = "";
    int[] tamanhosdeEntrada = {1000,10000,100000};// vetor com os tamanhos das entradas dos testes.
    int[] ordens = { 1, 0 };// vetor com as ordens ,sendo 1 ASCEDENTE  e 0 DESCRECENTE.
    Algoritmo alg;
    switch (algoritmo) {
      case 1:
        alg = new SelectSort();
        nomeAlg = "SelectSort";
        break;
      case 2:
        alg = new InsertSort();
        nomeAlg = "InsertSort";
        break;
      case 3:
        alg = new QuickSort();
        nomeAlg = "QuickSort";
        break;
      case 4:
        alg = new MergeSort();
        nomeAlg = "MergeSort";
        break;
      case 5:
        alg = new HeapSort();
        nomeAlg = "HeapSort";
        break;
      case 6:
        alg = new QMSort();
        nomeAlg = "QMSort";
        break;
      case 7:
        alg = new SISort();
        nomeAlg = "SISort";
        break;
      case 8:
        alg = new JDKCollection();
        nomeAlg = "JDKCollections";
        break;
      case 9:
        alg = new JDKArrays();
        nomeAlg = "JDKArrays";
        break;
      default:
        alg = new JDKArrays();
        nomeAlg = "JDKArrays";
        break;
    }
    for (int tamanho : tamanhosdeEntrada) {
      System.out.println("*".repeat(35));
      System.out.println("ENTRADA DE TAMANHO: " + tamanho);
      for (int ordem : ordens) {
        Generic<?, ?>[] entrada = new Generic[tamanho];
        Produto[] produtos = LoaderObject.Load(tamanho);
        for (int j = 0; j < tamanho; j++) {
          entrada[j] = new Generic<Integer, Produto>(produtos[j].getQuantidade(), produtos[j]);
        }
        alg.sort(entrada, ordem);
        log(nomeAlg, alg, "Integer", tamanho, ordem);
        System.out.println("-".repeat(100));
        for (int j = 0; j < tamanho; j++) {
          entrada[j] = new Generic<Double, Produto>(produtos[j].getPreço(), produtos[j]);
        }
        alg.sort(entrada, ordem);
        log(nomeAlg, alg, "Double", tamanho, ordem);
        System.out.println("-".repeat(100));
        for (int j = 0; j < tamanho; j++) {
          entrada[j] = new Generic<String, Produto>(produtos[j].getId(), produtos[j]);
        }
        alg.sort(entrada, ordem);
        log(nomeAlg, alg, "String", tamanho, ordem);
        System.out.println("-".repeat(100));
      }
    }
  }
}
