package Code_wars_rush;

import java.util.Random;

public class How_many_are_smaller_than_me_3kyu_BST { // not accepted, working only for distinct elements

    // AVL Node
    static class AvlNode
    {
        int key;
        AvlNode left;
        AvlNode right;
        int height;

        // size of the tree with the root = this node
        int size;
    };
    static int[] smallerToRight ;

    static int getHeight(AvlNode N)
    {
        if (N == null)
            return 0;

        return N.height;
    }

    static int size(AvlNode N)
    {
        if (N == null)
            return 0;

        return N.size;
    }

    // Allocating the new Node with the Key given ant two null-nodes (left and right)
    static AvlNode newNode(int key)
    {
        AvlNode node = new AvlNode();
        node.key   = key;
        node.left   = null;
        node.right  = null;

        // New node = leaf, not a tree for now
        node.height = 1;
        node.size = 1;
        return(node);
    }

    // Right rotation of the subtree rooted with node
    static AvlNode rightRotate(AvlNode node)
    {
        AvlNode leftChild = node.left;
        AvlNode tempChild = leftChild.right;

        // Here we're performing rotation
        leftChild.right = node;
        node.left = tempChild;

        // Here we're updating heights
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        leftChild.height = Math.max(getHeight(leftChild.left), getHeight(leftChild.right)) + 1;

        // Here we're updating sizes
        node.size = size(node.left) + size(node.right) + 1;
        leftChild.size = size(leftChild.left) + size(leftChild.right) + 1;

        // Returning the new root
        return leftChild;
    }

    // Left rotation of the subtree rooted with node
    static AvlNode leftRotate(AvlNode node)
    {
        AvlNode rightChild = node.right;
        AvlNode tempChild = rightChild.left;

        // Here we're performing rotation
        rightChild.left = node;
        node.right = tempChild;

        // Here we're updating heights
        node.height = Math.max(getHeight(node.left),
                getHeight(node.right)) + 1;
        rightChild.height = Math.max(getHeight(rightChild.left),
                getHeight(rightChild.right)) + 1;

        // Here we're updating sizes
        node.size = size(node.left) + size(node.right) + 1;
        rightChild.size = size(rightChild.left) + size(rightChild.right) + 1;

        // Returning the new root
        return rightChild;
    }

    // Calculates the balance factor of node N
    static int getBalance(AvlNode N)
    {
        if (N == null)
            return 0;

        return getHeight(N.left) - getHeight(N.right);
    }

    // Inserts a new key to the tree rooted with node. Calculates count of smaller elements for the new key
    static AvlNode insert(AvlNode node, int key,
                       int count)
    {
        // 1. Performing the normal BST rotation
        if (node == null)
            return(newNode(key));

        if (key < node.key)
            node.left  = insert(node.left, key, count);
        else
        {
            node.right = insert(node.right, key, count);

            // Updating count of smaller elements for this key
            smallerToRight[count] = smallerToRight[count] + size(node.left) + 1;
        }


        // 2.Updating height and size of this ancestor node
        node.height = Math.max(getHeight(node.left),
                getHeight(node.right)) + 1;
        node.size   = size(node.left) +
                size(node.right) + 1;

        // 3. GHere we get the balance factor of this ancestor node to check if this node became unbalanced one
        int balance = getBalance(node);

        // If this has happened -->> there are 4 diff.-cases

        // a. Left-Left Case
        if (balance > 1 && key < node.left.key)
            return rightRotate(node);

        // b. Right-Right Case
        if (balance < -1 && key > node.right.key)
            return leftRotate(node);

        // c. Left-Right Case
        if (balance > 1 && key > node.left.key)
        {
            node.left =  leftRotate(node.left);
            return rightRotate(node);
        }

        // d. Right-Left Case
        if (balance < -1 && key < node.right.key)
        {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        // Return the node's pointer
        return node;
    }

    // Here we're updating the smallerToRight array to contain count of smaller elements on right side of the array given.
    static void buildSmallerArray(int[] array)
    {
        int length = array.length;
        AvlNode root = null;

        smallerToRight = new int[length];

        // Initialize with 0s
        for (int i = 0; i < length; i++) {
            smallerToRight[i] = 0;
        }

        // Here we start from the rightmost element in the array given, inserting all elements one by one in
        // the AVL BST and calculating smaller-to-the-right elements
        for (int i = length - 1; i >= 0; i--) {
            root = insert(root, array[i], i);
        }
    }

    public static int[] smaller(int[] unsorted) {

        buildSmallerArray(unsorted);

        return smallerToRight;
    }

    // Some printing in one string
    static void printArray(int[] array)
    {
        int size = array.length;

        for (int j : array) {
            System.out.print(j + " ");
        }

        System.out.println();
    }

    // Driver code
    public static void main(String[] args)
    {
        int[] array = {10, 6, 15, 20, 30, 5, 7};

        array = new int[] {5, 4, 7, 9, 2, 4, 4, 5, 6};

        array = getRandomArray(100000000); // 0.1 billion for 26sec approximately

        long start = System.nanoTime();

        buildSmallerArray(array);

        long finish = System.nanoTime();

        System.out.println("\nПрошло времени в микросекундах : " + (finish - start) / 1000);

        // System.out.print("Resulting array: ");
        // printArray(smallerToRight);
    }

    public static int[] getRandomArray(int length) { // some checking
        Random random = new Random();

        int[] array = new int[length];

        for (int i = 0; i < length; i++) {
            array[i] = length - i;
        }

        return array;
    }
}
