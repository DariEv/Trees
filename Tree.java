/**
 * Created by Daria on 12.05.2016.
 */
public class Tree {
    private Node root;

    public Tree(){
        this.root=null;
    }

    //getter and setter
    public void setRoot(String root) {
        Node newRoot = new Node(root);
        this.root = newRoot;
    }
    public Node getRoot() {
        return this.root;
    }

    public static void printBinaryTree(Node root, int level){
        if(root==null)
            return;
        printBinaryTree(root.getLeft(), level+1);
        if(level!=0){
            for(int i=0;i<level-1;i++)
                System.out.print("|\t");
            System.out.println("|---"+root.getLabel());
        }
        else
            System.out.println(root.getLabel());
        printBinaryTree(root.getRight(), level+1);
    }

}
