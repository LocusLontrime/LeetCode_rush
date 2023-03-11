package JavaAlgos;

import java.util.ArrayList;
import java.util.List;

public class Tree {
    Node root;

    /**
     * обход в глубину
     */
    public boolean exist(int value) {
        if (root != null) {
            Node node = findDfs(root, value);
            return node != null;
        }
        return false;
    }

    // dfs
    private Node findDfs(Node node, int value) {
        if (node.value == value) {
            return node;
        } else {
            for (Node child : node.children) {
                Node result = findDfs(child, value);
                if (result != null) {
                    return result;
                }
            }
        }
        return null;
    }

    /**
     * обход в ширину
     */
    private Node findBfs(int value){
        List<Node> line = new ArrayList<>();
        line.add(root);
        while (line.size()>0){
            List<Node> nextLine = new ArrayList<>();
            for (Node node: line){
                if (node.value==value){
                    return node;
                }
                nextLine.addAll(node.children);
            }
            line = nextLine;
        }
        return null;
    }

    public static class Node {
        int value;
        List<Node> children;
    }
}