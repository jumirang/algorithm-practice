package tree;

class TreeNode {
  char data;
  TreeNode left;
  TreeNode right;
}

class BinarySearchTree {
  public TreeNode root = new TreeNode();

  public TreeNode insertKey(TreeNode root, char x) {
    TreeNode p = root;
    TreeNode newNode = new TreeNode();
    newNode.data = x;
    newNode.left = null;
    newNode.right = null;
    if (p == null) {
      return newNode;
    } else if (newNode.data < p.data) {
      p.left = insertKey(p.left, x);
      return p;
    } else if (newNode.data > p.data) {
      p.right = insertKey(p.right, x);
      return p;
    } else {
      return p;
    }
  }

  public void insertBST(char x) {
    root = insertKey(root, x);
  }

  public TreeNode searchBST(char x) {
    TreeNode p = root;
    while (p != null) {
      if (x < p.data) p = p.left;
      else if (x > p.data) p = p.right;
      else return p;
    }
    return p;
  }

  public void inorder(TreeNode root) {
    if (root != null) {
      inorder(root.left);
      System.out.printf(" %c", root.data);
      inorder(root.right);
    }
  }

  public void printBST() {
    inorder(root);
    System.out.println();
  }
}

public class BST_LinkedList {
  public static void main(String args[]) {
    BinarySearchTree BST = new BinarySearchTree();
    BST.insertBST('G');
    BST.insertBST('I');
    BST.insertBST('H');
    BST.insertBST('D');
    BST.insertBST('B');
    BST.insertBST('M');
    BST.insertBST('N');
    BST.insertBST('A');
    BST.insertBST('J');
    BST.insertBST('E');
    BST.insertBST('Q');

    System.out.printf("\nBinary Tree >>> ");
    BST.printBST();

    System.out.printf("Is there \"A\" ? >>> ");
    TreeNode p1 = BST.searchBST('A');
    if (p1 != null) System.out.printf("Searching Success! Searched Key : %c \n", p1.data);
    else System.out.printf("Searching Fail!!");
  }
}
