package src.main;

import java.util.*;

public class App {


    public static void executar() {
        Scanner in = new Scanner(System.in);
        int op;
        do {
            menu();
            System.out.print("> Escolha uma opção: ");
            op = in.nextInt();

            switch (op) {

                case 0:
                    System.out.println("> Programa finalizado.");
                    break;
                case 1:
                    int[] a1 = cadastroArray();
                    selectionSort(a1);
                    break;
                case 2:
                    int[] a2 = cadastroArray();
                    bubbleSort(a2);
                    break;
                case 3:
                    int[] a3 = cadastroArray();
                    insertionSort(a3);
                    break;
                case 4:
                    int[] a4 = cadastroArray();

                    long tempoInicial = System.currentTimeMillis();
                    quickSort(a4, 0, a4.length - 1);
                    long tempoFinal = System.currentTimeMillis();
                    long tempoExecucao = tempoFinal - tempoInicial;
                    imprimirVetorOrdenado(a4);
                    System.out.println(" > Tempo de execução no Quick Sort: " + tempoExecucao + "ms");
                    break;
            }
        } while (op != 0);
    }


    public static void menu() {
        System.out.println("\n@ MENU @ ");
        System.out.println("[0] Encerrar");
        System.out.println("[1] Análise de Selection Sort");
        System.out.println("[2] Análise de Bubble Sort");
        System.out.println("[3] Análise de Insertion Sort");
        System.out.println("[4] Análise de Quick Sort");
    }


    public static int[] cadastroArray() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o tamanho do array: ");
        int tam = sc.nextInt();

        int[] array = new int[tam];
        System.out.println("Digite os valores do array: ");
        for (int i = 0; i < tam; i++) {
            array[i] = sc.nextInt();
        }
        return array;
    }


    public static void insertionSort(int[] array) {
        long tempoInicial = System.currentTimeMillis();

        System.out.println(" @ INSERTION SORT @ ");
        System.out.println(" > Vetor Original: ");
        for (int i = 0; i < array.length; i++) {
            System.out.println(" > Indice [" + i + "] " + array[i]);
        }

        int cont = 0;
        for (int i = 1; i < array.length; i++) {
            int j = i;
            while (j > 0 && array[j] < array[j - 1]) {
                int aux = array[j];
                array[j] = array[j - 1];
                array[j - 1] = aux;
                j -= 1;
                cont++;
            }
        }
        System.out.println("\n > Vetor Ordenado: ");
        for (int i = 0; i < array.length; i++) {
            System.out.println(" > Indice [" + i + "] " + array[i]);
        }
        System.out.println("\n > Numero de trocas no Insertion Sort: " + cont);
        long tempoFinal = System.currentTimeMillis();
        long mediaFinal = tempoFinal - tempoInicial;
        System.out.println(" > Tempo de execução no Insertion Sort: " + mediaFinal + "ms");
    }


    public static void bubbleSort(int[] array) {
        System.out.println(" @ BUBBLE SORT @ ");
        System.out.println(" > Vetor Original: ");
        for (int i = 0; i < array.length; i++) {
            System.out.println(" > Indice [" + i + "] " + array[i]);
        }


        int cont = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int auxiliar = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = auxiliar;
                    cont++;
                }
            }
        }

        System.out.println("\n > Vetor Ordenado");
        for (int i = 0; i < array.length; i++) {
            System.out.println(" > Indice [" + i + "] " + array[i]);
        }
        System.out.println("\n > Numero de trocas no Bubble Sort: " + cont);
    }


    public static void selectionSort(int[] array) {
        long tempoInicial = System.currentTimeMillis();

        System.out.println(" @ SELECTION SORT @ ");
        System.out.println(" > Vetor Original: ");
        for (int i = 0; i < array.length; i++) {
            System.out.println(" > Indice [" + i + "] " + array[i]);
        }

        int cont = 0;
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
                cont++;
            }
        }

        System.out.println("\n > Vetor Ordenado: ");
        for (int i = 0; i < array.length; i++) {
            System.out.println(" > Indice [" + i + "] " + array[i]);
        }

        System.out.println("\n > Numero de trocas no Selection Sort: " + cont);
        long tempoFinal = System.currentTimeMillis();
        long tempoExecucao = tempoFinal - tempoInicial;
        System.out.println(" > Tempo de execução no Selection Sort: " + tempoExecucao + "ns");
    }


    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int p = particao(array, low, high);
            quickSort(array, low, p - 1);
            quickSort(array, p + 1, high);
        }
    }

    public static void imprimirVetorOrdenado(int[] array) {
        System.out.println("\n > Vetor Ordenado: ");
        for (int i = 0; i < array.length; i++) {
            System.out.println(" > Indice [" + i + "] " + array[i]);
        }
    }

    public static int particao(int[] array, int low, int high) {
        int meio = low + (high - low) / 2;
        int pivo = array[meio];

        // Trocar o pivô com o último elemento
        int aux = array[meio];
        array[meio] = array[high];
        array[high] = aux;

        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j] < pivo) {
                i++;
                aux = array[i];
                array[i] = array[j];
                array[j] = aux;
            }
        }

        aux = array[i + 1];
        array[i + 1] = array[high];
        array[high] = aux;

        return i + 1;
    }
}