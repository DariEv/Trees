import javafx.scene.Parent;

/**
 * Created by Daria on 11.05.2016.
 */
public class Node {
    private String label;
    private Node right;
    private Node left;
    private Node parent;

    public Node(String label) {
        this.label = label;
        this.left = null;
        this.right = null;
        this.parent = null;
    }

    //getter and setter
    public void setLabel(String label) {
        this.label = label;
    }
    public String getLabel() {
        return this.label;
    }
    public void setRight(String right) {
        Node rightNode = new Node(right);
        this.right = rightNode;
    }
    public Node getRight() {
        return this.right;
    }
    public void setLeft(String  left) {
        Node leftNode = new Node(left);
        this.left = leftNode;
    }
    public Node getLeft() {
        return this.left;
    }
    public void setParent(Node  parent) {
        this.parent = parent;
    }
    public Node getParent() {
        return this.parent;
    }

}
