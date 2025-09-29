package Trees;

import java.util.ArrayList;
import java.util.List;

class Node{
    int val;
    Node left;
    Node right;
    Node parent;

    Node(int num){ //constructor
        this.val = num;
        this.left = null;
        this.right = null;
        this.parent = null;
    }
}
class BinaryTree{        // treeclass reference
    Node root;
    BinaryTree(){
        root = null; //we start empty
    }

    static ArrayList<Integer> inorderreturn(Node node, ArrayList<Integer> result){
        if(node == null){
            return result;
        }
        inorderreturn(node.left, result);
        result.add(node.val);
        inorderreturn(node.right, result);

        return result;
    }

    List<Integer> inorder1() { // helper function assisting inorderreturn.
        return inorderreturn(root,new ArrayList<>());
    }



    static void inorder(Node node){
        if( node == null){
            return;
        }
        inorder(node.left);
        System.out.println(node.val);
        inorder(node.right);
    }

    public Node Findfirst(Node node){
        if(node == null){
            return null;
        }

        while(node.left != null){
            node = node.left;
        }
        return node;
    }

    public Node Findlast(Node node){
        if(node == null){
            return null;
        }
        while(node.right != null){
            node = node.right;
        }
        return node;
    }

    void inorder(){ //fucntion overload
        inorder(root);
    }

     Node findsuccesor(Node node){
        if(node == null){
            return null;
        }
        if(node.right != null){
            return Findfirst(node);
        }
        Node child  = node;
        Node parent = node.parent;

        while(parent != null && parent.right == child){
            child = parent;
            parent = parent.parent;
        }

        return parent;
    }


    Node findpredecessor(Node node){
        if(node == null){
            return null;
        }

        if(node.left != null){
            return Findlast(node.left);
        }
        Node child = node;
        Node parent = node.parent;

        while(parent != null && parent.left == child){
            child = parent ;
            parent = parent.parent;
        }

        return parent;
    }


}

public class FirstTree {
    public static void main(String[] args) {
        BinaryTree t = new BinaryTree();
        t.root.left = new Node(2);
        t.root.left.parent = t.root;

        t.root.left.left = new Node(1);
        t.root.left.left.parent = t.root.left;

        t.root.left.right = new Node(4);
        t.root.left.right.parent = t.root.left;

        t.root.left.right.left = new Node(3);
        t.root.left.right.left.parent = t.root.left.right;

        t.root.left.right.right = new Node(5);
        t.root.left.right.right.parent = t.root.left.right;

        t.root.right = new Node(7);
        t.root.right.parent = t.root;

        t.root.right.right = new Node(9);
        t.root.right.right.parent = t.root.right;



        t.inorder();
    }
}
