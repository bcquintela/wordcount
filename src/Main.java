import structures.BinaryTree;
import structures.MaxHeap;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        // Set the filename, including location
        String filename = "text.txt";

        // Insert the words into the Binary Tree
        BinaryTree words = new BinaryTree();
        Parser.insertWords(filename, words);

        // Insert the letters into the Priority Queue implemented with a Max Binary Heap
        MaxHeap heap = new MaxHeap();
        Parser.insertLetters(filename, heap);

        // Print the word count, traversing the Binary Tree in order
        System.out.println("Word count:");
        words.traverseInOrder(words.root);

        // Print the total number of words
        words.getTotalCount(words.root);
        System.out.println("Number of words: " + words.totalCount);

        System.out.println();

        // Print the letter frequency, iterating over the Max Binary Heap
        System.out.println("Letter frequency:");
        heap.iterateOverHeap();
    }
}
