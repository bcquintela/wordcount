package structures;

// Class that represents a Binary Tree.
public class BinaryTree {

    public Node root; // root of tree
    public int totalCount; // total count of words

    // Binary Tree constructor
    public BinaryTree() {
        totalCount = 0;
    }

    // Method to add a new node.
    public void add(String value, int lineNumber) {
        root = addRecursive(root, value, lineNumber);
    }


    // Method to recursively add a new node.
    private Node addRecursive(Node current, String value, int lineNumber) {
        if (current == null) {
            return new Node(value, lineNumber);
        }

        if(value.equals(current.value)) {
            current.count++;
            LinkedList.insert(current.lines, lineNumber);
            return current;
        }

        int comp = value.compareTo(current.value);
        if (comp < 0) {
            current.left = addRecursive(current.left, value, lineNumber);
        }
        else {
            current.right = addRecursive(current.right, value, lineNumber);
        }

        return current;
    }


    // Method to traverse the tree in order.
    public void traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.left);
            print(node);
            traverseInOrder(node.right);
        }
    }

    // Method to print the node contents.
    private void print(Node node) {
        String termTime = node.count == 1 ? " time" : " times";
        String termLine = node.lines.size == 1 ? " line " : " lines ";
        System.out.print("The word \"" + node.value + "\" occurs " + node.count + termTime +
                " in" + termLine);
        LinkedList.printList(node.lines);
        System.out.println();
    }

    // Method to get the total count of words.
    public void getTotalCount(Node node) {
        if (node != null) {
            getTotalCount(node.left);
            totalCount += node.count;
            getTotalCount(node.right);
        }
    }

    // Class that represents a Node.
    static class Node {
        String value;
        int count;
        LinkedList lines;
        Node left;
        Node right;

        // Node constructor
        Node(String value, int lineNumber) {
            this.value = value;
            count = 1;
            lines = new LinkedList();
            LinkedList.insert(lines, lineNumber);
            right = null;
            left = null;
        }
    }
}
