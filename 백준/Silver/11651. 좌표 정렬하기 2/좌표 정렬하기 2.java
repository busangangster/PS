import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    int n = Integer.parseInt(br.readLine());

    ArrayList<Node> arr = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      arr.add(new Node(x, y));
    }

    Collections.sort(arr);

    for (Node tmp : arr) {
      sb.append(tmp.x + " " + tmp.y).append("\n");
    }
    System.out.println(sb);
  }
}

class Node implements Comparable<Node> {
  int x;
  int y;

  public Node(int x, int y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public int compareTo(Node o) {
    if (this.y == o.y) {
      return this.x - o.x;
    }
    return this.y - o.y;
  }
}