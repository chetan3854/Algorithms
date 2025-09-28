package Trees;

class Node{
    int val;
    Node left;
    Node right;

    Node(int num){ //constructor
        this.val = num;
        this.left = null;
        this.right = null;
    }
}
class BinaryTree{        // treeclass reference
    Node root;
    BinaryTree(){
        root = null; //we start empty
    }

    static void inorder(Node node){
        if( node == null){
            return;
        }
        inorder(node.left);
        System.out.println(node.val);
        inorder(node.right);
    }

    void inorder(){ //fucntion overload
        inorder(root);
    }
}

public class FirstTree {
    public static void main(String[] args) {
        BinaryTree t = new BinaryTree();
        t.root = new Node(1);
        t.root.left = new Node(2);
        t.root.left.left = new Node(3);
        t.root.left.right = new Node(4);

        t.inorder();

    }
}
