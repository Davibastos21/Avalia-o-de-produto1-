import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=============================================");
        System.out.println("Análise de Algoritmos de Ordenação");
        System.out.println("=============================================");
        
        try {
            runSingleSort(scanner);
        } catch (IOException e) {
            System.err.println("Ocorreu um erro de I/O: " + e.getMessage());
            e.printStackTrace();
        }
        scanner.close();
    }

    private static void runSingleSort(Scanner scanner) throws IOException {
        System.out.println("\nEscolha o algoritmo de ordenação:");
        System.out.println("1. Bubble Sort");
        System.out.println("2. Insertion Sort");
        System.out.println("3. Selection Sort");
        System.out.println("4. Merge Sort");
        System.out.println("5. Quick Sort");
        System.out.println("6. Heap Sort");
        System.out.print("Sua escolha: ");
        int algoChoice = scanner.nextInt();
        scanner.nextLine();

        System.out.print("\nDigite a quantidade de números a serem lidos do arquivo: ");
        int count = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Digite o nome do arquivo de entrada (ex: dados.txt): ");
        String inputFile = scanner.nextLine();

        System.out.print("Digite o nome do arquivo de saída (ex: saida.txt): ");
        String outputFile = scanner.nextLine();

        System.out.println("\nLendo o arquivo e iniciando a ordenação...");
        int[] numbers = FileHandler.readNumbers(inputFile, count);

        long startTime = System.currentTimeMillis();

        switch (algoChoice) {
            case 1: SortingAlgorithms.bubbleSort(numbers); break;
            case 2: SortingAlgorithms.insertionSort(numbers); break;
            case 3: SortingAlgorithms.selectionSort(numbers); break;
            case 4: SortingAlgorithms.mergeSort(numbers); break;
            case 5: SortingAlgorithms.quickSort(numbers); break;
            case 6: SortingAlgorithms.heapSort(numbers); break;
            default: System.out.println("Algoritmo inválido."); return;
        }

        long endTime = System.currentTimeMillis();
        
        FileHandler.writeNumbers(outputFile, numbers);
        
        System.out.println("\n---------------------------------------------");
        System.out.println("Ordenação concluída!");
        System.out.println("Tempo de execução: " + (endTime - startTime) + " ms");
        System.out.println("Array ordenado foi salvo em: " + outputFile);
        System.out.println("---------------------------------------------");
    }
}
