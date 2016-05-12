import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        //Read the files
        String fruits = readFile("fruits.nwk");
        String t_tree = readFile("t_tree.nwk");
        String plants = readFile("plants.nwk");

        //create trees
        Tree fruitsTree = new Tree();
        makeTree(fruitsTree, fruits);

        Tree plantsTree = new Tree();
        makeTree(plantsTree, plants);

        Tree t_Tree = new Tree();
        makeTree(t_Tree, t_tree);

        // OUTPUT
        System.out.println("Input Newick tree from the file fruits.nwk: "+fruits);
        System.out.println("The result tree: ");
        System.out.println();
        fruitsTree.printBinaryTree(fruitsTree.getRoot(), 0);
        System.out.println();

        System.out.println("Input Newick tree from the file t_tree.nwk: "+t_tree);
        System.out.println("The result tree: ");
        System.out.println();
        t_Tree.printBinaryTree(t_Tree.getRoot(), 0);
        System.out.println();

        System.out.println("Input Newick tree from the file plants.nwk: "+plants);
        System.out.println("The result tree: ");
        System.out.println();
        plantsTree.printBinaryTree(plantsTree.getRoot(), 0);
        System.out.println();

    }

    public static void makeTree(Tree T, String nwk){
        T.setRoot("R");
        Node currentNode = T.getRoot();

        // ASCCI : 40-"(" ; 41-")" ; 44-","; 59-";"
        for(int i= 0; i<nwk.length(); i++){
            switch (nwk.charAt(i)){
                case 40:
                    Node tmp = currentNode;
                    if(currentNode.getLeft() == null) {
                        currentNode.setLeft(Integer.toString(i));
                        currentNode = currentNode.getLeft();
                        currentNode.setParent(tmp);
                    }else{
                        currentNode.setRight(Integer.toString(i));
                        currentNode = currentNode.getRight();
                        currentNode.setParent(tmp);
                    }
                    break;
                case 41:
                    currentNode=currentNode.getParent();
                    break;
                case 44:
                    currentNode=currentNode.getParent();
                    tmp=currentNode;
                    if(currentNode.getRight()==null) {
                        currentNode.setRight(Integer.toString(i));
                        currentNode = currentNode.getRight();
                        currentNode.setParent(tmp);
                    }else{
                        currentNode.getRight().setLeft(Integer.toString(i));
                        currentNode = currentNode.getRight().getLeft();
                        currentNode.setParent(tmp.getRight());
                    }
                    break;
                case 59:
                    break;
                default:
                    String rest = nwk.substring(i,nwk.length());
                    if(nwk.charAt(i-1) == 40) {
                        currentNode.setLabel(rest.substring(0, rest.indexOf(44)));
                    }
                    if(nwk.charAt(i-1) == 44) {
                        currentNode.setLabel(rest.substring(0, rest.indexOf(41)));
                    }
                    break;
            }
        }
    }

    // read the .nwk file
    public static String readFile(String fileName) {
        String myTree = "";
        String line = null;
        try {
            FileReader fileReader =
                    new FileReader(fileName);

            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                myTree=line;
            }
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            fileName + "'");
        }
        catch(IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + fileName + "'");
        }
        return myTree;
    }

}
