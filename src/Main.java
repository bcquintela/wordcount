import structures.BinaryTree;
import structures.MaxHeap;

import java.io.IOException;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Por favor, introduza o caminho do ficheiro de texto:");
        String textFileLocation = scanner.next();

        int option = 1;
        while (option != 3) {
            printMenu();
            try {
                option = scanner.nextInt();
                switch (option) {
                    case 1: printWordCount(textFileLocation); break;
                    case 2: printLetterFrequency(textFileLocation); break;
                    case 3: exit(0);
                    default: System.out.println("Por favor, introduza um valor entre 1 e 3");
                }
            } catch (Exception ex) {
                System.out.println("Por favor, introduza um valor entre 1 e 3");
                scanner.next();
            }
        }
    }

    // Method to print the user menu.
    private static void printMenu() {
        String[] options = {"1- Contar as palavras do texto",
                "2- Listar n caracteres que ocorrem no texto",
                "3- Sair",
        };

        System.out.println();
        System.out.println("----------------------MENU------------------------");

        for (String option : options){
            System.out.println(option);
        }

        System.out.println("--------------------------------------------------");
        System.out.println();
        System.out.print("Introduza a sua opção: ");
    }

    // Method to print the word count results.
    private static void printWordCount(String filename) throws IOException {
        // Insert the words into the Binary Tree
        BinaryTree words = new BinaryTree();
        Parser.insertWords(filename, words);

        // Print the word count, traversing the Binary Tree in order
        System.out.println();
        System.out.println("Word count:");
        words.traverseInOrder(words.root);

        // Print the total number of words
        words.getTotalCount(words.root);
        System.out.println("Number of words: " + words.totalCount);
    }

    // Method to print the letter frequency results.
    private static void printLetterFrequency(String filename) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduza o número de caracteres a listar: ");
        int n = scanner.nextInt();

        // Insert the letters into the Priority Queue implemented with a Max Binary Heap
        MaxHeap heap = new MaxHeap();
        Parser.insertLetters(filename, heap);

        // Print the letter frequency, iterating over the Max Binary Heap N times
        System.out.println();
        System.out.println("Letter frequency:");
        heap.iterateOverHeap(n);
    }
}
