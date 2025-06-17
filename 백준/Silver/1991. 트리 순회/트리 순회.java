import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int n = Integer.parseInt(br.readLine());

    HashMap<Character, Node> hm = new HashMap<>();
    for (char i = 'A'; i <= 'A' + n; i++) {
      hm.put(i, new Node(i));
    }

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      char N = st.nextToken().charAt(0);
      char L = st.nextToken().charAt(0);
      char R = st.nextToken().charAt(0);

      if (L != '.') {
        hm.get(N).left = hm.get(L);
      }
      if (R != '.') {
        hm.get(N).right = hm.get(R);
      }
    }

    Node root = hm.get('A');

    preOrder(root);
    System.out.println();
    inOrder(root);
    System.out.println();
    postOrder(root);

  }

  public static void preOrder(Node node) {
    if (node == null)
      return;
    System.out.print(node.val);
    preOrder(node.left);
    preOrder(node.right);
  }

  public static void inOrder(Node node) {
    if (node == null)
      return;
    inOrder(node.left);
    System.out.print(node.val);
    inOrder(node.right);
  }

  public static void postOrder(Node node) {
    if (node == null)
      return;
    postOrder(node.left);
    postOrder(node.right);
    System.out.print(node.val);
  }
}

class Node {
  char val;
  Node left;
  Node right;

  public Node(char val) {
    this.val = val;
  }
}
