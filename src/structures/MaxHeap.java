package structures;

// Class that represents a Max Binary Heap.
public class MaxHeap {

    static char []H = new char[500];
    public static int size = -1;

    // Method to return the index of the parent node of a given node.
    static int parent(int i) {
        return (i - 1) / 2;
    }

    // Method to return the index of the left child of the given node.
    static int leftChild(int i) {
        return ((2 * i) + 1);
    }

    // Method to return the index of the right child of the given node.
    static int rightChild(int i) {
        return ((2 * i) + 2);
    }

    // Method to shift up the node in order to maintain the heap property.
    static void shiftUp(int i) {
        while (i > 0 &&
                H[parent(i)] < H[i])
        {
            // Swap parent and current node
            swap(parent(i), i);

            // Update i to parent of i
            i = parent(i);
        }
    }

    // Method to shift down the node in order to maintain the heap property.
    static void shiftDown(int i) {
        int maxIndex = i;

        // Left Child
        int l = leftChild(i);

        if (l <= size &&
                H[l] > H[maxIndex])
        {
            maxIndex = l;
        }

        // Right Child
        int r = rightChild(i);

        if (r <= size &&
                H[r] > H[maxIndex])
        {
            maxIndex = r;
        }

        // If i not same as maxIndex
        if (i != maxIndex)
        {
            swap(i, maxIndex);
            shiftDown(maxIndex);
        }
    }

    // Method to insert a new element in the Binary Heap.
    public void insert(char c) {
        size = size + 1;
        H[size] = c;

        // Shift Up to maintain heap property
        shiftUp(size);
    }

    // Method to extract the element with maximum priority.
    static void extractMax() {
        // Replace the value at the root with the last leaf
        H[0] = H[size];
        size = size - 1;

        // Shift down the replaced element to maintain the heap property
        shiftDown(0);
    }

    // Method to get value of the current maximum element.
    public static char getMax() {
        return H[0];
    }

    // Method to remove the element located at given index.
    private static void remove(int i) {
        H[i] = (char) (getMax() + 1);

        // Shift the node to the root of the heap
        shiftUp(i);

        // Extract the node
        extractMax();
    }

    // Method to swap two nodes.
    static void swap(int i, int j) {
        char temp= H[i];
        H[i] = H[j];
        H[j] = temp;
    }

    // Method to remove the nodes containing a given letter.
    public static void removeNodes(char c) {
        int i = 0;

        while(i <= size) {
            if(H[i] == c) {
                remove(i);
                i=0;
            }
            else {
                i++;
            }
        }
    }

    // Method to count the nodes containing a given letter.
    public int countNodes(char c) {
        int i = 0;
        int count = 0;

        while(i <= size) {
            if(c == H[i]) {
                count++;
            }
            i++;
        }

        return count;
    }

    // Method to iterate over the Binary Heap and print the frequencies.
    public void iterateOverHeap() {
        int origSize = size;

        while(size > 0) {
            char c = getMax();
            int letterCount = countNodes(c);

            System.out.println(MaxHeap.getMax() + ": " + letterCount + " (fr=" +
                    String.format("%.1f", (float) (letterCount * 100) / origSize) + "%)");
            MaxHeap.removeNodes(c);
        }
    }
}
