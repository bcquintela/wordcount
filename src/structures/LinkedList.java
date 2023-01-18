package structures;

// Class that represents a Linked List.
public class LinkedList {

    Node head; // head of list
    int size; // size of list

    // Linked list constructor
    LinkedList() {
        size = 0;
    }

    // Linked list Node.
    // This inner class is made static so that main() can access it.
    static class Node {

        int data;
        Node next;

        // Node constructor
        Node(int d)
        {
            data = d;
            next = null;
        }
    }

    // Method to insert a new node.
    public static void insert(LinkedList list, int data) {
        list.size++;

        // Create a new node with given data
        Node newNode = new Node(data);

        // If the Linked List is empty, then make the new node as head
        if (list.head == null) {
            list.head = newNode;
        }
        else {
            // Else traverse till the last node and insert the newNode there
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }

            // Insert the newNode at last node
            last.next = newNode;
        }
    }

    // Method to print the LinkedList.
    public static void printList(LinkedList list) {
        Node currNode = list.head;

        // Traverse through the LinkedList
        while (currNode != null) {
            // Print the data at current node
            System.out.print(currNode.data + ", ");

            // Go to next node
            currNode = currNode.next;
        }
    }
}
