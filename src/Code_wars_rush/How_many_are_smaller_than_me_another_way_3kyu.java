package Code_wars_rush;

import java.util.Arrays;

public class How_many_are_smaller_than_me_another_way_3kyu { // accepted on codewars.com

    static class Node {
        int value;
        Node left, right;

        int elementFreq; // denotes number of times (frequency) an element has occurred.

        int lCount; // denotes the number of nodes on left side of the node encountered so far.

        public Node(int value) {

            this.value = value;
            left = null;
            right = null;

            elementFreq = 1;

            lCount = 0;
        }
    }

    static class BST {

        Node root;

        public BST(Node root) {
            this.root = root;
        }

        public int insert(Node node) { // Here we place the elements in the BST at its right position and returns the quantity of elements in BST
            // that are smaller than the element to be inserted

            Node currRoot = this.root;

            int counter = 0;

            Node prevRoot = currRoot;

            while (currRoot != null) {

                prevRoot = currRoot; // keeps the pointer on a previous root

                if (node.value > currRoot.value) { // Here we calculate the number of elements which are less than the current Node value.

                    counter += currRoot.elementFreq + currRoot.lCount;

                    currRoot = currRoot.right;
                }
                else if (node.value < currRoot.value) {

                    currRoot.lCount++;

                    currRoot = currRoot.left;
                }
                else {

                    prevRoot = currRoot;

                    prevRoot.elementFreq++;

                    break;
                }
            }

            if (prevRoot.value > node.value) {

                prevRoot.left = node;
            }
            else if (prevRoot.value < node.value) {

                prevRoot.right = node;
            }
            else {

                return counter + prevRoot.lCount;

            }

            return counter;
        }
    }

    public static void main(String[] args) {

        int[] array = new int[] {5, 4, 7, 9, 2, 4, 4, 5, 6};

        System.out.println(Arrays.toString(smaller(array)));
    }

    public static int[] smaller(int[] unsorted) {

        int length = unsorted.length;

        BST bst = new BST(new Node(unsorted[length - 1]));

        int[] result = new int[length];
        result[length - 1] = 0; // initial value to the right = 0 coz there are no elements to the right further

        for (int i = length - 2; i >= 0; i--) {

            result[i] = bst.insert(new Node(unsorted[i]));

        }

        return result;
    }

}
