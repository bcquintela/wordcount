import structures.BinaryTree;
import structures.MaxHeap;

import java.io.*;

// Class that represents a text file parser.
public class Parser {

    // Method to insert the words into a Binary Tree.
    static void insertWords(String filename, BinaryTree tree) throws IOException {
        File file = new File(filename);
        FileInputStream fileInputStream = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String line;
        int currentLine = 1;

        while((line = bufferedReader.readLine()) != null) {
            String[] words = line.toLowerCase().split("[\\pP\\s&&[^']]+");

            if(words.length != 0) {
                for(String word : words) {
                    tree.add(word, currentLine);
                }
            }

            currentLine++;
        }
    }

    // Method to insert the letter into a Priority Queue implemented with a Max Binary Heap.
    static void insertLetters(String filename, MaxHeap heap) throws IOException {
        File file = new File(filename);
        FileInputStream fileInputStream = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String line;

        while((line = bufferedReader.readLine()) != null) {
            String[] words = line.toLowerCase().split("[\\pP\\s&&[^']]+");

            for(String word : words) {
                for (int i = 0; i < word.length(); i++) {
                    char c = word.charAt(i);

                    heap.insert(c);
                }
            }
        }
    }
}
